package org.tds.sgh.system;

import java.util.Set;

import org.tds.sgh.business.CadenaHotelera;
import org.tds.sgh.business.Cliente;
import org.tds.sgh.dtos.ClienteDTO;
import org.tds.sgh.dtos.DTO;
import org.tds.sgh.dtos.ReservaDTO;

public class CancelarReservaController extends BaseReservaController implements ICancelarReservaController {
	public CancelarReservaController(CadenaHotelera ch) {
		super(ch);
	}

	@Override
	public ReservaDTO cancelarReservaDelCliente() throws Exception {
		return DTO.getInstance().map(this.ch.cancelarReserva(this.reservaSeleccionada));
	}

}
