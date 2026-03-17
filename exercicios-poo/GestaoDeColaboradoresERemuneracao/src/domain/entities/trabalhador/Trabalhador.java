package domain.entities.trabalhador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.entities.contrato.*;

public class Trabalhador {

    private final Long idTrabalhador;
    private final String cpf;

    private String nome;
    private String sobrenome;
    private String profissao;

    private List<ContratoAbstrato> contratos = new ArrayList<>();

    public Trabalhador(long idTrabalhador, String cpf, String nome, String sobrenome, String profissao) {
        this.idTrabalhador = idTrabalhador;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.profissao = profissao;
    }

    public Long getIdTrabalhador() {
        return idTrabalhador;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public List<ContratoAbstrato> getContratos() {
        return Collections.unmodifiableList(contratos);
    }

    public void setContratos(List<ContratoAbstrato> contratos) {
        this.contratos = contratos;
    }

    public void addContrato(ContratoAbstrato contrato) {
        contratos.add(contrato);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTrabalhador == null) ? 0 : idTrabalhador.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Trabalhador other = (Trabalhador) obj;
        if (idTrabalhador == null) {
            if (other.idTrabalhador != null)
                return false;
        } else if (!idTrabalhador.equals(other.idTrabalhador))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Trabalhador [idTrabalhador=" + idTrabalhador + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome="
                + sobrenome + ", profissao=" + profissao + ", contratos=" + contratos + "]";
    }

}
