<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
/* 		$("#testbtn").on('click', function(e){
			$("#output").html("<H3>" + e.target.tagName + "</H3>");
			$("#output").append("<H3>" + e.target.name + "</H3>");
			$("#output").append("<H3>" + e.target.value + "</H3>");
		}); */

	$("#testbtn").on('click', myfunc);
	
	function myfunc(e){
		$("#output").html("<H3>" + e.target.tagName + "</H3>");
		$("#output").append("<H3>" + e.target.name + "</H3>");
		$("#output").append("<H3>" + e.target.value + "</H3>");
		$("#output").append("<H3>" + e.target.innerText + "</H3>");
	}
	
	});
</script>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
500 서버 오류<br>
<%=exception %>
</body>
</html>