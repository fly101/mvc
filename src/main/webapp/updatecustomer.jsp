<%@ page import="fun.westory.mvc.pojo.Customer" %><%--
  Created by IntelliJ IDEA.
  User: miao
  Date: 2018/8/7
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object msg = request.getAttribute("message");
    if(msg != null){
%>
<br>
<font color="red"><%= msg %></font>
<br>
<br>
<%
    }

    String id = null;
    String oldName = null;
    String name = null;
    String address = null;
    String phone = null;

    Customer customer = (Customer)request.getAttribute("customer");
    if(customer != null){
        id = customer.getId() + "";
        oldName = customer.getName();
        name = customer.getName();
        address = customer.getAddress();
        phone = customer.getPhone();
    }else{
        id = request.getParameter("id");
        oldName = request.getParameter("oldName");
        name = request.getParameter("oldName");

        address = request.getParameter("address");
        phone = request.getParameter("phone");
    }
%>

<form action="update.do" method="post">
    <input type="hidden" name="id" value="<%=id%>" >
    <input type="hidden" name="oldName" value="<%=oldName%>" >
    <table style="background-color: aquamarine">
        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="name" value="<%= name %>"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="<%= address %>"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" value="<%= phone%>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form>
</body>
</html>
