package edsoncrf.apipessoas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @Column(length = 100)
    private String nome;
    private Date dataNascimento;
    @JsonIgnore
    @OneToMany
    private Set<Endereco> enderecos;

    public Pessoa() {
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", dataNascimento='" + dataNascimento +"'"+
                ", nome='" + nome + "'" +
                "}";
    }
}
