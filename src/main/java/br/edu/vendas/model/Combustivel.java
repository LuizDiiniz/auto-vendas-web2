package br.edu.vendas.model;

public enum Combustivel {
    FLEX("Flex"),
    GASOLINA("Gasolina"),
    ETANOL("Etanol"),
    DIESEL("Diesel"),
    HIBRIDO("Híbrido"),
    ELETRICO("Elétrico");

    private final String rotulo;
    Combustivel(String rotulo) { this.rotulo = rotulo; }
    public String getRotulo() { return rotulo; }
}
