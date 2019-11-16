<?php 
	include "data_gen.php";
	$day = $_GET["day"];
?>

<html><body>
<form method="POST" action="/IWP-Ass5/update.php">
	Day : <input name="day" value="<?php echo $day; ?>" readonly>
	<br> <br>
	Starter : <input name="starter" value="<?php echo $data[$day][0]; ?>">
	<br> <br>
	Main Course : <input name="main" value="<?php echo $data[$day][1]; ?>">
	<br> <br>
	Dessert : <input name="dessert" value="<?php echo $data[$day][2]; ?>">
	<br> <br>
	<input type="submit">

	<br> <br>
	<a href="/IWP-Ass5/food_menu.php">Back to menu</a>
</form>
</body></html>