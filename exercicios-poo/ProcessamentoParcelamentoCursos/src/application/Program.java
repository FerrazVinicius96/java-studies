package application;

import model.entities.Cursos;
import model.entities.Parcela;
import model.entities.Pedido;
import model.services.ServicoPagamento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

    private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final List<String> METODOS_ACEITOS = List.of("Cartao", "Pix", "Boleto");

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pt", "BR"));
        Scanner sc = new Scanner(System.in);

        Cursos cursosDisponiveis = new Cursos();

        System.out.println("=================================================");
        System.out.println("       BEM-VINDO À PLATAFORMA DE CURSOS TECH     ");
        System.out.println("=================================================");
        System.out.println("\nCursos disponíveis:\n");
        for (Map.Entry<String, Double> entrada : cursosDisponiveis.getCursos().entrySet()) {
            System.out.printf("  • %-35s R$ %.2f%n", entrada.getKey(), entrada.getValue());
        }

        String cursoEscolhido = null;
        while (cursoEscolhido == null) {
            System.out.print("\nEscolha o curso desejado (digite exatamente como exibido): ");
            String entrada = sc.nextLine().trim();
            try {
                cursosDisponiveis.getPreco(entrada);
                cursoEscolhido = entrada;
            } catch (IllegalArgumentException e) {
                System.out.println("  ✗ Curso inválido. Por favor, escolha um curso da lista acima.");
            }
        }

        String metodoPagamento = null;
        while (metodoPagamento == null) {
            System.out.println("\nMétodos de pagamento disponíveis: " + METODOS_ACEITOS);
            System.out.print("Escolha o método de pagamento: ");
            String entrada = sc.nextLine().trim();
            if (METODOS_ACEITOS.contains(entrada)) {
                metodoPagamento = entrada;
            } else {
                System.out.println("  ✗ Método inválido. Escolha entre: " + METODOS_ACEITOS);
            }
        }

        Integer qtdMeses = null;
        if (metodoPagamento.equals("Cartao")) {
            while (qtdMeses == null) {
                System.out.print("Insira a quantidade de parcelas (1 a 24): ");
                try {
                    int valor = Integer.parseInt(sc.nextLine().trim());
                    if (valor < 1 || valor > 24) {
                        System.out.println("  ✗ Quantidade inválida. Insira um valor entre 1 e 24.");
                    } else {
                        qtdMeses = valor;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("  ✗ Entrada inválida. Digite um número inteiro.");
                }
            }
        }

        Pedido pedido;
        if (qtdMeses != null) {
            pedido = new Pedido(cursosDisponiveis, cursoEscolhido, LocalDate.now(), metodoPagamento, qtdMeses);
        } else {
            pedido = new Pedido(cursosDisponiveis, cursoEscolhido, LocalDate.now(), metodoPagamento);
        }

        ServicoPagamento sp = new ServicoPagamento(pedido);

        System.out.println("\n=================================================");
        System.out.println("                 RESUMO DO PEDIDO               ");
        System.out.println("=================================================");
        System.out.printf("  Curso       : %s%n", cursoEscolhido);
        System.out.printf("  Valor total : R$ %.2f%n", sp.getPagamentoTotal());
        System.out.printf("  Pagamento   : %s%n", metodoPagamento);
        System.out.printf("  Data pedido : %s%n", pedido.getDataPedido().format(FORMATADOR_DATA));

        if (metodoPagamento.equals("Cartao")) {
            List<Parcela> parcelas = sp.processamentoParcela();
            System.out.printf("%n  Parcelado em %dx:%n%n", qtdMeses);
            for (int i = 0; i < parcelas.size(); i++) {
                Parcela p = parcelas.get(i);
                System.out.printf("    Parcela %2d: R$ %8.2f   Vencimento: %s%n",
                        i + 1,
                        p.getValorParcela(),
                        p.getVencimentoParcela().format(FORMATADOR_DATA));
            }
        } else {
            System.out.printf("%n  Valor a pagar: R$ %.2f (%s)%n", sp.getPagamentoTotal(), metodoPagamento);
        }

        System.out.println("\n=================================================");
        System.out.println("  Compra realizada com sucesso! Bons estudos. ✓  ");
        System.out.println("=================================================\n");

        sc.close();
    }
}