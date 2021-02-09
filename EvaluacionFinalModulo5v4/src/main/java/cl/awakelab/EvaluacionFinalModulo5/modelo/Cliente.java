package cl.awakelab.EvaluacionFinalModulo5.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	
	@Id
	private int rutcliente;
	private String clinombres;
	private String cliapellidos;
	private String clitelefono;
	private String cliafp;
	private String clisistemasalud;
	private String clidireccion;
	private String clicomuna;
	private int cliedad;
	
    @JoinColumn
	private int usuario_runusu;

	public Cliente() {
		super();
	}

	public Cliente(int rutcliente, String clinombres, String cliapellidos, String clitelefono, String cliafp,
			String clisistemasalud, String clidireccion, String clicomuna, int cliedad, int usuario_runusu) {
		super();
		this.rutcliente = rutcliente;
		this.clinombres = clinombres;
		this.cliapellidos = cliapellidos;
		this.clitelefono = clitelefono;
		this.cliafp = cliafp;
		this.clisistemasalud = clisistemasalud;
		this.clidireccion = clidireccion;
		this.clicomuna = clicomuna;
		this.cliedad = cliedad;
		this.usuario_runusu = usuario_runusu;
	}

	public int getRutcliente() {
		return rutcliente;
	}

	public void setRutcliente(int rutcliente) {
		this.rutcliente = rutcliente;
	}

	public String getClinombres() {
		return clinombres;
	}

	public void setClinombres(String clinombres) {
		this.clinombres = clinombres;
	}

	public String getCliapellidos() {
		return cliapellidos;
	}

	public void setCliapellidos(String cliapellidos) {
		this.cliapellidos = cliapellidos;
	}

	public String getClitelefono() {
		return clitelefono;
	}

	public void setClitelefono(String clitelefono) {
		this.clitelefono = clitelefono;
	}

	public String getCliafp() {
		return cliafp;
	}

	public void setCliafp(String cliafp) {
		this.cliafp = cliafp;
	}

	public String getClisistemasalud() {
		return clisistemasalud;
	}

	public void setClisistemasalud(String clisistemasalud) {
		this.clisistemasalud = clisistemasalud;
	}

	public String getClidireccion() {
		return clidireccion;
	}

	public void setClidireccion(String clidireccion) {
		this.clidireccion = clidireccion;
	}

	public String getClicomuna() {
		return clicomuna;
	}

	public void setClicomuna(String clicomuna) {
		this.clicomuna = clicomuna;
	}

	public int getCliedad() {
		return cliedad;
	}

	public void setCliedad(int cliedad) {
		this.cliedad = cliedad;
	}

	public int getUsuario_runusu() {
		return usuario_runusu;
	}

	public void setUsuario_runusu(int usuario_runusu) {
		this.usuario_runusu = usuario_runusu;
	}

	@Override
	public String toString() {
		return "Cliente [rutcliente=" + rutcliente + ", clinombres=" + clinombres + ", cliapellidos=" + cliapellidos
				+ ", clitelefono=" + clitelefono + ", cliafp=" + cliafp + ", clisistemasalud=" + clisistemasalud
				+ ", clidireccion=" + clidireccion + ", clicomuna=" + clicomuna + ", cliedad=" + cliedad
				+ ", usuario_runusu=" + usuario_runusu + "]";
	}
	
	
	
	
	
	

}
