<?php

include_once('config.php');

$seconds = (microtime(true) - $startTime);

echo sprintf("%s sec", number_format($seconds, 3));