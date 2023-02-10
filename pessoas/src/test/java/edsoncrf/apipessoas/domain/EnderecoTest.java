package edsoncrf.apipessoas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    @Test
    void getLogradouro() {
        Endereco e = new Endereco(1,"Endereco 1", 74030040, 56, "Goiânia");
        assertEquals("Endereco 1", e.getLogradouro());
    }

    @Test
    void getCep() {
        Endereco e = new Endereco(1,"Endereco 1", 74030040, 56, "Goiânia");
        assertEquals(74030040, e.getCep());
    }

    @Test
    void getNumero() {
        Endereco e = new Endereco(1,"Endereco 1", 74030040, 56, "Goiânia");
        assertEquals(56, e.getNumero());
    }

    @Test
    void getCidade() {
        Endereco e = new Endereco(1,"Endereco 1", 74030040, 56, "Goiânia");
        assertEquals("Goiânia", e.getCidade());
    }
}