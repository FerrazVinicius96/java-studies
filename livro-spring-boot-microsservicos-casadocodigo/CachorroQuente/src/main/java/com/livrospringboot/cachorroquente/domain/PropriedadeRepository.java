package com.livrospringboot.cachorroquente.domain;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropriedadeRepository extends CrudRepository<Propriedade, String> {

    /*
     Método para encontrar propriedades por filtro

     Usa o Spring Data para fazer essa Query:

     SELECT *
     FROM Propriedade
     WHERE nome LIKE %:filtro%
     ORDER BY categoria,nome
     */
    List<Propriedade> findByNomeContainingIgnoreCaseOrderByCategoriaAscNomeAsc(String filtro);

}
