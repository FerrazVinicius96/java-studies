package model.entities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cursos {

    private final Map<String, Double> cursos = new HashMap<>();

    public Cursos() {
        cursos.put("Java/SpringBoot - FullStack", 850.00);
        cursos.put("Análise de Dados - Python", 550.00);
        cursos.put("AI - Python", 1050.00);
    }

    public Map<String, Double> getCursos() {
        return Collections.unmodifiableMap(cursos);
    }

    public void addCurso(String nomeCurso, Double precoCurso) {
        if (nomeCurso == null || nomeCurso.isBlank()) {
            throw new IllegalArgumentException("O nome do curso não pode ser vazio.");
        }
        if (precoCurso == null || precoCurso <= 0) {
            throw new IllegalArgumentException("O preço do curso deve ser maior que zero.");
        }
        cursos.put(nomeCurso, precoCurso);
    }

    public void removerCurso(String nomeCurso) {
        if (!cursos.containsKey(nomeCurso)) {
            throw new IllegalArgumentException("Curso não encontrado: " + nomeCurso);
        }
        cursos.remove(nomeCurso);
    }

    public Double getPreco(String nomeCurso) {
        if (!cursos.containsKey(nomeCurso)) {
            throw new IllegalArgumentException("Curso não encontrado: " + nomeCurso);
        }
        return cursos.get(nomeCurso);
    }

    @Override
    public String toString() {
        return "Cursos: " + cursos;
    }

}