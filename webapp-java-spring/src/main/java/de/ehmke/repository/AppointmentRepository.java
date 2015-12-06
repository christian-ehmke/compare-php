package de.ehmke.repository;

import de.ehmke.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface AppointmentRepository extends CrudRepository<Appointment, Long>
{
}
