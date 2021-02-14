package desafio.digivox.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import desafio.digivox.models.Aluguel;

@RequestMapping("/aluguel")
public interface AluguelInterface {

	@PostMapping
	public ResponseEntity<Aluguel> inserir(@RequestBody Aluguel aluguel);

	@GetMapping
	public ResponseEntity<List<Aluguel>> buscarTodos();
 
}
