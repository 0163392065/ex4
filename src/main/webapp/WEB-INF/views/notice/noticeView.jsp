<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>NoticeView</h2>
		<table>
<%-- 		<tr>
			<td>NUM : ${dto.num }</td>
		</tr> --%>
		<tr>
			<td>WRITER : ${dto.writer }</td>
		</tr>
		<tr>
			<td>TITLE : ${dto.title }</td>
		</tr>	
		<tr>
			<td>CONTENTS : <br>${dto.contents } </td>
		</tr>
	</table>
	
	<!-- <a href="noticeWrite">noticeWrite</a> -->
	<a href="noticeDelete?num=${dto.num}">noticeDelete</a>
	<a href="noticeList">noticeList</a>
	<a href="noticeUpdate?num=${dto.num}">noticeUpdate</a>
</body>
</html>