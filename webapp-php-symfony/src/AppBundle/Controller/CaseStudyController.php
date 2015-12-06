<?php

namespace AppBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Template;
use Symfony\Component\Config\Definition\Exception\Exception;

class CaseStudyController extends Controller
{
    /**
     * Simulates database access
     *
     * @Route("/calendar", name="case-study-calendar")
     * @Template()
     */
    public function calendarAction()
    {
        /** @var \AppBundle\Repository\PersonRepository $repository */
        $repository = $this->getDoctrine()->getRepository('AppBundle:Person');
        $people = $repository->getPersonsWithAppointments();

        return array('people' => $people);
    }
}