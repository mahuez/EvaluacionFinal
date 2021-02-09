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

import cl.awakelab.EvaluacionFinalModulo5.modelo.Visita;
import cl.awakelab.EvaluacionFinalModulo5.servicio.VisitaServicio;

@Controller
public class VisitaControlador {
	
	@Autowired
	VisitaServicio vs;
	
	private static final Logger logger = LoggerFactory.getLogger(VisitaControlador.class);

	//Listar Visita = Obtener Visita
		@RequestMapping(value = "/listarvisita", method = RequestMethod.GET) // listarvisita
		public String obtenerVisita(Model model) { // obtenerVisita = listarVisita
			logger.info("Ingreso al listado de visita");
			List<Visita> listavisita = vs.obtenerVisita();
			model.addAttribute("lvisita", listavisita);
			logger.info("Se mostro listado de visita");
			return "frmlistarvisita";
		}

		
		@RequestMapping(value="/detallevisita/{idvisita}", method = RequestMethod.GET)
		public String detalleVista(Model model, @PathVariable int idvisita) {
			logger.debug("Detalle de la visita");
			Visita detvisi = vs.obtenerVisitaPorId(idvisita);
			model.addAttribute("visi", detvisi);
			return "msgdetallevisita";
		}
		
		
		//Crear Visita
		@RequestMapping(value = "/crearvisita", method = RequestMethod.GET) // crearvisita
		public String crearVisita(Model model) {
			logger.info("Ingreso a crear visita");
			return "frmcrearvisita";
		}

		
		//Procesar Crear Visita
		@RequestMapping(value = "/procesarcrearvisita", method = RequestMethod.POST) // procesarcrearvisita
		public String procesarcrearVisita(Model model, 
				@RequestParam("idvisita") int idvisita,
				@RequestParam("visfecha") String visfecha, 
				@RequestParam("vishora") String vishora,
				@RequestParam("vislugar") String vislugar, 
				@RequestParam("viscomentarios") String viscomentarios,
				@RequestParam("cliente_rutcliente") int cliente_rutcliente) {

			logger.info("Proceso de crear visita");
			Visita visi = new Visita(idvisita, visfecha, vishora, vislugar, viscomentarios,cliente_rutcliente);
			boolean result = vs.crearVisita(visi);
			String mensaje = "";

			if (result) {
				mensaje = "La visita fue creada sin inconvenientes";
				logger.info("Se creó Visita");
			} else {
				mensaje = "Ocurrió un error al momento de crear visita";
				logger.error("Fallo al crear visita");
			}

			model.addAttribute("msgcrear", mensaje);
			return "msgcrearvisita";
		}

		
		//Eliminar Visita
		@RequestMapping(value = "/eliminarvisita/{idvisita}", method = RequestMethod.GET) // eliminarvisita
		public String eliminarVisita(Model model, @PathVariable int idvisita) {
			Visita visi = vs.obtenerVisitaPorId(idvisita);
			vs.eliminarVisita(visi);
			logger.info("Visita eliminada");
			return "msgeliminarvisita";

		}

		
		//Editar Visita
		@RequestMapping(value = "/editarvisita/{idvisita}", method = RequestMethod.GET) // editarvisita
		public String editarVisita(Model model, @PathVariable int idvisita) {
			Visita detvisi = vs.obtenerVisitaPorId(idvisita);
			logger.info("Visita eliminada");
			model.addAttribute("myvis", detvisi);
			return "frmeditarvisita";
		}

		
		//Procesar Visita
		@RequestMapping(value = "/procesaeditarvisita", method = RequestMethod.POST) // procesareditarvisita
		public String procesareditarVisita(Model model, 
				@RequestParam("idvisita") int idvisita,
				@RequestParam("visfecha") String visfecha, 
				@RequestParam("vishora") String vishora,
				@RequestParam("vislugar") String vislugar, 
				@RequestParam("viscomentarios") String viscomentarios,
				@RequestParam("cliente_rutcliente") int cliente_rutcliente) {

			logger.info("Proceso la edición de visita");
			Visita visi = new Visita(idvisita, visfecha, vishora, vislugar, viscomentarios,
					cliente_rutcliente);
			boolean result = vs.editarVisita(visi);
			String mensaje = "";

			if (result) {
				mensaje = "La visita fue editada sin inconvenientes";
				logger.error("Se edito la visita");
			} else {
				mensaje = "Ocurrio un error al momento de ejecutar la edicion";
				logger.error("Fallo al editar la visita");
			}

			model.addAttribute("msgeditar", mensaje);
			return "msgeditarvisita";
		}
}
