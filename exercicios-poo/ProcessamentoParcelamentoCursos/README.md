# 🎓 Plataforma de Cursos Tech — Módulo de Checkout

## 📋 Sobre o Projeto

Sistema de checkout para uma plataforma de cursos de tecnologia com foco em formações Full-Stack. O módulo permite que um aluno escolha um curso, selecione o método de pagamento e, caso opte pelo parcelamento em cartão, receba a geração automática de todas as parcelas com **juros simples mensais** aplicados e datas de vencimento calculadas.

Este projeto foi desenvolvido como exercício prático de **Programação Orientada a Objetos em Java**, explorando conceitos como encapsulamento, separação de responsabilidades, validação de dados e modelagem de entidades do mundo real.

## ✨ Funcionalidades

- 📚 **Catálogo de cursos** com listagem de nomes e preços formatados
- 🛡️ **Validação robusta** de entradas em todos os pontos do sistema
- 💳 **Três métodos de pagamento** — Cartão, Pix e Boleto
- 📆 **Geração automática de parcelas** com juros simples e datas de vencimento
- ⚠️ **Tratamento de exceções** explícito em toda a camada de entidades

## 🗂️ Estrutura do Projeto

```
src/
├── application/
│   └── Program.java              # Ponto de entrada — interface com o usuário
│
└── model/
    ├── entities/
    │   ├── Cursos.java           # Catálogo de cursos disponíveis
    │   ├── Pedido.java           # Entidade principal do pedido
    │   └── Parcela.java          # Representação de cada parcela gerada
    │
    └── services/
        └── ServicoPagamento.java # Lógica de cálculo de juros e parcelamento
```

## 🧮 Lógica de Parcelamento

O sistema aplica **juros simples mensais** de **2,5% a.m.** O valor de cada parcela cresce linearmente conforme o mês:

**Exemplo — Curso "Java/SpringBoot FullStack" (R$ 850,00) em 3x:**

| Parcela | Cálculo                       |   Valor   | Vencimento |
| :-----: | ----------------------------- | :-------: | :--------: |
|   1ª    | `(850 / 3) × (1 + 0,025 × 1)` | R$ 290,42 | 21/04/2025 |
|   2ª    | `(850 / 3) × (1 + 0,025 × 2)` | R$ 298,33 | 21/05/2025 |
|   3ª    | `(850 / 3) × (1 + 0,025 × 3)` | R$ 306,25 | 21/06/2025 |

## 🚀 Como Executar

### Pré-requisitos

- Java **17** ou superior instalado
- Uma IDE como **IntelliJ IDEA**, **Eclipse** ou **VS Code** com extensão Java

### Passos

# 1. Clone ou baixe o projeto

# 2. Abra o projeto na sua IDE

# 3. Execute a classe principal

### Exemplo de uso no terminal

```
=================================================
       BEM-VINDO À PLATAFORMA DE CURSOS TECH
=================================================

Cursos disponíveis:

  • Java/SpringBoot - FullStack            R$ 850,00
  • Análise de Dados - Python              R$ 550,00
  • AI - Python                            R$ 1.050,00

Escolha o curso desejado: Java/SpringBoot - FullStack

Métodos de pagamento disponíveis: [Cartao, Pix, Boleto]
Escolha o método de pagamento: Cartao

Insira a quantidade de parcelas (1 a 24): 3

=================================================
                 RESUMO DO PEDIDO
=================================================
  Curso       : Java/SpringBoot - FullStack
  Valor total : R$ 850,00
  Pagamento   : Cartao
  Data pedido : 21/03/2025

  Parcelado em 3x:

    Parcela  1: R$   290,42   Vencimento: 21/04/2025
    Parcela  2: R$   298,33   Vencimento: 21/05/2025
    Parcela  3: R$   306,25   Vencimento: 21/06/2025

=================================================
  Compra realizada com sucesso! Bons estudos. ✓
=================================================
```

## 🏛️ Conceitos OOP Aplicados

| Conceito                           | Onde foi aplicado                                                                        |
| ---------------------------------- | ---------------------------------------------------------------------------------------- |
| **Encapsulamento**                 | Atributos `private final` em `Parcela`; mapa protegido por `unmodifiableMap` em `Cursos` |
| **Separação de Responsabilidades** | Entidades cuidam dos dados; `ServicoPagamento` cuida do cálculo                          |
| **Princípio DRY**                  | Validação centralizada em `validarCurso()` dentro de `Pedido`                            |
| **Tratamento de Exceções**         | `IllegalArgumentException` lançada explicitamente em `Cursos` e `Pedido`                 |
| **Encadeamento de Construtores**   | `this(...)` em `Pedido` elimina repetição entre os três construtores                     |
| **Imutabilidade**                  | Atributos `final` em `Parcela` garantem que parcelas não sejam alteradas após criação    |

## 👨‍💻 Sobre o Autor

Advogado em transição de carreira para o desenvolvimento de software, cursando **Análise e Desenvolvimento de Sistemas — 3º Período**. Este projeto representa a aplicação prática dos fundamentos de Java OOP, com foco em construir código limpo, seguro e bem estruturado desde o início da jornada de aprendizado.

## 📌 Próximos Passos

- [ ] Aplicar **herança** criando tipos específicos de pedido, como `PedidoCartao` e `PedidoAvista`, estendendo `Pedido`
- [ ] Introduzir uma **interface** `Pagavel` com o método `calcularTotal()`, implementada de formas distintas por cada tipo de pagamento
- [ ] Explorar **Collections** substituindo a `List<Parcela>` por um `LinkedList` e comparar o comportamento na prática
- [ ] Praticar **Generics** criando uma classe utilitária `Repositorio<T>` capaz de armazenar cursos, pedidos ou parcelas
- [ ] Usar **Streams e Lambdas** para filtrar, ordenar e somar parcelas sem laços `for` explícitos

  Feito com ☕ Java e muita dedicação • ADS 3º Período
