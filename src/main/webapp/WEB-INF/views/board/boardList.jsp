<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var m = '${message}';
	if(m != ''){
		alert(m);
	}
</script>
</head>
<body>
	<!-- List제목 -->
	<h2>${board }List</h2>
	
	<table>
		<tr>
			<td>NUM</td>
			<td>TITLE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.num }</td>
				<td>
				<!-- catch로 예외처리 -->
				<c:catch>
				<c:forEach begin="1" end="${dto.depth }">-></c:forEach></c:catch>
				<a href="${board }View?num=${dto.num }">${dto.title }</a></td>
				<td>${dto.writer }</td>
				<td>${dto.reg_date }</td>
				<td>${dto.hit }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="../">home</a>
	<a href="${board }Write">WRITE</a>
</body>
</html>