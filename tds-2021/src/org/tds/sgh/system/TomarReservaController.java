package org.tds.sgh.system;

import java.util.GregorianCalendar;
import java.util.Set;

import org.tds.sgh.business.CadenaHotelera;
import org.tds.sgh.dtos.ClienteDTO;
import org.tds.sgh.dtos.DTO;
import org.tds.sgh.dtos.ReservaDTO;

public class TomarReservaController extends BaseReservaController implements ITomarReservaController {
	public TomarReservaController(CadenaHotelera ch) {
		super(ch);
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
		this.reservaSeleccionada = this.ch.seleccionarReserva(codigoReserva);
		return DTO.getInstance().map(this.reservaSeleccionada);
	}

	@Override
	public ReservaDTO registrarHuesped(String nombre, String documento) throws Exception {
		return DTO.getInstance().map(this.ch.registrarHuesped(this.reservaSeleccionada, nombre, documento));
	}

	@Override
	public ReservaDTO tomarReserva() throws Exception {
		return DTO.getInstance().map(this.ch.tomarReserva(this.reservaSeleccionada));
	}

}
