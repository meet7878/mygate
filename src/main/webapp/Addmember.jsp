<%@page import="com.bean.UserBean"%>
<%@page import="com.bean.HouseBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Member page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.error {
	color: red;
}

body {
	background-color: #eee;
}

*[role="form"] {
	max-width: 530px;
	padding: 15px;
	margin: 0 auto;
	background-color: #fff;
	border-radius: 0.3em;
}

*[role="form"] h2 {
	margin-left: 5em;
	margin-bottom: 1em;
}
</style>


</head>
<body>
 <jsp:include page="UserHeader.jsp"></jsp:include> 
	<%
	String genderError = (String) request.getAttribute("genderError");
	String genderValue = (String) request.getAttribute("genderValue");
	%>

	<div class="container">
		<form class="form-horizontal" role="form" action="AddMemberController"
			method="post">
			<h2>Add Member</h2>
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<input type="text" id="firstName" placeholder="name"
						class="form-control" name="name" autofocus
						value="${firstNameValue}"> <span class="help-block">
						${firstNameError}</span>
				</div>
			</div>
						
		 
			<div class="form-group">
				<label class="control-label col-sm-3">Gender</label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="femaleRadio" value="Female" name="gender"
								<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%>>Female
							</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="maleRadio" value="Male" name="gender"
								<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%>>Male
							</label>
						</div>

					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="contact" class="col-sm-3 control-label">age</label>
				<div class="col-sm-9">
					<input type="text" id="password" placeholder="Number"
						name="age" class="form-control" value="${ageValue}">
					<span class="help-block">${ageError}</span>
				</div>
			</div>
			<div class="form-group">
				<label for="contact" class="col-sm-3 control-label">Contact Number</label>
				<div class="col-sm-9">
					<input type="text" id="password" placeholder="Number"
						name="contactnumber" class="form-control" value="${contactNumberValue}">
					<span class="help-block">${contactNumberError}</span>
				</div>
			</div>
							
			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<button type="submit" value="addmember"
						class="btn btn-primary btn-block">AddMember</button>
				</div>
			</div>

			

		</form>
	</div>
</body>
</html>