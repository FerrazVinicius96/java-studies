package application;

import java.util.Scanner;

import model.entities.Equipamento;
import model.entities.EquipamentoRoteador;
import model.entities.EquipamentoSwitch;
import model.services.ServicoEquipamento;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServicoEquipamento servico = new ServicoEquipamento();

        System.out.println("==================================================");
        System.out.println("  BEM-VINDO AO INVENTÁRIO DE EQUIPAMENTOS DE REDE ");
        System.out.println("==================================================");

        boolean ativo = true;

        while (ativo) {
            System.out.print(
                    "\nOpções:\n1 - Adicionar Equipamento\n2 - Remover Equipamento" +
                            "\n3 - Relatório de Equipamentos\n0 - Sair\nInsira: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    // Tipo escolhido antes do nome: correto e independente do nome digitado.
                    System.out.print("Tipo (1-Switch / 2-Roteador): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome do equipamento: ");
                    String nome = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Quantidade de portas: ");
                        int portas = sc.nextInt();
                        sc.nextLine();
                        servico.addEquipamento(new EquipamentoSwitch(id, nome, marca, portas));
                    } else if (tipo == 2) {
                        System.out.print("Largura de banda (GB): ");
                        int banda = sc.nextInt();
                        sc.nextLine();
                        servico.addEquipamento(new EquipamentoRoteador(id, nome, marca, banda));
                    } else {
                        System.out.println("Tipo inválido. Equipamento não cadastrado.");
                        break;
                    }
                    System.out.printf("%n'%s' adicionado com sucesso!%n", nome);
                    break;

                case 2:
                    System.out.print("Informe o ID do equipamento a remover: ");
                    int idRemover = sc.nextInt();
                    sc.nextLine();

                    // Busca o equipamento pelo ID para poder removê-lo.
                    Equipamento alvo = servico.getRepositorio().findAll().stream()
                            .filter(e -> e.getIdEquipamento().equals(idRemover))
                            .findFirst()
                            .orElse(null);

                    if (alvo == null) {
                        System.out.println("Equipamento com ID " + idRemover + " não encontrado.");
                    } else {
                        servico.removerEquipamento(alvo);
                        System.out.println("Equipamento removido com sucesso.");
                    }
                    break;

                case 3:
                    System.out.println("\n" + "=".repeat(100));
                    System.out.printf("%-50s%n", "RELATÓRIO DE EQUIPAMENTOS");
                    System.out.println("=".repeat(100));

                    if (servico.getRepositorio().findAll().isEmpty()) {
                        System.out.println("Nenhum equipamento cadastrado.");
                    } else {
                        servico.getRepositorio().findAll()
                                .forEach(e -> System.out.println(e));
                    }
                    System.out.println("=".repeat(100));
                    break;

                case 0:
                    ativo = false;
                    System.out.println("\nPrograma encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}