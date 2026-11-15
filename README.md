# Cadastro de Livros

Aplicação de console em Java para cadastrar, listar, buscar, alterar e excluir livros, com persistência em MySQL. Organizada em camadas: model, repository (JDBC), service (validações), controller e view.

## Requisitos

- JDK 17
- MySQL 8 em `localhost:3306`

## Configuração

1. Crie o banco: execute `sql/criar_banco.sql` (instalação nova) ou `sql/alterar_banco.sql` (banco do projeto original, uma única vez).
2. Defina as variáveis de ambiente `DB_PASSWORD` (obrigatória), `DB_USER` (padrão `root`) e `DB_URL` (padrão `jdbc:mysql://localhost:3306/livraria_db`). `.env.example` lista os nomes; o `.env` não é versionado e não é lido automaticamente.

## Execução

Compile e execute (PowerShell, na raiz do projeto):

```
$env:DB_PASSWORD = "sua_senha"
javac -encoding UTF-8 -d bin (Get-ChildItem -Recurse src -Filter *.java).FullName
java -Dfile.encoding=UTF-8 -cp "bin;lib/*" br.com.livraria.App
```

O driver MySQL já está em `lib/`. O `bin/` é ignorado pelo Git.

## Estrutura

```
src/br/com/livraria/   código-fonte (config, controller, model, repository, service, view)
sql/                   scripts do banco
lib/                   driver MySQL Connector/J
```

Política de segurança em [SECURITY.md](SECURITY.md).

## Licença

[MIT](LICENSE)
