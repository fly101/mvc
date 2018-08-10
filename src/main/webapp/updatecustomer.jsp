<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
    <c:if test="${requestScope.message != null}">
        ${requestScope.message}
    </c:if>

<br>

    <c:set var="id" value="${customer != null ? customer.id : param.id }"></c:set>
    <c:set var="oldName" value="${customer != null ? customer.name : param.oldName }"></c:set>
    <c:set var="name" value="${customer != null ? customer.name : param.oldName }"></c:set>
    <c:set var="address" value="${customer != null ? customer.address : param.address }"></c:set>
    <c:set var="phone" value="${customer != null ? customer.phone : param.phone }"></c:set>


<form action="update.do" method="post">
    <input type="hidden" name="id" value="${id}" >
    <input type="hidden" name="oldName" value="${oldName}" >
    <table style="background-color: aquamarine">
        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="name" value="${name}"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="${address}"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" value="${phone}"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form>
</body>
</html>
