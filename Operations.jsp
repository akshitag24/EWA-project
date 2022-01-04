<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body style="background-color:Ivory">
<h1 style="color:Coral;text-align:center;font-size:500%">Welcome to CARZOZ</h1>
<h2 style="color:DarkSlateGray;text-align:center;font-size:300%">You are successfully logged in</h2>
<p style="text-align:center;color:Orange">
    1. Add a new car to the database<br>
    <br>
    2. Remove a existing car from database<br>
    <br>
    3. Update car details in database<br>
    <br>
    4. View available cars <br>
    <br>
    5. Homepage<br>
    <br>
</p>
<form action="operations" method="post" style="text-align:center">
<label for="fname" style="color:Blue">Enter Option:</label>
<input type="text" id="fname" name="opt" ><br>
<br>
<button type="submit" style="color:Grey">Done</button>
</form>
</body>
</html>