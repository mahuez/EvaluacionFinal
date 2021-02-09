package cl.awakelab.EvaluacionFinalModulo5.servicio;

import java.util.List;

import cl.awakelab.EvaluacionFinalModulo5.modelo.Cliente;

public interface ClienteServicio {

		public List<Cliente> obtenerCliente();
		public boolean crearCliente(Cliente cli);
		public boolean eliminarCliente(Cliente cli);
		public boolean editarCliente(Cliente cli);
		public Cliente obtenerClientePorRut(int rutcliente);
		
}
