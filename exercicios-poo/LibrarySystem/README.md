# 📚 Sistema de Gerenciamento de Biblioteca

## 📋 Sobre o Projeto

Sistema de gerenciamento de acervo bibliográfico desenvolvido em Java com foco em **Programação Orientada a Objetos**. O sistema permite cadastrar livros, realizar empréstimos e devoluções, com controle de estado de disponibilidade. Utiliza a **Stream API** do Java para busca e filtragem do acervo de forma funcional.

Este projeto foi desenvolvido como exercício prático de **Programação Orientada a Objetos em Java**, explorando encapsulamento, gerenciamento de estado, coleções e programação funcional com Streams.

## ✨ Funcionalidades

- 📖 **Cadastro de livros** com título, autor e ISBN
- 🔖 **Empréstimo de livros** com validação de disponibilidade
- 🔄 **Devolução de livros** com atualização automática de status
- 🔍 **Busca por título** utilizando Stream API e expressões lambda
- 📋 **Listagem do acervo** com indicação do status de cada livro

## 🗂️ Estrutura do Projeto

```
src/
├── application/
│   └── Program.java         # Ponto de entrada — interface com o usuário
│
└── model/
    └── entities/
        └── Book.java        # Entidade livro com controle de empréstimo
```

## 🧮 Lógica de Empréstimo e Devolução

A entidade `Book` controla seu próprio estado por meio do atributo `isBorrowed`. Os métodos `borrow()` e `returnBook()` validam o estado antes de permitir a operação:

| Operação       | Pré-condição              | Resultado                       |
| :------------- | :------------------------ | :------------------------------ |
| `borrow()`     | Livro **não** emprestado  | `isBorrowed` muda para `true`   |
| `returnBook()` | Livro emprestado          | `isBorrowed` muda para `false`  |

O ISBN é declarado `final`, garantindo que o identificador único do livro não possa ser alterado após a criação.

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
     SISTEMA DE BIBLIOTECA
========================================

Opções:
1 - Cadastrar livro
2 - Realizar empréstimo
3 - Devolver livro
4 - Buscar livro por título
5 - Listar acervo
0 - Sair
Insira: 5

Acervo da biblioteca:

  [DISPONÍVEL] "Clean Code"       — Robert C. Martin  (ISBN: 978-0132350884)
  [EMPRESTADO] "Effective Java"   — Joshua Bloch      (ISBN: 978-0134685991)
  [DISPONÍVEL] "Design Patterns"  — Gang of Four      (ISBN: 978-0201633610)

========================================
```

## 🏛️ Conceitos OOP Aplicados

| Conceito                    | Onde foi aplicado                                                                          |
| --------------------------- | ------------------------------------------------------------------------------------------ |
| **Encapsulamento**          | Atributos `private` com acesso controlado; estado de empréstimo protegido pelos métodos    |
| **Imutabilidade**           | `final` no ISBN impede alteração após criação do objeto                                    |
| **Gerenciamento de Estado** | `isBorrowed` rastreia disponibilidade; métodos validam transições de estado                |
| **Coleções**                | `ArrayList<Book>` armazena o acervo no `Program`                                           |
| **Stream API**              | `stream().filter().findFirst()` para busca de livros por título                            |
| **Expressões Lambda**       | Predicados lambda para filtrar o acervo de forma concisa                                   |
| **toString() Override**     | Representação textual customizada para exibição dos dados do livro                         |

## 👨‍💻 Sobre o Autor

Advogado em transição de carreira para o desenvolvimento de software, cursando **Análise e Desenvolvimento de Sistemas — 3º Período**. Este projeto representa a aplicação prática dos fundamentos de Java OOP, com foco em construir código limpo, seguro e bem estruturado desde o início da jornada de aprendizado.

## 📌 Próximos Passos

- [ ] Extrair a coleção de livros para uma classe **`Biblioteca`** com métodos `emprestar()`, `devolver()` e `buscar()`, separando responsabilidades do `Program`
- [ ] Criar uma classe **`Emprestimo`** que registre o livro, o usuário e a data de retirada/devolução
- [ ] Adicionar **exceções customizadas** como `LivroIndisponivelException` e `LivroNaoEncontradoException`
- [ ] Aplicar **Streams** para filtrar apenas livros disponíveis ou listar por ordem alfabética com `sorted()`
- [ ] Explorar **`Optional<Book>`** como retorno da busca, eliminando verificações de `null` explícitas

  Feito com ☕ Java e muita dedicação • ADS 3º Período
