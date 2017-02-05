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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.uploadPreview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/myUploadPreview.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
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
                <div class="col-xs-2 col-xs-offset-5 col-sm-2 col-sm-offset-5" id="divBtnValidateFirstPart" hidden>
                    <button type="button" class="btn btn-primary btn-block" id="btnValidateFirstPart">Validate</button>
                </div>
            </div>
        </div>

        <div class="hidden" id="secondPartCreatePlaylist">
            <div class="row">
                <div class="col-xs-1 col-sm-1">
                    <a href="#" id="backToFirstPart"><span class="glyphicon glyphicon-chevron-left"></span></a>
                </div>
                <div class="col-xs-10 col-sm-10">
                    <p class="titleCreationPlaylist">Playlist creation</p>
                    <br/>
                    <p class="titleCreationPlaylist" style="font-size: 18px">Just add some songs to your playlist!</p>
                </div>
            </div>
            <br/>
            <br/>
            <div class="row">
                <div class="col-xs-5 col-xs-offset-2 col-sm-4 col-sm-offset-0">
                    <div style="padding-left: 20px">
                        <a href="#" id="chevronUp"><span class="glyphicon glyphicon-chevron-up"></span></a>
                        <a href="#" id="chevronDown"><span class="glyphicon glyphicon-chevron-down"></span></a>
                        <label class="labelForm" for="selectAddedSongs">Added songs:</label>
                        <div class='wrapperSelectMultiple' id='wrapperSelectMultiple' style='overflow-x:scroll; width:100%; overflow: -moz-scrollbars-horizontal; margin-bottom: 10px'>
                            <select multiple="multiple" id="selectAddedSongs" name="idSongsList"></select>
                           <%-- <s:select multiple="true"
                                      list="idSongsList"
                                      value="idSongsList"
                                      id="selectAddedSongs"
                                      cssClass="form-group"
                                      name="idSongsList">
                            </s:select>--%>
                            <button type="button" id="deleteSong" class="btn btn-primary">Delete</button>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-1"><br/></div>
                <div class="col-xs-12 col-sm-7 col-sm-offset-0">
                        <label class="labelForm" for="inputUser">First step: Search for a song</label>
                        <div class="form-inline">
                            <input type="text" class="form-control" id="inputUser" placeholder="Type the desired song" required>
                            <button type="button" id="searchForSong" class="btn btn-primary">Research</button>
                        </div>
                    <br/>
                        <label class="labelForm" for="resultsResearch">Second step: Add the song you want</label>
                        <div class="form-inline">
                            <select class="form-control" id="resultsResearch"></select>
                            <button type="button" id="addSongToPlaylist" class="btn btn-primary">Add</button>
                        </div>
                    <br/>
                    <div class="form-group">
                        <label class="labelForm">Last step: Confirm your playlist!</label>
                        <!--<p class="labelForm" id="pLastStep">Last step: Confirm your playlist!</p>-->

                    </div>
                    <div class="row">
                        <button type="button" class="btn btn-primary" id="btnValidateSecondPart" disabled>Validate</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="hidden" id="thirdPartCreatePlaylist">
            <div class="row">
                <div class="col-xs-1 col-sm-1">
                    <a href="#" id="backToSecondPart"><span class="glyphicon glyphicon-chevron-left"></span></a>
                </div>
                <div class="col-xs-10 col-sm-10">
                    <p class="titleCreationPlaylist">Playlist creation</p>
                    <br/>
                    <p class="titleCreationPlaylist" style="font-size: 18px">Final step: personalize it!</p>
                </div>
            </div>
            <br/>
            <br/>
            <div class="row">
                <!--image part -->
                <div class="col-xs-4 col-xs-offset-2 col-sm-4 col-sm-offset-2">
                    <div id="image-preview">
                        <input type="file" name="upload" id="input" hidden/>
                        <canvas id="canvas" height="200" width="200"></canvas>
                        <label class="labelForm" id="image-label" for="input">Choose image</label>
                    </div>
                </div>
                <div class="col-xs-4 col-sm-4">
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
            <br/>
            <br/>
            <div class="row" id="wrapperSubmitButton">
                <s:submit cssClass="btn btn-primary" id="buttonSubmit" value="Validate"/>
            </div>
        </div>
    </s:form>
</div>
</body>
</html>
