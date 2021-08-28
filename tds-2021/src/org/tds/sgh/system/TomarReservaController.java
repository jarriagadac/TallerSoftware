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

public class TomarReservaController implements ITomarReservaController {
	private CadenaHotelera ch;
	private Cliente clienteSeleccionado;
	private Reserva reservaSeleccionada;
	
	public TomarReservaController(CadenaHotelera ch) {
		this.ch = ch;
	}
	
	@Override
	public Set<ReservaDTO> buscarReservasDelCliente() throws Exception {
		return DTO.getInstance().mapReservas(this.ch.buscarReservasDelCliente(this.clienteSeleccionado));
	}

	@Override
	public Set<ClienteDTO> buscarCliente(String patronNombreCliente) {
		return DTO.getInstance().mapClientes(this.ch.buscarClientes(patronNombreCliente));
	}

	@Override
	public ClienteDTO seleccionarCliente(String rut) throws Exception {
		this.clienteSeleccionado = this.ch.buscarCliente(rut);
		return DTO.getInstance().map(this.clienteSeleccionado);
	}

	@Override
	public boolean confirmarDisponibilidad(String nombreHotel, String nombreTipoHabitacion,
			GregorianCalendar fechaInicio, GregorianCalendar fechaFin) throws Exception {
		return this.ch.confirmarDisponibilidad(nombreHotel, nombreTipoHabitacion, fechaInicio, fechaFin);
	}

	@Override
	public ReservaDTO registrarReserva(String nombreHotel, String nombreTipoHabitacion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin, boolean modificablePorHuesped) throws Exception {
		return DTO.getInstance().map(this.ch.registrarReserva(this.clienteSeleccionado, nombreHotel, nombreTipoHabitacion, fechaInicio, fechaFin, modificablePorHuesped));
	}

	@Override
	public Set<HotelDTO> sugerirAlternativas(String pais, String nombreTipoHabitacion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin) throws Exception {
		return DTO.getInstance().mapHoteles(this.ch.sugerirAlternativas(pais, nombreTipoHabitacion, fechaInicio, fechaFin)); 
	}

	@Override
	public ClienteDTO registrarCliente(String rut, String nombre, String direccion, String telefono, String mail)
			throws Exception {
		this.clienteSeleccionado = this.ch.agregarCliente(rut, nombre, direccion, telefono, mail);
		return DTO.getInstance().map(this.clienteSeleccionado);
	}

	@Override
	public ReservaDTO modificarReserva(String nombreHotel, String nombreTipoHabitacion, GregorianCalendar fechaInicio,
			GregorianCalendar fechaFin, boolean modificablePorHuesped) throws Exception {
		return DTO.getInstance().map(this.ch.modificarReserva(this.reservaSeleccionada, nombreHotel, nombreTipoHabitacion, fechaInicio, fechaFin, modificablePorHuesped));
	} 

	@Override
	public Set<ReservaDTO> buscarReservasPendientes(String nombreHotel) throws Exception {
		return DTO.getInstance().mapReservas(this.ch.buscarReservasPendientes(nombreHotel));
	}

	@Override
	public ReservaDTO seleccionarReserva(long codigoReserva) throws Exception {
		this.reservaSeleccionada = this.ch.seleccionarReserva(this.clienteSeleccionado, codigoReserva);
		return DTO.getInstance().map(this.reservaSeleccionada);
	}

	@Override
	public ReservaDTO registrarHuesped(String nombre, String documento) throws Exception {
		return DTO.getInstance().map(this.ch.registrarHuesped(this.reservaSeleccionada, nombre, documento));
	}

	@Override
	public ReservaDTO tomarReserva() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
