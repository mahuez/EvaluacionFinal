package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Cliente;
import cl.awakelab.EvaluacionFinalModulo5.modelo.ClienteRepositorio;
import cl.awakelab.EvaluacionFinalModulo5.modelo.UsuarioRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired
	ClienteRepositorio clr;
	UsuarioRepositorio ur;

	@Override
	public List<Cliente> obtenerCliente() {
		return (List<Cliente>) clr.findAll();
	}

	@Override
	public boolean crearCliente(Cliente cli) {
		clr.save(cli);
		return true;
	}

	@Override
	public boolean eliminarCliente(Cliente cli) {
		clr.delete(cli);
		return true;
	}

	@Override
	public boolean editarCliente(Cliente cli) {
		clr.save(cli);
		return true;
	}	
	
	
	@Override
	public Cliente obtenerClientePorRut(int rutcliente) {
		// TODO Auto-generated method stub
		return null;
	}

	}


