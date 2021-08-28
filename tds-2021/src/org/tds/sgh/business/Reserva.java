package org.tds.sgh.business;

import java.util.GregorianCalendar;
import java.util.Set;

public class Reserva {
	private long codigo;
	private String estado;
	private GregorianCalendar fechaFin;
	private GregorianCalendar fechaInicio;
	private Habitacion habitacion;
	private Hotel hotel;
	private Set<Huesped> huespedes;
	private boolean modificablePorHuesped;
	private Cliente cliente;
	private TipoHabitacion tipoHabitacion;
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Set<Huesped> getHuespedes() {
		return huespedes;
	}
	public void setHuespedes(Set<Huesped> huespedes) {
		this.huespedes = huespedes;
	}
	public boolean isModificablePorHuesped() {
		return modificablePorHuesped;
	}
	public void setModificablePorHuesped(boolean modificablePorHuesped) {
		this.modificablePorHuesped = modificablePorHuesped;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	public Reserva(long codigo, String estado, GregorianCalendar fechaFin, GregorianCalendar fechaInicio,
			Habitacion habitacion, Hotel hotel, Set<Huesped> huespedes, boolean modificablePorHuesped, Cliente cliente,
			TipoHabitacion tipoHabitacion) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.habitacion = habitacion;
		this.hotel = hotel;
		this.huespedes = huespedes;
		this.modificablePorHuesped = modificablePorHuesped;
		this.cliente = cliente;
		this.tipoHabitacion = tipoHabitacion;
	}
	
	
}
