<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/5/2020
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>


    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:choose>
            <c:when test="${not empty latestProducts}">
                <c:forEach items="${latestProducts}" var="product">
                    <product:productListerItem product="${product}"/>
                   <%-- <h3>${product.name}</h3>--%>
                   <%-- <h4>Price:: <product:productListerItemPrice product="${product}"/></h4>--%>
                 <%-- <product:productPrimaryImage product="${product}" format="thumbnail"/><br><br>--%>
                 </c:forEach>
            </c:when>
            <c:otherwise>
                <h3 style="color: red;text-align: center">No Latest Products are Found(CMS)</h3>
            </c:otherwise>
        </c:choose>


