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
	<h1>비밀번호 변경</h1>
	<form id="changePw" method="post" action="/changePw">
		<div>
			아이디 : <input id="id" type="text" name="id" value="${id}" readonly>
		</div>
		<div>
			이메일 : <input id="email" type="email" name="email">
		</div>
		<div>
			변경할 비밀번호 : <input type="password" name="pw" id="pw">
		</div>
		<div>
			비밀번호 확인: <input type="password" name="pwck" id="pwck">
		</div>
		<button type="button" id="changeBtn">비밀번호 변경</button>
	</form>
	
<script>
    $('#changeBtn').click(function(){
        let id = $('#id').val();
        let email = $('#email').val();
        let pw = $('#pw').val();
        let pwck = $('#pwck').val();

        if(pw != pwck) {
            alert('비밀번호가 일치하지 않습니다.');
            return;
        }

        $.ajax({
            url: '/changePw',
            type: 'post',
            data: {
                id: id,
                email: email,
                pw: pw,
                pwck: pwck
            },
            success: function(data) {
                if(data == 'success') {
                    alert('비밀번호가 성공적으로 변경되었습니다.');
                    window.location.href = '/login';
                } else if(data == 'fail') {
                    alert('최근 사용한 비밀번호 입니다.');
                }
            }
        });
    });
</script>
</body>
</html>