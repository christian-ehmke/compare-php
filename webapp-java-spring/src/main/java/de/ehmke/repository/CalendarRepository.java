package de.ehmke.repository;

import de.ehmke.entity.Calendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface CalendarRepository extends CrudRepository<Calendar, Long>
{
}
