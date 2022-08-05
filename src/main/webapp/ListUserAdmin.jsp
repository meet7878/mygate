<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of user in Admin pannel</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
<link rel="stylesheet" 
href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">

</head>
<body>
 <jsp:include page="AdminHeader.jsp"></jsp:include> -

<%

	   ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<table id="users" class="display table-hover table-bordered table-striped" >

					<thead class="thead-light">

						<tr>
							<!-- <th>UserId</th> -->
							<th>FirstName</th>
							<th>LastName</th>
							<th>Email</th>
							<th>Gender</th>
							<th>contactnum</th>
							<th>Status</th>
							<th>Approve</th>
							<th>Add House</th>
						</tr>

					</thead>

				
						<%
				 		    for (UserBean user : users){
						%>
						<tr>
							<%-- <td><%=user.getUserid()%></td> --%>
							<td><%=user.getFirstname()%></td>
							<td><%=user.getLastname()%></td>
							<td><%=user.getEmail()%></td>
							<td><%=user.getContactnum() %>
							<td><%=user.getGender()%></td>
							<td><%=user.getStatus()%></td>
							<%-- <td><a href="DeleteController?userid=<%=user.getUserId()%>">Delete</a> 
							<a href="UpdateUserFormController?userid=<%=user.getUserId()%>">Update</a></td> --%>
							
							<td><a href="AproveController?userid=<%=user.getUserid() %>">Enable</a></td>
							<td><a href="AddHouseDetails.jsp?userid=<%=user.getUserid() %>">Add House</a></td>
							
						</tr>

						<%
						    }
						%>
					

				</table>

			</div>
		</div>
	</div>
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" ></script>
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#users').DataTable();
	});
	</script> 
	
</body>
</html>

</body>
</html>