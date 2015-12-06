<?php
namespace AppBundle\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity
 */
class Calendar
{
    /**
     * @ORM\Id
     * @ORM\Column(type="bigint")
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @ORM\OneToMany(targetEntity="AppBundle\Entity\Appointment", mappedBy="calendar")
     */
    private $appointments;

    /**
     * @ORM\ManyToOne(targetEntity="AppBundle\Entity\Person", inversedBy="calendars")
     * @ORM\JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
     */
    private $owner;

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->appointments = new ArrayCollection();
    }

    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Add appointment
     *
     * @param Appointment $appointment
     * @return Calendar
     */
    public function addAppointment(Appointment $appointment)
    {
        $this->appointments[] = $appointment;

        return $this;
    }

    /**
     * Remove appointment
     *
     * @param Appointment $appointment
     */
    public function removeAppointment(Appointment $appointment)
    {
        $this->appointments->removeElement($appointment);
    }

    /**
     * Get appointments
     *
     * @return \Doctrine\Common\Collections\Collection
     */
    public function getAppointments()
    {
        return $this->appointments;
    }

    /**
     * Set owner
     *
     * @param Person $owner
     * @return Calendar
     */
    public function setOwner(Person $owner = null)
    {
        $this->owner = $owner;

        return $this;
    }

    /**
     * Get owner
     *
     * @return Person
     */
    public function getOwner()
    {
        return $this->owner;
    }
}
