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
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Douze</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <img src="${pageContext.request.contextPath}/resources/images/bobross.jpeg" style="width: 50px; height: auto">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li>
                    <s:url action="register" var="urlRegister"/>
                    <s:a href="%{urlRegister}"><b>Register</b></s:a>
                </li>
                <li><p class="navbar-text">Already have an account?</p></li>
                <div id="login-logout">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b><span class="caret"></span></a>
                        <ul id="login-dp" class="dropdown-menu">
                            <li>
                                <div class="row" >
                                    <div class="col-md-10 col-md-offset-1">
                                        <s:form cssClass="formLogin" id="formLogin" theme="bootstrap" accept-charset="UTF-8">
                                            <s:textfield
                                                    name="username"
                                                    type="text"
                                                    cssClass="loginFromForm"
                                                    placeholder="Username"
                                                    required="true"/>
                                            <s:textfield
                                                    name="password"
                                                    type="password"
                                                    cssClass="passwordFromForm"
                                                    placeholder="Password"
                                                    required="true"/>
                                            <s:submit cssClass="btn btn-primary pull-right" value="Sign In"/>
                                        </s:form>
                                    </div>
                                </div>
                            </li>
                            <li class="divider" id="dividerLoginForm"></li>
                            <li>
                                <div class="text-right bottom" id="forgotPasswordLink"><a href="#">Forgot your password ?</a></div>
                            </li>
                        </ul>
                    </li>
                </div>
            </ul>
        </div>
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
