package edsoncrf.apipessoas.rest.controller;

import edsoncrf.apipessoas.domain.Pessoa;
import edsoncrf.apipessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("{id}")
    public Pessoa getPessoaById(@PathVariable Integer id){
        return pessoaRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa save(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoaRepository.delete(pessoa);
                    return pessoa;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pessoa não encontrada"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Pessoa pessoa){
          pessoaRepository
                    .findById(id)
                    .map(pessoaExistente -> {
                        pessoa.setId(pessoaExistente.getId());
                        pessoaRepository.save(pessoa);
                        return pessoaExistente;
                    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                          "Pessoa não encontrada"));
    }

    @GetMapping
    public List<Pessoa> find(Pessoa filtro){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return pessoaRepository.findAll(example);
    }


}
