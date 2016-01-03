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

    @Query("SELECT DISTINCT p FROM Person p LEFT OUTER JOIN FETCH p.calendars c LEFT OUTER JOIN FETCH c.appointments")
    List<Person> findAllWithAppointments();

}
