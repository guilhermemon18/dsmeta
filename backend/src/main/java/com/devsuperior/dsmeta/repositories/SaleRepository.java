package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

//salvar, editar, buscar,deletar vendas.
//JpaRepository<T1,T2> onde T1 é o tipo da entidade e T2 é o tipo da chave da entidade.
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	//consulta customizada no banco de dados, pela data máxima e data mínima, comando em JPQL.
	//:min é LocalDate min e :max é LocalDate max.
	//ordena pelas maiores vendas.
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
