<?php 
	include 'koneksi.php';
	$query = "SELECT * FROM siswa";
	$result =$con->query($query);
	

	// Fetch all
	$data_siswa = $result->fetch_all(MYSQLI_ASSOC);

	echo json_encode($data_siswa);
?>