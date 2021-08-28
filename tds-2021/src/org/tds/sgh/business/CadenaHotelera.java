package org.tds.sgh.business;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.tds.sgh.dtos.DTO;
import org.tds.sgh.dtos.HotelDTO;
import org.tds.sgh.dtos.HuespedDTO;
import org.tds.sgh.dtos.ReservaDTO;
import org.tds.sgh.infrastructure.NotImplementedException;

public class CadenaHotelera {
	// --------------------------------------------------------------------------------------------

	private Map<String, Cliente> clientes;
	private Map<String, Hotel> hoteles;
	private String nombre;
	private Map<String, TipoHabitacion> tiposHabitacion;
	private Object reserva;
	
	// --------------------------------------------------------------------------------------------

	public CadenaHotelera(String nombre) {
		this.clientes = new HashMap<String, Cliente>();
		this.hoteles = new HashMap<String, Hotel>();
		this.nombre = nombre;
		this.tiposHabitacion = new HashMap<String, TipoHabitacion>();
	}

	// --------------------------------------------------------------------------------------------

	public Cliente agregarCliente(String rut, String nombre, String direccion, String telefono, String mail)
			throws Exception {
		if (this.clientes.containsKey(rut)) {
			throw new Exception("Ya existe un cliente con el RUT indicado.");
		}

		Cliente cliente = new Cliente(rut, nombre, direccion, telefono, mail);

		this.clientes.put(cliente.getRut(), cliente);

		return cliente;
	}

	public Hotel agregarHotel(String nombre, String pais) throws Exception {
		if (this.hoteles.containsKey(nombre)) {
			throw new Exception("Ya existe un hotel con el nombre indicado.");
		}

		Hotel hotel = new Hotel(nombre, pais);

		this.hoteles.put(hotel.getNombre(), hotel);

		return hotel;
	}

	public TipoHabitacion agregarTipoHabitacion(String nombre) throws Exception {
		if (this.tiposHabitacion.containsKey(nombre)) {
			throw new Exception("Ya existe un tipo de habitación con el nombre indicado.");
		}

		TipoHabitacion tipoHabitacion = new TipoHabitacion(nombre);

		this.tiposHabitacion.put(tipoHabitacion.getNombre(), tipoHabitacion);

		return tipoHabitacion;
	}

	public Cliente buscarCliente(String rut) throws Exception {
		Cliente cliente = this.clientes.get(rut);

		if (cliente == null) {
			throw new Exception("No existe un cliente con el nombre indicado.");
		}

		return cliente;
	}

	public Set<Cliente> buscarClientes(String patronNombreCliente) {
		Set<Cliente> clientesEncontrados = new HashSet<Cliente>();

		for (Cliente cliente : this.clientes.values()) {
			if (cliente.coincideElNombre(patronNombreCliente)) {
				clientesEncontrados.add(cliente);
			}
		}

		return clientesEncontrados;
	}

	public Hotel buscarHotel(String nombre) throws Exception {
		Hotel hotel = this.hoteles.get(nombre);

		if (hotel == null) {
			throw new Exception("No existe un hotel con el nombre indicado.");
		}

		return hotel;
	}

	public TipoHabitacion buscarTipoHabitacion(String nombre) throws Exception {
		TipoHabitacion tipoHabitacion = this.tiposHabitacion.get(nombre);

		if (tipoHabitacion == null) {
			throw new Exception("No existe un tipo de habitación con el nombre indicado.");
		}

		return tipoHabitacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Set<Cliente> listarClientes() {
		return new HashSet<Cliente>(this.clientes.values());
	}

	public Set<Hotel> listarHoteles() {
		return new HashSet<Hotel>(this.hoteles.values());
	}

	public Set<TipoHabitacion> listarTiposHabitacion() {
		return new HashSet<TipoHabitacion>(this.tiposHabitacion.values());
	}


	public Set<Reserva> buscarReservasPendientes(String nombreHotel) {
		Hotel h = this.hoteles.get(nombreHotel);
		return h.buscarReservasPendientes();
	}

	public Reserva seleccionarReserva(Cliente cliente, long codigoReserva) {
		return cliente.buscarReservaPorCodigo(codigoReserva);
	}

	public Set<Reserva> buscarReservasDelCliente(Cliente cliente) {
		return cliente.buscarReservasActivas();
	}

	public Reserva registrarHuesped(Reserva reserva, String nombre, String documento) {
		return reserva.agregarHuesped(nombre, documento);
	}

	public Reserva modificarReserva(Reserva reserva, String nombreHotel, String nombreTipoHabitacion,
			GregorianCalendar fechaInicio, GregorianCalendar fechaFin, boolean modificablePorHuesped) {
		Hotel h = this.hoteles.get(nombreHotel);
		TipoHabitacion th = this.tiposHabitacion.get(nombreTipoHabitacion);
		reserva = reserva.modificarReserva(h, th, fechaInicio, fechaFin, modificablePorHuesped);
		reserva.enviarEmail();
		return reserva;
	}

	public Reserva tomarReserva(Reserva reserva) {
		return reserva.asignarHabitacion();
	}
	
	public Set<Hotel> sugerirAlternativas(String pais, String nombreTipoHabitacion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin) throws Exception {
		Set<Hotel> hoteles = new HashSet<Hotel>();
		TipoHabitacion th = this.tiposHabitacion.get(nombreTipoHabitacion);
		for(Hotel h : this.hoteles.values()) {
			if(h.confirmarDisponibilidad(th, fechaInicio, fechaFin) && h.getPais() == pais) {
				hoteles.add(h);
			}
		}
		return hoteles;
	}
	

	public Reserva registrarReserva(Cliente cliente, String nombreHotel, String nombreTipoHabitacion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin, boolean modificablePorHuesped) throws Exception {
		Hotel h = this.hoteles.get(nombreHotel);
		TipoHabitacion th = this.tiposHabitacion.get(nombreTipoHabitacion);
		
		Reserva reserva = h.registrarReserva(cliente, th, fechaInicio, fechaFin, modificablePorHuesped);
		cliente.agregarReserva(reserva);
		reserva.enviarEmail();
		return reserva;
	}
	
	
	public boolean confirmarDisponibilidad(String nombreHotel, String nombreTipoHabitacion,
			GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		Hotel h = this.hoteles.get(nombreHotel);
		TipoHabitacion th = this.tiposHabitacion.get(nombreTipoHabitacion);
		
		return h.confirmarDisponibilidad(th, fechaInicio, fechaFin);
	}
}
