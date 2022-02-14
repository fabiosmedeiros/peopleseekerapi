package com.fabiosmedeiros.peopleseekerapi.service;

import com.fabiosmedeiros.peopleseekerapi.dto.MessageResponseDTO;
import com.fabiosmedeiros.peopleseekerapi.dto.PersonDTO;
import com.fabiosmedeiros.peopleseekerapi.entity.Person;
import com.fabiosmedeiros.peopleseekerapi.exception.PersonNotFoundException;
import com.fabiosmedeiros.peopleseekerapi.mapper.PersonMapper;
import com.fabiosmedeiros.peopleseekerapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A camada Service agrupa as classes que irão conter as regras de negócio
 *  da aplicação. A annotation @Service indica que a classe PersonService
 *  é uma classe de serviço. A annotation @AllArgsConstructor irá criar um
 *  construtor em tempo de compilação não sendo necessário declararmos um
 *  explicitamente.
 * @author fabiosmedeiros
 * @version 1.0
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return  allPeople.stream()
                .map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);

        return createMessageResponse(updatedPerson.getId(), "Update person with ID ");
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
