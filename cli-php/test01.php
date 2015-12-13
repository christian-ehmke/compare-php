<?php
include(__DIR__ . '/global/begin.php');

/**
 * test case: calculate factorial
 */
const N = 100;

$factorial = 1;
for ($i = 1; $i <= N; $i++)
{
    $factorial = $factorial * $i;
}

// print factorial result
// echo sprintf("%s! is %s", N, number_format($factorial)) . "\n";

include(__DIR__ . '/global/end.php');