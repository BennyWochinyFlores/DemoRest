package pe.company.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="talleres")
public class Taller implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tallerId;
	@Column
	private String nombre;
	@Column
	private float costo;
	
	@ManyToOne
	@JoinColumn(name="instructor_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(instructor_id) references instructores(instructor_id)"))
	private Instructor instructor;
	
	public Taller() {		
	}

	
	public Taller(Taller taller) {
        this(taller.getTallerId(), taller.getNombre(), taller.getCosto(),taller.getInstructor());
    }
	
	public Taller(Integer tallerId, String nombre, float costo, Instructor instructor) {
		super();
		this.tallerId = tallerId;
		this.nombre = nombre;
		this.costo = costo;
		this.instructor = instructor;
	}


	public Integer getTallerId() {
		return tallerId;
	}

	public void setTallerId(Integer tallerId) {
		this.tallerId = tallerId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
