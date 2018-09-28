<%@ page language="java" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TradePost</title>
<meta http-equiv="refresh" content="5;url=${redirectPage }">
</head>
<body onload="run()">
	
	${message }
	<b><span id="spanId">5</span> seconds</b>  
      
    <% response.setHeader("Refresh", "5;url=list/1");%>  	
</body>
<br><script type="text/javascript">
    var x = 5;
    function run(){
        var span = document.getElementById("spanId");
        span.innerHTML = x;
        x--;
        window.setTimeout("run()", 1000);
    }
     
</script><br>
</html>