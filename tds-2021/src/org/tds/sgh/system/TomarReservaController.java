package org.tds.sgh.system;

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
	public Set<ClienteDTO> buscarCliente(String patronNombreCliente) {
		return DTO.getInstance().mapClientes(this.ch.buscarClientes(patronNombreCliente));
	}

	@Override
	public Set<ReservaDTO> buscarReservasPendientes(String nombreHotel) throws Exception {
		return DTO.getInstance().mapReservas(this.ch.buscarReservasPendientes(nombreHotel));
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
