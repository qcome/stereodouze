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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/librairies/javascript.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/soundcloud.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/navbar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jplayer.swf"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jplayer.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jplayer.playlist.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/skin/blue.monday/css/jplayer.blue.monday.css" rel="stylesheet" type="text/css">

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
<div class="container home-container">
<s:iterator var="category" value="#application.categories" status="i">
<div class="row">
    <s:url var="goToCategoryPlaylist" action="categoryPlaylist.action" namespace="/">
        <s:param name="category"><s:property value="#category"/></s:param>
    </s:url>
    <s:a cssClass="home-category" href="%{goToCategoryPlaylist}">
        <div class="well well-sm">
            <strong><s:property value="#category"/></strong>
        </div>
    </s:a>
    <div class="wrapper-home-playlists">
        <a class="left carousel-control" href="#">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <div class="container-playlists" id="<s:property value="#category"/>">
            <div class="wrapper-ul">
                <ul>
                    <s:iterator var="playlist" value="#application.playlists" status="i">
                        <s:if test="%{#category eq #playlist.category.name}">
                            <li>
                                <div class="thumbnail-playlist">
                                    <s:url action="goToPlaylist.action" var="urlTag" escapeAmp="false">
                                        <s:param name="idPlaylist"><s:property value="#playlist.idPlaylist"/></s:param>
                                        <s:param name="userName"><s:property value="#playlist.userName"/></s:param>
                                    </s:url>
                                    <a href="<s:property value="#urlTag" />" >
                                        <div class="playlist-info" hidden>
                                            <div class="playlistDescription"><s:property value="#playlist.description"/></div>
                                            <div class="playlist-info-creator">Created by: <s:property value="#playlist.userName"/></div>
                                        </div>
                                        <img class="group list-group-image" src="resources/images/<s:property value="#playlist.imageName"/>" alt="" />


                                    </a>
                                </div>
                                <a href="<s:property value="#urlTag" />" >
                                    <div class="name-playlist-home"><s:property value="#playlist.playlistName"/></div>
                                </a>
                            </li>
                        </s:if>
                    </s:iterator>
                </ul>
            </div>
        </div>
        <a class="right carousel-control" href="#">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>

</div>
</s:iterator>
</div>
</body>
</html>
