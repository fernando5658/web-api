package ar.com.educacionit.app.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")

public class Producto {

	@javax.persistence.Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long Id;
	
	// DECLARO LOS CAMPOS DEL MySql PARA REALIZAR LA CONEXIÓN
	@Column(name = "Descripcion")
	private String Descripcion;
	
	@Column(name = "Precio")
	private Double Precio;
	
	@Column(name = "Codigo", unique = true)
	private String Codigo;
	
	public	Producto() {
		
	}

	// CREO UN CONSTRUCTOR CON TODOS LOS CAMPOS
	public Producto(Long id, String descripcion, Double precio, String codigo) {
		super();
		Id = id;
		Descripcion = descripcion;
		Precio = precio;
		Codigo = codigo;
	}
	
	// GENERO GETTERS AND SETTERS 
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	@Override
	public String toString() {
		return "Producto [Id=" + Id + ", Descripcion=" + Descripcion + ", Precio=" + Precio + ", Codigo=" + Codigo
				+ "]";
	}
	
	
	
}
