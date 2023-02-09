package edsoncrf.apipessoas.rest.controller;

import edsoncrf.apipessoas.domain.Endereco;
import edsoncrf.apipessoas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private EnderecoRepository enderecoRepository;
    @PostMapping
    @ResponseStatus(CREATED)
    public Endereco save(@RequestBody Endereco endereco){
        return  enderecoRepository.save(endereco);
    }
    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Endereco endereco){
        enderecoRepository.findById(id).map(e ->{
            endereco.setId(e.getId());
            enderecoRepository.save(endereco);
            return endereco;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado."));
    }
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        enderecoRepository.findById(id).map(e ->{
            enderecoRepository.delete(e);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado."));
    }
    @GetMapping("{id}")
    public Endereco getById(@PathVariable Integer id){
        return enderecoRepository.findById(id)
        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado."));
    }

    @GetMapping
    public List<Endereco> find(Endereco filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return enderecoRepository.findAll(example);
    }
}
