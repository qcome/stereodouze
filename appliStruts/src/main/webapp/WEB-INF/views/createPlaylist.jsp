<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 22/01/2017
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
    <title>Create Playlist</title>
    <sj:head/>
    <sb:head/>
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/librairies/javascript.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/createPlaylist.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/soundcloud.js"></script>

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
<%--<s:text name="createPlaylistLabel"/>--%>
<div class="container" id="containerCreatePlaylist">
    <div class="show">
        <div class="row">
            <p class="titleCreationPlaylist"> Welcome to playlist creation</p>
            <br>
            <p class="titleCreationPlaylist" style="font-size: 18px">Let's choose your playlist properties</p>
            <br>
            <br>
        </div>
        <form id="formPlaylistProperties" accept-charset="UTF-8">
            <div class="row">
                <div class="col-xs-4 col-sm-4">
                    <p class="labelForm">Select your drug:</p>
                </div>
                <div class="col-xs-8 col-sm-8">
                    <s:radio cssClass="radio-inline" name="drugs" list="drugsList" />
                </div>
            </div>
        </form>
    </div>
    <div class="hidden">
        <div class="row">
            <s:form cssClass="formCreatePlaylist" id="formCreatePlaylist" theme="bootstrap" action="createPlaylistAction" accept-charset="UTF-8">
                <div class="col-xs-4 col-sm-4">
                    <form id="formAddedSongs" accept-charset="UTF-8">
                        <s:label cssClass="labelForm" for="addedSongs" value="Added songs:"/>
                        <s:select multiple="true"
                                  list="idSongsList"
                                  value="idSongsList"
                                  id="addedSongs"
                                  cssClass="form-control"
                                  name="idSongsList">
                        </s:select>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </form>
                </div>
                <div class="col-xs-8 col-sm-8">
                    <form id="searchForSong" accept-charset="UTF-8">
                        <div class="form-group">
                            <label class="labelForm" for="inputUser">First step: Search for a song</label>
                            <div class="form-inline">
                                <input type="text" class="form-control" id="inputUser" placeholder="Type the desired song" required>
                                <button type="submit" class="btn btn-primary pull-right">Research</button>
                            </div>
                        </div>
                    </form>
                    <form id="addSongToPlaylist" accept-charset="UTF-8">
                        <div class="form-group">
                            <label class="labelForm" for="resultsResearch">Second step: Add the song you want</label>
                            <div class="form-inline">
                                <select class="form-control" id="resultsResearch"></select>
                                <button type="submit" class="btn btn-primary pull-right">Add</button>
                            </div>
                        </div>
                    </form>
                        <s:label cssClass="labelForm" for="buttonSubmit" value="Last step: Confirm your playlist!"/>
                        <s:submit cssClass="btn btn-primary pull-right" id="buttonSubmit" value="Validate"/>
                </div>
            </s:form>
        </div>
    </div>
</div>
</body>
</html>
