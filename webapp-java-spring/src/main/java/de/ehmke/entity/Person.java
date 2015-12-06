package de.ehmke.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
public class Person
{

    /**
     * The id
     */
    @Id
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
    @Column(name = "birthday")
    private Date birthday;

    /**
     * The calendars
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
    private List<Calendar> calendars;

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
     * @return the calendars
     */
    public List<Calendar> getCalendars()
    {
        return calendars;
    }

    /**
     * @param calendars the calendars
     */
    public void setCalendars(List<Calendar> calendars)
    {
        this.calendars = calendars;
    }
}
