package desafio.digivox.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import desafio.digivox.models.Agendamento;

@RequestMapping("/agendamentos")
public interface AgendamentoInterface {

	@PostMapping
	public ResponseEntity<Agendamento> inserir(@RequestBody Agendamento agendamento);

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable(required = true) Long id);

	@PutMapping
	public ResponseEntity<Agendamento> atualizar(@RequestBody Agendamento livro);

	@GetMapping
	public ResponseEntity<List<Agendamento>> buscarTodos();

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Agendamento>> findOneAgendamento(@PathVariable(required = true) Long id);
	
}
