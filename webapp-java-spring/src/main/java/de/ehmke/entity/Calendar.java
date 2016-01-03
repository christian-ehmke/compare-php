package de.ehmke.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "calendar")
public class Calendar
{

    /**
     * The id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The person
     */
    @ManyToOne()
    @JoinColumn(nullable = false, name = "person_id")
    private Person person;

    /**
     * The appointments
     */
    @OneToMany(mappedBy = "calendar", cascade = CascadeType.REMOVE)
    private Set<Appointment> appointments;

    /**
     * @return the id
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @param id the id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return the person
     */
    public Person getPerson()
    {
        return person;
    }

    /**
     * @param person the person
     */
    public void setPerson(Person person)
    {
        this.person = person;
    }

    /**
     * @return the appointments
     */
    public Set<Appointment> getAppointments()
    {
        return appointments;
    }

    /**
     * @param appointments the appointments
     */
    public void setAppointments(Set<Appointment> appointments)
    {
        this.appointments = appointments;
    }
}
