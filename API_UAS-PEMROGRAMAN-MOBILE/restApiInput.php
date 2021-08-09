<?php 
	include 'koneksi.php';
	
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$msg = null;
		//Mendapatkan Nilai Variable
		$nisn = $_POST['nisn'];
		$nama_siswa = $_POST['nama_siswa'];
		$alamat_siswa = $_POST['alamat_siswa'];
		$nign = $_POST['nign'];
		$nama_guru = $_POST['nama_guru'];
		$alamat_guru = $_POST['alamat_guru'];
		$id_mapel = $_POST['id_mapel'];
		$nama_mapel = $_POST['nama_mapel'];
		$kelas = $_POST['kelas'];
		//eksekusi ke database
		if(!empty($nisn) || !empty($nama_siswa)){
			$insert_siswa= mysqli_query($con, "Insert into siswa(nisn,nama_siswa,alamat_siswa)
			values('$nisn','$nama_siswa','$alamat_siswa')");
			$msg = "Data berhasil disimpan";
		}
	
		if(!empty($nign) || !empty($nama_guru)){
			$insert_guru= mysqli_query($con, "Insert into guru(nign,nama_guru,alamat_guru)
			values('$nign','$nama_guru','$alamat_guru')");
			$msg = "Data berhasil disimpan";	
		}
		
		if(!empty($id_mapel) || !empty($nama_mapel)){
			$insert_mapel= mysqli_query($con, "Insert into mapel(id_mapel,nama_mapel,kelas)
			values('$id_mapel','$nama_mapel','$kelas')");
			$msg = "Data berhasil disimpan";
		}
		
		echo (!empty($msg)) ? "Data Berhasil Disimpan" : "Data tidak boleh kosong";
		
		
		mysqli_close($con);
	}else{
		echo"Data gagal";
	}

?>