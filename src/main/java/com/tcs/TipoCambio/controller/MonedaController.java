package com.tcs.TipoCambio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.TipoCambio.dao.MonedaRepossitory;
import com.tcs.TipoCambio.model.Moneda;

@RestController
public class MonedaController {
	@Autowired
	private MonedaRepossitory repositorio;
	
	@PostMapping("/guardarMoneda")
	public String guardarMoneda(@RequestBody Moneda moneda) {
		repositorio.save(moneda);
		return "Moneda guardada con exito";
	}
	
	@GetMapping("/obtenerTodasLasMonedas")
	public List<Moneda> getAll(){
		return repositorio.findAll();
	}
	
	@PostMapping("/obtenerMoneda")
	public List<Moneda> obtenerMoneda(@RequestBody Moneda moneda){
		return repositorio.findById(moneda.getId());
	}
}
