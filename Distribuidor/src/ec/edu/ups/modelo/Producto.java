package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Distribuidora
 *
 */
@Entity

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String descripcion;
	private double preciounitario;
	private double preciopublico;
	@Transient
	private boolean editable;	
	@ManyToMany
	@JoinColumn
	private Set<Bodega>listaProducto;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facdet")
	private Set<FacturaDetalle>facturaDetalle;	
	
	
	@ManyToOne
	private Categoria categoria;
	 
		public Producto() {
			
		}

	public Producto( String nombre,String descripcion,Double preciounitario, Double preciopublico,Categoria categoria) {
		super();
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.preciounitario=preciounitario;
		this.preciopublico=preciopublico;
		this.categoria=categoria;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(Double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public Double getPreciopublico() {
		return preciopublico;
	}

	public void setPreciopublico(Double preciopublico) {
		this.preciopublico = preciopublico;
	}

	
	
	public Set<Bodega> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(Set<Bodega> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public Set<FacturaDetalle> getFacturaDetalle() {
		return facturaDetalle;
	}

	public void setFacturaDetalle(Set<FacturaDetalle> facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setPreciounitario(double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public void setPreciopublico(double preciopublico) {
		this.preciopublico = preciopublico;
	}

	public boolean isEditable() {
		return editable;
	}
	
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Descripcion=" + descripcion + ", Precio unitario="
				+ preciounitario + ", Precio publico=" + preciopublico ;
	}
	
	
   
}
