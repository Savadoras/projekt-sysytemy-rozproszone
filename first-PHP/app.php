#!/usr/bin/php

<?php
// zmienne predefiniowane
$host = "127.0.0.1";
$port = 12345;
$wsdl 	= 'http://' . $host . ':' . $port . '/?wsdl';

// uchwyt do STDIN
$fh = fopen('php://stdin', 'r') or die($php_errormsg);

echo "====================\n";
echo "    Aplikacja #1\n";
echo "====================\n";

// czytanie znaków z STDIN
while ($char = fgets($fh)) {
	try {
		$soap = new SoapClient($wsdl);
		$soap->sendOver($char);
		echo (".");
	} catch (SoapFault $e) {
		echo ("Błąd komunikacji z serwerem.\n");
		echo $e;
		exit();
	}
}
echo ("\n");
?>