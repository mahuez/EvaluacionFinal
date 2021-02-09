package cl.awakelab.EvaluacionFinalModulo5.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PROFESIONAL")
public class Profesional {

	@Id
	private int runprof;
	private String nombres;
	private String apellidos;
	private int telefono;
	private String tituloprofesional;
	private String proyecto;
	
    @JoinColumn
	private int usuario_runusu;

	public Profesional() {
		super();
	}

	public Profesional(int runprof, String nombres, String apellidos, int telefono, String tituloprofesional,
			String proyecto, int usuario_runusu) {
		super();
		this.runprof = runprof;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.tituloprofesional = tituloprofesional;
		this.proyecto = proyecto;
		this.usuario_runusu = usuario_runusu;
	}

	public int getRunprof() {
		return runprof;
	}

	public void setRunprof(int runprof) {
		this.runprof = runprof;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTituloprofesional() {
		return tituloprofesional;
	}

	public void setTituloprofesional(String tituloprofesional) {
		this.tituloprofesional = tituloprofesional;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public int getUsuario_runusu() {
		return usuario_runusu;
	}

	public void setUsuario_runusu(int usuario_runusu) {
		this.usuario_runusu = usuario_runusu;
	}

	@Override
	public String toString() {
		return "Profesional [runprof=" + runprof + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", tituloprofesional=" + tituloprofesional + ", proyecto=" + proyecto + ", usuario_runusu="
				+ usuario_runusu + "]";
	}

	
}
