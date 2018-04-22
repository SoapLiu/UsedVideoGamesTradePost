<%@ page language="java" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TradePost</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="../resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="../resources/blueprint/print.css" type="text/css" media="print">
<link rel="stylesheet" href="../resources/blueprint/plugins/fancy-type/screen.css" type="text/css" media="screen, projection">

<script type="text/javascript"
	src="<c:url value="../resources/js/jquery.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="../resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="../resources/js/jquery.nivo.slider.js"/>"></script>

</head>
<body>
	<div class="container">
		<h1>Welcome to Used Video Games Trade Post</h1>
		<div class="span-7">
        		<p>here is search part</p>
      	</div>
      	<div class="span-8">
        		<p>here is register part</p>
      	</div>
      	<div class="span-7">
        		<p>here is sign in part</p>
      	</div>
      	<hr />
      	<div>
      		<h2 class="alt">${userdetail.username }'s post</h2>
      	</div>
      	<hr />
      	
      	<div class="span-5 colborder">	
      		<center>
      			<a href="${pageContext.request.contextPath}/userdetail/${userdetail.uid }" target="_blank">
      				<img src="<c:url value="../resources/imgs/head.png" />" style="width: 50%;" alt="headimg" />
      			</a>
      			<br />
      			<br />
      			User: <a href="${pageContext.request.contextPath}/userdetail/${userdetail.uid}" target="_blank">${userdetail.username }</a>
      		</center>
     	</div>	
      	<div class="span-17 last" style="position:relative;">
      		<c:forEach items="${userdetailarticlelist}" var="article" >
      			<h4>
      				<a href="${pageContext.request.contextPath}/articledetail/${article.aid}" target="_blank" style="text-decoration:none;">${article.title }</a>
					<br />
				</h4>
				<c:if test="${!empty article.label }">
					<div class="span-1">#${article.label }#</div>
				</c:if>
				<p style="float: right;">
					<fmt:formatDate value="${article.date }" pattern="MM/dd HH:mm:ss" />
				</p>
      			<hr />
      		</c:forEach>
      		
		</div>
		<hr />		
		
	</div>

	
</body>
</html>