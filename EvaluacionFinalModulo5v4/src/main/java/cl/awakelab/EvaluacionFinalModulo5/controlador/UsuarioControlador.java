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

import cl.awakelab.EvaluacionFinalModulo5.modelo.Usuario;
import cl.awakelab.EvaluacionFinalModulo5.servicio.AdministrativoServicio;
import cl.awakelab.EvaluacionFinalModulo5.servicio.ClienteServicio;
import cl.awakelab.EvaluacionFinalModulo5.servicio.ProfesionalServicio;
import cl.awakelab.EvaluacionFinalModulo5.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {

	@Autowired
	UsuarioServicio us;
	ClienteServicio cls;
	ProfesionalServicio ps;
	AdministrativoServicio as;

	private static final Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

	// Listar Usuario = Obtener Usuario
	@RequestMapping(value = "/listarusuario", method = RequestMethod.GET) // listarusuario
	public String obtenerUsuario(Model model) { // obtenerUsuario = listarUsuario
		logger.info("Ingreso al listado de usuario");
		List<Usuario> listausuario = us.obtenerUsuario();
		model.addAttribute("lusuario", listausuario);
		logger.info("Se mostro listado de usuario");
		return "frmlistarusuario";
	}
	

	// Crear Usuario
	@RequestMapping(value = "/crearusuario", method = RequestMethod.GET) // crearusuario
	public String crearUsuario(Model model) {
		logger.info("Ingreso a crear usuario");
		return "frmcrearusuario";
	}
	
	@RequestMapping(value="/selecciontipousuario", method = RequestMethod.GET)
	public String selecciontipousuario(Model model) {
		logger.info("Ingreso a la creación de productos");
		return "msgcrearusuario";
	}
	// Procesar Crear Usuario
	@RequestMapping(value = "/procesarcrearusuario", method = RequestMethod.POST) // procesarcrearusuario
	public String procesarcrearUsuario(Model model, 
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido, 
			@RequestParam("fechanacimiento") String fechanacimiento,
			@RequestParam("runusu") int runusu, 
			@RequestParam("tipo") String tipo) {

		logger.info("Proceso de crear usuario");
		Usuario usua = new Usuario(nombre, apellido, fechanacimiento, runusu, tipo);
		boolean result = us.crearUsuario(usua);
		String mensaje = "";

		if (result) {
			mensaje = "Usuario fue creado sin inconvenientes";
			logger.info("Se creó usuario");
		} else {
			mensaje = ("Ocurrió un error al usuario");
		}

		model.addAttribute("msgcrear", mensaje);
		return "msgcrearusuario";
	}

	// Eliminar usuario
	@RequestMapping(value = "/eliminarusuario/{runusu}", method = RequestMethod.GET) // eliminarcapacitacion
	public String eliminarUsuario(Model model, @PathVariable int runusu) {
		Usuario usua = us.obtenerUsuarioPorRut(runusu);
		us.eliminarUsuario(usua);
		logger.info("Usuario eliminada");
		return "msgeliminarusuario";

	}

	// Editar Usuario
	@RequestMapping(value = "/editarusuario/{runusu}", method = RequestMethod.GET) // editarusuario
	public String editarUsuario(Model model, @PathVariable int runusu) {
		Usuario usua = us.obtenerUsuarioPorRut(runusu);
		logger.info("Usuario editado");
		model.addAttribute("myusu", usua);
		return "frmeditarusuario";
	}

	// Procesar Editar
	@RequestMapping(value = "/procesaeditarusuario", method = RequestMethod.POST) // procesareditar
	public String procesareditarUsuario(Model model, 
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido, 
			@RequestParam("fechanacimiento") String fechanacimiento,
			@RequestParam("runusu") int runusu, 
			@RequestParam("tipo") String tipo) {

		logger.info("Proceso la edición de usuario");
		Usuario usua = new Usuario(nombre, apellido, fechanacimiento, runusu, tipo);
		boolean result = us.editarUsuario(usua);
		String mensaje = "";

		if (result) {
			mensaje = "El usuario fue editada sin inconvenientes";
			logger.error("Se edito usuario");
		} else {
			mensaje = "Ocurrio un error al momento de ejecutar la edicion";
			logger.error("Fallo al editar el usuario");
		}

		model.addAttribute("msgeditar", mensaje);
		return "msgeditarusuario";
	}

}