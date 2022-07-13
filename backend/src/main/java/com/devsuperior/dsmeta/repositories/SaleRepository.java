package com.devsuperior.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;

//salvar, editar, buscar,deletar vendas.
//JpaRepository<T1,T2> onde T1 é o tipo da entidade e T2 é o tipo da chave da entidade.
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
}
