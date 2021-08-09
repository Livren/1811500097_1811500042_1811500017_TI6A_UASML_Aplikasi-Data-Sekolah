<?php 
	include 'koneksi.php';
	$query = "SELECT * FROM mapel";
	$result =$con->query($query);
	
	

	// Fetch all
	$data_mapel = $result->fetch_all(MYSQLI_ASSOC);

	echo json_encode($data_mapel);
?>