package com.tcs.TipoCambio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.TipoCambio.model.TipoCambio;

public interface TipoCambioRepossitory extends JpaRepository<TipoCambio, Integer>{

	//List<TipoCambio> findByMonedas(int monedaOrigen, int monedaDestino);
}
