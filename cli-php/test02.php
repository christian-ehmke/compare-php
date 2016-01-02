<?php

$a = [];
for ($i = 0; $i < 100000; $i++)
{
    $a[] = ['abc', 'def', 'ghi', 'jkl', 'mno', 'pqr'];
}

echo memory_get_usage(true) . PHP_EOL;