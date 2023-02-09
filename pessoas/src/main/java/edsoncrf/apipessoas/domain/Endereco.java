package edsoncrf.apipessoas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@Data
@AllArgsConstructor
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String logradouro;
    private Integer cep;
    private Integer numero;
    private String cidade;
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
