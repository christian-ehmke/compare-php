<?php
namespace AppBundle\Command;

use AppBundle\Entity\Appointment;
use AppBundle\Entity\Calendar;
use AppBundle\Entity\Gender;
use AppBundle\Entity\Person;
use Faker\Factory;
use Symfony\Bundle\FrameworkBundle\Command\ContainerAwareCommand;
use Symfony\Component\Console\Input\InputInterface;
use Symfony\Component\Console\Output\OutputInterface;

class GenerateTestDataCommand extends ContainerAwareCommand
{
    private static $NUMBER_Of_PERSONS = 50;

    private static $NUMBER_Of_CALENDARS = 200;

    /**
     * Configure symfony cli command
     */
    protected function configure()
    {
        $this
            ->setName('demo:generateTestData')
            ->setDescription('Generate test data and save it to the internal database');
    }

    /**
     * @param InputInterface $input
     * @param OutputInterface $output
     * @return void
     */
    protected function execute(InputInterface $input, OutputInterface $output)
    {
        $output->writeln('Generating people...');

        /** @var \Doctrine\ORM\EntityManager $entityManager */
        $entityManager = $this->getContainer()->get('doctrine')->getManager();

        $faker = Factory::create();
        $people = array();
        for ($i = 0; $i < self::$NUMBER_Of_PERSONS; $i++)
        {
            $person = new Person();
            $gender = (rand(0, 1) == 0) ? Gender::MALE() : Gender::FEMALE();
            $person->setFirstName($faker->format("firstName", array($gender->getName())));
            $person->setLastName($faker->lastName);
            $person->setGender($gender);
            $person->setBirthday($faker->dateTimeBetween('-60 years', '-18 years'));
            $entityManager->persist($person);
            $people[] = $person;
            $output->write('.');
        }
        $output->writeln('');

        $output->writeln('Generating calendars with appointments...');
        for ($i = 0; $i < self::$NUMBER_Of_CALENDARS; $i++)
        {

            $calendar = new Calendar();
            $calendar->setPerson($faker->randomElement($people));
            $entityManager->persist($calendar);

            for ($j = 0; $j < $faker->randomDigit; $j++)
            {
                $appointment = new Appointment();
                $appointment->setWhen($faker->dateTimeThisYear);
                $appointment->setWhat($faker->text);
                $appointment->setCalendar($calendar);
                $entityManager->persist($appointment);
            }

            $output->write('.');
        }

        $entityManager->flush();
    }
}
