package de.ehmke.repository;

import de.ehmke.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface PersonRepository extends CrudRepository<Person, Long>
{

    @Query("SELECT p FROM Person p JOIN p.calendars c JOIN c.appointments a")
    List<Person> findAllWithAppointments();
    
}
