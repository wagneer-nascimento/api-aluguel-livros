package desafio.digivox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafio.digivox.models.Aluguel;
import desafio.digivox.models.Cliente;
import desafio.digivox.models.Livro;
import desafio.digivox.repositories.AluguelRepository;
import desafio.digivox.rn.RNDigivox;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private RNDigivox regraNegocio;
	
	public Aluguel inserir(Aluguel request) {
		
		regraNegocio.verificarExistenciaCliente(request.getIdCliente());
		regraNegocio.verificarExistenciaLivro(request.getIdLivro());
		
		Aluguel aluguel = new Aluguel();
		Livro livro = new Livro();
		Cliente cliente = new Cliente();
		cliente.setId(request.getIdCliente());
		livro.setId(request.getIdLivro());
		aluguel.setCliente(cliente);
		aluguel.setLivro(livro);
		aluguel.setIdLivro(request.getIdLivro());
		aluguel.setValor(request.getValor());
		aluguel.setDataAluguel(request.getDataAluguel());
		aluguel.setDataDevolucao(request.getDataDevolucao());
		aluguelRepository.save(aluguel);

		return aluguel;

	}

	@Transactional(readOnly = true)
	public List<Aluguel> buscarTodos() {
		List<Aluguel> listaAluguel = aluguelRepository.findAll();

		return listaAluguel;
	}
}
