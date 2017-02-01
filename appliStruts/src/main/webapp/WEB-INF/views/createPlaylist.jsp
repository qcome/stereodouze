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
    <s:form cssClass="form-inline" id="formCreatePlaylist" theme="bootstrap" action="createPlaylistAction" accept-charset="UTF-8" enctype="multipart/form-data" method="POST">
        <div class="show" id="firstPartCreatePlaylist">
            <div class="row">
                <p class="titleCreationPlaylist">Welcome to playlist creation</p>
                <br>
                <p class="titleCreationPlaylist" style="font-size: 18px">Let's choose your playlist properties</p>
                <br>
                <br>
            </div>

            <div class="row">
                <div class="col-xs-4 col-sm-4">
                    <p class="labelForm">Select your drug:</p>
                </div>
                <div class="col-xs-8 col-sm-8">
                    <div id="radioDrugs">
                        <s:radio cssClass="radio-inline" name="drugs" id="radioDrugs" list="drugsList"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-4 col-sm-4">
                    <div id="labelSelectMood">

                    </div>
                </div>
                <div class="col-xs-8 col-sm-8">
                    <div id="radioMoods" class="hidden">
                        <s:radio cssClass="radio-inline" name="moods" id="radioMoods" list="moodsList"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-2 col-xs-offset-5 col-sm-2 col-sm-offset-5" id="divBtnValidateFirstPart">

                </div>
            </div>
        </div>

        <div class="hidden" id="secondPartCreatePlaylist">
            <div class="row">
                <p class="titleCreationPlaylist">Playlist creation</p>
                <br/>
                <p class="titleCreationPlaylist" style="font-size: 18px">Just add some songs to your playlist!</p>
                <br/>
                <br/>
            </div>
            <div class="row">
                <div class="col-xs-5 col-sm-5">

                        <s:label cssClass="labelForm" for="addedSongs" value="Added songs:"/>
                    <div class="wrapperSelectMultiple">
                        <s:select multiple="true"
                                  list="idSongsList"
                                  value="idSongsList"
                                  id="addedSongs"
                                  cssClass="form-group"
                                  name="idSongsList">
                        </s:select>
                    </div>
                        <button type="button" id="deleteSong" class="btn btn-primary">Delete</button>
                </div>


                <div class="col-xs-7 col-sm-7">
                        <div class="form-group">
                            <label class="labelForm" for="inputUser">First step: Search for a song</label>
                            <div class="form-inline">
                                <input type="text" class="form-control" id="inputUser" placeholder="Type the desired song" required>
                                <button type="button" id="searchForSong" class="btn btn-primary pull-right">Research</button>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="labelForm" for="resultsResearch">Second step: Add the song you want</label>
                            <div class="form-inline">
                                <select class="form-control" id="resultsResearch"></select>
                                <button type="button" id="addSongToPlaylist" class="btn btn-primary pull-right">Add</button>
                            </div>
                        </div>
                    <div class="form-group">
                        <label class="labelForm" for="btnValidateSecondPart">Last step: Confirm your playlist!</label>
                        <button type="button" class="btn btn-primary pull-right" id="btnValidateSecondPart">Validate</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="hidden" id="thirdPartCreatePlaylist">
            <div class="row">
                <p class="titleCreationPlaylist">Playlist creation</p>
                <br/>
                <p class="titleCreationPlaylist" style="font-size: 18px">Final step: customize it!</p>
                <br/>
                <br/>
            </div>
            <div class="row">
                <s:label for="title" cssClass="labelForm" value="Give it a title"/>
                <s:textfield name="title" id="title" />
            </div>
            <div class="row">
                    <%--<label for="uploadImage" class="labelForm">Upload the playlist image!</label>
                    <s:file cssClass="file-loading" id="uploadImage" name="file"/>--%>
                <div class="form-inline">
                    <s:file name="upload" cssClass="labelForm" label="Add a nice picture" id="imageUpload"/>
                    <s:submit cssClass="btn btn-primary pull-right" id="buttonSubmit" value="Validate"/>
                </div>

            </div>
        </div>
    </s:form>
</div>
</body>
</html>
