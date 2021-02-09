package cl.awakelab.EvaluacionFinalModulo5.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINISTRATIVO")
public class Administrativo {

	@Id
	private int rutadmin;
	private String nombres;
	private String apellidos;
	private String email;
	private String area;
	
    @JoinColumn
	private int usuario_runusu;

	public Administrativo() {
		super();
	}

	public Administrativo(int rutadmin, String nombres, String apellidos, String email, String area,
			int usuario_runusu) {
		super();
		this.rutadmin = rutadmin;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.area = area;
		this.usuario_runusu = usuario_runusu;
	}

	public int getRutadmin() {
		return rutadmin;
	}

	public void setRutadmin(int rutadmin) {
		this.rutadmin = rutadmin;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getUsuario_runusu() {
		return usuario_runusu;
	}

	public void setUsuario_runusu(int usuario_runusu) {
		this.usuario_runusu = usuario_runusu;
	}

	@Override
	public String toString() {
		return "Administrativo [rutadmin=" + rutadmin + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email="
				+ email + ", area=" + area + ", usuario_runusu=" + usuario_runusu + "]";
	}

	
}