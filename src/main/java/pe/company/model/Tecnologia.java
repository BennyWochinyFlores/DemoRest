package pe.company.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="tecnologias")
public class Tecnologia implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tecnologiaId;
	@Column
	private String nombre;
	@Column
	private Date fregistro;
	
	@ManyToMany(mappedBy="itemsTecnologia",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Instructor> itemsInstructo=new HashSet<>();
	
	public Tecnologia() {		
	}
	@PrePersist
	public void prePersist() {
		fregistro=new Date();
	}
	
	public Tecnologia(Tecnologia tecnologia) {
        this(tecnologia.getTecnologiaId(),tecnologia.getNombre(), tecnologia.getFregistro(), tecnologia.getItemsInstructo());
    }
	
	public Tecnologia(Integer tecnologiaId, String nombre, Date fregistro, Set<Instructor> itemsInstructo) {
		super();
		this.tecnologiaId = tecnologiaId;
		this.nombre = nombre;
		this.fregistro = fregistro;
		this.itemsInstructo = itemsInstructo;
	}


	public Integer getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(Integer tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFregistro() {
		return fregistro;
	}

	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}

	public Set<Instructor> getItemsInstructo() {
		return itemsInstructo;
	}

	public void setItemsInstructo(Set<Instructor> itemsInstructo) {
		this.itemsInstructo = itemsInstructo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
