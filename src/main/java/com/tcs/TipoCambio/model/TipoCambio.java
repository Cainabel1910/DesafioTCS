package com.tcs.TipoCambio.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class TipoCambio {
	
	@Id
	@GeneratedValue
	private int id;
	private int monedaOrigen;
	private int monedaDestino;
	private double tipoCambio;
	
	@Transient
	private double monto;

	public TipoCambio() {
		
	}

	public TipoCambio(int id, int monedaOrigen, int monedaDestino, double tipoCambio) {
		super();
		this.id = id;
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
		this.tipoCambio = tipoCambio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(int monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public int getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(int monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	
	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, monedaDestino, monedaOrigen, tipoCambio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoCambio other = (TipoCambio) obj;
		return id == other.id && monedaDestino == other.monedaDestino && monedaOrigen == other.monedaOrigen
				&& Double.doubleToLongBits(tipoCambio) == Double.doubleToLongBits(other.tipoCambio);
	}

	@Override
	public String toString() {
		return "TipoCambio [id=" + id + ", monedaOrigen=" + monedaOrigen + ", monedaDestino=" + monedaDestino
				+ ", tipoCambio=" + tipoCambio + "]";
	}
	
	
	
}
