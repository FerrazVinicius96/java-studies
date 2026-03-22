package model.services;

import model.entities.Equipamento;
import model.repositories.RepositorioEquipamento;

public class ServicoEquipamento {

    private final RepositorioEquipamento repositorio = new RepositorioEquipamento();

    public void addEquipamento(Equipamento e) {
        repositorio.add(e);
    }

    public void removerEquipamento(Equipamento e) {
        validarPresenca(e); // validação interna antes de remover
        repositorio.remove(e);
    }

    // private: é uma regra interna do serviço, não deve ser chamada de fora.
    private void validarPresenca(Equipamento e) {
        if (!repositorio.contains(e)) {
            throw new IllegalArgumentException("Equipamento com ID "
                    + e.getIdEquipamento() + " não encontrado no inventário.");
        }
    }

    public RepositorioEquipamento getRepositorio() {
        return repositorio;
    }
}