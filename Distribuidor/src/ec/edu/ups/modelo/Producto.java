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
	private boolean editable;
	@ManyToOne
	private Bodega bodega;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
	private Set<FacturaDetalle>facturaDetalle;
	private FacturaDetalle producto;
	
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

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
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
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", preciounitario="
				+ preciounitario + ", preciopublico=" + preciopublico + ", bodega=" + bodega + "]";
	}
	
	
   
}
