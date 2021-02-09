package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Visita;


public interface VisitaServicio {

	public List<Visita> obtenerVisita();
	public boolean crearVisita(Visita vis);
	public boolean eliminarVisita(Visita vis);
	public boolean editarVisita(Visita vis);
	public Visita obtenerVisitaPorId(int idvisita);
}
