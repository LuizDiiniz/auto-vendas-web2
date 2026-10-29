# Validação desta versão

## Executado na preparação

- Build `mvn clean verify` com OpenJDK 17.0.20 e Maven 3.9.9: **BUILD SUCCESS**.
- **11 testes JUnit, 0 falhas, 0 erros, 0 ignorados**: seis de hierarquia/arquivos e cinco de campos automotivos e restrições.
- Aplicação real iniciada no Apache Tomcat 11.0.15, com Faces, PrimeFaces, CDI e Hibernate.
- DDL e DML executados em PGlite 0.3.2, PostgreSQL 17.4 em WebAssembly, acessado pelo JDBC através do adaptador pglite-socket 0.0.7.
- Interface exercitada em Chromium 141 com Playwright 1.56.1; resultados em `RESULTADOS-UI.txt`.
- Capturas reais em `docs/imagens`: página inicial, marcas, categorias, veículos, prévia de upload e início em tela móvel de 390 px.

A passagem pelo adaptador local usou uma conexão por vez e parâmetros JDBC específicos desse teste. Esses parâmetros não são necessários no PostgreSQL nativo. As configurações padrão do projeto continuam apontando para o banco local `autovendas`, usuário e senha `autovendas`.

## Conferências na interface

Criação, edição e exclusão de marca; bloqueio de duplicidade sem distinguir espaços ou maiúsculas; bloqueio de exclusão de marca vinculada; árvore de categorias com três níveis e bloqueio de exclusão de pai; carga dos seis carros; cadastro de veículo com os novos campos, seleção de enums, upload PNG, prévia e entrega da miniatura via HTTP 200; edição de preço, ano, quilometragem, combustível e câmbio, com recarga confirmando persistência e manutenção da foto; exclusão de veículo; ausência de erros JavaScript durante o roteiro.

Os testes JUnit adicionais verificam ano obrigatório, limite histórico, limite móvel até o próximo ano, km não negativo, seleção de câmbio/combustível, preço positivo, estoque não negativo e vínculos obrigatórios.

## Limites

- Nesta preparação não houve execução em Windows/NetBeans, JDK 25, PostgreSQL nativo nem Docker Compose. A configuração do Lombok foi atualizada para 1.18.42 nos dois usos através de uma propriedade única; a compilação aqui foi feita no JDK 17.
- PGlite não substitui o teste final no PostgreSQL da máquina da faculdade. Execute o roteiro do README nesse ambiente antes da entrega.
- Não foram feitos testes de carga, concorrência distribuída ou uma auditoria de segurança de produção.
- Os dados de demonstração são fictícios. A imagem usada no teste é uma ilustração do projeto, não uma foto real dos modelos listados. A carga SQL inicial não aponta para arquivos gerados durante os testes.
- A atividade implementa o catálogo de carros, sem clientes, registro de venda ou pagamentos.
