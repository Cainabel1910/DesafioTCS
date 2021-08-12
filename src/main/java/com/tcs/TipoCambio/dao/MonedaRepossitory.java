package com.tcs.TipoCambio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.TipoCambio.model.Moneda;

public interface MonedaRepossitory extends JpaRepository<Moneda, Integer>{
	
	List<Moneda> findById(int id);

}
