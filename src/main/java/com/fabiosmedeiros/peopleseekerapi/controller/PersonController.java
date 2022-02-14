package com.fabiosmedeiros.peopleseekerapi.controller;

import com.fabiosmedeiros.peopleseekerapi.dto.MessageResponseDTO;
import com.fabiosmedeiros.peopleseekerapi.dto.PersonDTO;
import com.fabiosmedeiros.peopleseekerapi.exception.PersonNotFoundException;
import com.fabiosmedeiros.peopleseekerapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
 * Pontos importantes a serem observados na declaração do PersonController:
 * - @RestController é a combinação das annotations @Controller e @ResponseBody,
 *    e é utilizada para o desenvolvimento de serviços RESTFul.
 * - @RequestMapping é uma annotation utilizada para implementar o URL handler,
 *    suportando os métodos GET, POST, PUT, DELETE e PATCH.
 * - @AllArgsConstructor irá criar um construtor em tempo de compilação,
 *    não sendo necessário declararmos um construtor explicitamente.
 */
@RestController
@RequestMapping("/api/v1/person")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    // Aqui o PersonService será injetado com a annotation @AllArgsConstructor
    private PersonService personService;

    /* @PostMapping define que o método aceite requisições POST
       Aqui @ResponseStatus define o código de retorno 201 (CREATED) */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    // @GetMapping permite que o método aceite requisições GET
    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    // @GetMapping permite que o método aceite requisições GET, aceitando o parâmetro id
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    /* @PutMapping permite que o método aceite requisições PUT, aceitando o parâmetro id
       Aqui @ResponseStatus define o código de retorno como 204 (NO_CONTENT) */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        personService.update(id, personDTO);
    }

    /* @DeleteMapping permite que o método aceite requisições DELETE, aceitando o parâmetro id
       Aqui @ResponseStatus define o código de retorno como 204 (NO_CONTENT) */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

}
