package model.entities;

public class EquipamentoSwitch extends Equipamento {

    private final Integer qtdPortas;

    public EquipamentoSwitch(Integer idEquipamento, String nome, String marca, Integer qtdPortas) {
        super(idEquipamento, nome, marca);
        this.qtdPortas = qtdPortas;
    }

    public Integer getQtdPortas() {
        return qtdPortas;
    }

    @Override
    public String getTipo() {
        return "Switch";
    }

    @Override
    public String getDescricaoCapacidade() {
        return qtdPortas + " portas de acesso";
    }
}