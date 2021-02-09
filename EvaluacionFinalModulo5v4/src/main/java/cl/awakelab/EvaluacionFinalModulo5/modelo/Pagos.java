package cl.awakelab.EvaluacionFinalModulo5.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PAGOS")
public class Pagos {

	@Id
	private int idpagos;
	private String fechapago;
	private int monto;
	private String mes;
	private int a�o;
	
    @JoinColumn
	private int cliente_rutcliente;

	public Pagos() {
		super();
	}

	public Pagos(int idpagos, String fechapago, int monto, String mes, int a�o, int cliente_rutcliente) {
		super();
		this.idpagos = idpagos;
		this.fechapago = fechapago;
		this.monto = monto;
		this.mes = mes;
		this.a�o = a�o;
		this.cliente_rutcliente = cliente_rutcliente;
	}

	public int getIdpagos() {
		return idpagos;
	}

	public void setIdpagos(int idpagos) {
		this.idpagos = idpagos;
	}

	public String getFechapago() {
		return fechapago;
	}

	public void setFechapago(String fechapago) {
		this.fechapago = fechapago;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public int getCliente_rutcliente() {
		return cliente_rutcliente;
	}

	public void setCliente_rutcliente(int cliente_rutcliente) {
		this.cliente_rutcliente = cliente_rutcliente;
	}

	@Override
	public String toString() {
		return "Pagos [idpagos=" + idpagos + ", fechapago=" + fechapago + ", monto=" + monto + ", mes=" + mes + ", a�o="
				+ a�o + ", cliente_rutcliente=" + cliente_rutcliente + "]";
	}

}
