package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Book;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        boolean emExecucao = true;

        ArrayList<Book> books = new ArrayList<>();

        // Carga inicial
        books.add(new Book("TOMATS", "Hemmingway", "7001"));
        books.add(new Book("GG", "Fitzgerald", "7002"));
        books.add(new Book("CAP", "Dostoyevski", "7003"));

        do {
            System.out.println("\n--- SISTEMA DE BIBLIOTECA ---");
            System.out.print("1-Adicionar livro\n2-Pegar livro emprestado\n3-Retornar livro\n0-Sair\nOpção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Insira título: ");
                    String title = sc.nextLine();
                    System.out.print("Insira autor: ");
                    String author = sc.nextLine();
                    System.out.print("Insira ISBN: ");
                    String isbn = sc.nextLine();

                    books.add(new Book(title, author, isbn));
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do livro para EMPRÉSTIMO: ");
                    String searchTitleBorrow = sc.nextLine();

                    // Busca na lista usando Stream (Predicate)
                    Book foundBorrow = books.stream()
                            .filter(x -> x.getTitle().equalsIgnoreCase(searchTitleBorrow))
                            .findFirst()
                            .orElse(null);

                    if (foundBorrow != null) {
                        foundBorrow.borrow(); 
                    } else {
                        System.out.println("Erro: Livro não encontrado no acervo.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do livro para DEVOLUÇÃO: ");
                    String searchTitleReturn = sc.nextLine();

                    Book foundReturn = books.stream()
                            .filter(x -> x.getTitle().equalsIgnoreCase(searchTitleReturn))
                            .findFirst()
                            .orElse(null);

                    if (foundReturn != null) {
                        foundReturn.returnBook(); 
                    } else {
                        System.out.println("Erro: Livro não encontrado no acervo.");
                    }
                    break;

                case 0:
                    emExecucao = false;
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Insira uma entrada válida.");
                    break;
            }
        } while (emExecucao);

        sc.close();
    }
}