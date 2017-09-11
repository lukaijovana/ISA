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
	<c:set var="manid" value="${restaurantManager.id}"/>
	<spring:url value="/restaurantManager/selectRestaurant/${manid}" var="formUrl"/>
	<form:form modelAttribute="restaurant" action="${formUrl }" method="post" >
		<div>
			<label for="manager-workplace">Select workplace:</label>
			<form:select path="id" cssClass="selectpicker" items="${options}" itemValue = "id" itemLabel="name"></form:select>
					<form:errors path="id"/>
		</div>
		<div>
			<button type="submit" >Submit</button>
		</div>
	
	
	</form:form>
</body>
</html>