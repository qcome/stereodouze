<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 17/01/2017
  Time: 06:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<html>
<head>
    <title>Mon application web</title>
    <s:head/>
    <sj:head/>
    <sb:head/>
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/librairies/javascript.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/soundcloud.js"></script>
    <!--<script type="text/javascript" src="/resources/librairies/Widget-JS-API-master/soundcloud.player.api.js"></script>-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/home.js"></script>

    <script src="http://connect.soundcloud.com/sdk.js"></script>
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
<div class="row">
    <div class="container" id="containerFindId">
        <form class="form" id="formFindId" role="form" method="post" accept-charset="UTF-8">
            <div class="form-group">
                <label class="sr-only" for="link">Login</label>
                <input type="url" class="form-control" id="link" placeholder="Playlist Link" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary pull-right">Go!</button>
            </div>
        </form>
    </div>
</div>


<!--<object height="81" width="100%" id="myPlayer" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000">
    <param name="movie" value="http://player.soundcloud.com/player.swf?url=http%3A%2F%2Fsoundcloud.com%2Fmatas%2Fhobnotropic&enable_api=true&object_id=myPlayer"/>
    <param name="allowscriptaccess" value="always"/>
    <embed allowscriptaccess="always" height="81" src="http://player.soundcloud.com/player.swf?url=http%3A%2F%2Fsoundcloud.com%2Fmatas%2Fhobnotropic&enable_api=true&object_id=myPlayer" type="application/x-shockwave-flash" width="100%" name="myPlayer"></embed>
</object>-->
<div id="target">
    <iframe width="100%" height="280" scrolling="yes" frameborder="no"></iframe>
</div>
</body>
</html>
