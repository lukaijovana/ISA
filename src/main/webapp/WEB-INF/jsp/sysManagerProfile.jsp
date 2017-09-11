<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Manager : View Profile</title>
</head>
<body>
	<p>
		Dobro dosli, <c:out value = "${sysmanager.firstName }" />
		<a href="<c:url value="/sysmanager/viewAllManagers"/>">Pregled svih menadzera restorana</a>
		<a href="<c:url value="/sysmanager/viewAllRestaurants"/>">Pregled svih restoranar</a>
		<a href="<c:url value="/sysmanager/viewAllSysManagers"/>">Pregled svih menadzera sistema</a>
	</p>
</body>
</html>