<?php
namespace AppBundle\Command;

use AppBundle\Entity\Gender;
use Symfony\Bundle\FrameworkBundle\Command\ContainerAwareCommand;
use Symfony\Component\Console\Input\InputInterface;
use Symfony\Component\Console\Output\OutputInterface;

class GenerateTestDataCommand extends ContainerAwareCommand
{
    protected function configure()
    {
        $this
            ->setName('demo:generateTestData')
            ->setDescription('Generate test data and save it to the internal database');
    }

    protected function execute(InputInterface $input, OutputInterface $output)
    {
        $output->writeln('Generating people...');

        /** @var \Doctrine\ORM\EntityManager $entityManager */
        $entityManager = $this->getContainer()->get('doctrine')->getManager();

        $faker = \Faker\Factory::create();
        $people = array();
        for ($i = 0; $i < 50; $i++) {
            $person = new \AppBundle\Entity\Person();
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
        for ($i = 0; $i < 200; $i++) {
            $calendar = new \AppBundle\Entity\Calendar();
            $calendar->setOwner($faker->randomElement($people));
            $entityManager->persist($calendar);

            for ($j = 0; $j < $faker->randomDigit; $j++) {
                $appointment = new \AppBundle\Entity\Appointment();
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
