<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Login</title>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css">
  	
</head>
<body>
    <header>
        <h2 class="emp-name">Employee Management</h2>
        <ul>
           <li> <a href="register">Register</a> </li>
           <li> <a href="/OaclandTask/"> Login</a></li>
           <li><a href="welcome">Home</a></li>
        </ul>
    </header>

   <section class="login-form-section">
    <div class="login-container">
       
        <h1 class="heading">Employee Login</h1>
        <form class="login-form"  action="loginEmployee" method="post">
           <div class="login-id">
                <label for="">Login Id :</label>
                <input name="loginId" class="field" type="text" placeholder="Enter login-id">
           </div>
           <div class="password">
                <label for="">Password :</label>
                <input name="password" class="field" type="password" placeholder="Enter password">
           </div>
           
           <%
           		String loginEmployee = (String)request.getAttribute("loginEmployee");
           		String registerSuccess = (String)request.getAttribute("registerSuccess");
           %>
           <div>
           		<%if(loginEmployee!=null){ %>
           			<h4 class="login-error"><%=loginEmployee %></h4>
           		<%} %>
           		<%if(registerSuccess!=null){ %>
           			<h4 class="register-success"><%=registerSuccess %></h4>
           		<%} %>
           </div>
           
           <div class="buttons">
                <button class="submit-btn" type="submit">Login</button>
           </div>
        </form>
    </div>
   </section>
</body>
</html>