# Exercício – Evolução do cadastro de livros

**Aluno:** Kawã Sanchez

## 1. O que foi entregue

- Projeto atualizado (pasta `CadastroLivros`).
- `sql/criar_banco.sql`: instalação nova, tabela já com `edicao`, `editora` e `numero_unidades` e seus CHECK.
- `sql/alterar_banco.sql`: instalação existente, `ALTER TABLE` executado uma única vez.

## Como executar

Requisitos: JDK 17 no PATH e MySQL em `localhost:3306`.

1. Banco novo: execute `sql/criar_banco.sql` no MySQL Workbench. Banco já existente do projeto original: execute `sql/alterar_banco.sql` uma única vez.
2. Copie `.env.example` para `.env` e preencha `DB_PASSWORD` (e `DB_USER`/`DB_URL`, se forem diferentes). O `.env` é ignorado pelo Git e é lido pelo VS Code ao executar. Fora do VS Code, defina as mesmas variáveis de ambiente.
3. O driver (`mysql-connector-j-8.4.0.jar`) já está em `lib/`.
4. Na pasta do projeto, abra `src/br/com/livraria/App.java` no VS Code e clique em **Run** (ou F5) para compilar e abrir o menu.

## 2. Evidências

### 2.1 Banco após o ALTER (livros antigos com valores provisórios)
SELECT no Workbench: os livros antigos foram preservados, com os valores provisórios (edição 1, "Não informada", 0 unidades).

![Banco no Workbench](evidencias/00_banco_select.png)

### 2.2 Cadastro válido
Cadastro de "Java para Iniciantes", Ana Souza, 2025, edição 2, Editora Acadêmica, 10 unidades, com a mensagem de sucesso.

![Cadastro válido](evidencias/01_cadastro.png)

### 2.3 Consulta por código e listagem
Consulta do código 4 e listagem: o livro novo e os 3 livros antigos (valores provisórios: edição 1, "Não informada", 0 unidades) mostram edição, editora e unidades.

![Consulta e listagem](evidencias/02_consulta_listagem.png)

### 2.4 Alteração
Registro atual exibido antes de pedir os novos dados:

![Início da alteração](evidencias/03_alteracao_inicio.png)

Novos valores digitados (edição 3, editora "teste", 14 unidades) e confirmação:

![Alteração concluída](evidencias/04_alteracao.png)

### 2.5 Exclusão
Exclusão do livro de teste, com a exibição do registro (inclusive os novos campos) antes da confirmação:

![Exclusão](evidencias/05_exclusao.png)

### 2.6 Conferência direto no banco
O mesmo SELECT mostra as colunas `edicao`, `editora` e `numero_unidades` na tabela `livros` (livraria_db).

![Banco no Workbench](evidencias/00_banco_select.png)

## 3. Perguntas

**1. Por que o código do livro passou para a posição 7 no UPDATE?**
O método `preencher` é usado tanto pelo INSERT quanto pelo UPDATE e grava os seis dados do livro nas posições 1 a 6 (nome, autor, ano, edição, editora e número de unidades). No UPDATE, esses seis valores formam o `SET`, e o `id` do `WHERE` é o sétimo `?`. Antes havia só três campos, então o código ficava na posição 4.

**2. Por que a interface `LivroRepository` não precisou mudar?**
Os métodos dela recebem e devolvem um objeto `Livro`, e não campos soltos. Os novos dados entram pela própria entidade, então as assinaturas continuam iguais. Só a implementação JDBC (`LivroMySqlRepository`) precisou mudar.

**3. Qual é a diferença entre ler um número no terminal e validar a regra de negócio desse número?**
Ler é converter o texto digitado em número inteiro; a View repete a pergunta se o usuário digitar letras. Validar é decidir se o valor é aceitável para o negócio: edição maior ou igual a 1, unidades maior ou igual a 0, editora de 1 a 120 caracteres. Essa regra fica no Service, para valer em qualquer interface e antes de gravar. O valor -1 é um inteiro válido para a leitura e inválido para a regra.

**4. Por que alterar apenas a View não seria suficiente para armazenar os campos novos?**
A View só lê e exibe dados. Sem as colunas no banco, os atributos no Model, os parâmetros no SQL do Repository e a validação no Service, os campos não teriam onde ser guardados e seriam perdidos ao fechar o programa.
