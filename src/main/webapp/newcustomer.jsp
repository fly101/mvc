<%--
  Created by IntelliJ IDEA.
  User: miao
  Date: 2018/8/7
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        Object message = request.getAttribute("message");
        if (message != null) {
    %>
    <span><%=message%></span>
    <%
        }
    %>

    <form action="add.do" method="post">
        <table style="background-color: aquamarine">
            <tr>
                <td>CustomerName:</td>
                <td><input type="text" name="name" value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" value="<%= request.getParameter("address") == null ? "" : request.getParameter("address") %>"/></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone" value="<%= request.getParameter("phone") == null ? "" : request.getParameter("phone") %>"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
