package org.tds.sgh.system;

import java.util.GregorianCalendar;
import java.util.Set;

import org.tds.sgh.business.CadenaHotelera;
import org.tds.sgh.business.Cliente;
import org.tds.sgh.dtos.ClienteDTO;
import org.tds.sgh.dtos.DTO;
import org.tds.sgh.dtos.HotelDTO;
import org.tds.sgh.dtos.ReservaDTO;

public class HacerReservaController implements IHacerReservaController {
	private CadenaHotelera ch;
	private Cliente clienteSeleccionado;
	
	public HacerReservaController(CadenaHotelera ch) {
		this.ch = ch;
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
	public ClienteDTO registrarCliente(String rut, String nombre, String direccion, String telefono, String mail)
			throws Exception {
		return DTO.getInstance().map(this.ch.agregarCliente(rut, nombre, direccion, telefono, mail));
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

}
