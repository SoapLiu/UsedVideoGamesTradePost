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
      	<hr />

      	<div class="span-10" style="margin:100px 300px;">
      	
			<h3>Register with Username and Password</h3>
			
			<c:if test="${not empty errorMsg}">
				<div class="errorMsg">${errorMsg}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<form name='registerForm' action="<c:url value='/register' />" method='POST' >
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td><input name="submit" type="submit"
						value="Register" /></td>
					<td><input name="reset" type="reset"
						value="Reset" /></td>
				</tr>
			</table>		
			</form>      		
		</div>
		<hr />
		<center><a href="http://www.liuyi.cool"><img src="resources/imgs/foot.jpeg" /></a></center>	
	</div>

	
</body>
</html>