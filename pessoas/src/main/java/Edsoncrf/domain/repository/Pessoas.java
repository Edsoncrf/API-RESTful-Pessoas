package Edsoncrf.domain.repository;

import Edsoncrf.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Pessoas extends JpaRepository<Pessoa, Integer> {

    @Query(value = "SELECT * FROM pessoa c WHERE c.nome LIKE '%:nome%'", nativeQuery = true)
    List<Pessoa> encontraPorNome(@Param("nome") String nome);

    @Query("DELETE FROM Pessoa c WHERE c.nome = :nome")
    @Modifying //para update e delete usasse essa anotação
    void deleteByNome(String nome);

    boolean existsByNome(String nome);
    @Query("SELECT c FROM Pessoa c LEFT JOIN FETCH c.enderecos WHERE c.id = :id")
    Pessoa findPessoaFetchEnderecos(@Param("id") Integer id);

}
