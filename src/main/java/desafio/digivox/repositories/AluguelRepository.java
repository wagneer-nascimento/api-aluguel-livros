package desafio.digivox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.digivox.models.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
