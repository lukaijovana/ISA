<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Greetings : View all</title>
</head>
<body>
	<div id="managers">
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th></th>
			</tr>
			<c:forEach items="${managers}"  var="manager">
				<tr>	
					<td><c:out value="${manager.id}"/> </td>			
					<td><c:out value="${manager.firstName}"/></td>
					<td><c:out value="${manager.lastName}"/></td>
					<c:set var="workplace" value="${manager.workplace}"/>
					<c:choose>
						<c:when test = "${empty workplace}">
						<td><a href = "<c:url value="/restaurantManager/addRestaurant/${manager.id}"/>">Dodaj restoran</a></td>
						</c:when>
						<c:otherwise>
						<td><c:out value = "${manager.workplace.name }" /></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>	
	<div id="newManager">
		<a href="<c:url value="/sysmanager/newRestaurantManager"/>">Add a new manager</a>
	</div>
</body>
</html>
