package desafio.digivox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafio.digivox.models.Livro;
import desafio.digivox.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro inserirLivro(Livro request) {
		Livro livro = new Livro();
		
		livro.setAutor(request.getAutor());
		livro.setTitulo(request.getTitulo());
		livro.setDescricao(request.getDescricao());
		livro.setAno(request.getAno());

		livroRepository.save(livro);

		return livro;

	}

	@Transactional(readOnly = true)
	public List<Livro> buscarTodos() {
		List<Livro> listaLivro = livroRepository.findAll();

		return listaLivro;
	}

	@Transactional
	public Livro updateLivro(Livro request) {
		Livro livro = new Livro();

		livro.setId(request.getId());
		livro.setAutor(request.getAutor());
		livro.setTitulo(request.getTitulo());
		livro.setDescricao(request.getDescricao());
		livro.setAno(request.getAno());

		livroRepository.save(livro);

		return livro;
	}

	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}

}
