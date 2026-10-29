# Continuar em outro computador

1. Clone o repositório do integrante ou extraia este ZIP.
2. Confira a disponibilidade de Java 17 ou 25, NetBeans, Tomcat 11 e PostgreSQL. Em computador da faculdade, respeite as permissões de instalação.
3. Para começar com os exemplos: siga o README para criar o banco `autovendas` e execute DDL e DML uma vez.
4. Para continuar com cadastros reais de um teste anterior: no computador de origem, faça Backup do banco pelo pgAdmin e copie a pasta `autovendas-uploads` do usuário. No destino, use Restore e coloque as imagens na pasta usada pelo servidor. Se restaurar um backup, não rode também a carga inicial. O backup não inclui os arquivos de imagem.
5. Abra a pasta do projeto no NetBeans, selecione Tomcat 11 e execute Run.
6. Mudanças no código são enviadas com Git. Cadastros e fotos precisam do backup; `git push` não os transporta.

Se só houver alterações locais que ainda não foram publicadas, copie também a pasta do projeto ou registre e envie os commits antes de trocar de máquina.
