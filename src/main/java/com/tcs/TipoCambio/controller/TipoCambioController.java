package com.tcs.TipoCambio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.TipoCambio.dao.MonedaRepossitory;
import com.tcs.TipoCambio.dao.TipoCambioRepossitory;
import com.tcs.TipoCambio.model.Moneda;
import com.tcs.TipoCambio.model.TipoCambio;

@RestController
public class TipoCambioController {
	@Autowired
	private TipoCambioRepossitory tipoCambioRepositorio;
	
	@Autowired
	private MonedaRepossitory monedaRepositorio;
	
	@PostMapping("/guardarTipoCambio")
	public String guardarTipoCambio(@RequestBody TipoCambio tipoCambio) {
		tipoCambioRepositorio.save(tipoCambio);
		return "Tipo de Cambio guardado con exito";
	}
	
	@PostMapping("/obtenerTipoCambio")
	public Map<String, Object> obtenerTipoCambio(@RequestBody TipoCambio tipoCambio) {
		Map<String, Object> response= new HashMap<>();
		List<Moneda> monedaOrigen = monedaRepositorio.findById(tipoCambio.getMonedaOrigen());
		response.put("monedaOrigen", tipoCambio.getMonedaOrigen());
		response.put("nombreMonedaOrigen", monedaOrigen.get(0).getNombre());
		List<Moneda> monedaDestino = monedaRepositorio.findById(tipoCambio.getMonedaDestino());
		response.put("monedaDestino", tipoCambio.getMonedaDestino());
		response.put("nombreMonedaDestino", monedaDestino.get(0).getNombre());
		response.put("monto", tipoCambio.getMonto());
	    List<TipoCambio> tipoCambioList = tipoCambioRepositorio.findAll();
	    tipoCambioList.stream().forEach((p)-> {
	    	if (p.getMonedaDestino() == tipoCambio.getMonedaDestino() && p.getMonedaOrigen() == tipoCambio.getMonedaOrigen()) {
	    		response.put("tipoCambio", p.getTipoCambio());
			}
	     });
	    
		double montoTipoCambio = tipoCambio.getMonto()*Double.parseDouble(response.get("tipoCambio").toString());
		response.put("montoTipoCambio", montoTipoCambio);
		return response;
	}


}
