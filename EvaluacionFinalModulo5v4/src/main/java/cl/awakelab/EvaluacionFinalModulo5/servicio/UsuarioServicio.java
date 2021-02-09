package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;


import cl.awakelab.EvaluacionFinalModulo5.modelo.Usuario;


public interface UsuarioServicio {

	public List<Usuario> obtenerUsuario();
	public boolean crearUsuario(Usuario usu);
	public boolean eliminarUsuario(Usuario usu);
	public boolean editarUsuario(Usuario usu);
	public Usuario obtenerUsuarioPorRut(int runusu);
	/*public Usuario obtenerUsuarioPorRut(int run);*/
	
}
