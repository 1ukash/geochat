package ru.geochat.model.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.geochat.model.dto.Person;

public interface IPersonManager {

  @Transactional(propagation = Propagation.REQUIRED)
  Person getPersonById(Integer id);

  void createNewPerson(Person p);

}