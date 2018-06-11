<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   function flushCode() {
       var time = new Date();
       document.getElementById("scode").src="<%=request.getContextPath()%>/createCode?time=" + time;
   }
</script>
</head>
<body>
    <center>
        <form action="<%=request.getContextPath() %>/checkCode" method="post">
            请输入验证码:<input type="text" name="code"/><br/>
            <input type="submit" value="提交"/>
        </form>
        <img id="scode" alt="验证码"  src="<%=request.getContextPath() %>/createCode"/>
        <a href="#" onclick="javascript:flushCode();">看不清?</a>
    </center>
</body>
</html>