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

import cl.awakelab.EvaluacionFinalModulo5.modelo.Administrativo;
import cl.awakelab.EvaluacionFinalModulo5.servicio.AdministrativoServicio;
import cl.awakelab.EvaluacionFinalModulo5.servicio.UsuarioServicio;

@Controller
public class AdministrativoControlador {

	@Autowired
	AdministrativoServicio as;
	UsuarioServicio us;
	
	private static final Logger logger = LoggerFactory.getLogger(AdministrativoControlador.class);
	
	
	//Listar Administrativo = Obtener Administrativo
		@RequestMapping(value = "/listaradministrativo", method = RequestMethod.GET) // listaradministrativo
		public String obtenerAdministrativo(Model model) { // obtenerAdministrativo = listarAdministrativo
			logger.info("Ingreso al listado de administrativo");
			List<Administrativo> listaadm = as.obtenerAdministrativo();
			model.addAttribute("ladministrativo", listaadm);
			logger.info("Se mostro listado de administrativos");
			return "frmlistaradministrativo";
		}

		@RequestMapping(value="/detalleadministrativo/{runadmin}", method = RequestMethod.GET)
		public String detalleAdministrativo(Model model, @PathVariable int runadmin) {
			logger.debug("Detalle de administrativo");
			Administrativo detadm = as.obtenerAdministrativoPorRun(runadmin);
			model.addAttribute("adm", detadm);
			return "msgdetalleadministrativo";
		}
		
		//Crear Cliente
		@RequestMapping(value = "/crearadministrativo", method = RequestMethod.GET) // crearcliente
		public String crearadministrativo(Model model) {
			logger.info("Ingreso a crear cliente");
			return "frmcrearadministrativo";
		}
		
		//Procesar Crear Administrativo
			@RequestMapping(value = "/procesarcrearadministrativo", method = RequestMethod.POST) // procesarcrearcliente
			public String procesarcrearAdministrativo(Model model, 
					@RequestParam("runadmin") int runadmin,
					@RequestParam("nombres") String nombres, 
					@RequestParam("apellidos") String apellidos,
					@RequestParam("email") String email, 
					@RequestParam("area") String area, 
					@RequestParam("usuario_runusu") int usuario_runusu) {

				logger.info("Proceso de crear cliente");
				Administrativo admi = new Administrativo(runadmin,nombres,apellidos,email,area,usuario_runusu);
				boolean result = as.crearAdministrativo(admi);
				String mensaje = "";

				if (result) {
					mensaje = "Administrativo fue creado sin inconvenientes";
					logger.info("Se creó administrativo");
				} else {
					mensaje = "Ocurrió un error al momento de crear administrativo";
					logger.error("Fallo al crear administrativo");
				}

				model.addAttribute("msgcrear", mensaje);
				return "msgcrearadministrativo";
			}
		
			//Eliminar Administrativo
			@RequestMapping(value = "/eliminaradministrativo/{runadmin}", method = RequestMethod.GET) // eliminarcliente
			public String eliminarAdministrativo(Model model, @PathVariable int runadmin) {
				Administrativo admi = as.obtenerAdministrativoPorRun(runadmin);
				as.eliminarAdministrativo(admi);
				logger.info("Administrativo eliminado");
				return "msgeliminaradministrativo";

			}
	
	
			//Editar Administrativo
			@RequestMapping(value = "/editaradministrativo/{runadmin}", method = RequestMethod.GET) // editaradministrativo
			public String editarAdministrativo(Model model, @PathVariable int runadmin) {
				Administrativo detadm = as.obtenerAdministrativoPorRun(runadmin);
				logger.info("Editando administrativo");
				model.addAttribute("myadm", detadm);
				return "frmeditaradministrativo";
			}

			
			//Procesar Administrativo
			@RequestMapping(value = "/procesaeditaradministrativo", method = RequestMethod.POST) // procesareditaradministrativo
			public String procesareditarAdministrativo(Model model, 
					@RequestParam("runadmin") int runadmin,
					@RequestParam("nombres") String nombres, 
					@RequestParam("apellidos") String apellidos,
					@RequestParam("email") String email, 
					@RequestParam("area") String area, 
					@RequestParam("usuario_runusu") int usuario_runusu) {

				logger.info("Proceso la edición de administrativo");
				Administrativo admi = new Administrativo(runadmin,nombres,apellidos,email,area,usuario_runusu);
				boolean result = as.editarAdministrativo(admi);
				String mensaje = "";

				if (result) {
					mensaje = "El/La administrativo fue editado/a sin inconvenientes";
					logger.error("Se edito la cliente");
				} else {
					mensaje = "Ocurrio un error al momento de ejecutar la edicion";
					logger.error("Fallo al editar administrativo");
				}

				model.addAttribute("msgeditar", mensaje);
				return "msgeditaradministrativo";
			}
			
			
}
