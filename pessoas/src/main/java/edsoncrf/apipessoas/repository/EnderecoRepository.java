package edsoncrf.apipessoas.repository;

import edsoncrf.apipessoas.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
