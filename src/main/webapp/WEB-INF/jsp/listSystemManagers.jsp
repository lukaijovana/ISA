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
				<th>Last Name</th>
				<th></th>
			</tr>
			<c:forEach items="${managers}"  var="manager">
				<tr>	
					<td><c:out value="${manager.id}"/> </td>			
					<td><c:out value="${manager.firstName}"/></td>
					<td><c:out value="${manager.lastName}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>	
	<div id="newManager">
		<a href="<c:url value="/sysmanager/newSystemManager"/>">Add a new system manager</a>
	</div>
</body>
</html>
