package desafio.digivox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafio.digivox.models.Agendamento;
import desafio.digivox.models.Cliente;
import desafio.digivox.models.Livro;
import desafio.digivox.repositories.AgendamentoRepository;
import desafio.digivox.rn.RNDigivox;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Autowired
	private RNDigivox regraNegocio;

	public Agendamento inserir(Agendamento request) {
		regraNegocio.verificarExistenciaCliente(request.getIdCliente());
		regraNegocio.verificarExistenciaLivro(request.getIdLivro());

		Agendamento agendamento = new Agendamento();

		Livro livro = new Livro();
		Cliente cliente = new Cliente();

		cliente.setId(request.getIdCliente());
		livro.setId(request.getIdLivro());
		agendamento.setCliente(cliente);
		agendamento.setLivro(livro);
		agendamento.setDataAgendamento(request.getDataAgendamento());
		agendamentoRepository.save(agendamento);

		return agendamento;

	}

	@Transactional(readOnly = true)
	public List<Agendamento> buscarTodos() {
		List<Agendamento> listaAgendamento = agendamentoRepository.findAll();

		return listaAgendamento;
	}

	@Transactional
	public Agendamento update(Agendamento request) {
		regraNegocio.verificarExistenciaCliente(request.getIdCliente());
		regraNegocio.verificarExistenciaLivro(request.getIdLivro());

		Agendamento agendamento = new Agendamento();
		Livro livro = new Livro();
		Cliente cliente = new Cliente();

		cliente.setId(request.getIdCliente());
		livro.setId(request.getIdLivro());
		agendamento.setId(request.getId());

		agendamentoRepository.save(agendamento);

		return agendamento;
	}

	public void delete(Long id) {
		agendamentoRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<Agendamento> buscarOneAgendamento(Long id) {
		Optional<Agendamento> listaAgendamento =  agendamentoRepository.findById(id);
		
		return listaAgendamento;
	}

}
