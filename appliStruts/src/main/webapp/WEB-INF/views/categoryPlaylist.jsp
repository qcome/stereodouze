<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 22/02/2017
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <sj:head/>
    <sb:head/>
    <title><s:property value="category"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/librairies/javascript.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/categoryPlaylist.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/navbar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/soundcloud.js"></script>
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
        <div class="title-category-playlist">
            <s:property value="category"/>
        </div>
    </div>
</div>
<br/>
<br/>
<div class="container">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">All</a></li>
        <s:iterator var="subCategory" value="subCategories" status="i">
            <li><a href="#" class="sub-category-a"><s:property value="#subCategory"/></a></li>
        </s:iterator>
    </ul>
    <div class="wrapper-category-playlist">
        <s:iterator var="playlist" value="#application.playlists" status="i">


            <s:if test="%{#playlist.category.playlistName eq category}">
                <div class="wrapper-playlist">
                    <s:url action="goToPlaylist.action" var="urlTag" escapeAmp="false">
                        <s:param name="idPlaylist"><s:property value="#playlist.idPlaylist"/></s:param>
                        <s:param name="userName"><s:property value="#playlist.userName"/></s:param>
                    </s:url>
                    <a href="<s:property value="#urlTag" />" >
                            <%--<div class="playlist-info">
                                <div class="playlistDescription"><s:property value="#playlist.description"/></div>
                                <div class="playlist-info-creator">Created by: <s:property value="#playlist.userName"/></div>
                            </div>--%>

                        <img class="group list-group-image" src="resources/images/<s:property value="#playlist.imageName"/>" alt="" />
                                <s:property value="#playlist.playlistName"/>
                    </a>

                </div>
            </s:if>
        </s:iterator>

    </div>
</div>




</body>
</html>
