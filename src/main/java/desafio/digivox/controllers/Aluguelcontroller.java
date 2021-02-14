package desafio.digivox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import desafio.digivox.interfaces.AluguelInterface;
import desafio.digivox.models.Aluguel;
import desafio.digivox.service.AluguelService;

@RestController
public class Aluguelcontroller implements AluguelInterface {

	@Autowired
	private AluguelService aluguelService;

	public ResponseEntity<Aluguel> inserir(Aluguel aluguel) {
		Aluguel response = aluguelService.inserir(aluguel);
		return ResponseEntity.ok().body(response);
	}

	public ResponseEntity<List<Aluguel>> buscarTodos() {
		List<Aluguel> response = aluguelService.buscarTodos();
		return ResponseEntity.ok().body(response);
	}

}
