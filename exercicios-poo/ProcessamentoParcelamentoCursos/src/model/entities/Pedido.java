package model.entities;

import java.time.LocalDate;

public class Pedido {

    private final Cursos cursosDisponiveis;
    private String cursoEscolhido;
    private LocalDate dataPedido;
    private String metodoCompra;
    private Integer qtdMeses;

    public Pedido(Cursos cursosDisponiveis) {
        this.cursosDisponiveis = cursosDisponiveis;
        this.dataPedido = LocalDate.now();
    }

    public Pedido(Cursos cursosDisponiveis, String cursoEscolhido, LocalDate dataPedido, String metodoCompra) {
        this(cursosDisponiveis);
        validarCurso(cursoEscolhido);
        this.cursoEscolhido = cursoEscolhido;
        this.dataPedido = dataPedido;
        this.metodoCompra = metodoCompra;
    }

    public Pedido(Cursos cursosDisponiveis, String cursoEscolhido, LocalDate dataPedido, String metodoCompra,
            Integer qtdMeses) {
        this(cursosDisponiveis, cursoEscolhido, dataPedido, metodoCompra);
        this.qtdMeses = qtdMeses;
    }

    private void validarCurso(String nomeCurso) {
        if (!cursosDisponiveis.getCursos().containsKey(nomeCurso)) {
            throw new IllegalArgumentException("Curso não disponível: " + nomeCurso);
        }
    }

    public Cursos getCursosDisponiveis() {
        return cursosDisponiveis;
    }

    public String getCursoEscolhido() {
        return cursoEscolhido;
    }

    public void setCursoEscolhido(String cursoEscolhido) {
        validarCurso(cursoEscolhido);
        this.cursoEscolhido = cursoEscolhido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getMetodoCompra() {
        return metodoCompra;
    }

    public void setMetodoCompra(String metodoCompra) {
        this.metodoCompra = metodoCompra;
    }

    public Integer getQtdMeses() {
        return qtdMeses;
    }

    public void setQtdMeses(Integer qtdMeses) {
        this.qtdMeses = qtdMeses;
    }

    @Override
    public String toString() {
        return "Compras: \nCursoEscolhido: " + cursoEscolhido
                + ", Data Compra: " + dataPedido
                + ", Metodo Compra: " + metodoCompra
                + ", Parcelado em " + qtdMeses + " mes(es)";
    }

}