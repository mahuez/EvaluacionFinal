package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Profesional;


public interface ProfesionalServicio {

	public List<Profesional> obtenerProfesional();
	public boolean crearProfesional(Profesional pro);
	public boolean eliminarProfesional(Profesional pro);
	public boolean editarProfesional(Profesional pro);
	public Profesional obtenerProfesionalPorRun(int runprof);

}
