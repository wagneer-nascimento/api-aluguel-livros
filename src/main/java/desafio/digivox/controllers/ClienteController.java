package desafio.digivox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import desafio.digivox.interfaces.ClienteInterface;
import desafio.digivox.models.Cliente;
import desafio.digivox.service.ClienteService;

@RestController
public class ClienteController implements ClienteInterface {

	@Autowired
	private ClienteService clienteService;

	public ResponseEntity<Cliente> inserir(Cliente cliente) {
		Cliente response = clienteService.inserirCliente(cliente);
		return ResponseEntity.ok().body(response);
	}

	public ResponseEntity<Void> deletar(Long id) {
		clienteService.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Cliente> atualizar(Cliente cliente) {
		Cliente response = clienteService.updateCliente(cliente);
		return ResponseEntity.ok().body(response);
	}

	public ResponseEntity<List<Cliente>> buscarTodos() {
		List<Cliente> clientes = clienteService.buscarTodos();
		return ResponseEntity.ok().body(clientes);
	}

}
