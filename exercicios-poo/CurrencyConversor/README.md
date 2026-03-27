# 💱 Conversor de Moedas

## 📋 Sobre o Projeto

Sistema de conversão de moedas estrangeiras (Dólar e Euro) para Real Brasileiro, desenvolvido em Java com foco em **Programação Orientada a Objetos**. O projeto aplica o padrão de projeto **Strategy** por meio de interfaces, permitindo trocar o algoritmo de conversão sem alterar o código do serviço que o utiliza. A injeção de dependência via construtor torna o design desacoplado e extensível.

Este projeto foi desenvolvido como exercício prático de **Programação Orientada a Objetos em Java**, explorando conceitos como interfaces, polimorfismo, injeção de dependência e separação de responsabilidades.

## ✨ Funcionalidades

- 💵 **Conversão de Dólar (USD) para Real (BRL)** com taxa de câmbio configurável
- 💶 **Conversão de Euro (EUR) para Real (BRL)** com taxa de câmbio configurável
- 🔄 **Troca dinâmica de conversor** sem modificar a lógica de processamento
- 🛡️ **Validação de entrada** com tratamento de exceção para dados inválidos

## 🗂️ Estrutura do Projeto

```
src/
├── application/
│   └── Program.java                # Ponto de entrada — interface com o usuário
│
└── model/
    └── services/
        ├── CurrencyConverter.java  # Interface — contrato de conversão
        ├── DollarConverter.java    # Implementação: USD → BRL
        ├── EuroConverter.java      # Implementação: EUR → BRL
        └── PaymentProcessor.java   # Serviço que utiliza o conversor injetado
```

## 🧮 Lógica de Conversão

O `PaymentProcessor` recebe qualquer implementação de `CurrencyConverter` via construtor. O cálculo é delegado inteiramente ao conversor injetado, sem qualquer conhecimento do tipo concreto:

```
valor em BRL = valor em moeda estrangeira × taxa de câmbio
```

**Exemplo de conversão:**

| Conversor       | Valor | Taxa    | Resultado  |
| :-------------- | :---: | :-----: | :--------: |
| DollarConverter | 100   | 5,25    | R$ 525,00  |
| EuroConverter   | 100   | 5,70    | R$ 570,00  |

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
        CONVERSOR DE MOEDAS
========================================

Escolha o tipo de conversão:
1 - Dólar (USD) → Real (BRL)
2 - Euro (EUR) → Real (BRL)
0 - Sair
Insira: 1

Digite o valor em USD: 200

Valor convertido: R$ 1.050,00

========================================
```

## 🏛️ Conceitos OOP Aplicados

| Conceito                           | Onde foi aplicado                                                                              |
| ---------------------------------- | ---------------------------------------------------------------------------------------------- |
| **Interface**                      | `CurrencyConverter` define o contrato de conversão sem impor implementação                     |
| **Polimorfismo**                   | `PaymentProcessor` chama `converter()` sem saber se é Dólar ou Euro                           |
| **Injeção de Dependência**         | `PaymentProcessor` recebe o conversor via construtor, não instancia diretamente                |
| **Padrão Strategy**                | `DollarConverter` e `EuroConverter` são algoritmos intercambiáveis de conversão                |
| **Encapsulamento**                 | Taxas de câmbio são atributos privados de cada conversor concreto                              |
| **Separação de Responsabilidades** | Conversores cuidam da taxa; `PaymentProcessor` cuida do processamento do pagamento             |

## 👨‍💻 Sobre o Autor

Advogado em transição de carreira para o desenvolvimento de software, cursando **Análise e Desenvolvimento de Sistemas — 3º Período**. Este projeto representa a aplicação prática dos fundamentos de Java OOP, com foco em construir código limpo, seguro e bem estruturado desde o início da jornada de aprendizado.

## 📌 Próximos Passos

- [ ] Adicionar **novos conversores** (Libra, Iene) sem tocar no `PaymentProcessor`, validando a abertura à extensão
- [ ] Criar uma **factory** `ConversorFactory` que retorna a implementação correta com base em um enum de moeda
- [ ] Aplicar **Streams** para processar uma lista de transações em lote, convertendo cada uma e somando o total em BRL
- [ ] Explorar **exceções customizadas** como `MoedaNaoSuportadaException` para cenários de moeda inválida
- [ ] Persistir as taxas em um **arquivo de propriedades** (`.properties`), carregando-as dinamicamente em vez de codificá-las

  Feito com ☕ Java e muita dedicação • ADS 3º Período
