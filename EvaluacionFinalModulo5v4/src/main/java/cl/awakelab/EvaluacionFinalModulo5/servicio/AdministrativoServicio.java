package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;


import cl.awakelab.EvaluacionFinalModulo5.modelo.Administrativo;



public interface AdministrativoServicio {

	public List<Administrativo> obtenerAdministrativo();
	public boolean crearAdministrativo(Administrativo adm);
	public boolean eliminarAdministrativo(Administrativo adm);
	public boolean editarAdministrativo(Administrativo adm);
	public Administrativo obtenerAdministrativoPorRun(int runadmin);
	
}

