package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Capacitacion;
import cl.awakelab.EvaluacionFinalModulo5.modelo.CapacitacionRepositorio;


@Service
public class CapacitacionServicioImpl implements CapacitacionServicio {

	@Autowired
	CapacitacionRepositorio cr;
	
	@Override
	public List<Capacitacion> obtenerCapacitacion() {
		return (List<Capacitacion>) cr.findAll();
	}

	@Override
	public boolean crearCapacitacion(Capacitacion cap) {
		cr.save(cap);
		return true;
	}

	@Override
	public boolean eliminarCapacitacion(Capacitacion cap) {
		cr.delete(cap);
		return true;
	}

	@Override
	public boolean editarCapacitacion(Capacitacion cap) {
		cr.save(cap);
		return true;
	}

	@Override
	public Capacitacion obtenerCapacitacionPorId(int idcapacitacion) {
		return cr.findOne(idcapacitacion);
	}

}
