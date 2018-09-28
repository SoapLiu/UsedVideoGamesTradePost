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
        			<input type="text" name="tagname" class="need change something here" />
        			<button type="submit"> Search by Tag</button>
        		</form>
      	</div>
      	<div class="span-7 colborder">
        		<form action="${pageContext.request.contextPath }/searchbykeyword" method="post" style="float:left;">
        			<input type="text" name="keyword" class="need change something here" />
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

      	
      	<div class="span-5 colborder">	
      		<center>
      			<a href="${pageContext.request.contextPath}/userdetail/${userdetail.uid }" >
      				<img src="<c:url value="${userdetail.headimg }" />" style="width: 100px;height: 100px;" alt="headimg" />
      			</a>
      			<br />
      			<br />
      			User: <a href="${pageContext.request.contextPath}/userdetail/${userdetail.uid}" target="_blank">${userdetail.username }</a>
      			<br />
      			<br />
      			<c:if test="${userFlag eq true}">
      				<input onclick="window.open('${pageContext.request.contextPath }/password')" type='button' value='Change Password' >
      				<br />
      				<br />
      				<form action="${pageContext.request.contextPath}/headimgupload" method="post" enctype="multipart/form-data">
						<input type="file" name="headimgfile" />
						<input type="submit" value="Change Profilephoto">
					</form>
      			</c:if>
      			
      			
      		</center>
     	</div>	
      	<div class="span-17 last" style="position:relative;">
      		<c:forEach items="${userdetailarticlelist}" var="article" >
      			<h4>
      				<a href="${pageContext.request.contextPath}/articledetail/${article.aid}" style="text-decoration:none;">${article.title }</a>
      				<c:if test="${userdetail.uid eq user.uid || user.role eq 'admin'}">
      					<div style="float: right;">
	      					<input onclick="window.open('${pageContext.request.contextPath }/userdeletearticle/${article.aid}')" type='button' value='delete' >
						</div>
      				</c:if>	
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
		<center><a href="http://www.liuyi.cool"><img src="../resources/imgs/foot.jpeg" /></a></center>
	</div>

	
</body>
</html>