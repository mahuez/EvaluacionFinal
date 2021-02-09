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

import cl.awakelab.EvaluacionFinalModulo5.modelo.Pagos;
import cl.awakelab.EvaluacionFinalModulo5.servicio.ClienteServicio;
import cl.awakelab.EvaluacionFinalModulo5.servicio.PagosServicio;

@Controller
public class PagosControlador {

	@Autowired
	PagosServicio pas;
	ClienteServicio cls;
	
	private static final Logger logger = LoggerFactory.getLogger(PagosControlador.class);
	
	//Listar Pagos = Obtener Pagos
		@RequestMapping(value = "/listarpagos", method = RequestMethod.GET) // listarpagos
		public String obtenerPagos(Model model) { // obtenerPagos = listarPagos
			logger.info("Ingreso al listado de pagos");
			List<Pagos> listapagos = pas.obtenerPagos();
			model.addAttribute("lpagos", listapagos);
			logger.info("Se mostro listado de pagos");
			return "frmlistarpagos";
		}

		
		@RequestMapping(value="/detallepagos/{idpagos}", method = RequestMethod.GET)
		public String detallePagos(Model model, @PathVariable int idpagos) {
			logger.debug("Detalle de la pagos");
			Pagos detpago = pas.obtenerPagosPorId(idpagos);
			model.addAttribute("pago", detpago);
			return "msgdetallepagos";
		}
		
		
		//Crear Pagos
		@RequestMapping(value = "/crearpagos", method = RequestMethod.GET) // crearpagos
		public String crearPagos(Model model) {
			logger.info("Ingreso a crear pagos");
			return "frmcrearpagos";
		}

		
		//Procesar Crear Pagos
		@RequestMapping(value = "/procesarcrearpagos", method = RequestMethod.POST) // procesarcrearpagos
		public String procesarcrearPagos(Model model, 
				@RequestParam("idpagos") int idpagos,
				@RequestParam("fechapago") String fechapago, 
				@RequestParam("monto") int monto,
				@RequestParam("mes") String mes, 
				@RequestParam("año") int año,
				@RequestParam("cliente_rutcliente") int cliente_rutcliente) {

			logger.info("Proceso de crear pagos");
			Pagos pago = new Pagos(idpagos, fechapago, monto, mes, año, cliente_rutcliente);
			boolean result = pas.crearPagos(pago);
			String mensaje = "";

			if (result) {
				mensaje = "El pago fue creado sin inconvenientes";
				logger.info("Se creó pago");
			} else {
				mensaje = "Ocurrió un error al momento de crear pagos";
				logger.error("Fallo al crear pago");
			}

			model.addAttribute("msgcrear", mensaje);
			return "msgcrearpagos";
		}

		
		//Eliminar Pagos
		@RequestMapping(value = "/eliminarpagos/{idpagos}", method = RequestMethod.GET) // eliminarpagos
		public String eliminarPagos(Model model, @PathVariable int idpagos) {
			Pagos pago = pas.obtenerPagosPorId(idpagos);
			pas.eliminarPagos(pago);
			logger.info("Pago eliminado");
			return "msgeliminarpagos";

		}

		
		//Editar Pagos
		@RequestMapping(value = "/editarpagos/{idpagos}", method = RequestMethod.GET) // editarpagos
		public String editarPagos(Model model, @PathVariable int idpagos) {
			Pagos detpago = pas.obtenerPagosPorId(idpagos);
			logger.info("Pago eliminado");
			model.addAttribute("mypago", detpago);
			return "frmeditarpagos";
		}

		
		//Procesar Editar
		@RequestMapping(value = "/procesaeditarpagos", method = RequestMethod.POST) // procesareditarpagos
		public String procesareditarPagos(Model model, 
				@RequestParam("idpagos") int idpagos,
				@RequestParam("fechapago") String fechapago, 
				@RequestParam("monto") int monto,
				@RequestParam("mes") String mes, 
				@RequestParam("año") int año,
				@RequestParam("cliente_rutcliente") int cliente_rutcliente) {

			logger.info("Proceso la edición de pagos");
			Pagos pago = new Pagos(idpagos, fechapago, monto, mes, año, cliente_rutcliente);
			boolean result = pas.editarPagos(pago);
			String mensaje = "";

			if (result) {
				mensaje = "El pago fue editado sin inconvenientes";
				logger.error("Se edito el pago");
			} else {
				mensaje = "Ocurrio un error al momento de ejecutar la edicion";
				logger.error("Fallo al editar el pago");
			}

			model.addAttribute("msgeditar", mensaje);
			return "msgeditarpagos";
		}

}
