package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Pagos;


public interface PagosServicio {

	public List<Pagos> obtenerPagos();
	public boolean crearPagos(Pagos pag);
	public boolean eliminarPagos(Pagos pag);
	public boolean editarPagos(Pagos pag);
	public Pagos obtenerPagosPorId(int idpagos);
}
