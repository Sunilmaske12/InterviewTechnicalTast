<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register Employee</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<h2 class="emp-name">
			Employee Management
		</h2>
		<ul>
			<li> <a href="register">Register</a> </li>
           <li> <a href="/OaclandTask/"> Login</a></li>
           <li><a href="welcome">Home</a></li>

		</ul>
	</header>

	<div class="register-container">
		<h1 class="heading">Employee Registration Form</h1>
		<form:form action="registerEmployee" method="post"
			modelAttribute="employee">

			<div class="name">
				<div class="register-field">
					<label for="">Name :</label>
					<form:input class="field" type="text"
						placeholder="Enter your name..." path="name" />
				</div>
				<p><form:errors path="name" /></p>
			</div>

			<div class="gender">
				<div class="register-field">
					<label for="">Gender :</label> 
					<form:radiobutton path="gender" class="male" value="male" />Male 
					<form:radiobutton path="gender" class="female" value="female" />Female
				</div>
				<p><form:errors path="gender" /></p>
			</div>

			<div class="dob">
				<div class="register-field">
					<label for="">Date of Birth :</label> 
					<form:input type="date" class="field" path="dateOfBirth" />
				</div>
					<p><form:errors path="dateOfBirth" /></p>
			</div>

			<div class="address">
				<div class="register-field">
					<label for="">Address :</label>
					<textarea name="address" rows="3" placeholder="Your address"></textarea>
				</div>
				<p><form:errors path="address" /></p>
			</div>

			<div class="city">
				<div class="register-field">
					<label for="">City :</label> <form:input	path="city" class="field"
						type="text" placeholder="Enter city..." />
				</div>
				<p><form:errors path="city" /></p>
			</div>

			<div class="state">
				<div class="register-field">
					<label for="">State :</label> <form:input path="state" class="field"
						type="text" placeholder="Enter state..." />
				</div>
				<p><form:errors path="state" /></p>
			</div>

			<div class="login-id">
				<div class="register-field">
					<label for="">Login Id :</label> <form:input path="loginId"
						class="field" type="text" placeholder="Enter login id..." />
				</div>
				<p><form:errors path="loginId" /></p>
			</div>

			<div class="password">
				<div class="register-field">
					<label for="">Password :</label> <form:input path="password"
						class="field" type="password" placeholder="Enter password..." />
				</div>
				<p><form:errors path="password" /></p>
			</div>


			<div class="buttons">
				<button class="submit-btn" type="submit">Register</button>
				<button class="reset-btn" type="reset">Reset</button>
			</div>
		</form:form>
	</div>
</body>
</html>