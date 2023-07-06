<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function () {
	var jsondata = {"a":"a데이터", "b":"b데이터"};
	//json 은 key를 반드시 큰 따옴표로 해줘야한다. 작은 따옴표 안됨
	//서버로 보낼 데이터를 json으로 생성한다
	alert(jsondata.a);
	//컨트롤러의 방법1대로 public String jsontest(String a, String b) 선언시
	/*	$.ajax({
			url: "jsontest",
			data: jsondata, 
			type: "get", //post도 가능
			dataType: "json",
			success: function (resp) {
				$('div').html(resp);
			} // success 
		}); // ajax 
	*/
	//컨트롤러의 방법2대로 @RequestBody Map<String,String> jsondata 선언시
	$.ajax({
			url: "jsontest",
			data: JSON.stringify(jsondata), //ajax는 저 data를 문자열화 해주지 않기 때문에 Controller에서 받아줄 때에 에러가 생긴다.
			contentType : 'application/json; charset=UTF-8',
			type: "post", //json데이터를 요청 바디에 포함해야 하므로. @RequestBody는 요청 바디의 데이터를 읽어온다
			dataType: "json",
			success: function (resp) {
				$('div').html(resp);
			} // success 
		}); // ajax 
		
		
}); // ready
</script>
</head>
<body>

<div></div>
</body>
</html>