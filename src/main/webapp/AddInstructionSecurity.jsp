<%@page import="com.bean.UserBean"%>
<%@page import="com.bean.HouseBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add insrustion</title>
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

	<jsp:include page="SecurityHeader.jsp"></jsp:include>
	-

	<div class="container">
		<form class="form-horizontal" role="form"
			action="AddinstructionSecurityController" method="post">
			<h2>Add Security instruction</h2>
			<div class="form-group">
				<label for="name" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<input type="text" id="firstName" placeholder="name"
						class="form-control" name="name" autofocus value=""> <span
						class="help-block"> </span>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-3">Allow</label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="femaleRadio" value="yes" name="per">yes
							</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="maleRadio" value="no" name="per">No
							</label>
						</div>

					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="contact" class="col-sm-3 control-label">type</label>
				<div class="col-sm-9">
					<input type="text" id="password" placeholder="type" name="type"
						class="form-control"> <span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="contact" class="col-sm-3 control-label">Description</label>
				<div class="col-sm-9">
					<input type="text" id="password" placeholder="Description]"
						name="description" class="form-control"> <span
						class="help-block"></span>
				</div>
			</div>

				
			<label for="block">Select block:</label> <select id="block"
				name="block">
				<c:forEach items="${houses}" var="it">
					<option value="${it.houseid}">${it.block}</option>
				</c:forEach>
			</select> <label for="cars">Select house:</label> <select id="cars"
				name="housenumber">
				<c:forEach items="${houses}" var="it">
					<option value="${it.houseid}">${it.housenumber}</option>
				</c:forEach>
			</select> ${FlateError}



			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<button type="submit" value="addinstruction"
						class="btn btn-primary btn-block">Addinstruction</button>
				</div>
			</div>



		</form>
	</div>
</body>
</html>