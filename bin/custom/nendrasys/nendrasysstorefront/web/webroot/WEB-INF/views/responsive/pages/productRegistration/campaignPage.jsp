<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/30/2020
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <h1 style="color: red;text-align: center">Welcome to Campaign Page</h1>


    <cms:pageSlot position="CampaignPageBanner" var="banner" limit="1">
        <cms:component component="${banner}" element="div" class="yComponentWrapper"/>
    </cms:pageSlot>

    <cms:pageSlot position="CampaignPageParagraph" var="paragraph" limit="1">
        <cms:component component="${paragraph}" element="div" class="yComponentWrapper"/>
    </cms:pageSlot>



</template:page>