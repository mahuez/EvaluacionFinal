package cl.awakelab.EvaluacionFinalModulo5.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Profesional;
import cl.awakelab.EvaluacionFinalModulo5.servicio.ProfesionalServicio;
import cl.awakelab.EvaluacionFinalModulo5.servicio.UsuarioServicio;

@Controller
public class ProfesionalControlador {

	@Autowired
	ProfesionalServicio ps;
	UsuarioServicio us;

private static final Logger logger = LoggerFactory.getLogger(ProfesionalControlador.class);

//Listar Profesional = Obtener Profesional
	@RequestMapping(value = "/listarprofesional", method = RequestMethod.GET) // listarprofesional
	public String obtenerProfesional(Model model) { // obtenerProfesional = listarProfesional
		logger.info("Ingreso al listado de cliente");
		List<Profesional> listaprofesional = ps.obtenerProfesional();
		model.addAttribute("lprofesional", listaprofesional);
		logger.info("Se mostro listado de profesionales");
		return "frmlistarprofesional";
	}

	@RequestMapping(value="/detalleprofesional/{runprof}", method = RequestMethod.GET)
	public String detalleProfesional(Model model, @PathVariable int runprof) {
		logger.debug("Detalle del profesional");
		Profesional detpro = ps.obtenerProfesionalPorRun(runprof);
		model.addAttribute("pro", detpro);
		return "msgdetalleprofesional";
	}
	
	//Crear Profesional
	@RequestMapping(value = "/crearprofesional", method = RequestMethod.GET) // crearcliente
	public String crearCliente(Model model) {
		logger.info("Ingreso a crear cliente");
		return "frmcrearprofesional";
	}
	

	//Procesar Crear Profesional
		@RequestMapping(value = "/procesarcrearprofesional", method = RequestMethod.POST) // procesarcrearprofesional
		public String procesarcrearProfesional(Model model, 
				@RequestParam("runprof") int runprof,
				@RequestParam("nombres") String nombres, 
				@RequestParam("apellidos") String apellidos,
				@RequestParam("telefono") int telefono, 
				@RequestParam("tituloprofesional") String tituloprofesional,
				@RequestParam("proyecto") String proyecto, 
				@RequestParam("usuario_runusuario") int usuario_runusu) {

			logger.info("Proceso de crear cliente");
			Profesional prof = new Profesional(runprof,nombres,apellidos,telefono,tituloprofesional,proyecto,usuario_runusu);
			boolean result = ps.crearProfesional(prof);
			String mensaje = "";

			if (result) {
				mensaje = "Profesional fue creado sin inconvenientes";
				logger.info("Se creó profesional");
			} else {
				mensaje = "Ocurrió un error al momento de crear profesional";
				logger.error("Fallo al crear profesional");
			}

			model.addAttribute("msgcrear", mensaje);
			return "msgcrearprofesional";
		}
	
		//Eliminar Profesional
		@RequestMapping(value = "/eliminarprofesional/{runprof}", method = RequestMethod.GET) // eliminarprofesional
		public String eliminarProfesional(Model model, @PathVariable int runprof) {
			Profesional prof = ps.obtenerProfesionalPorRun(runprof);
			ps.eliminarProfesional(prof);
			logger.info("Profesional eliminado");
			return "msgeliminarprofesional";

		}

		
		//Editar Profesional
		@RequestMapping(value = "/editarprofesional/{runprof}", method = RequestMethod.GET) // editarprofesional
		public String editarProfesional(Model model, @PathVariable int runprof) {
			Profesional detprof = ps.obtenerProfesionalPorRun(runprof);
			logger.info("Editando profesional");
			model.addAttribute("myprof", detprof);
			return "frmeditarprofesional";
		}

		
		//Procesar Editar
		@RequestMapping(value = "/procesaeditarprofesional", method = RequestMethod.POST) // procesareditarprofesional
		public String procesareditarProfesional(Model model, 
				@RequestParam("runprof") int runprof,
				@RequestParam("nombres") String nombres, 
				@RequestParam("apellidos") String apellidos,
				@RequestParam("telefono") int telefono, 
				@RequestParam("tituloprofesional") String tituloprofesional,
				@RequestParam("proyecto") String proyecto, 
				@RequestParam("usuario_runusuario") int usuario_runusu) {

			logger.info("Proceso la edición de profesional");
			Profesional prof = new Profesional(runprof,nombres,apellidos,telefono,tituloprofesional,proyecto,usuario_runusu);
			boolean result = ps.editarProfesional(prof);
			String mensaje = "";

			if (result) {
				mensaje = "El/La profesional fue editado/a sin inconvenientes";
				logger.error("Se edito la profesional");
			} else {
				mensaje = "Ocurrio un error al momento de ejecutar la edicion";
				logger.error("Fallo al editar el/la profesional");
			}

			model.addAttribute("msgeditar", mensaje);
			return "msgeditarprofesional";
		}

}
