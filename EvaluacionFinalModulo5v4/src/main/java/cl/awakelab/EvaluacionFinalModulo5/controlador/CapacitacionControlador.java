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

import cl.awakelab.EvaluacionFinalModulo5.modelo.Capacitacion;
import cl.awakelab.EvaluacionFinalModulo5.servicio.CapacitacionServicio;
import cl.awakelab.EvaluacionFinalModulo5.servicio.ClienteServicio;



@Controller
public class CapacitacionControlador {

	@Autowired
	CapacitacionServicio cs;
	ClienteServicio cls;

	private static final Logger logger = LoggerFactory.getLogger(CapacitacionControlador.class);

	
	//Listar Capacitacion = Obtener Capacitacion
	@RequestMapping(value = "/listarcapacitacion", method = RequestMethod.GET) // listarcapacitacion
	public String obtenerCapacitacion(Model model) { // obtenerCapacitacion = listarCapacitacion
		logger.info("Ingreso al listado de capacitaciones");
		List<Capacitacion> listacapacitacion = cs.obtenerCapacitacion();
		model.addAttribute("lcapacitacion", listacapacitacion);
		logger.info("Se mostro listado de capacitaciones");
		return "frmlistarcapacitacion";
	}

	
	@RequestMapping(value="/detallecapacitacion/{idcapacitacion}", method = RequestMethod.GET)
	public String detalleProducto(Model model, @PathVariable int idcapacitacion) {
		logger.debug("Detalle de la capacitacion");
		Capacitacion detcapa = cs.obtenerCapacitacionPorId(idcapacitacion);
		model.addAttribute("capa", detcapa);
		return "msgdetallecapacitacion";
	}
	
	
	//Crear Capacitacion
	@RequestMapping(value = "/crearcapacitacion", method = RequestMethod.GET) // crearcapacitacion
	public String crearCapacitacion(Model model) {
		logger.info("Ingreso a crear capacitacion");
		return "frmcrearcapacitacion";
	}

	
	//Procesar Crear Capacitacion
	@RequestMapping(value = "/procesarcrear", method = RequestMethod.POST) // procesarcrear
	public String procesarcrearCapacitacion(Model model, 
			@RequestParam("idcapacitacion") int idcapacitacion,
			@RequestParam("capfecha") String capfecha, 
			@RequestParam("caphora") String caphora,
			@RequestParam("caplugar") String caplugar, 
			@RequestParam("capduracion") int capduracion,
			@RequestParam("cliente_rutcliente") int cliente_rutcliente) {

		logger.info("Proceso de crear capacitacion");
		Capacitacion capa = new Capacitacion(idcapacitacion, capfecha, caphora, caplugar, capduracion,
				cliente_rutcliente);
		boolean result = cs.crearCapacitacion(capa);
		String mensaje = "";

		if (result) {
			mensaje = "La capacitacion fue creada sin inconvenientes";
			logger.info("Se creó capacitacion");
		} else {
			mensaje = "Ocurrió un error al momento de crear capacitacion";
			logger.error("Fallo al crear capacitacion");
		}

		model.addAttribute("msgcrear", mensaje);
		return "msgcrearcapacitacion";
	}

	
	//Eliminar Capacitacion
	@RequestMapping(value = "/eliminarcapacitacion/{idcapacitacion}", method = RequestMethod.GET) // eliminarcapacitacion
	public String eliminarCapacitacion(Model model, @PathVariable int idcapacitacion) {
		Capacitacion capa = cs.obtenerCapacitacionPorId(idcapacitacion);
		cs.eliminarCapacitacion(capa);
		logger.info("Capacitacion eliminada");
		return "msgeliminarcapacitacion";

	}

	
	//Editar Capacitacion
	@RequestMapping(value = "/editarcapacitacion/{idcapacitacion}", method = RequestMethod.GET) // editarcapacitacion
	public String editarCapacitacion(Model model, @PathVariable int idcapacitacion) {
		Capacitacion detcapa = cs.obtenerCapacitacionPorId(idcapacitacion);
		logger.info("Capacitacion eliminada");
		model.addAttribute("mycapa", detcapa);
		return "frmeditarcapacitacion";
	}

	
	//Procesar Editar
	@RequestMapping(value = "/procesaeditarcapa", method = RequestMethod.POST) // procesareditar
	public String procesareditarCapacitacion(Model model, 
			@RequestParam("idcapacitacion") int idcapacitacion,
			@RequestParam("capfecha") String capfecha, 
			@RequestParam("caphora") String caphora,
			@RequestParam("caplugar") String caplugar, 
			@RequestParam("capduracion") int capduracion,
			@RequestParam("cliente_rutcliente") int cliente_rutcliente) {

		logger.info("Proceso la edición de capacitacion");
		Capacitacion capa = new Capacitacion(idcapacitacion, capfecha, caphora, caplugar, capduracion,
				cliente_rutcliente);
		boolean result = cs.editarCapacitacion(capa);
		String mensaje = "";

		if (result) {
			mensaje = "La capacitacion fue editada sin inconvenientes";
			logger.error("Se edito la capacitacion");
		} else {
			mensaje = "Ocurrio un error al momento de ejecutar la edicion";
			logger.error("Fallo al editar la capacitacion");
		}

		model.addAttribute("msgeditar", mensaje);
		return "msgeditarcapacitacion";
	}
}