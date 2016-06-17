<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spitter</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<s:url value="/" var="homeUrl" />
	<a href="${homeUrl}">Home</a>

	<s:url value="/spittles" var="spittlesUrl">
		<s:param name="max" value="60" />
		<s:param name="count" value="20" />
	</s:url>
	<a href="${spittlesUrl}">Spittles</a>

	<s:url value="/spitter/{username}" var="spitterUrl">
		<s:param name="username" value="jbauer" />
	</s:url>
	<a href="${spitterUrl}">Spitter</a>

	<h1>
		<s:message code="spittr.register" />
	</h1>
	<sf:form method="POST" commandName="spitter">
		<sf:errors path="*" cssClass="errors" element="div" />
		<sf:label path="firstName" cssErrorClass="error">First Name</sf:label>:
		<sf:input path="firstName" cssErrorClass="error" />
		<!-- sf:errors path="firstName" cssClass="error" /> -->
		<br />
	Last Name: <sf:input path="lastName" />
		<br />
	UserName: <sf:input path="username" />
		<br />
	Password: <sf:password path="password" />
		<br />
		<input type="submit" name="Register" />
		<br />

	</sf:form>

	<h2>Some escaped code lies here.</h2>
	<s:escapeBody htmlEscape="true">
		<h1>
			<s:message code="spittr.register" />
		</h1>
	</s:escapeBody>
</body>
</html>