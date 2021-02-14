package desafio.digivox.rn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.digivox.repositories.ClienteRepository;
import desafio.digivox.repositories.LivroRepository;
import desafio.digivox.service.exceptions.ExcecaoDadosNaoEncontrado;

@Service
public class RNDigivox {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void verificarExistenciaCliente(Long id) {
		boolean existe = clienteRepository.existsById(id);
		if (!existe) {
			throw new ExcecaoDadosNaoEncontrado("Cliente não existe , verifique o ID");
		}

	}

	public void verificarExistenciaLivro(Long id) {
		boolean existe = livroRepository.existsById(id);
		if (!existe) {
			throw new ExcecaoDadosNaoEncontrado("Livro não existe , verifique o ID");
		}

	}

}
