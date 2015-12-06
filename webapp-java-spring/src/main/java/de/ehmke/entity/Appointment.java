package de.ehmke.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment
{

    /**
     * The id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * The when date
     */
    @Column(nullable = false, name = "when_date")
    private Date whenDate;

    /**
     * The what
     */
    @Column(nullable = false, name = "what")
    private String what;

    /**
     * The calendar
     */
    @ManyToOne()
    @JoinColumn(nullable = false, name = "calendar_id")
    private Calendar calendar;

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
     * @return the when date
     */
    public Date getWhenDate()
    {
        return whenDate;
    }

    /**
     * @param whenDate the when date
     */
    public void setWhenDate(Date whenDate)
    {
        this.whenDate = whenDate;
    }

    /**
     * @return the what.
     */
    public String getWhat()
    {
        return what;
    }

    /**
     * @param what the what
     */
    public void setWhat(String what)
    {
        this.what = what;
    }

    /**
     * @return the calendar
     */
    public Calendar getCalendar()
    {
        return calendar;
    }

    /**
     * @param calendar the calendar
     */
    public void setCalendar(Calendar calendar)
    {
        this.calendar = calendar;
    }
}
