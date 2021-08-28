package org.tds.sgh.business;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Set;

import org.tds.sgh.infrastructure.ICalendario;
import org.tds.sgh.infrastructure.ISistemaMensajeria;
import org.tds.sgh.infrastructure.Infrastructure;

public class Reserva {
	private long codigo;
	private EstadoReserva estado;
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
	public EstadoReserva getEstado() {
		return estado;
	}
	public void setEstado(EstadoReserva estado) {
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
	public Reserva(Cliente cliente, Hotel hotel, TipoHabitacion tipoHabitacion, GregorianCalendar fechaFin, GregorianCalendar fechaInicio, boolean modificablePorHuesped) {
		super();
		this.codigo = new Random().nextLong();
		this.estado = EstadoReserva.Pendiente;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.hotel = hotel;
		this.modificablePorHuesped = modificablePorHuesped;
		this.cliente = cliente;
		this.tipoHabitacion = tipoHabitacion;
	}
	
	public Boolean tieneConflicto(TipoHabitacion th, GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		if(this.tipoHabitacion == th && this.estado != EstadoReserva.Cancelada ) {
			ICalendario cal = Infrastructure.getInstance().getCalendario();
			boolean noTieneConflicto = cal.esAnterior(fechaFin, this.fechaInicio) || cal.esPosterior(fechaInicio, this.fechaFin);
			return !noTieneConflicto;
		}
		return false;
	}
	
	public void enviarEmail() {
		ISistemaMensajeria sm = Infrastructure.getInstance().getSistemaMensajeria();
		String destinatario = this.cliente.getMail();
		String asunto = "Tu Reserva";
		String mensaje = "Tu reserva fue actualizada.";
		sm.enviarMail(destinatario, asunto, mensaje);
	}
}
