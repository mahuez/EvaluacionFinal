package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Pagos;
import cl.awakelab.EvaluacionFinalModulo5.modelo.PagosRepositorio;

@Service
public class PagosServicioImpl implements PagosServicio {

	@Autowired
	PagosRepositorio par;
	
	@Override
	public List<Pagos> obtenerPagos() {
		return (List<Pagos>) par.findAll();
	}

	@Override
	public boolean crearPagos(Pagos pag) {
		par.save(pag);
		return true;
	}

	@Override
	public boolean eliminarPagos(Pagos pag) {
		par.delete(pag);
		return true;
	}

	@Override
	public boolean editarPagos(Pagos pag) {
		par.save(pag);
		return true;
	}

	@Override
	public Pagos obtenerPagosPorId(int idpagos) {
		return par.findOne(idpagos);
	}

}
