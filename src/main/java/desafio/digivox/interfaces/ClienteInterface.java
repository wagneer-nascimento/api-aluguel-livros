package desafio.digivox.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import desafio.digivox.models.Cliente;

@RequestMapping("/clientes")
public interface ClienteInterface {

	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente);

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable(required = true) Long id);

	@PutMapping
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente);

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodos();

}
