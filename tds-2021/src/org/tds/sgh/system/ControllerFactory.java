package org.tds.sgh.system;

import org.tds.sgh.business.CadenaHotelera;
import org.tds.sgh.infrastructure.NotImplementedException;


public class ControllerFactory implements IControllerFactory
{
	// --------------------------------------------------------------------------------------------
	
	private CadenaHotelera cadenaHotelera;
	
	// --------------------------------------------------------------------------------------------
	
	public ControllerFactory(CadenaHotelera cadenaHotelera)
	{
		this.cadenaHotelera = cadenaHotelera;
	}
	
	// --------------------------------------------------------------------------------------------
	
	@Override
	public ICadenaController createCadenaController()
	{
		return new CadenaController(this.cadenaHotelera);
	}
	
	@Override
	public ICancelarReservaController createCancelarReservaController()
	{
		return new CancelarReservaController();
	}
	
	@Override
	public IHacerReservaController createHacerReservaController()
	{
		return new HacerReservaController();
	}
	
	@Override
	public IModificarReservaController createModificarReservaController()
	{
		return new ModificarReservaController();
	}
	
	@Override
	public ITomarReservaController createTomarReservaController()
	{
		return new TomarReservaController();
	}
}
