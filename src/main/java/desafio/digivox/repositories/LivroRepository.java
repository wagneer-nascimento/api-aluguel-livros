package desafio.digivox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.digivox.models.Livro;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
