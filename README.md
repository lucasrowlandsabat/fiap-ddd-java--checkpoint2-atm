# 💻 FIAP Bank ATM - Checkpoint 2

## 📌 Descrição
Este projeto consiste no desenvolvimento da versão evoluída do sistema de Caixa Eletrônico (ATM) em Java, proposto como Checkpoint 2 da disciplina de Domain Driven Design - Java.

O sistema simula operações bancárias utilizando conceitos de Programação Orientada a Objetos e Domain Driven Design (DDD), incluindo autenticação, movimentações financeiras e histórico de operações.

# 🚀 Funcionalidades

- Cadastro de cliente
- Sistema de autenticação
- Consulta de saldo
- Depósito
- Saque
- Histórico de movimentações
- Registro de taxas e movimentações automáticas

# 🔒 Regras do Sistema

- Uso de BigDecimal para operações monetárias
- Controle de saldo encapsulado
- Registro automático de movimentações
- Validação de saldo para saque
- Histórico com data e hora das operações

# 📂 Estrutura do Projeto

src/
└── br/com/fiapbank/
    ├── application/
    │   ├── ContaFactory
    │   ├── ContaService
    │   └── Main
    │
    ├── infrastructure/
    │   └── ContaRepository
    │
    ├── model/
    │   ├── entity/
    │   │   ├── BaseEntity
    │   │   ├── Cliente
    │   │   ├── Conta
    │   │   ├── ContaCorrente
    │   │   └── ContaPoupanca
    │   │
    │   └── valueobject/
    │       ├── ContaAcesso
    │       ├── Dinheiro
    │       └── Movimentacao
    │
    └── presentation/
        └── Menu

# 👨‍💻 Autor

Desenvolvido por Lucas Rowlands Abat como projeto prático avaliativo na disciplina de Domain Driven Design - Java no curso de segundo ano de Engenharia de Software.
