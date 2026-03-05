package com.livrospringboot.cachorroquente.domain.repository;


import com.livrospringboot.cachorroquente.domain.entities.Propriedade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropriedadeRepository extends PagingAndSortingRepository<Propriedade, String> {
    @Query("Select c from Propriedade c where c.nome like %:filtro% order by categoria,subcategoria,nome")
    public List<Propriedade> findByFiltro(@Param("filtro") String filtro);
}
