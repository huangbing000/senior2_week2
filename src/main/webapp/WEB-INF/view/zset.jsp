<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/css/list.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="resource/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<table>
	<tr>
		<td>id</td>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>已售百分比</td>
	</tr>
	<c:forEach items="${set}" var="s">
		<tr>
			<td>${s.id}</td>
			<td>${s.name}</td>
			<td>${s.price}</td>
			<td>${s.bfb}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
