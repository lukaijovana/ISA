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

<script type="text/javascript">
          function onSubmit() {
            var inputs = document.getElementById("izbor");
            var selected_inputs = [];
            var j = 0;
            for (var i = 0; i < inputs.length; i++) {
              if (inputs[i].selected) {
                selected_inputs[j] = inputs[i].value;
                j = j + 1;
              }
            }
            for(var k = 0; k < selected_inputs.length; k++) {
				alert("selected input is: " + selected_inputs[k])            	
            }
            document.getElementById("polje").value = selected_inputs[0];
          }

           
</script>
</head>
<body>
	<spring:url value="/restaurant/add/" var="formUrl"/>
	<form:form modelAttribute="restaurant" action="${formUrl }" method="post" onsubmit="onSubmit();">
		<div>
			<label for="restaurant-name">Name</label>
			<form:input id="restaurant-name" path="name"/>
					<form:errors path="name"/>
		</div>
	
		<div>
			<label for="restaurant-description">Description</label>
			<form:input id="restaurant-description" path="description"/>
					<form:errors path="description"/>
			
		</div>
	

		<div>
			<label for="restaurant-country">Country</label>
			<form:input id="restaurant-country" path="country"/>
					<form:errors path="country"/>
		</div>

		<div>
			<label for="restaurant-city">City</label>
			<form:input id="restaurant-city" path="city"/>
					<form:errors path="city"/>
		</div>

		<div>
			<label for="restaurant-address">Address</label>
			<form:input id="restaurant-address" path="address"/>
					<form:errors path="address"/>
		</div>	
		
	
		
  			<form:select id = "izbor" path = "managersId" multiple="true" cssClass="selectpicker" items="${manageroptions}" itemValue = "id" itemLabel="firstName"></form:select>
       	
		<div>
			<button type="submit" >Submit</button>
		</div>

	 </form:form>
</body>
</html>