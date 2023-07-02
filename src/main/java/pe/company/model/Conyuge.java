package pe.company.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="conyuges")
public class Conyuge implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long conyugeDni;
	@Column
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="instructor_id",nullable=false,unique=true,
    foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(instructor_id)references instructores(instructor_id)"))
	private Instructor instructor;
	
	public Conyuge() {}


	
	public Conyuge(Conyuge conyuge) {
        this(conyuge.getConyugeDni(),conyuge.getNombre(),conyuge.getInstructor());
    }


	public Conyuge(Long conyugeDni, String nombre, Instructor instructor) {
		super();
		this.conyugeDni = conyugeDni;
		this.nombre = nombre;
		this.instructor = instructor;
	}


	public Long getConyugeDni() {
		return conyugeDni;
	}

	public void setConyugeDni(Long conyugeDni) {
		this.conyugeDni = conyugeDni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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