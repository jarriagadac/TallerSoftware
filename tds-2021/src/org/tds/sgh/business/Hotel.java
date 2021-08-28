package org.tds.sgh.business;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hotel {
	// --------------------------------------------------------------------------------------------

	private Map<String, Habitacion> habitaciones;
	private Map<String, Habitacion> habitacionesTomadas;
	private Map<Long, Reserva> reservas;

	private String nombre;

	private String pais;

	// --------------------------------------------------------------------------------------------

	public Hotel(String nombre, String pais) {
		this.habitaciones = new HashMap<String, Habitacion>();
		this.habitacionesTomadas = new HashMap<String, Habitacion>();
		this.reservas = new HashMap<Long, Reserva>();

		this.nombre = nombre;

		this.pais = pais;
	}

	// --------------------------------------------------------------------------------------------

	public Habitacion agregarHabitacion(TipoHabitacion tipoHabitacion, String nombre) throws Exception {
		if (this.habitaciones.containsKey(nombre)) {
			throw new Exception("El hotel ya tiene una habitación con el nombre indicado.");
		}

		Habitacion habitacion = new Habitacion(tipoHabitacion, nombre);

		this.habitaciones.put(habitacion.getNombre(), habitacion);

		return habitacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public Set<Habitacion> listarHabitaciones() {
		return new HashSet<Habitacion>(this.habitaciones.values());
	}

	public boolean confirmarDisponibilidad(TipoHabitacion th, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin) {
		int cantHabs = 0;
		for (Habitacion hab : this.habitaciones.values()) {
			if(hab.habDeTipo(th)) cantHabs++;
		}
		int cantRes = 0;
		for(Reserva res : this.reservas.values()) {
			if(res.tieneConflicto(th, fechaInicio, fechaFin)) cantRes++;
		}
		return cantHabs > cantRes;
	}
	
	public Reserva registrarReserva(Cliente cliente, TipoHabitacion th, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, boolean ModificablePorHuesped) {
		Reserva reserva = new Reserva(cliente, this, th, fechaInicio, fechaFin, ModificablePorHuesped);
		this.reservas.put(reserva.getCodigo(), reserva);
		return reserva;
	}

	public Set<Reserva> buscarReservasPendientes() {
		Set<Reserva> reservas = new HashSet<Reserva>();
		for(Reserva res : this.reservas.values()) {
			if(res.getEstado() == EstadoReserva.Pendiente) reservas.add(res);
		}
		return reservas;
	}

	public void quitarReserva(Reserva reserva) {
		this.reservas.remove(reserva.getCodigo());
	}

	public void agregarReserva(Reserva reserva) {
		this.reservas.put(reserva.getCodigo(), reserva);
	}

	public Habitacion buscarHabitacionDisponible(TipoHabitacion tipoHabitacion) {
		for(Habitacion hab : this.habitaciones.values()) {
			if(hab.habDeTipo(tipoHabitacion) && this.habitacionesTomadas.containsValue(hab)) {
				this.habitacionesTomadas.put(hab.getNombre(), hab);
				return hab;
			}
		}
		return null;
	}
}
