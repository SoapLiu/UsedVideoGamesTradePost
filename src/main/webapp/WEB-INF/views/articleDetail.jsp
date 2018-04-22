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
      		<h2 class="alt">${article.title }</h2>
      	</div>
      	<hr />
      	
      	<div class="span-5 colborder">	
      		<center>
      			<a href="${pageContext.request.contextPath}/userdetail/${article.user.uid }" target="_blank">
      				<img src="<c:url value="../resources/imgs/head.png" />" style="width: 50%;" alt="headimg" />
      			</a>
      			<br />
      			<br />
      			Seller: <a href="${pageContext.request.contextPath}/userdetail/${author.uid}" target="_blank">${author.username }</a>
      		</center>
     	</div>	
      	<div class="span-17 last" style="position:relative;">
      		<c:out value="${article.content }"></c:out>
      		<div>
      			<h6 style="position:absolute; right:0px; top:10px; width:100px; height:100px;">
					publish time:<fmt:formatDate value="${article.date }" pattern="MM/dd HH:mm:ss" />
				</h6>
      		</div>
		</div>
		<hr />
		
		<c:forEach items="${commentList }" var="cl">
			<div class="span-5 colborder">	
      			<center>
      				<a href="${pageContext.request.contextPath}/userdetail/${cl.user.uid }" target="_blank">
      					<img src="<c:url value="../resources/imgs/head.png" />" style="width: 50%;" alt="headimg" />
      				</a>
      				<br />
      				<br />
      				<c:if test="${cl.user.uid eq article.user.uid}">Seller: </c:if>
      				<a href="${pageContext.request.contextPath}/userdetail/${cl.user.uid}" target="_blank">${cl.user.uid }</a>
      			</center>
     		</div>	
      		<div class="span-17 last" style="position:relative;">
      			<c:out value="${cl.content }"></c:out>
      			<div>
      				<h6 style="position:absolute; right:0px; top:10px; width:100px; height:100px;">
						publish time:<fmt:formatDate value="${cl.date }" pattern="MM/dd HH:mm:ss" />
					</h6>
      			</div>
			</div>
			<hr />			
		</c:forEach>
		
		
	</div>

	
</body>
</html>