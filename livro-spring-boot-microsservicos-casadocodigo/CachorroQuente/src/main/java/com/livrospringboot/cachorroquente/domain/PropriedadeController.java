package com.livrospringboot.cachorroquente.domain;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PropriedadeController {

    private final PropriedadeRepository repository;

    public PropriedadeController(PropriedadeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/find")
    List<Propriedade> findByFiltro(@RequestParam("filtro") String filtro) {
        return repository.findByNomeContainingIgnoreCaseOrderByCategoriaAscNomeAsc(filtro);
    }

}
