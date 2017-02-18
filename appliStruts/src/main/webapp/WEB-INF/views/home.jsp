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
    <!--<script type="text/javascript" src="/resources/librairies/Widget-JS-API-master/soundcloud.player.api.js"></script>-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/home.js"></script>
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
<br/>
<br/>
<!--<div class="row">
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
</div>-->
<!--<button class="btn btn-primary" id="testbuttton">testbutton</button>-->
<div class="container">

<s:iterator var="category" value="#application.categories" status="i">
<div class="row">
    <a href="#" class="home-category">
    <div class="well well-sm">

            <strong><s:property value="#category"/></strong>

    </div>
    </a>



    <div class="wrapper-home-playlists">
        <a class="left carousel-control" href="#">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <div class="container-playlists" id="<s:property value="#category"/>">
            <ul>
                <s:iterator var="playlist" value="#application.playlists" status="i">
                    <s:if test="%{#category eq #playlist.drug.name}">
                    <li>
                        <div class="thumbnail-playlist">
                            <s:url action="goToPlaylist.action" var="urlTag" escapeAmp="false">
                                <s:param name="idPlaylist"><s:property value="#playlist.idPlaylist"/></s:param>
                                <s:param name="userName"><s:property value="#playlist.userName"/></s:param>
                            </s:url>
                            <a href="<s:property value="#urlTag" />" >
                                <!--<div class="playlist-info">
                                    <div class="playlistDescription"><s:property value="#playlist.description"/></div>
                                    <div class="playlist-info-creator">Created by: <s:property value="#playlist.userName"/></div>
                                </div>-->

                                <img class="group list-group-image" src="resources/images/<s:property value="#playlist.imageName"/>" alt="" />
                            </a>
                        </div>
                    </li>
                    </s:if>
                </s:iterator>
            </ul>
        </div>
        <a class="right carousel-control" href="#">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
        <%--<s:iterator var="playlist" value="#application.playlists" status="i">
            <s:if test="%{#category eq #playlist.drug.name}">

                <div class="item  col-xs-3 col-lg-3">
                    <div class="thumbnail">
                        <s:url action="goToPlaylist.action" var="urlTag" escapeAmp="false">
                            <s:param name="idPlaylist"><s:property value="#playlist.idPlaylist"/></s:param>
                            <s:param name="userName"><s:property value="#playlist.userName"/></s:param>
                        </s:url>
                        <a href="<s:property value="#urlTag" />" >
                            <div class="playlist-info">
                                <div class="playlistDescription"><s:property value="#playlist.description"/></div>
                                <div class="playlist-info-creator">Created by: <s:property value="#playlist.userName"/></div>
                            </div>

                            <img class="group list-group-image" src="resources/images/<s:property value="#playlist.imageName"/>" alt="" />
                        </a>
                    </div>
                </div>
            </s:if>
        </s:iterator>--%>
    </div>

</div>
</s:iterator>
</div>
<!--<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<div class="row">
    <div class="container-fluid" id="containerPlayer">
        <div id="jquery_jplayer_1" class="jp-jplayer"></div>
        <div id="jp_container_1" class="jp-audio" role="application" aria-label="media player">
            <div class="jp-type-playlist">
                <div class="jp-playlist">
                    <ul>
                        <li></li>
                    </ul>
                </div>
                <div class="jp-gui jp-interface">
                    <div class="jp-controls">
                        <button class="jp-previous" role="button" tabindex="0">previous</button>
                        <button class="jp-play" role="button" tabindex="0">play</button>
                        <button class="jp-next" role="button" tabindex="0">next</button>
                        <button class="jp-stop" role="button" tabindex="0">stop</button>
                    </div>
                    <div class="jp-progress">
                        <div class="jp-seek-bar">
                            <div class="jp-play-bar"></div>
                        </div>
                    </div>
                    <div class="jp-volume-controls">
                        <button class="jp-mute" role="button" tabindex="0">mute</button>
                        <button class="jp-volume-max" role="button" tabindex="0">max volume</button>
                        <div class="jp-volume-bar">
                            <div class="jp-volume-bar-value"></div>
                        </div>
                    </div>
                    <div class="jp-time-holder">
                        <div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
                        <div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
                    </div>
                    <div class="jp-toggles">
                        <button class="jp-repeat" role="button" tabindex="0">repeat</button>
                        <button class="jp-shuffle" role="button" tabindex="0">shuffle</button>
                    </div>
                </div>
                <!--playlist initialy placed
                <div class="jp-no-solution">
                    <span>Update Required</span>
                    To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
                </div>
            </div>
        </div>
    </div>
</div>-->
<!--<object height="81" width="100%" id="myPlayer" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000">
    <param name="movie" value="http://player.soundcloud.com/player.swf?url=http%3A%2F%2Fsoundcloud.com%2Fmatas%2Fhobnotropic&enable_api=true&object_id=myPlayer"/>
    <param name="allowscriptaccess" value="always"/>
    <embed allowscriptaccess="always" height="81" src="http://player.soundcloud.com/player.swf?url=http%3A%2F%2Fsoundcloud.com%2Fmatas%2Fhobnotropic&enable_api=true&object_id=myPlayer" type="application/x-shockwave-flash" width="100%" name="myPlayer"></embed>
</object>-->
<!--<div id="target">
    <iframe width="100%" height="280" scrolling="yes" frameborder="no"></iframe>
</div>-->
</body>
</html>
