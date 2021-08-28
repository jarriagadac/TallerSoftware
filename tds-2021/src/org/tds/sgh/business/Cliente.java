package org.tds.sgh.business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cliente {
	// --------------------------------------------------------------------------------------------

	private String direccion;
	private String mail;
	private String nombre;
	private String rut;
	private String telefono;
	private Map<Long, Reserva> reservas;

	// --------------------------------------------------------------------------------------------

	public Cliente(String rut, String nombre, String direccion, String telefono, String mail) {
		this.reservas = new HashMap<Long, Reserva>();
		this.direccion = direccion;
		this.mail = mail;
		this.nombre = nombre;
		this.rut = rut;
		this.telefono = telefono;
	}

	// --------------------------------------------------------------------------------------------

	public boolean coincideElNombre(String patronNombreCliente) {
		return this.nombre.matches(patronNombreCliente);
	}

	public String getDireccion() {
		return this.direccion;
	}

	public String getMail() {
		return this.mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void agregarReserva(Reserva reserva) {
		this.reservas.put(reserva.getCodigo(), reserva);
	}

	public Reserva buscarReservaPorCodigo(long codigoReserva) {
		return this.reservas.get(codigoReserva);
	}

	public Set<Reserva> buscarReservasActivas() {
		Set<Reserva> reservas = new HashSet<Reserva>();
		for(Reserva res : this.reservas.values()) {
			if(res.isActiva()) reservas.add(res);
		}
		return reservas;
	}
}
