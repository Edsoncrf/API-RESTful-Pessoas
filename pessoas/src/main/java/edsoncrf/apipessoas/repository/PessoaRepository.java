package edsoncrf.apipessoas.repository;

import edsoncrf.apipessoas.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
