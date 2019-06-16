#!/usr/bin/php

<?php
// zmienne predefiniowane
$host = "127.0.0.1";
$port = 12345;
$wsdl 	= 'http://' . $host . ':' . $port . '?wsdl';

// uchwyt do STDIN
$fh = fopen('php://stdin', 'r') or die($php_errormsg);

// czytanie znaków z STDIN
while ($char = fgetc($fh)) {
	print_r($char);

	// $soap = new SoapClient($wsdl);
	// $soap->getTime($line);
}

// socket_close($client);
?>