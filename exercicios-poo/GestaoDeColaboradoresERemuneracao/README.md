# 🧾 Gestão de Colaboradores e Remuneração

## 📋 Sobre o Projeto

Sistema de gerenciamento de colaboradores e contratos de trabalho desenvolvido em Java com foco em **Programação Orientada a Objetos**. O sistema suporta os dois regimes contratuais mais comuns no mercado brasileiro — **CLT** e **PJ** — cada um com sua própria alíquota de imposto. Aplica o padrão **Strategy** para o cálculo tributário e utiliza **Generics** no serviço de contratos, tornando a arquitetura extensível a novos regimes sem alterar o código existente.

Este projeto foi desenvolvido como exercício prático de **Programação Orientada a Objetos em Java**, explorando classes abstratas, interfaces, Generics, Enums e composição de objetos com foco em modelagem de domínio real.

## ✨ Funcionalidades

- 👷 **Cadastro de trabalhadores** com nome e lista de contratos associados
- 📄 **Cadastro de contratos CLT** com cálculo de imposto de **27,5%** sobre o salário bruto
- 📄 **Cadastro de contratos PJ** com cálculo de imposto de **7,5%** sobre o valor faturado
- 💸 **Cálculo do líquido a receber** (bruto − imposto) por contrato
- 📊 **Relatório de remuneração** listando todos os contratos de um trabalhador

## 🗂️ Estrutura do Projeto

```
src/
├── application/
│   └── Program.java                            # Ponto de entrada — interface com o usuário
│
└── domain/
    ├── model/
    │   └── enums/
    │       └── ContratoEnum.java               # Enum dos tipos de contrato
    │
    ├── entities/
    │   ├── imposto/
    │   │   ├── ImpostoInterface.java           # Interface — contrato de cálculo de imposto
    │   │   ├── ImpostoClt.java                 # Implementação: 27,5% para CLT
    │   │   └── ImpostoPj.java                  # Implementação: 7,5% para PJ
    │   │
    │   ├── contrato/
    │   │   ├── ContratoAbstrato.java           # Classe abstrata base dos contratos
    │   │   ├── ContratoClt.java                # Contrato CLT concreto
    │   │   └── ContratoPj.java                 # Contrato PJ concreto
    │   │
    │   └── trabalhador/
    │       └── Trabalhador.java                # Entidade trabalhador com lista de contratos
    │
    └── services/
        └── ServiceContrato.java                # Serviço genérico para contratos
```

## 🧮 Lógica de Tributação

Cada regime contratual recebe uma implementação de `ImpostoInterface` via construtor (Injeção de Dependência). O cálculo do líquido é delegado ao imposto injetado, sem que o contrato conheça o tipo concreto:

| Regime | Alíquota | Exemplo (bruto R$ 5.000,00) | Imposto     | Líquido     |
| :----- | :------: | :-------------------------: | :---------: | :---------: |
| CLT    | 27,5%    | R$ 5.000,00                 | R$ 1.375,00 | R$ 3.625,00 |
| PJ     | 7,5%     | R$ 5.000,00                 | R$ 375,00   | R$ 4.625,00 |

## 🚀 Como Executar

### Pré-requisitos

- Java **17** ou superior instalado
- Uma IDE como **IntelliJ IDEA**, **Eclipse** ou **VS Code** com extensão Java

### Passos

```
# 1. Clone ou baixe o projeto

# 2. Abra o projeto na sua IDE

# 3. Execute a classe principal: src/application/Program.java
```

### Exemplo de uso no terminal

```
========================================
   GESTÃO DE COLABORADORES
========================================

Trabalhador: Ana Silva

Contratos:

  ID: C001 | Regime: CLT | Bruto: R$  5.000,00 | Imposto: R$  1.375,00 | Líquido: R$  3.625,00
  ID: C002 | Regime: PJ  | Bruto: R$ 10.000,00 | Imposto: R$    750,00 | Líquido: R$  9.250,00

  Total líquido: R$ 12.875,00

========================================
```

## 🏛️ Conceitos OOP Aplicados

| Conceito                   | Onde foi aplicado                                                                                        |
| -------------------------- | -------------------------------------------------------------------------------------------------------- |
| **Classe Abstrata**        | `ContratoAbstrato` fornece estrutura comum (ID, espécie, datas) sem poder ser instanciada diretamente   |
| **Herança**                | `ContratoClt` e `ContratoPj` estendem `ContratoAbstrato`, herdando atributos e comportamentos comuns    |
| **Interface**              | `ImpostoInterface` define o contrato de cálculo; contratos dependem da abstração, não da implementação  |
| **Polimorfismo**           | `ServiceContrato` opera sobre `ContratoAbstrato`; o cálculo correto é resolvido em tempo de execução    |
| **Padrão Strategy**        | `ImpostoClt` e `ImpostoPj` são algoritmos intercambiáveis de tributação injetados nos contratos         |
| **Injeção de Dependência** | Contratos recebem `ImpostoInterface` via construtor, permanecendo desacoplados da implementação concreta |
| **Generics**               | `ServiceContrato<T extends ContratoAbstrato>` é reutilizável para qualquer tipo de contrato              |
| **Enum**                   | `ContratoEnum` garante type-safety nas categorias contratuais, eliminando Strings mágicas               |
| **Composição**             | `Trabalhador` possui uma `List<ContratoAbstrato>` — relação "tem vários contratos"                      |
| **Encapsulamento**         | Atributos `private final` para dados imutáveis; `equals()/hashCode()` baseados no ID do contrato        |
| **BigDecimal**             | Cálculos financeiros com precisão decimal, evitando erros de ponto flutuante                            |

## 👨‍💻 Sobre o Autor

Advogado em transição de carreira para o desenvolvimento de software, cursando **Análise e Desenvolvimento de Sistemas — 3º Período**. Este projeto representa a aplicação prática dos fundamentos de Java OOP, com foco em construir código limpo, seguro e bem estruturado desde o início da jornada de aprendizado.

## 📌 Próximos Passos

- [ ] Criar a interface **`IRepositorio<T>`** e uma implementação em memória, separando a camada de dados do serviço
- [ ] Adicionar o regime **Freelance** criando `ContratoFreelance` e `ImpostoFreelance` sem alterar as classes existentes — validando o princípio Open/Closed
- [ ] Aplicar **Streams** para calcular o total líquido de um trabalhador com `stream().map().reduce()`
- [ ] Introduzir **exceções customizadas** como `ContratoNaoEncontradoException` e `TrabalhadorSemContratoException`
- [ ] Explorar **Records** do Java 16+ para representar objetos de valor imutáveis, como um resumo de pagamento

  Feito com ☕ Java e muita dedicação • ADS 3º Período
