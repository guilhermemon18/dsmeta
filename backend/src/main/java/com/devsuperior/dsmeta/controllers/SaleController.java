package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;

//Controller deve chamar um service, deve ter uma referência para um service

@RestController//avisa que é controller.
@RequestMapping(value = "/sales")//rota de acesso.
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	//configura a função para responder ao protocolo http.
	@GetMapping
	public List<Sale> findSales(){
		return service.findSales();
	}

}
