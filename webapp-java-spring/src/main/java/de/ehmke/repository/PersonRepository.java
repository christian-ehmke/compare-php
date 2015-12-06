package de.ehmke.repository;

import de.ehmke.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface PersonRepository extends CrudRepository<Person, Long>
{
}
