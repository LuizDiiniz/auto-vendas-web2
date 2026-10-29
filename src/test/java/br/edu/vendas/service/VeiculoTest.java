package br.edu.vendas.service;

import br.edu.vendas.model.*;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.time.Year;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {
    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll static void iniciar() {
        factory = Validation.byDefaultProvider().configure()
            .messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory();
        validator = factory.getValidator();
    }
    @AfterAll static void fechar() { factory.close(); }

    private Produto valido() {
        Produto p = new Produto();
        p.setNome("Corolla XEi"); p.setPreco(new BigDecimal("132900.00"));
        p.setQuantidadeEstoque(1); p.setMarca(new Marca()); p.setCategoria(new Categoria());
        p.setAnoModelo(2023); p.setQuilometragem(32000);
        p.setCambio(Cambio.CVT); p.setCombustivel(Combustivel.FLEX);
        return p;
    }
    private boolean erro(Produto p, String campo) {
        return validator.validate(p).stream().anyMatch(v -> v.getPropertyPath().toString().equals(campo));
    }
    @Test void aceitaVeiculoCompleto() { assertTrue(validator.validate(valido()).isEmpty()); }
    @Test void exigeAnoCambioECombustivel() {
        Produto p = valido(); p.setAnoModelo(null); p.setCambio(null); p.setCombustivel(null);
        assertTrue(erro(p,"anoModelo")); assertTrue(erro(p,"cambio")); assertTrue(erro(p,"combustivel"));
    }
    @Test void rejeitaAnoMuitoAntigoEFuturo() {
        Produto p=valido(); p.setAnoModelo(1885); assertTrue(erro(p,"anoModelo"));
        p.setAnoModelo(Year.now().getValue()+2); assertTrue(erro(p,"anoModeloValido"));
        p.setAnoModelo(Year.now().getValue()+1); assertTrue(validator.validate(p).isEmpty());
    }
    @Test void rejeitaQuilometragemNegativa() {
        Produto p=valido(); p.setQuilometragem(-1); assertTrue(erro(p,"quilometragem"));
        p.setQuilometragem(0); assertTrue(validator.validate(p).isEmpty());
    }
    @Test void mantemRegrasDePrecoEstoqueEVinculos() {
        Produto p=valido(); p.setPreco(BigDecimal.ZERO); p.setQuantidadeEstoque(-1);
        p.setMarca(null); p.setCategoria(null);
        assertTrue(erro(p,"preco")); assertTrue(erro(p,"quantidadeEstoque"));
        assertTrue(erro(p,"marca")); assertTrue(erro(p,"categoria"));
    }
}
