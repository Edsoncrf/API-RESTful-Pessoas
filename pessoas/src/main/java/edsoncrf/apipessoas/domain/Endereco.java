package edsoncrf.apipessoas.domain;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String logradouro;
    private Integer cep;
    private Integer numero;
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
