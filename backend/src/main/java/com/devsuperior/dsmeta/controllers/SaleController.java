package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

//Controller deve chamar um service, deve ter uma referência para um service

@RestController//avisa que é controller.
@RequestMapping(value = "/sales")//rota de acesso.
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
	//configura a função para responder ao protocolo http.
	@GetMapping//requisição get.
	public Page<Sale> findSales(
			//@RequestParam parametros que são passados na busca
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="")String maxDate,
			Pageable pageable){//Pageable pageable: pagina em páginas de 20 elementos, 
		//precisa declarar no controller e no service.
		//dados trafegam como texto na web, por isso String nas datas.
		return service.findSales(minDate,maxDate,pageable);
	}
	
	@GetMapping("/{id}/notification")//parametro id
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}

}
