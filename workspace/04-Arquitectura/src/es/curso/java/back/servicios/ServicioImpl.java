package es.curso.java.back.servicios;

import java.util.Collection;

import es.curso.java.back.entidades.Cliente;
import es.curso.java.back.negocios.Negocio;
import es.curso.java.back.persistencias.ClientesDao;
import es.curso.java.front.modelos.ClienteDto;

public class ServicioImpl implements Servicio {

	private Negocio negocio;
	
	private ClientesDao persistencia;

	public ServicioImpl() {
		super();
	}

	public ServicioImpl(Negocio negocio, ClientesDao persistencia) {
		super();
		this.negocio = negocio;
		this.persistencia = persistencia;
	}

	/* (non-Javadoc)
	 * @see es.curso.java.back.servicios.Servicio#setNegocio(es.curso.java.back.negocios.Negocio)
	 */
	@Override
	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}

	/* (non-Javadoc)
	 * @see es.curso.java.back.servicios.Servicio#setPersistencia(es.curso.java.back.persistencias.Persistencia)
	 */
	@Override
	public void setPersistencia(ClientesDao persistencia) {
		this.persistencia = persistencia;
	}

	@Override
	public void altaCliente(ClienteDto cliente) {

		Cliente clienteEntidad = negocio
				.transformarUnDtoEnCliente(cliente);
		
		clienteEntidad.setId(negocio.generarSiguienteId());
		
		persistencia.insertar(clienteEntidad);	
		
	}

	@Override
	public void modificarCliente(ClienteDto cliente) {

		persistencia.actualizar(negocio
				.transformarUnDtoEnCliente(cliente));
		
	}

	@Override
	public void borrarClientePorId(Long id) {
		persistencia.borrar(id);		
	}

	@Override
	public ClienteDto obtenerClientePorId(Long id) {
		return negocio
				.transformarUnClienteEnDto(
						persistencia.consulta(id));
	}

	@Override
	public Collection<ClienteDto> obtenerTodosLosClientes() {
		
		return negocio.transformarUnaColeccionDeClienteEnColeccionDeDto(persistencia.consulta());
	}
	
}
