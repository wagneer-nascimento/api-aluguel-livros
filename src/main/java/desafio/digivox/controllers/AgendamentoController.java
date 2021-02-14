package desafio.digivox.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import desafio.digivox.interfaces.AgendamentoInterface;
import desafio.digivox.models.Agendamento;
import desafio.digivox.service.AgendamentoService;

@RestController
public class AgendamentoController implements AgendamentoInterface {

	@Autowired
	private AgendamentoService agendamentoService;

	public ResponseEntity<Agendamento> inserir(Agendamento agendamento) {
		Agendamento response = agendamentoService.inserir(agendamento);
		return ResponseEntity.ok().body(response);
	}

	public ResponseEntity<Void> deletar(Long id) {
		agendamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Agendamento> atualizar(Agendamento agendamento) {
		Agendamento response = agendamentoService.update(agendamento);
		return ResponseEntity.ok().body(response);
	}

	public ResponseEntity<List<Agendamento>> buscarTodos() {
		List<Agendamento> livros = agendamentoService.buscarTodos();
		return ResponseEntity.ok().body(livros);
	}

	public ResponseEntity<Optional<Agendamento>> findOneAgendamento(@PathVariable(required = true) Long id) {
		Optional<Agendamento> listaAgendamento = agendamentoService.buscarOneAgendamento(id);
		return ResponseEntity.ok().body(listaAgendamento);
	}

}
