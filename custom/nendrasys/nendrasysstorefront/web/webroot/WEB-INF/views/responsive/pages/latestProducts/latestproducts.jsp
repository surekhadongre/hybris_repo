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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page pageTitle="${pageTitle}">

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <h1 style="color: green;text-align: center">Welcome to Latest Products Page</h1>

    <cms:pageSlot position="LatestProducts" var="products" >
                <cms:component component="${products}" element="div" class="yComponentWrapper"/>
    </cms:pageSlot>

</template:page>