# 👔 Sistema de Folha de Pagamento

## 📋 Sobre o Projeto

Sistema de gerenciamento de folha de pagamento desenvolvido em Java com foco em **Programação Orientada a Objetos**. O projeto modela diferentes tipos de colaboradores — Funcionário base, Gerente e Desenvolvedor — cada um com sua própria regra de remuneração. O `PayrollService` opera sobre todos eles de forma polimórfica, sem precisar conhecer o tipo concreto de cada funcionário.

Este projeto foi desenvolvido como exercício prático de **Programação Orientada a Objetos em Java**, explorando herança, polimorfismo, sobrescrita de métodos e upcasting.

## ✨ Funcionalidades

- 👤 **Cadastro de funcionários** dos tipos Employee, Manager e Developer
- 💰 **Cálculo de pagamento** com regras específicas por tipo de colaborador
- 📊 **Geração de relatório de folha** listando todos os colaboradores e seus salários
- 🔁 **Processamento polimórfico** — o serviço calcula o pagamento correto sem verificar o tipo

## 🗂️ Estrutura do Projeto

```
src/
├── application/
│   └── Program.java              # Ponto de entrada — interface com o usuário
│
└── model/
    ├── entities/
    │   ├── Employee.java         # Classe base — nome, horas e valor/hora
    │   ├── Manager.java          # Gerente — adiciona bônus de equipe
    │   └── Developer.java        # Desenvolvedor — adiciona auxílio de certificação
    │
    └── services/
        └── PayrollService.java   # Gerencia a lista e calcula a folha de pagamento
```

## 🧮 Lógica de Remuneração

Cada subclasse sobrescreve o método `payment()` herdado de `Employee`, somando os adicionais específicos ao salário base:

| Tipo          | Cálculo                                          |
| :------------ | :----------------------------------------------- |
| `Employee`    | `horas × valorPorHora`                           |
| `Manager`     | `horas × valorPorHora + bonusEquipe`             |
| `Developer`   | `horas × valorPorHora + auxilioCertificacao`     |

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
       FOLHA DE PAGAMENTO
========================================

Colaboradores cadastrados:

  Ana Silva        [Developer]   R$  6.200,00
  Carlos Mendes   [Manager]     R$  8.750,00
  João Pereira     [Employee]    R$  4.400,00

  Total da folha:               R$ 19.350,00

========================================
```

## 🏛️ Conceitos OOP Aplicados

| Conceito                    | Onde foi aplicado                                                                                      |
| --------------------------- | ------------------------------------------------------------------------------------------------------ |
| **Herança**                 | `Manager` e `Developer` estendem `Employee`, herdando nome, horas e valor/hora                        |
| **Polimorfismo**            | `PayrollService` chama `payment()` na referência `Employee`; Java executa a versão correta             |
| **Sobrescrita (Override)**  | `payment()` é sobrescrito em `Manager` e `Developer` para adicionar seus bônus específicos            |
| **Upcasting**               | `List<Employee>` armazena referências para objetos `Manager` e `Developer`                            |
| **Encapsulamento**          | Atributos `private` com acesso controlado por getters; nome imutável após construção                  |
| **super**                   | Subclasses chamam `super.payment()` para reaproveitar o cálculo base sem duplicação                   |
| **Coleções**                | `ArrayList<Employee>` gerencia o conjunto de colaboradores no `PayrollService`                        |

## 👨‍💻 Sobre o Autor

Advogado em transição de carreira para o desenvolvimento de software, cursando **Análise e Desenvolvimento de Sistemas — 3º Período**. Este projeto representa a aplicação prática dos fundamentos de Java OOP, com foco em construir código limpo, seguro e bem estruturado desde o início da jornada de aprendizado.

## 📌 Próximos Passos

- [ ] Criar uma **classe abstrata** `Employee` com `payment()` abstrato, forçando que toda subclasse implemente sua própria regra
- [ ] Introduzir uma **interface** `Remuneravel` com `calcularPagamento()`, desacoplando a lógica de pagamento da hierarquia de herança
- [ ] Aplicar **Streams e Lambdas** para calcular o total da folha com `mapToDouble(Employee::payment).sum()`
- [ ] Adicionar **exceções customizadas** para validar dados de entrada, como horas negativas ou valor/hora zerado
- [ ] Explorar **Generics** criando um `Repositorio<T>` reutilizável para armazenar qualquer tipo de entidade

  Feito com ☕ Java e muita dedicação • ADS 3º Período
