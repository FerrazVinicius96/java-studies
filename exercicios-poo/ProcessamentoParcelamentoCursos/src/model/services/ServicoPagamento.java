package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Parcela;
import model.entities.Pedido;

public class ServicoPagamento {

    private final Double taxaPercentualMensal = 0.025;
    private Pedido pedido;

    public ServicoPagamento(Pedido pedido) {
        this.pedido = pedido;
    }

    public Double getPagamentoTotal() {
        return pedido.getCursosDisponiveis().getPreco(pedido.getCursoEscolhido());
    }

    public Double getValorParcela(Integer mesEquivalente) {
        double parcelaBase = getPagamentoTotal() / pedido.getQtdMeses();
        return parcelaBase * (1 + taxaPercentualMensal * mesEquivalente);
    }

    public List<Parcela> processamentoParcela() {
        List<Parcela> lp = new ArrayList<>();

        for (int i = 1; i <= pedido.getQtdMeses(); i++) {
            lp.add(new Parcela(getValorParcela(i), pedido.getDataPedido().plusMonths(i)));
        }

        return lp;
    }
}
