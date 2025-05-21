<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			/*
			$('#addBtn').click(function(){
				if($('#name').val().length < 4) {
					alert('name은 4자 이상');
					return;
				}
				if(!$.isNumeric($('#age').val()) || $('#age').val() < 0 || $('#age').val() > 200){
					alert('age는 0~200 숫자만')
					return;
				}
				$('#addForm').submit();
			})
			*/
		});
	</script>
</head>
<body>
	<h1>addSample</h1>
	<span>${errMsg}</span>
	<form id="addForm" method="post" action="/addSample">
		<div>
			name : <input type="text" name="name" id="name">
			<span>${nameErrMsg}</span>
		</div>
		<div>
			age : <input type="number" name="age" id="age" min="0" max="200">
			<span>${ageErrMsg}</span>
		</div>
		<div>
			<button type="submit" id="addBtn">입력</button>
		</div>
	</form>
</body>
</html>