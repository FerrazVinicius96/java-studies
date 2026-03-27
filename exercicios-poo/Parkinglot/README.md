# 🅿️ Sistema de Estacionamento

## 📋 Sobre o Projeto

Sistema de controle de estacionamento desenvolvido em Java com foco em **Programação Orientada a Objetos**. O sistema gerencia a entrada e saída de veículos, calcula automaticamente a duração da permanência e o valor a cobrar com base no tempo estacionado. Utiliza a **Time API** do Java para controle preciso de horários.

Este projeto foi desenvolvido como exercício prático de **Programação Orientada a Objetos em Java**, explorando encapsulamento, composição, API de datas/tempo e Streams.

## ✨ Funcionalidades

- 🚗 **Check-in de veículos** com registro automático do horário de entrada
- 🚪 **Check-out de veículos** com cálculo automático da duração e valor a pagar
- 🔍 **Busca por placa** para localizar veículos estacionados
- 📋 **Listagem dos veículos** presentes no estacionamento no momento

## 🗂️ Estrutura do Projeto

```
src/
├── application/
│   └── Program.java            # Ponto de entrada — interface com o usuário
│
└── model/
    ├── entities/
    │   └── Vehicle.java        # Entidade veículo com horário de entrada
    │
    └── services/
        └── ParkingLot.java     # Serviço de controle do estacionamento
```

## 🧮 Lógica de Cobrança

O valor é calculado no momento do check-out com base na diferença entre o horário de saída e o horário de entrada registrado no `Vehicle`. A cobrança é feita por hora cheia, arredondando para cima:

```
horas = ⌈ minutos_de_permanência / 60 ⌉   (arredondamento para cima)
valor = horas × PRICE_PER_HOUR
```

**Exemplo de cobrança:**

| Entrada | Saída | Duração  | Horas Cobradas | Valor (R$ 10,00/h) |
| :------ | :---- | :------: | :------------: | :----------------: |
| 08:00   | 09:45 | 1h 45min | 2h             | R$ 20,00           |
| 14:00   | 16:00 | 2h 00min | 2h             | R$ 20,00           |
| 10:30   | 12:45 | 2h 15min | 3h             | R$ 30,00           |

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
      SISTEMA DE ESTACIONAMENTO
========================================

Opções:
1 - Check-in (entrada)
2 - Check-out (saída)
3 - Listar veículos
0 - Sair
Insira: 1

Placa do veículo: ABC-1234
Veículo ABC-1234 registrado. Entrada: 10:30

...

Insira: 2

Placa do veículo: ABC-1234
Duração: 2h 15min (cobradas 3h)
Valor a pagar: R$ 30,00
Veículo ABC-1234 liberado.

========================================
```

## 🏛️ Conceitos OOP Aplicados

| Conceito                | Onde foi aplicado                                                                              |
| ----------------------- | ---------------------------------------------------------------------------------------------- |
| **Encapsulamento**      | Atributos de `Vehicle` são privados; horário de entrada somente leitura via getter             |
| **Composição**          | `ParkingLot` possui uma `List<Vehicle>` — gerencia sem herdar                                  |
| **Time API**            | `LocalDateTime` para registro preciso de entrada/saída; `Duration.between()` para o intervalo |
| **Constante de classe** | `PRICE_PER_HOUR` como `static final` centraliza a tarifa e evita magic numbers                 |
| **Stream API**          | `stream().filter()` para localizar veículo pela placa em `ParkingLot`                          |
| **Expressões Lambda**   | Predicados lambda para filtrar a lista de veículos de forma concisa                            |
| **Math API**            | `Math.ceil()` e `Math.max()` garantem arredondamento correto na cobrança                       |
| **toString() Override** | Representação customizada do veículo para exibição nos relatórios                              |

## 👨‍💻 Sobre o Autor

Advogado em transição de carreira para o desenvolvimento de software, cursando **Análise e Desenvolvimento de Sistemas — 3º Período**. Este projeto representa a aplicação prática dos fundamentos de Java OOP, com foco em construir código limpo, seguro e bem estruturado desde o início da jornada de aprendizado.

## 📌 Próximos Passos

- [ ] Criar uma entidade **`Ticket`** que registre placa, horário de entrada, horário de saída e valor pago, mantendo histórico de passagens
- [ ] Adicionar **exceções customizadas** como `VeiculoNaoEncontradoException` e `VagaOcupadaException`
- [ ] Implementar **vagas limitadas** com controle de capacidade máxima do estacionamento
- [ ] Aplicar **Streams** para gerar relatórios: total arrecadado no dia, média de permanência, pico de ocupação
- [ ] Explorar **`Optional<Vehicle>`** como retorno da busca por placa, eliminando verificações de `null` explícitas

  Feito com ☕ Java e muita dedicação • ADS 3º Período
