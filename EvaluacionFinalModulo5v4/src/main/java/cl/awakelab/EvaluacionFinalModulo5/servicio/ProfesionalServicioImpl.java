package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Profesional;
import cl.awakelab.EvaluacionFinalModulo5.modelo.ProfesionalRepositorio;

@Service
public class ProfesionalServicioImpl implements ProfesionalServicio{

	@Autowired
	ProfesionalRepositorio pr;
	
	@Override
	public List<Profesional> obtenerProfesional() {
		return (List<Profesional>) pr.findAll();
	}

	@Override
	public boolean crearProfesional(Profesional pro) {
		pr.save(pro);
		return true;
	}

	@Override
	public boolean eliminarProfesional(Profesional pro) {
		pr.delete(pro);
		return true;
	}

	@Override
	public boolean editarProfesional(Profesional pro) {
		pr.save(pro);
		return true;
	}

	@Override
	public Profesional obtenerProfesionalPorRun(int runprof) {
		// TODO Auto-generated method stub
		return null;
	}

}
