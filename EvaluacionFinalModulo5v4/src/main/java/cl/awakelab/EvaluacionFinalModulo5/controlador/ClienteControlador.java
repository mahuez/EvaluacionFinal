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

import cl.awakelab.EvaluacionFinalModulo5.modelo.Cliente;
import cl.awakelab.EvaluacionFinalModulo5.servicio.ClienteServicio;
import cl.awakelab.EvaluacionFinalModulo5.servicio.UsuarioServicio;

@Controller
public class ClienteControlador {
		
	@Autowired
	ClienteServicio cls;
	UsuarioServicio us;
	
private static final Logger logger = LoggerFactory.getLogger(ClienteControlador.class);

	
	//Listar Cliente = Obtener Cliente
	@RequestMapping(value = "/listarcliente", method = RequestMethod.GET) // listarcliente
	public String obtenerCliente(Model model) { // obtenerCliente = listarCliente
		logger.info("Ingreso al listado de cliente");
		List<Cliente> listacliente = cls.obtenerCliente();
		model.addAttribute("lcliente", listacliente);
		logger.info("Se mostro listado de clientes");
		return "frmlistarcliente";
	}

	@RequestMapping(value="/detallecliente/{rutcliente}", method = RequestMethod.GET)
	public String detalleCliente(Model model, @PathVariable int rutcliente) {
		logger.debug("Detalle de la cliente");
		Cliente detcli = cls.obtenerClientePorRut(rutcliente);
		model.addAttribute("cli", detcli);
		return "msgdetallecliente";
	}
	
	//Crear Cliente
		@RequestMapping(value = "/crearcliente", method = RequestMethod.GET) // crearcliente
		public String crearCliente(Model model) {
			logger.info("Ingreso a crear cliente");
			return "frmcrearcliente";
		}

	//Procesar Crear Cliente
		@RequestMapping(value = "/procesarcrearcliente", method = RequestMethod.POST) // procesarcrearcliente
		public String crearCliente(Model model, 
				@RequestParam("rutcliente") int rutcliente,
				@RequestParam("clinombres") String clinombres, 
				@RequestParam("cliapellidos") String cliapellidos,
				@RequestParam("clitelefono") String clitelefono, 
				@RequestParam("cliafp") String cliafp,
				@RequestParam("clisistemasalud") String clisistemasalud, 
				@RequestParam("clidireccion") String clidireccion,
				@RequestParam("clicomuna") String clicomuna, 
				@RequestParam("cliedad") int cliedad,
				@RequestParam("usuario_runusu") int usuario_runusu) {

			logger.info("Proceso de crear cliente");
			Cliente clie = new Cliente(rutcliente,clinombres,cliapellidos,clitelefono,cliafp,clisistemasalud,clidireccion,clicomuna,cliedad, usuario_runusu);
			boolean result = cls.crearCliente(clie);

			
			String mensaje = "";

			if (result) {
				mensaje = "El/La cliente fue editado/a sin inconvenientes";
				logger.error("Se creo la cliente");
			} else {
				mensaje = "Ocurrio un error al momento de ejecutar la edicion";
				logger.error("Fallo al editar la cliente");
			}

			model.addAttribute("msgeditar", mensaje);
			return "msgcrearcliente";
		}
	
		//Eliminar Cliente
		@RequestMapping(value = "/eliminarcliente/{rutcliente}", method = RequestMethod.GET) // eliminarcliente
		public String eliminarCliente(Model model, @PathVariable int rutcliente) {
			Cliente clie = cls.obtenerClientePorRut(rutcliente);
			cls.eliminarCliente(clie);
			logger.info("Cliente eliminado");
			return "msgeliminarcliente";

		}

		
		//Editar Cliente
		@RequestMapping(value = "/editarcliente/{rutcliente}", method = RequestMethod.GET) // editarcliente
		public String editarCliente(Model model, @PathVariable int rutcliente) {
			Cliente detclie = cls.obtenerClientePorRut(rutcliente);
			logger.info("Editando cliente");
			model.addAttribute("mycli", detclie);
			return "frmeditarcliente";
		}

		
		//Procesar Editar
		@RequestMapping(value = "/procesaeditacliente", method = RequestMethod.POST) // procesareditarcliente
		public String editarCliente(Model model, 
				@RequestParam("rutcliente") int rutcliente,
				@RequestParam("clinombres") String clinombres, 
				@RequestParam("cliapellidos") String cliapellidos,
				@RequestParam("clitelefono") String clitelefono, 
				@RequestParam("cliafp") String cliafp,
				@RequestParam("clisistemasalud") String clisistemasalud, 
				@RequestParam("clidireccion") String clidireccion,
				@RequestParam("clicomuna") String clicomuna, 
				@RequestParam("cliedad") int cliedad,
				@RequestParam("usuario_runusu") int usuario_runusu) {

			logger.info("Proceso la edición de capacitacion");
			Cliente clie = new Cliente(rutcliente,clinombres,cliapellidos,clitelefono,cliafp,clisistemasalud,clidireccion,clicomuna,cliedad,usuario_runusu);
			boolean result = cls.editarCliente(clie);
			String mensaje = "";

			if (result) {
				mensaje = "El/La cliente fue editado/a sin inconvenientes";
				logger.error("Se edito la cliente");
			} else {
				mensaje = "Ocurrio un error al momento de ejecutar la edicion";
				logger.error("Fallo al editar la cliente");
			}

			model.addAttribute("msgeditar", mensaje);
			return "msgeditarcliente";
		}
		
		
}
