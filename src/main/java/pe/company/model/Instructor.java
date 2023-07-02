package pe.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="instructores")
public class Instructor implements Serializable
{
	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer instructorId;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String password;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date fregistro;
	
	@OneToOne(mappedBy="instructor")
	@JsonIgnoreProperties({ "instructor"})
	private Conyuge conyuge;
	
	@OneToMany(mappedBy="instructor")
	@JsonIgnoreProperties({ "instructor"})
	private Collection<Taller> itemsTaller=new ArrayList<>();
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="instructores_tecnologias",
	           joinColumns=@JoinColumn(name="instructor_id",nullable=false,
	           foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(instructor_id) references instructores(instructor_id)")),
	           inverseJoinColumns=@JoinColumn(name="tecnologia_id",nullable=false,
	           foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(tecnologia_id) references tecnologias(tecnologia_id)")))
	private Set<Tecnologia> itemsTecnologia=new HashSet<>();

	public Instructor() {
		
	}


	public Integer getInstructorId() {
		return instructorId;
	}
	
	@PrePersist
	public void prePersist() {
		fregistro=new Date();
	}


	public Instructor(Integer instructorId, String nombre, String apellidos, String password, String email,
			Date fregistro, Conyuge conyuge, Collection<Taller> itemsTaller, Set<Tecnologia> itemsTecnologia) {
		super();
		this.instructorId = instructorId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.email = email;
		this.fregistro = fregistro;
		this.conyuge = conyuge;
		this.itemsTaller = itemsTaller;
		this.itemsTecnologia = itemsTecnologia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFregistro() {
		return fregistro;
	}


	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}


	public Conyuge getConyuge() {
		return conyuge;
	}


	public void setConyuge(Conyuge conyuge) {
		this.conyuge = conyuge;
	}


	public Collection<Taller> getItemsTaller() {
		return itemsTaller;
	}


	public void setItemsTaller(Collection<Taller> itemsTaller) {
		this.itemsTaller = itemsTaller;
	}


	public Set<Tecnologia> getItemsTecnologia() {
		return itemsTecnologia;
	}


	public void setItemsTecnologia(Set<Tecnologia> itemsTecnologia) {
		this.itemsTecnologia = itemsTecnologia;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}

	public void addTecnologia(Tecnologia tecnologia) {
	    itemsTecnologia.add(tecnologia);
	    tecnologia.getItemsInstructo().add(this);
	}


}


