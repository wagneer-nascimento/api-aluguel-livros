package desafio.digivox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import desafio.digivox.interfaces.LivroInterface;
import desafio.digivox.models.Livro;
import desafio.digivox.service.LivroService;

@RestController
public class LivroController implements LivroInterface {

	@Autowired
	private LivroService livroService;

	public ResponseEntity<Livro> inserir(Livro livro) {
		Livro response = livroService.inserirLivro(livro);
		return ResponseEntity.ok().body(response);
	}

	public ResponseEntity<Void> deletar(Long id) {
		livroService.deleteLivro(id);
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Livro> atualizar(Livro livro) {
		Livro response = livroService.updateLivro(livro);
		return ResponseEntity.ok().body(response);
	}

	public ResponseEntity<List<Livro>> buscarTodos() {
		List<Livro> livros = livroService.buscarTodos();
		return ResponseEntity.ok().body(livros);
	}

}
