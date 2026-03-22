# ☕ java-studies


Repositório de estudos e projetos práticos em **Java**, desenvolvidos ao longo da graduação em Análise e Desenvolvimento de Sistemas. Cada projeto foi construído com atenção a boas práticas de **Orientação a Objetos**: encapsulamento, separação de responsabilidades, validação de dados e tratamento de exceções.


## 🗂️ Estrutura do Repositório

```
java-studies/
└── exercicios-poo/
    ├── CurrencyConversor/
    ├── Employee/
    ├── GestaoDeColaboradoresERemuneracao/
    ├── LibrarySystem/
    ├── Parkinglot/
    ├── ProcessamentoParcelamentoCursos/
    └── StudyPlanner/
```


## 📦 Projetos — `exercicios-poo`

### 💱 CurrencyConversor
Conversor de moedas que aplica taxas de câmbio entre diferentes moedas. Exercita modelagem de entidades, operações aritméticas com tipos numéricos e formatação de saída.

---

### 👤 Employee
Modelagem de funcionários com atributos como nome, cargo e salário. Explora herança, encapsulamento e a relação entre classes base e especializadas.

---

### 👥 GestaoDeColaboradoresERemuneracao
Sistema de gestão de colaboradores com cálculo de remuneração. Trabalha com coleções de objetos, polimorfismo e regras de negócio aplicadas sobre entidades do mundo real.

---

### 📚 LibrarySystem
Sistema de biblioteca para gerenciamento de livros e empréstimos. Exercita relacionamentos entre classes, controle de estado de objetos e validações de domínio.

---

### 🅿️ Parkinglot
Simulação de estacionamento com controle de entrada, saída e cobrança de tarifas. Pratica o uso de coleções, lógica temporal com `LocalDateTime` e encapsulamento de regras de negócio.

---

### 🎓 ProcessamentoParcelamentoCursos
Módulo de checkout para uma plataforma de cursos de tecnologia. O sistema recebe um pedido, aplica **juros simples mensais de 2,5% a.m.** e gera automaticamente todas as parcelas com datas de vencimento. Destaque para a separação entre camada de entidades (`model.entities`) e camada de serviços (`model.services`).

**Principais conceitos aplicados:**
- Encapsulamento com `Collections.unmodifiableMap()`
- Validação centralizada via método privado (princípio DRY)
- Encadeamento de construtores com `this(...)`
- Lançamento explícito de `IllegalArgumentException`
- Formatação de saída com `printf` e `DateTimeFormatter`

---

### 📅 StudyPlanner
Planejador de estudos para organização de cursos, divididos em módulos e aulas. O programa soma o tempo de cada módulo e tempo total de cada curso através do tempo de cada aula.

---


## 🏛️ Conceitos OOP Praticados

| Conceito | Descrição |
|---|---|
| **Encapsulamento** | Atributos privados, getters/setters e proteção do estado interno dos objetos |
| **Herança** | Reutilização e especialização de comportamento entre classes |
| **Polimorfismo** | Objetos de tipos diferentes respondendo ao mesmo método de formas distintas |
| **Tratamento de Exceções** | `IllegalArgumentException`, `try/catch` e falhas explícitas em vez de silenciosas |
| **Coleções** | Uso de `List`, `Map` e `HashMap` com boas práticas de acesso e imutabilidade |
| **API `java.time`** | Manipulação de datas com `LocalDate`, `LocalDateTime` e `DateTimeFormatter` |
| **Princípio DRY** | Eliminação de duplicação de lógica via métodos privados e encadeamento de construtores |

<br/>

## 👨‍💻 Sobre o Autor

Advogado em transição de carreira para o desenvolvimento de software, cursando **Análise e Desenvolvimento de Sistemas — 3º Período**. Este repositório documenta a construção de uma base sólida em Java, com foco em escrever código limpo, bem estruturado e orientado a boas práticas desde o início da jornada.


---


  Feito com ☕ Java e dedicação  •  ADS 3º Período
