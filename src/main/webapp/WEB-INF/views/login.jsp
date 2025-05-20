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
	<form method="post" action="/login">
		<div>
			id : <input type="text" name="id">
		</div>
		<div>
			pw : <input type="password" name="pw">
		</div>
		<button type="submit">로그인</button>
	</form>
	<a href="/joinMember">회원가입</a>
</body>
</html>