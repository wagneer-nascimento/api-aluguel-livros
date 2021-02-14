package desafio.digivox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;
	private String valor;
	private String dataAluguel;
	private String dataDevolucao;
	@Transient
	private Long idCliente;
	@Transient
	private Long idLivro;

	public Aluguel() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(String dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	@Override
	public String toString() {
		return "Aluguel [id=" + id + ", cliente=" + cliente + ", livro=" + livro + ", valor=" + valor + ", dataAluguel="
				+ dataAluguel + ", dataDevolucao=" + dataDevolucao + ", idCliente=" + idCliente + ", idLivro=" + idLivro
				+ "]";
	}

}
