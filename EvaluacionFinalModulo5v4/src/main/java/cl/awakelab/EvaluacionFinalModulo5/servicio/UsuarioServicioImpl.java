package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.EvaluacionFinalModulo5.modelo.ClienteRepositorio;
import cl.awakelab.EvaluacionFinalModulo5.modelo.Usuario;
import cl.awakelab.EvaluacionFinalModulo5.modelo.UsuarioRepositorio;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	UsuarioRepositorio ur;
	ClienteRepositorio clr;
	
	@Override
	public List<Usuario> obtenerUsuario() {
		return (List<Usuario>) ur.findAll();
	}

	@Override
	public boolean crearUsuario(Usuario usu) {
		ur.save(usu);
		return true;
	}

	@Override
	public boolean eliminarUsuario(Usuario usu) {
		ur.delete(usu);
		return true;
	}

	@Override
	public boolean editarUsuario(Usuario usu) {
		ur.save(usu);
		return true;
	}

	@Override
	public Usuario obtenerUsuarioPorRut(int runusu) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public boolean crearclienteyusuario(Cliente clie) {
		clr.save(clie);
		return false;
	}*/


}
