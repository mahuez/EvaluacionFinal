package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Capacitacion;


public interface CapacitacionServicio {

	public List<Capacitacion> obtenerCapacitacion();
	public boolean crearCapacitacion(Capacitacion cap);
	public boolean eliminarCapacitacion(Capacitacion cap);
	public boolean editarCapacitacion(Capacitacion cap);
	public Capacitacion obtenerCapacitacionPorId(int idcapacitacion);
}
