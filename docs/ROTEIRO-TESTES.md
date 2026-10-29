# Roteiro de conferência

Use dados fictícios e uma imagem própria. Cadastros alterados no banco não são gravados nos scripts automaticamente.

| Teste | Resultado esperado |
|---|---|
| Criar uma marca, editar e excluir uma marca sem vínculos | Mensagem de sucesso e tabela atualizada |
| Cadastrar Toyota com espaços e outra combinação de maiúsculas | Duplicidade bloqueada |
| Excluir Toyota com Corolla vinculado | Exclusão bloqueada; permite desativar |
| Criar categoria raiz, filha e neta | Caminho completo e indentação no menu |
| Excluir pai com subcategorias | Exclusão bloqueada |
| Editar categoria e escolher ela mesma ou descendente como pai | Não aceita formar ciclo |
| Cadastrar carro preenchendo os campos e enviando PNG/JPG/WEBP até 2 MB | Prévia antes de salvar e miniatura depois |
| Editar preço, ano, km, câmbio e combustível | Novos valores persistidos ao recarregar |
| Salvar sem ano, marca, categoria, câmbio ou combustível | Validação impede gravação |
| Usar preço zero, estoque ou km negativos, ano muito antigo ou acima do próximo ano | Validação impede gravação |
| Renomear um arquivo de texto para .jpg | Conteúdo rejeitado |
| Editar só a descrição de um carro com foto | Imagem permanece |
| Excluir carro e confirmar | Sai da lista e remove imagem vinculada |
| Filtrar, ordenar e mudar página da tabela | Lista responde aos critérios |

Para apresentar: mostre primeiro a organização Marcas > Categorias > Veículos; depois demonstre um cadastro com foto, uma edição e um bloqueio de exclusão. Explique que o EntityManager grava os dados no PostgreSQL, enquanto os arquivos ficam fora do WAR.
