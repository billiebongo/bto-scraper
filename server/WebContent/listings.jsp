<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
    <title>Listings</title>
</head>
<body>
<form action="ListingsServlet" method="post">
    <table>
        <tr>
            <th>Select</th>
            <th>Block Number</th>
            <th>Town</th>
            <th>Flat Type</th>
            <th>Location</th>
        </tr>
        <c:if test="${hdbList != null}">
            <c:forEach items="${hdbList}" var="record">
                <tr>
                    <td><input type="checkbox" value="${record.block}" name="hdbval" id="cb-${record.block}"></td>
                    <td>${record.block}</td>
                    <td>${record.town}</td>
                    <td>${record.flat_type}</td>
                    <td>${record.location}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <input type="submit" name="submit_form" id="submit_form" value="Listings">
</form>
</body>
</html>
