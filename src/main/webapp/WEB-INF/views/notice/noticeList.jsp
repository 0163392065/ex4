<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<h2>NoticeList</h2>
	
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
				<td><a href="noticeView?num=${dto.num }">${dto.title }</a></td>
				<td>${dto.writer }</td>
				<td>${dto.reg_date }</td>
				<td>${dto.hit }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="../">home</a>
	<a href="noticeWrite">noticeWrite</a>
	<!-- <a href="noticeDelete">noticeDelete</a> -->
</body>
</html>