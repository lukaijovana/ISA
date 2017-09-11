<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<html>
<head>
    <title>Result:</title>
</head>
<body>

<h2>Your Profile</h2>
   <table>
    <tr>
        <td>eMail:</td>
        <td>${email}</td>
    </tr>
    <tr>
        <td>Password:</td>
        <td>${password}</td>
    </tr>
        <tr>
        <td>First Name:</td>
        <td>${firstName}</td>
    </tr>
        <tr>
        <td>Last Name:</td>
        <td>${lastName}</td>
    </tr>
        <tr>
        <td>Full Address:</td>
        <td>${country},${city},${address}</td>
    </tr>
        <tr>
        <td>Photo:</td>
        <td>${photo} - url putanja do slike</td>
    </tr>
    
    
</table>  
</body>
</html>