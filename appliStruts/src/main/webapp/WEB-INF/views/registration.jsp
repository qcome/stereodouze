<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 18/01/2017
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
    <title>Register</title>
    <sj:head/>
    <sb:head/>
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/librairies/javascript.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/home.js"></script>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation" id="navigationbar">
    <div class="container-fluid">
        <jsp:include page="navbar.jsp"/>
    </div>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<div class="row">
    <div class="container" id="containerRegistration">
        <s:form cssClass="formRegistration" theme="bootstrap" action="registerAction" accept-charset="UTF-8">
            <s:textfield
                    name="username"
                    cssClass="form-control"
                    placeholder="Username"
                    required="true"/>
            <s:password
                    name="password"
                    cssClass="form-control"
                    placeholder="Password"
                    required="true"/>
            <s:password
                    name="passwordConfirmation"
                    cssClass="form-control"
                    placeholder="Password Confirmation"
                    required="true"/>
            <s:submit cssClass="btn btn-primary" value="Validate"/>
        </s:form>
    </div>
</div>
</body>
</html>
