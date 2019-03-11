<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bakery--Manager</title>

<style>

body {
  background-color: lightblue;
  font-family:monospace;
}

h1 {
  color: #4CAF50;
  text-align: center;
  font-size: 35px;
}

.button{
  background-color: #4CAF50;
  border: none;
  border-radius: 8px;
  color: white;
  padding: 8px 24px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 22px;
  margin: 4px 2px;
  cursor: pointer;
  transition: all 0.5s;
  width: 250px;
  height: 50px;
  }
  
.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 15px;
  right: 0px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 15px;
}

.button:hover span:after {
  opacity: 1;
  right: 25px;
  
}

.div1 {
  width: 500px;
  height: 420px;
  position: absolute;
  top: 50%;
  left: 50%;
  margin: -150px 0 0 -250px;
  background-color:white;
  text-align:center;
  vertical-align: middle;
  border: none;
  border-radius: 8px;
}




</style>

</head>

<body>

	<h1>Manager Page</h1>

	<br>
	<br>
	<br>
    
    <div class="div1" style="font-family:monospace;">
    	<br><br>
		<form action="InventoryInput.jsp" method="POST" class="button" style="vertical-align:middle">
			<span><input type="submit" value="Inventory Controller" name="send" class="button"></span>
		</form>
		<br><br>
		<form action = "MasterScheduleUIA.jsp" method="POST" class="button" style="vertical-align:middle">
			<span><input type="submit" value="MasterSchedule" name="send" class="button"></span><br>
		</form>
		<br><br>
		<form action = "MRPList.jsp" method="POST" class="button" style="vertical-align:middle">
			<span><input type="submit" value="MRP" name="send" class="button"></span><br>
		</form>
		<br><br>
		<form action = "MainPage.html" method="POST" class="button" style="vertical-align:middle">
			<span><input type="submit" value="Back To MainPage" name="send" class="button"></span><br>
		</form>
		<br><br>
	</div>
	
    

</body>
</html>