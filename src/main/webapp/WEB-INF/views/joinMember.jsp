<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="/joinMember">
		<div>
			ID : <input type="text" name="id">
		</div>
		<div>
			PW : <input type="password" name="pw"> 
		</div>
		<div>
			EMail : <input type="email" name="email">
		</div>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>