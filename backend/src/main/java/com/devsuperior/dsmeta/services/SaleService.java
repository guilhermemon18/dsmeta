package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

//operações de negócios com vendas
//um service deve ter um Repository
@Service//registrando o service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	
	public Page<Sale> findSales(String minDate,String maxDate,Pageable pageable) {
		
		//cria um dia atual.
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.endsWith("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		
		return repository.findSales(min, max, pageable);
	}
}