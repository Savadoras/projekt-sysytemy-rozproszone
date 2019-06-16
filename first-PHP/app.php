#!/usr/bin/php

<?php
// zmienne predefiniowane
$host = "127.0.0.1";
$port = 12345;
$wsdl 	= 'http://' . $host . ':' . $port . '/?wsdl';

// uchwyt do STDIN
$fh = fopen('php://stdin', 'r') or die($php_errormsg);

// czytanie znaków z STDIN
while ($char = fgets($fh)) {
	// print_r($char);

	try {
		$soap = new SoapClient($wsdl);
		$soap->sendOver($char);
		echo (".");
	} catch (SoapFault $e) {
		echo "==============================\n";
		echo ("Błąd komunikacji z serwerem.\n");
		echo "==============================\n\n";
		echo $e;
		exit();
	}
}
echo ("\n");
?>