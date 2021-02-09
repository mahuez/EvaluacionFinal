package cl.awakelab.EvaluacionFinalModulo5.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {

	
	private String nombre;
	private String apellido;
	private String fechanacimiento;
	
	@Id
	private int runusu;
	private String tipo;

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String fechanacimiento, int runusu, String tipo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.runusu = runusu;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimineto(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public int getRunusu() {
		return runusu;
	}

	public void setRunusu(int runusu) {
		this.runusu = runusu;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", fechanacimiento=" + fechanacimiento
				+ ", runusu=" + runusu + ", tipo=" + tipo + "]";
	}

}
