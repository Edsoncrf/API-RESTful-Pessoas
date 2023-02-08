package Edsoncrf.rest.controller;

import Edsoncrf.domain.entity.Endereco;
import Edsoncrf.domain.repository.Enderecos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    private Enderecos enderecos;
    public EnderecoController(Enderecos enderecos) {
        this.enderecos = enderecos;
    }
    @PostMapping
    @ResponseStatus(CREATED)
    public Endereco save(@RequestBody Endereco endereco){
        return  enderecos.save(endereco);
    }
    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Endereco endereco){
        enderecos.findById(id).map(e ->{
            endereco.setId(e.getId());
            enderecos.save(endereco);
            return endereco;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado."));
    }
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        enderecos.findById(id).map(e ->{
            enderecos.delete(e);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado."));
    }
    @GetMapping("{id}")
    public Endereco getById(@PathVariable Integer id){
        return enderecos.findById(id)
        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado."));
    }

    @GetMapping
    public List<Endereco> find(Endereco filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return enderecos.findAll(example);
    }
}
