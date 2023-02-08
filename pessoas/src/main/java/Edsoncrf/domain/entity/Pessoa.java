package Edsoncrf.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

//Entity escaneia a entidade e registra como tabela do bd
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "dataNascimento")
    private String dataNascimento;
    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private Set<Endereco> enderecos;
    public Pessoa() {
    }


    public Set<Endereco> getEnderecos(){
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Pessoa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", dataNascimento='" + dataNascimento +"'"+
                ", nome='" + nome + '\'' +
                '}';
    }
}
