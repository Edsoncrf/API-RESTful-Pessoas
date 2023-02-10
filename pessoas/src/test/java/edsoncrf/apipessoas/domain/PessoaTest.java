package edsoncrf.apipessoas.domain;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @org.junit.jupiter.api.Test
    void getNome() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Pessoa p = new Pessoa(1,"Edson", formato.parse("1997-07-12"),null);
        assertEquals("Edson", p.getNome());
    }

    @org.junit.jupiter.api.Test
    void getDataNascimento() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Pessoa p = new Pessoa(1,"Edson", formato.parse("1997-07-12"), null);
        assertEquals(formato.parse("1997-07-12"), p.getDataNascimento());
    }

}