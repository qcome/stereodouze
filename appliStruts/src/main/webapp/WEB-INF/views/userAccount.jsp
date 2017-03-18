<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%--
<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 01/03/2017
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <sj:head/>
    <sb:head/>
    <title>My Account</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/croppie.css" rel="stylesheet" type="text/css" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/librairies/javascript.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/userAccount.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/navbar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/croppie.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
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
<div class="container">
    <div class="row row-centered">
        <p class="titleCreationPlaylist">My account</p>
        <br/>
    </div>
    <div class="row">
        <!--image part -->
        <div class="col-xs-12 col-sm-4 col-sm-offset-1">
            <div id="image-preview">
                <input type="file" name="upload" id="input" hidden required="required"/>
                <input type="hidden" id="cssCroppedImage" name="cssCroppedImage" value="">
                <div class="croppie-container" id="wrapperCropper">
                </div>
                <!--<canvas id="canvas" height="200" width="200"></canvas>-->
                <label class="labelForm" id="image-label" for="input">Choose image</label>
            </div>
        </div>
        <div class="col-xs-12 col-sm-2"><br/></div>
        <div class="col-xs-12 col-sm-4">
            <div class="form-group">
                <label for="inputTitle"  class="labelForm">Give it a title</label>
                <input type="text" id="inputTitle" name="title" class="form-control" required>
            </div>
            <div class="form-group">
                <label class="labelForm" for="description">Description</label>
                <textarea class="form-control" name="description" rows="5" id="description" required></textarea>
            </div>
        </div>
    </div>
</div>

</body>
</html>
