package desafio.digivox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafio.digivox.models.Cliente;
import desafio.digivox.repositories.ClienteRepository;
import desafio.digivox.rn.RNDigivox;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private RNDigivox regraNegocio;

	public Cliente inserirCliente(Cliente request) {
		Cliente cliente = new Cliente();

		cliente.setEmail(request.getEmail());
		cliente.setEndereco(request.getEndereco());
		cliente.setNome(request.getNome());
		cliente.setTelefone(request.getTelefone());
		clienteRepository.save(cliente);

		return cliente;

	}

	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		List<Cliente> listaCliente = clienteRepository.findAll();

		return listaCliente;
	}

	@Transactional
	public Cliente updateCliente(Cliente request) {
		regraNegocio.verificarExistenciaCliente(request.getId());

		Cliente cliente = new Cliente();
		cliente.setId(request.getId());
		cliente.setEmail(request.getEmail());
		cliente.setEndereco(request.getEndereco());
		cliente.setNome(request.getNome());
		cliente.setTelefone(request.getTelefone());
		clienteRepository.save(cliente);

		return cliente;
	}

	public void deleteCliente(Long id) {
		regraNegocio.verificarExistenciaCliente(id);
		clienteRepository.deleteById(id);
	}

}
