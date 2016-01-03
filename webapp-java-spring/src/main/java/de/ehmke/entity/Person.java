package de.ehmke.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "person")
public class Person
{

    /**
     *
     */
    public enum Gender
    {
        MALE, FEMALE
    }

    /**
     * The id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The first name
     */
    @Column(nullable = false, name = "first_name")
    private String firstName;

    /**
     * The last name
     */
    @Column(nullable = false, name = "last_name")
    private String lastName;

    /**
     * The birthday
     */
    @Temporal(DATE)
    @Column(name = "birthday")
    private Date birthday;

    /**
     * The gender
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "gender")
    private Gender gender;

    /**
     * The calendars
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
    private Set<Calendar> calendars;

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
     * Gets the firstName.
     *
     * @return the firstName
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Sets the firstName.
     *
     * @param firstName the new firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets the lastName.
     *
     * @return the lastName
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the new lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets the birthday.
     *
     * @return the letzter logout am
     */
    public Date getBirthday()
    {
        return birthday;
    }

    /**
     * Sets the letzter logout am.
     *
     * @param birthday the new letzter logout am
     */
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    /**
     * @return the gender
     */
    public Gender getGender()
    {
        return gender;
    }

    /**
     * @param gender the gender
     */
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    /**
     * @return the calendars
     */
    public Set<Calendar> getCalendars()
    {
        return calendars;
    }

    /**
     * @param calendars the calendars
     */
    public void setCalendars(Set<Calendar> calendars)
    {
        this.calendars = calendars;
    }
}
