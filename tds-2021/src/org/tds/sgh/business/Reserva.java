package org.tds.sgh.business;

import java.util.GregorianCalendar;
import java.util.HashSet;
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
	
	public Reserva(Cliente cliente, Hotel hotel, TipoHabitacion tipoHabitacion, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, boolean modificablePorHuesped) {
		this.cliente = cliente;
		this.codigo = Math.abs(new Random().nextLong());
		this.estado = EstadoReserva.Pendiente;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.hotel = hotel;
		this.modificablePorHuesped = modificablePorHuesped;
		this.cliente = cliente;
		this.tipoHabitacion = tipoHabitacion;
		//this.huespedes = new HashSet<Huesped>();
	}
	
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
	
	public String getNombreHabitacion() {
		if(this.habitacion == null) return null;
		return this.habitacion.getNombre();
	}

	public boolean isActiva() {
		return this.estado == EstadoReserva.Pendiente;
	}

	public Reserva agregarHuesped(String nombre, String documento) {
		Huesped hue = new Huesped(nombre, documento);
		this.huespedes.add(hue);
		return this;
	}

	public Reserva modificarReserva(Hotel h, TipoHabitacion th, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, boolean modificablePorHuesped) {
		this.hotel.quitarReserva(this);
		this.hotel = h;
		this.tipoHabitacion = th;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.modificablePorHuesped = modificablePorHuesped;
		this.hotel.agregarReserva(this);
		return this;
	}

	public Reserva asignarHabitacion() {
		this.habitacion = this.hotel.buscarHabitacionDisponible(this.tipoHabitacion);
		this.estado = EstadoReserva.Tomada;
		return this;
	}
}
