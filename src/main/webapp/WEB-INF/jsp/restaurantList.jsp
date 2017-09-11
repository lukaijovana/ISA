<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Restaurants : View all</title>
</head>
<body>
	<div id="restaurants">
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th></th>
			</tr>
			<c:forEach items="${restaurants}"  var="restaurant">
				<tr>	
					<td><c:out value="${restaurant.id}"/></td>				
					<td><c:out value="${restaurant.name}"/></td>
					<td><c:out value="${restaurant.description}"/></td>
				</tr>
				<c:set var="workplace" value="${restaurant.managers}"/>
				<c:choose>
				<c:when test = "${not empty workplace}">
					<c:forEach items="${workplace}"  var="manager">
						<td>Radnik:<c:out value="${manager.firstName}"/></td>
					</c:forEach>
				</c:when>
				</c:choose>
						
				
			</c:forEach>
		</table>
	</div>	
	<div id="newRestaurant">
		<a href="<c:url value="/sysmanager/newRestaurant"/>">Create new restaurant</a>
	</div>
</body>
</html>