package model.entities;

public class EquipamentoRoteador extends Equipamento {

    private final Integer larguraDeBanda;

    public EquipamentoRoteador(Integer idEquipamento, String nome, String marca, Integer larguraDeBanda) {
        super(idEquipamento, nome, marca);
        this.larguraDeBanda = larguraDeBanda;
    }

    public Integer getLarguraDeBanda() {
        return larguraDeBanda;
    }

    @Override
    public String getTipo() {
        return "Roteador";
    }

    @Override
    public String getDescricaoCapacidade() {
        return larguraDeBanda + " GB de largura de banda";
    }
}