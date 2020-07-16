package ec.edu.ups.controlador;

import java.io.Serializable;

public class Roww implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre1;
	private String descripcion;
	private double pun;
	private double ppu;
	private int stock;
	private int cantidad;

	public Roww(String nombre1, String descripcion, double pun, double ppu, int stock) {
		super();
		this.nombre1 = nombre1;
		this.descripcion = descripcion;
		this.pun = pun;
		this.ppu = ppu;
		this.stock = stock;
	}
	
	
	public Roww(String nombre1, String descripcion, double pun, double ppu, int stock, int cantidad) {
		super();
		this.nombre1 = nombre1;
		this.descripcion = descripcion;
		this.pun = pun;
		this.ppu = ppu;
		this.stock = stock;
		this.cantidad=cantidad;
	}


	public String getNombre1() {
		return nombre1;
	}


	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPun() {
		return pun;
	}


	public void setPun(double pun) {
		this.pun = pun;
	}


	public double getPpu() {
		return ppu;
	}


	public void setPpu(double ppu) {
		this.ppu = ppu;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Roww [nombre1=" + nombre1 + ", descripcion=" + descripcion + ", pun=" + pun + ", ppu=" + ppu
				+ ", stock=" + stock + "]";
	}
	
	
	
}
