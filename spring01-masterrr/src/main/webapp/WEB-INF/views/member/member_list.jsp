<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<%@ include file="../include/member_header.jsp" %>
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>
	<h2>회원 목록</h2>
	<input type="button" value="회원등록" onclick="location.href='${path}/member/write.do'">
	<table border="1" width="700px">
		<tr>
			<th>비회원 코드</th>
			<th>비회원 주문 번호</th>
			<th>주문 날짜</th>
			<th>구매자</th>
		</tr>
		<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.n_mc}</td>
			<td>${row.n_mon}</td>
			<td>${row.order_date}</td>
			<td>${row.buyer_name}</td>
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>