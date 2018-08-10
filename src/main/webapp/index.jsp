<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: miao
  Date: 2018/8/6
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.1.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var content = $(this).parent().parent().find("td:eq(1)").text();
                var flag = confirm("确定要删除"+content+"吗？");
                return flag;
            });
        });
        
        
        
    </script>
</head>
<body>

    <form action="query.do" method="post">
        <table>
            <tr>
                <td>CustomerName:</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Query"/></td>
                <td><a href="newcustomer.jsp">Add New Customer</a></td>
            </tr>
        </table>
    </form>


    <br><br>

    <c:if test="${! empty requestScope.customers}">

    <hr>
    <br><br>

    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>CustomerName</th>
            <th>Address</th>
            <th>Phone</th>
            <th>UPDATE\DELETE</th>
        </tr>

        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.phone}</td>
                <td>
                    <a href="edit.do?id=${customer.id}">UPDATE</a>
                    <a href="delete.do?id=${customer.id}" class="delete">DELETE</a>
                </td>
            </tr>
        </c:forEach>

    </table>


    </c:if>
</body>
</html>
