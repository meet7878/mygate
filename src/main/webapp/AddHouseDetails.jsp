<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>House Details</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
legend {
	background-color: powderblue;
	text-align: center;
}
</style>
</head>
<body>
	<% String userid = request.getParameter("userid"); %>
	<form method="post" action="AddHouseController?userid=<%=userid %>"	class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>House</legend>

			<!-- Text input-->
			
			<div class="form-group">
				<label class="col-md-4 control-label">Owner Name</label>
				<div class="col-md-4">
					<input type="text" name="owner_name" placeholder="Owner Name"
						class="form-control input-md">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label">House Details</label>
				<div class="col-md-4">
					<input type="text" name="house_details" placeholder="House Details"
						class="form-control input-md">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label">House Number</label>
				<div class="col-md-4">
					<input type="text" name="house_number" placeholder="House Number"
						class="form-control input-md">
				</div>
			</div>
			

			<div class="form-group">
				<label class="col-md-4 control-label">Block</label>
				<div class="col-md-4">
					<select class="form-control input-md" name="block" required="">
						<option></option>
						<option>A</option>
						<option>B</option>
						<option>C</option>
					</select>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label">Floor</label>
				<div class="col-md-4">
					<select class="form-control input-md" name="floor">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button type="submit" class="btn btn-primary">Submit</button>
					${msg} <a href="Admin.jsp" button type="submit"
						class="btn btn-primary ">Back To Home</a>
				</div>
			</div>
		</fieldset>
	</form>
</body>
</html>