<%@page import="org.springframework.ui.Model"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oakland.entity.Employee"%>
<%@page import="java.util.List"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee | Welcome Page</title>
  	<link href="resources/css/style.css" rel="stylesheet" type="text/css">
 
</head>
<body>
    <header>
      <h2 class="emp-name">Employee Management</h2>
     	<%
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    		String empName = (String)request.getAttribute("loginEmployeeName");
    		if(empName!=null){
    			%>
    			
        <h2 class="emp-name login-emp">Hello, <span><%=empName %></span></h2>
    			
    			<%
    			}
    	%>
        <ul>
           <li> <a href="register">Register</a> </li>
           <li> <a href="/OaclandTask/"> Login</a></li>
           <li><a href="welcome">Home</a></li>
        </ul>
    </header>
    <div class="all-emp">
        <table>
            <thead>
                <tr>
                	<th width="20px">Sr.No.</th>
                <th width="100px">Login-Id</th>
                <th width="200px">Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th width="200px">Address</th>
                <th>State</th>
                <th >City</th>
                </tr>
            </thead>
            <tbody>
            
            <%
            List<Employee> allEmployees = (List<Employee>)request.getAttribute("allEmployees");
             	for(Employee employee:allEmployees){
            		%>
            		    <tr>
	                    <td><%=employee.getId()%></td>
	                    <td><%=employee.getLoginId() %></td>
	                    <td><%=employee.getName() %></td>
	            	   	<td><%
	  					   		if(employee.getDateOfBirth()!=null){
	  					   	%>
	  					   		 <%= sdf.format(employee.getDateOfBirth())%>
	  					   	<%
	  					   		}
	  					   	%></td>
  					   	
	                    <td><%=employee.getGender()%></td>
	                    <td><%=employee.getAddress() %></td>
	                    <td><%=employee.getState()%></td>
	                    <td><%=employee.getCity()%></td>  
	                </tr>
            		
            <%}%>
           </tbody>
        </table>
    </div>
</body>
</html>