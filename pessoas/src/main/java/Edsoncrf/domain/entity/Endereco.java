package Edsoncrf.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "cep")
    private Integer cep;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "cidade")
    private String cidade;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public  String toString(){
        return "Endereco{"+
                "id="+ id +
                "logradouro='" + logradouro + "'"+
                "cep="+ cep +
                "numero="+ numero +
                "cidade='" + cidade + "'"+
                "}";
    }
}
