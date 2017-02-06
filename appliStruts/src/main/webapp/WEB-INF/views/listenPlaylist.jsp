<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 06/02/2017
  Time: 00:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
    <sj:head/>
    <sb:head/>
    <title><s:property value="playlist.name"/></title>

    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/librairies/javascript.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/listenPlaylist.js"></script>
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
<br/>
<br/>
<div class="container" id="containerListenPlaylist">
</div>
<div class="row">
    <div id="wrapperContainerPlayer">
        <div class="container-fluid" id="containerPlayer">
            <div id="jquery_jplayer_1" class="jp-jplayer"></div>
            <div id="jp_container_1" class="jp-audio" role="application" aria-label="media player">
                <div class="jp-type-single">
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
                    <!--playlist initialy placed -->
                    <div class="jp-no-solution">
                        <span>Update Required</span>
                        To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
