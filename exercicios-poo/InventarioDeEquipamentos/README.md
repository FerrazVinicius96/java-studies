# 🖧 Inventário de Equipamentos de Rede

## Sobre o Projeto

Sistema de gerenciamento de inventário para infraestrutura de redes, desenvolvido em Java com foco em **Programação Orientada a Objetos**. Permite cadastrar, remover e listar equipamentos de rede (Switches e Roteadores) com atributos específicos para cada tipo. O sistema simula o cadastro de equipamentos de rede de um departamento de TI de uma prefeitura, com suporte a tipos específicos de equipamentos e geração de relatórios formatados.

## Funcionalidades

- ✅ **Cadastrar** equipamentos do tipo Switch (com quantidade de portas) ou Roteador (com largura de banda)
- ✅ **Remover** equipamentos pelo ID
- ✅ **Listar** todos os equipamentos em um relatório padronizado com nome, tipo e capacidade
- ✅ **Validação** de equipamentos antes de operações de remoção

## Estrutura do Projeto

```
src/
├── application/
│   └── Program.java                  # Ponto de entrada, loop do menu
└── model/
    ├── entities/
    │   ├── Equipamento.java           # Classe abstrata base
    │   ├── EquipamentoSwitch.java     # Switch com quantidade de portas
    │   └── EquipamentoRoteador.java   # Roteador com largura de banda
    ├── repositories/
    │   └── RepositorioEquipamento.java # Camada de persistência em memória
    └── services/
        └── ServicoEquipamento.java    # Regras de negócio
```

## Diagrama de Classes

```
                        ┌──────────────────────────┐
                        │      <<abstract>>         │
                        │        Equipamento        │
                        │---------------------------|
                        │ - idEquipamento: Integer  │
                        │ - nome: String            │
                        │ - marca: String           │
                        │---------------------------|
                        │ + getTipo(): String       │
                        │ + getDescricaoCapacidade()│
                        │ + toString(): String      │
                        └────────────┬─────────────┘
                                     │
               ┌─────────────────────┴──────────────────────┐
               │                                            │
  ┌────────────────────────┐              ┌─────────────────────────────┐
  │    EquipamentoSwitch   │              │     EquipamentoRoteador     │
  │------------------------|              |-----------------------------|
  │ - qtdPortas: Integer   │              │ - larguraDeBanda: Integer   │
  │------------------------|              |-----------------------------|
  │ + getTipo()            │              │ + getTipo()                 │
  │ + getDescricaoCapac... │              │ + getDescricaoCapacidade()  │
  └────────────────────────┘              └─────────────────────────────┘

  ┌─────────────────────────────┐         ┌──────────────────────────────┐
  │   RepositorioEquipamento    │◄────────│      ServicoEquipamento      │
  │-----------------------------|         |------------------------------|
  │ - equipamentos: Set<Eq...>  │         │ - repositorio: Repositorio.. │
  │-----------------------------|         |------------------------------|
  │ + add(Equipamento)          │         │ + addEquipamento(Equipamento)│
  │ + remove(Equipamento)       │         │ + removerEquipamento(...)    │
  │ + contains(Equipamento)     │         │ - validarPresenca(...)       │
  │ + findAll(): Set<Eq...>     │         └──────────────────────────────┘
  └─────────────────────────────┘
```

## Como Executar

### Pré-requisitos

- [JDK 11+](https://adoptium.net/) instalado
- Terminal ou IDE de sua preferência (IntelliJ, Eclipse, VS Code)

### Compilação e execução via terminal

```bash
# Clone o repositório

# Compile todos os arquivos

# Execute
```

### Execução via IDE

Importe o projeto como um projeto Java simples e execute a classe `Program.java`.

---

## Exemplo de Uso

```
==================================================
  BEM-VINDO AO INVENTÁRIO DE EQUIPAMENTOS DE REDE
==================================================

Opções:
1 - Adicionar Equipamento
2 - Remover Equipamento
3 - Relatório de Equipamentos
0 - Sair
Insira: 1

Tipo (1-Switch / 2-Roteador): 1
Nome do equipamento: Switch Sala Servidores
Marca: Cisco
ID: 101
Quantidade de portas: 48

'Switch Sala Servidores' adicionado com sucesso!

...

====================================================================================================
RELATÓRIO DE EQUIPAMENTOS
====================================================================================================
ID: 101   | Nome: Switch Sala Servidores | Marca: Cisco   | Tipo: Switch   | Capacidade: 48 portas de acesso
ID: 102   | Nome: Roteador Principal     | Marca: TP-Link | Tipo: Roteador | Capacidade: 1000 GB de largura de banda
====================================================================================================
```

---

## Conceitos de POO Aplicados

| Conceito             | Onde foi aplicado                                                                     |
| -------------------- | ------------------------------------------------------------------------------------- |
| **Abstração**        | `Equipamento` é abstrata; não pode ser instanciada diretamente                        |
| **Herança**          | `EquipamentoSwitch` e `EquipamentoRoteador` estendem `Equipamento`                    |
| **Polimorfismo**     | `toString()`, `getTipo()` e `getDescricaoCapacidade()` sobrescritos em cada subclasse |
| **Encapsulamento**   | Campos `private final`; coleção interna protegida por `Collections.unmodifiableSet`   |
| **Camadas (layers)** | Separação entre `entities`, `repositories`, `services` e `application`                |

## 👨‍💻 Sobre o Autor

Advogado em transição de carreira para o desenvolvimento de software, cursando **Análise e Desenvolvimento de Sistemas — 3º Período**. Este projeto representa a aplicação prática dos fundamentos de Java OOP, com foco em construir código limpo, seguro e bem estruturado desde o início da jornada de aprendizado.

## 📌 Próximos Passos

- [ ] **Interfaces** — criar IRepositorio<T> com métodos add, remove, findAll permite trocar a implementação sem mudar o serviço.
- [ ] **Generics** — o repositório poderia ser Repositorio<T extends Equipamento>, reutilizável para qualquer entidade futura.
- [ ] **Exceções customizadas** — criar EquipamentoNaoEncontradoException extends RuntimeException é mais expressivo do que usar IllegalArgumentException.
- [ ] **Streams** — o stream().filter().findFirst() já usado no case 2 é um bom ponto de entrada para aprender a API de Streams do Java.

  Feito com ☕ Java e muita dedicação • ADS 3º Período
