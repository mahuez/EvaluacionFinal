package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Administrativo;
import cl.awakelab.EvaluacionFinalModulo5.modelo.AdministrativoRepositorio;

@Service
public class AdministrativoServicioImpl implements AdministrativoServicio {

	@Autowired
	AdministrativoRepositorio ar;
	
	@Override
	public List<Administrativo> obtenerAdministrativo() {
		return (List<Administrativo>) ar.findAll();
	}

	@Override
	public boolean crearAdministrativo(Administrativo adm) {
		ar.save(adm);
		return true;
	}

	@Override
	public boolean eliminarAdministrativo(Administrativo adm) {
		ar.delete(adm);
		return true;
	}

	@Override
	public boolean editarAdministrativo(Administrativo adm) {
		ar.save(adm);
		return true;
	}

	@Override
	public Administrativo obtenerAdministrativoPorRun(int runadmin) {
		// TODO Auto-generated method stub
		return null;
	}

}
