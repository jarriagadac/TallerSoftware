package org.tds.sgh.business;

public class Huesped {
	private String nombre;
	private String documento;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Huesped(String nombre, String documento) {
		super();
		this.nombre = nombre;
		this.documento = documento;
	}
	
	
}
