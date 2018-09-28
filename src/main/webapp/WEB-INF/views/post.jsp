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

<link rel="stylesheet" href="resources/blueprint/screen.css" type="text/css" media="screen, projection">
<link rel="stylesheet" href="resources/blueprint/print.css" type="text/css" media="print">
<link rel="stylesheet" href="resources/blueprint/plugins/fancy-type/screen.css" type="text/css" media="screen, projection">

</head>
<body>
	<div class="container">
		<center><a href="/controller/list/1"><img src="resources/imgs/pagehead.jpg" /></a></center>
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
      	
      	<!-- post part -->
		<c:choose>
			<c:when test="${!empty user }">
				<div style="padding-top: 10px;">
            		<legend>Post your games</legend>				
				<fieldset>
            			<form id="addarticle" action="<c:url value='/addarticle' />" method="post">
            				<p>
              				<label for="title">Title</label><br>
              				<input type="text" class="title" name="title" id="title" placeholder="Title, eg. Call Of Duty: Modern War 2">
            				</p>
            				<p>
              				<label for="label">Tag</label><br>
              				<input type="text" class="label" id="label" name="label" placeholder="#tag#, eg. #FPS#">
            				</p>
            				<p>
              				<label for="content">Content</label><br>
              				<textarea name="content" id="content" rows="5" cols="40" style="margin: 5.5px 0px; width: 900px; height: 200px;"></textarea>
            				</p>
            				<p>
            					<label for="uploadarticleimg">Article Picture Address</label><br>
            					<input type="text" name="uploadarticleimg" value="${uploadarticleimg }" />
            				</p>
            				<p>
              				<input type="submit" value="Submit">
              				<input type="reset" value="Reset">
            				</p>
          			</form>
          			<form action="${pageContext.request.contextPath}/articleimgupload" method="post" enctype="multipart/form-data">
						<input type="file" name="file" />
						<input type="submit" value="Upload">
					</form>
        			</fieldset>		
				</div>
			</c:when>
			<c:otherwise>
				<center>
					<h3>You can post your games after you login</h3>
				</center>
			</c:otherwise>
		</c:choose>
		
     <center><a href="http://www.liuyi.cool"><img src="resources/imgs/foot.jpeg" /></a></center>
	</div>
	
</body>
</html>