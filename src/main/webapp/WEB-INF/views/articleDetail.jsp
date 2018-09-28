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
      	<div>
      		<h2 class="alt">${article.title }</h2>
      	</div>
      	<hr />
      	
      	<div class="span-5 colborder">	
      		<center>
      			<a href="${pageContext.request.contextPath}/userdetail/${article.user.uid }" >
      				<img src="<c:url value="${article.user.headimg }" />" style="width: 100px;height: 100px;" alt="headimg" />
      			</a>
      			<br />
      			<br />
      			Seller: <a href="${pageContext.request.contextPath}/userdetail/${author.uid}" >${author.username }</a>
      			<br />
      			<br />
      			<fmt:formatDate value="${article.date }" pattern="MM/dd HH:mm:ss" />
      			<br />
      		</center>
     	</div>	
      	<div class="span-17 last" style="position:relative;">
      		<img src="<c:url value="${article.articleimg }"/>" style="width:50%" alt="headimg" >
      		<br />
      		<c:out value="${article.content }"></c:out>
		</div>
		<hr />
		
		<c:forEach items="${commentList }" var="cl">
			<div class="span-5 colborder">	
      			<center>
      				<a href="${pageContext.request.contextPath}/userdetail/${cl.user.uid }" >
      					<img src="<c:url value="${cl.user.headimg }" />" style="width: 100px;height: 100px;" alt="headimg" />
      				</a>
      				<br />
      				<br />
      				<c:choose>
      					<c:when test="${cl.user.uid eq article.user.uid }">
      						Seller: <a href="${pageContext.request.contextPath}/userdetail/${cl.user.uid}" >${cl.author }</a>
      					</c:when> 
      					<c:otherwise>
      						Customer: <a href="${pageContext.request.contextPath}/userdetail/${cl.user.uid}" >${cl.author }</a>      					
      					</c:otherwise>      					
      				</c:choose>
      				<br />
      				<br />
      				<c:if test="${cl.user.uid eq user.uid || user.role eq 'admin'}">
	      				<input onclick="window.open('${pageContext.request.contextPath }/userdeletecomment/${article.aid }/${cl.cid }')" type='button' value='delete' >
      				</c:if>	
      				<br />
      				<br />
      				<fmt:formatDate value="${cl.date }" pattern="MM/dd HH:mm:ss" />
      				<br />
      				<br />
      				
      				
      			</center>
     		</div>	
      		<div class="span-17 last" style="position:relative;">
      			<c:out value="${cl.content }"></c:out>
      			<div>
      			</div>
			</div>
			<hr />			
		</c:forEach>
		
		<c:choose>
			<c:when test="${!empty user }">
				<div style="padding-top: 10px;">
            		<form id="addcomment" action="<c:url value='/addcomment/${article.aid}' />" method="post">
            			<fieldset>
            				<legend>Reply here</legend>
            				<p>
              				<label for="content">Content</label><br>
              				<textarea name="content" id="content" rows="5" cols="40" style="margin: 5.5px 0px; width: 900px; height: 200px;"></textarea>
            				</p>
            				<p>
              				<input type="submit" value="Submit">
              				<input type="reset" value="Reset">
            				</p>
          			</fieldset>
        			</form>		
				</div>
			</c:when>
			<c:otherwise>
				<center>
					<h3>You can reply after you login</h3>
				</center>
			</c:otherwise>
		</c:choose>
		<center><a href="http://www.liuyi.cool"><img src="../resources/imgs/foot.jpeg" /></a></center>
	</div>
	
</body>
</html>