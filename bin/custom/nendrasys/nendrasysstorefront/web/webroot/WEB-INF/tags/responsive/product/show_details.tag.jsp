<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/20/2019
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<h1 style="color: red;text-align: center">Manufacturing Details By Product Code</h1><br><br>

<table>
    <thead>
        <tr>
            <td>Company</td>
            <td>COUNTRY</td>
            <td>Years in Market</td>
            <td>Ratings</td>
        </tr>
        <tr>
            <td><c:out value="${manufacturingDetails.company}" /></td>
            <td><c:out value="${manufacturingDetails.country}" /></td>
            <td><c:out value="${manufacturingDetails.yearsInMarket}" /></td>
            <td><c:out value="${manufacturingDetails.rating}" /></td>
        </tr>
    </thead>


</table>