<?php

/**
 * Every call to a date/time function will generate a E_NOTICE if the time zone is not valid, and/or a E_STRICT
 * or E_WARNING message if using the system settings or the TZ environment variable.
 */
date_default_timezone_set("Greenwich");

/** @var DateTime $starttime */
$startTime = null;