<%@ page import="java.util.Enumeration" %>
<%@ page import="kr.co.nandsoft.example.service.Calculator" %>
<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2021-08-03
  Time: 오전 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <title>계산기</title>
    <meta charset="UTF-8">
      <%
//          Enumeration<String> paramName = request.getParameterNames();
//          out.println(paramName.hasMoreElements());
//          while(paramName.hasMoreElements()) {
//              out.println(paramName.nextElement());
//          }
//          String button = (String)request.getParameter("button");
      %>
  </head>
  <div>
    <form name="main_form" style="text-align: center;">
      <input type="text" name="temp" readonly style="text-align: right;" value="<%out.println(request.getAttribute("temp"));%>">
      <%--<iframe src="index.jsp" name="iframe" style="width:1px; height:1px; border:0; visibility:hidden;"></iframe>--%>
      <div>
        <input button type="submit" value="del" name ="button" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit" value="c" name ="button" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit" value="/" name ="button" readonly formaction="/" formmethod="post" name="button">
      </div>
      <div>
        <input button type="submit"  value="1" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="2" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="3" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="*" readonly formaction="/" formmethod="post" name="button">
      </div>
      <div>
        <input button type="submit" value="4" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit" value="5" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="6" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="+" readonly formaction="/" formmethod="post" name="button">
      </div>
      <div>
        <input button type="submit"  value="7" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="8" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="9" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="-" readonly formaction="/" formmethod="post" name="button">
      </div>
      <div>
        <input button type="submit"  value="0" readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="." readonly formaction="/" formmethod="post" name="button">
        <input button type="submit"  value="=" readonly formaction="/" formmethod="post" name="button">
      </div>
      <input type = "text" name="buffer" value="${calcified}">
    </form>
  </div>
</body>
</html>