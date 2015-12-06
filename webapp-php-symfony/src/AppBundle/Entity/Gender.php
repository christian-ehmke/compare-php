<?php

namespace AppBundle\Entity;


use Symfony\Component\Config\Definition\Exception\Exception;

class Gender
{
    /**
     * @var string
     */
    private static $FEMALE = "f";

    /**
     * @var string
     */
    private static $FEMALE_LONG = "female";

    /**
     * @var string
     */
    private static $MALE = "m";

    /**
     * @var string
     */
    private static $MALE_LONG = "male";

    /**
     * @var string
     */
    private $gender;

    /**
     * Gender constructor.
     * @param $gender
     */
    private function __construct($gender)
    {
        $this->gender = $gender;
    }

    /**
     * @param $gender
     * @return Gender|null
     */
    public static function createInstance($gender)
    {
        if ($gender != self::$FEMALE && $gender != self::$MALE)
            throw new Exception(sprintf('Value (%s) of gender is not valid.', $gender));

        return ($gender == self::$FEMALE) ? self::FEMALE() : self::MALE();
    }

    /**
     * @return Gender
     */
    public static function FEMALE()
    {
        return new Gender(self::$FEMALE);
    }

    /**
     * @return Gender
     */
    public static function MALE()
    {
        return new Gender(self::$MALE);
    }

    /**
     * @return String
     */
    public function getAbbreviation()
    {
        return $this->gender;
    }

    /**
     * @return string
     */
    public function getName()
    {
        return ($this->isFemale()) ? self::$FEMALE_LONG : self::$MALE_LONG;
    }

    /**
     * @return bool
     */
    public function isFemale()
    {
        return ($this->gender == self::FEMALE()) ? true : false;
    }

    /**
     * @return bool
     */
    public function isMale()
    {
        return ($this->gender == self::MALE()) ? true : false;
    }
}