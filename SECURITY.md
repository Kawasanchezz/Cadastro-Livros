# Política de segurança

## Versões suportadas

Apenas a versão da branch principal.

## Como relatar uma vulnerabilidade

Use o recurso "Report a vulnerability" na aba Security do repositório no GitHub (relato privado). Não abra issue pública com detalhes.

## Limitações conhecidas

- Aplicação de console para uso local e didático; não há autenticação nem controle de acesso próprios, e a proteção depende do acesso ao MySQL.
- As credenciais do banco vêm de variáveis de ambiente (`DB_PASSWORD`); a conexão usa as configurações padrão do driver, sem TLS forçado.
- O driver `mysql-connector-j-8.4.0.jar` está versionado em `lib/` e precisa ser atualizado manualmente.
- Não há testes automatizados nem CI.
