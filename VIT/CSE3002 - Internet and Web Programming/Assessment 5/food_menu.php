<?php 
	include "data_gen.php";

	echo '<table>';
		foreach($days as $day) {
			echo "<tr> <td> <a href='update_form.php/?day=$day'> $day </a> </td>";
				echo "<td>";
					echo implode("<br>---<br>", $data[$day]);
				echo "</td>";
			echo "</tr>";
		}
	echo "</table>";
?> 

<style>
	table, th, td {
		border: 1px solid black;
	}

	th, td {
		padding: 5px;
	}
</style>