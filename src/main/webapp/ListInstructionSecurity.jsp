<%@page import="com.bean.InstructionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" 
href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body>
 <jsp:include page="SecurityHeader.jsp"></jsp:include> -

<%
	   ArrayList<InstructionBean> instructions = (ArrayList<InstructionBean>) request.getAttribute("instructions");
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<table id="users" class="display table-hover table-bordered table-striped" >

					<thead class="thead-light">
					
					<tr>
							<th>Name</th>
							<th>Allow</th>
							<th>Type</th>
							<th>Decription</th>
							<th>block</th>
							<th>housenumber</th>
							<!-- <th>Action</th> -->
							
						</tr>
                    </thead>
                    
                    <c:forEach items="${instructions}" var="add">
                    <tr>
                    <td> ${add.name} </td>
                    <td>${add.allow }</td>
                    <td>${add.type }</td>
                    <td>${add.description}</td>
                    <td>${add.block}</td>
                    <td>${add.housenumber}</td>
                    <%-- <td><a href="DeleteInstructionCotroller?instructionid=${add.instructionid} ">Delete </a></td> --%>
                    </tr>
                    </c:forEach>
                    
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