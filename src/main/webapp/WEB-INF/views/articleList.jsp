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
		<legend>Search</legend>
		<div class="span-7">
        		<form action="${pageContext.request.contextPath }/searchbytag" method="post" style="float:left;">
        			<input type="text" name="tagname" class="need change something here" />
        			<button type="submit"> Search by Tag</button>
        		</form>
      	</div>
      	<div class="span-8">
        		<form action="${pageContext.request.contextPath }/searchbykeyword" method="post" style="float:left;">
        			<input type="text" name="keyword" class="need change something here" />
        			<button type="submit"> Search by Keyword</button>
        		</form>
      	</div>
      	<div style="float:left;width: 1px;height: 25px; background: #000;"></div> 
      	<div class="span-7">
        		<p>here is sign in part</p>
      	</div>
      	<hr />
      	
      	<div class="span-17 colborder">
      		<c:forEach items="${articleList}" var="article" >
      			<h4>
      				<a href="${pageContext.request.contextPath}/articledetail/${article.aid}" target="_blank" style="text-decoration:none;">${article.title }</a>
					<div style="float: right;">
						<a href="${pageContext.request.contextPath}/userdetail/${article.user.uid}" target="_blank" style="text-decoration:none;">${article.author }</a>
					</div>
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
      		
      		<br />
      		<div>
				<a href="${pageContext.request.contextPath}/list/${currentPage==1?1:currentPage-1 }">
					←
				</a>
					No.${currentPage }/Total:${pageTotal }
				<a href="${pageContext.request.contextPath}/list/${currentPage==pageTotal?pageTotal:currentPage+1 }">
					→
				</a>
			</div>
      	</div>
      	
      	<div class="span-5 last">
      			<h2 class="alt">we can put log in here..</h2>
		</div>
		<hr />
			
	</div>

</body>
</html>