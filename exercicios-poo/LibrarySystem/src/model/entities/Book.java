package model.entities;

public class Book {
    private String title;
    private String author;
    private final String isbn; // 'final' garante que não mude após iniciado
    private boolean isBorrowed;

    // Construtor: Iniciamos o livro sempre como disponível (isBorrowed = false)
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
    // Note: Não criamos o setIsbn para manter a integridade do dado.

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Métodos de Negócio
    public void borrow() {
        if (isBorrowed) {
            System.out.println("ERRO: O livro '" + title + "' já está emprestado.");
        } else {
            isBorrowed = true;
            System.out.println("Sucesso: Empréstimo do livro '" + title + "' realizado.");
        }
    }

    public void returnBook() {
        if (!isBorrowed) {
            System.out.println("AVISO: O livro '" + title + "' já estava na biblioteca.");
        } else {
            isBorrowed = false;
            System.out.println("Sucesso: Livro '" + title + "' devolvido.");
        }
    }

    @Override
    public String toString() {
        return "Livro: " + title + " | Autor: " + author + " | ISBN: " + isbn +
                " | Status: " + (isBorrowed ? "Emprestado" : "Disponível");
    }
}