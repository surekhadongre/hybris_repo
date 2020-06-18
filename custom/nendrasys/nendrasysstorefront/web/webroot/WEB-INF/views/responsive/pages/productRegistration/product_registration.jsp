<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/10/2020
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">


 <h1 style="color: red;text-align: center">Welcome to ProductRegistration Page</h1>

 <form:form action="${pageContext.servletContext.contextPath}/registerProduct" method="post" modelAttribute="productRegisterForm">
  <table border="2" align="center">
  <%--Product id::<form:input path="productId" /><form:errors path="productId" /><br><br>
  Quantity Needed::<form:input path="quantityNeeded" /><form:errors path="quantityNeeded" /><br><br>
  Company Name::<form:input path="companyName" /><form:errors path="companyName" /><br><br>
  <input type="submit" value="Register" />--%>
  <formElement:formInputBox idKey="product.registration.productId"
                                    labelKey="product.registration.productId" path="productId" inputCSS="form-control"
                                    mandatory="true" />
  <formElement:formInputBox idKey="product.registration.quantityNeeded"
                                    labelKey="product.registration.quantityNeeded" path="quantityNeeded" inputCSS="form-control"
                                    mandatory="true" />
  <formElement:formInputBox idKey="product.registration.companyName"
                                    labelKey="product.registration.companyName" path="companyName" inputCSS="form-control"
                                    mandatory="true" />
  <input type="submit" value="Register" align="center" />
 </form:form>

 <style>
  span{color: red}
 </style>

</template:page>
