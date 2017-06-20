<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
span{
	cursor: pointer;
}
</style>
<script type="text/javascript">
	var m = '${message}';
	if(m != ''){
		alert(m);
	}
	
	$(function() {
		$(".go").click(function() {
			/* 방법2 */
			document.frm.curPage.value = $(this).attr("id");
			document.frm.search.value = '${listInfo.search}';
			document.frm.find.value = '${listInfo.find}';
			document.frm.submit();
			
			/* 방법1 
			var cur=$(this).attr("id");
			location.href = "${board }List?curPage="+cur+"&search=${listInfo.search}&find=${listInfo.find}"; */ 
		});
		
	});
</script>
</head>
<body>
	<!-- List제목 -->
	<h2>${board }List</h2>
	<div>
		<form action="${board }List" name="frm">
		<input type="hidden" name="curPage">
			<select name="search">
				<option value="title">TITLE</option>
				<option value="writer">WRITER</option>
				<option value="contents">CONTENTS</option>
			</select>
			<input type="text" name="find">
			<input type="submit" name="SERACH">
		</form>
	</div>
	
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
	<c:if test="${listInfo.curBlock > 1 }">
	<span id="${listInfo.startNum-1 }" class="go">[이전]</span>
<%-- 	<a href="${board }List?curPage=${listInfo.startNum-1 }&search=${listInfo.search}&find=${listInfo.find}">[이전]</a> --%>
	</c:if>
	<c:forEach begin="${listInfo.startNum }" end="${listInfo.lastNum }" var="i">
	<span id="${i }" class="go">${i }</span>
		<%-- <a href="${board}List?curPage=${i}&search=${listInfo.search}&find=${listInfo.find}">${i }</a> --%>
	</c:forEach>
	
	<c:if test="${listInfo.curBlock < listInfo.totalBlock }">
		<span id="${listInfo.lastNum+1 }" class="go">[다음]</span>
		<%-- <a href="${board }List?curPage=${listInfo.lastNum+1 }&search=${listInfo.search}&find=${listInfo.find}">[다음]</a> --%>
	</c:if>
	
	
	<a href="../">home</a>
	<a href="${board }Write">WRITE</a>
	<div>
		<p>curPage : ${listInfo.curPage }</p>
		<p>SEARCH : ${listInfo.search }</p>
		<p>FIND : ${listInfo.find }</p>
	</div>
</body>
</html>