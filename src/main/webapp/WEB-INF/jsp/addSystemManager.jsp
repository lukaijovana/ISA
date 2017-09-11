<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Create Restaurant Manager</title>
</head>
<body>
	<spring:url value="/sysmanager/add" var="formUrl"/>
	<form:form modelAttribute="newmanager" action="${formUrl }" method="post" >
		<div>
			<label for="newmanager-name">First Name</label>
			<form:input id="newmanager-name" path="firstName"/>
					<form:errors path="firstName"/>
		</div>
	
		<div>
			<label for="newmanager-lastname">Last Name</label>
			<form:input id="newmanager-lastname" path="lastName"/>
					<form:errors path="lastName"/>
			
		</div>
	
		<div>
			<label for="newmanager-email">E-Mail</label>
			<form:input id="newmanager-email" path="eMail"/>
					<form:errors path="eMail"/>
			
		</div>
	
		<div>
			<label for="newmanager-password">Password</label>
			<form:password id="newmanager-password" path="password"/>
					<form:errors path="password"/>
		
		</div>

		<div>
			<label for="newmanager-country">Country</label>
			<form:input id="newmanager-country" path="country"/>
					<form:errors path="country"/>
		</div>

		<div>
			<label for="newmanager-city">City</label>
			<form:input id="newmanager-city" path="city"/>
					<form:errors path="city"/>
		</div>

		<div>
			<label for="newmanager-address">Address</label>
			<form:input id="newmanager-address" path="address"/>
					<form:errors path="address"/>
		</div>	


		<div>
			<button type="submit" >Submit</button>
		</div>
	</form:form>
</body>
</html>