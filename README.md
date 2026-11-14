# Cadastro de Livros

Aplicação de console em Java para cadastrar, listar, buscar, alterar e excluir livros, com persistência em MySQL. Organizada em camadas: model, repository (JDBC), service (validações), controller e view.

## Requisitos

- JDK 17
- MySQL 8 em `localhost:3306`
- VS Code com o Extension Pack for Java

## Configuração

1. Crie o banco: execute `sql/criar_banco.sql` (instalação nova) ou `sql/alterar_banco.sql` (banco do projeto original, uma única vez).
2. Copie `.env.example` para `.env` e preencha `DB_PASSWORD`. O `.env` não é versionado.

## Execução

Abra `src/br/com/livraria/App.java` no VS Code e use **Run** (ou F5). O driver MySQL já está em `lib/`.

## Estrutura

```
src/br/com/livraria/   código-fonte (config, controller, model, repository, service, view)
sql/                   scripts do banco
lib/                   driver MySQL Connector/J
evidencias/            capturas de tela
```

Política de segurança em [SECURITY.md](SECURITY.md).

## Licença

[MIT](LICENSE)
