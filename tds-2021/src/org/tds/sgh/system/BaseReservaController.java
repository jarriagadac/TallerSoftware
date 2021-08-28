package org.tds.sgh.system;

import java.util.GregorianCalendar;
import java.util.Set;

import org.tds.sgh.business.CadenaHotelera;
import org.tds.sgh.business.Cliente;
import org.tds.sgh.business.Reserva;
import org.tds.sgh.dtos.ClienteDTO;
import org.tds.sgh.dtos.DTO;
import org.tds.sgh.dtos.HotelDTO;
import org.tds.sgh.dtos.ReservaDTO;

public class BaseReservaController {
	protected CadenaHotelera ch;
	protected Cliente clienteSeleccionado;
	protected Reserva reservaSeleccionada;
	
	public BaseReservaController(CadenaHotelera ch) {
		this.ch = ch;
	}
	
	public Set<ClienteDTO> buscarCliente(String patronNombreCliente) {
		return DTO.getInstance().mapClientes(this.ch.buscarClientes(patronNombreCliente));
	}
	
	public boolean confirmarDisponibilidad(String nombreHotel, String nombreTipoHabitacion,
			GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		return this.ch.confirmarDisponibilidad(nombreHotel, nombreTipoHabitacion, fechaInicio, fechaFin);
	}
	
	public ClienteDTO seleccionarCliente(String rut) throws Exception {
		this.clienteSeleccionado = this.ch.buscarCliente(rut);
		return DTO.getInstance().map(this.clienteSeleccionado);
	}
	
	public ClienteDTO registrarCliente(String rut, String nombre, String direccion, String telefono, String mail)
			throws Exception {
		this.clienteSeleccionado = this.ch.agregarCliente(rut, nombre, direccion, telefono, mail);
		return DTO.getInstance().map(this.clienteSeleccionado);
	}
	
	public ReservaDTO registrarReserva(String nombreHotel, String nombreTipoHabitacion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin, boolean modificablePorHuesped) throws Exception {
		this.reservaSeleccionada = this.ch.registrarReserva(this.clienteSeleccionado, nombreHotel, nombreTipoHabitacion, fechaInicio, fechaFin, modificablePorHuesped);
		return DTO.getInstance().map(this.reservaSeleccionada);
	}
	
	public Set<HotelDTO> sugerirAlternativas(String pais, String nombreTipoHabitacion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin) throws Exception {
		return DTO.getInstance().mapHoteles(this.ch.sugerirAlternativas(pais, nombreTipoHabitacion, fechaInicio, fechaFin)); 
	}
	
	public Set<ReservaDTO> buscarReservasDelCliente() throws Exception {
		return DTO.getInstance().mapReservas(this.ch.buscarReservasDelCliente(this.clienteSeleccionado));
	}
	
	public ReservaDTO seleccionarReserva(long codigoReserva) throws Exception {
		this.reservaSeleccionada = this.ch.seleccionarReserva(codigoReserva);
		return DTO.getInstance().map(this.reservaSeleccionada);
	}
	
	public ReservaDTO modificarReserva(String nombreHotel, String nombreTipoHabitacion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin, boolean modificablePorHuesped) throws Exception {
		return DTO.getInstance().map(this.ch.modificarReserva(this.reservaSeleccionada, nombreHotel, nombreTipoHabitacion, fechaInicio, fechaFin, modificablePorHuesped));
	} 
}
