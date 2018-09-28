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

</head>
<body>
	<div class="container">
		<center><a href="/controller/list/1"><img src="../resources/imgs/pagehead.jpg" /></a></center>
		<legend>Search</legend>
		<div class="span-8">
        		<form action="${pageContext.request.contextPath }/searchbytag" method="post" style="float:left;">
        			<input type="text" name="tagname" />
        			<button type="submit"> Search by Tag</button>
        		</form>
      	</div>
      	<div class="span-7 colborder">
        		<form action="${pageContext.request.contextPath }/searchbykeyword" method="post" style="float:left;">
        			<input type="text" name="keyword" />
        			<button type="submit"> Search by Keyword</button>
        		</form>
      	</div>
      	
      	<div class="span-7">
        		<input onclick="window.open('${pageContext.request.contextPath }/loginform')" type='button' value='Login' style="float:left;" >
        		<input onclick="window.open('${pageContext.request.contextPath }/registerform')" type='button' value='Register' style="float:left; position:relative; left:10%;">
        		<input onclick="window.open('${pageContext.request.contextPath }/post')" type='button' value='Post' style="float:left; position:relative; left:18%;">
        		<input onclick="window.open('${pageContext.request.contextPath }/logout')" type='button' value='Logout' style="float:right;" >
      	</div>
      	<hr />
      	
      	<h4>${registerResult}</h4>
      	<div class="span-17 colborder">
      		<c:forEach items="${articleList}" var="article" >
      			<h4>
      				<a href="${pageContext.request.contextPath}/articledetail/${article.aid}" style="text-decoration:none;">${article.title }</a>
					<div style="float: right;">
						<a href="${pageContext.request.contextPath}/userdetail/${article.user.uid}" style="text-decoration:none;">${article.author }</a>
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
      		<div style="padding-top: 50px;">
				<center>
					<c:choose>
						<c:when test="${!empty user }">
							<a href="${pageContext.request.contextPath}/userdetail/${user.uid }" target="_blank">
								<img src="<c:url value="${user.headimg }" />" style="width: 100px;height: 100px;" alt="headimg" >
							</a>
							<br /><br />
							<a href="${pageContext.request.contextPath}/userdetail/${user.uid }" target="_blank" style="text-decoration:none;">
								Username: ${user.username }
							</a>
							<br /><br />
							<input onclick="window.open('${pageContext.request.contextPath }/logout')" type='button' value='Logout' >
						</c:when>
						<c:otherwise>
							<input onclick="window.open('${pageContext.request.contextPath }/loginform')" type='button' value='Login' >
						</c:otherwise>
					</c:choose>
				</center>
			</div>
		</div>
		<hr />
		
		
	<center><a href="http://www.liuyi.cool"><img src="../resources/imgs/foot.jpeg" /></a></center>
	</div>
</body>
</html>