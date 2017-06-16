<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>NoticeWrite	</h2>
	<form action="notice${path }" method="post">
	<div>
		<input type="hidden" name="num" id="num" value="${dto.num }">
	</div>
		<table>
		<tr>
			<td>WRITER : <input type="text" name="writer" id="writer" value="${dto.writer }"></td>
		</tr>
		<tr>
			<td>TITLE : <input type="text" name="title" id="title" value="${dto.title }"></td>
		</tr>	
		<tr>
			<td>CONTENTS : <br><textarea style="width: 400px; height: 200px;" name="contents" id="contents" >${dto.contents }</textarea> </td>
		</tr>
		
	</table>
	<input type="submit" name="WRITE">
	<!-- <button>SUBMIT</button> -->
	</form>
	<a href="noticeDelete">noticeDelete</a>
	<a href="noticeList">noticeList</a>
	<a href="noticeUpdate">noticeUpdate</a>
</body>
</html>