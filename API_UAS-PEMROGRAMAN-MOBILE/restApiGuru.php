<?php 
	include 'koneksi.php';
	$query = "SELECT * FROM guru";
	$result =$con->query($query);
	
	

	// Fetch all
	$data_guru = $result->fetch_all(MYSQLI_ASSOC);

	echo json_encode($data_guru);
?>