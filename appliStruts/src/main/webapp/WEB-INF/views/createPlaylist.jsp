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
<br/>
<br/>
<%--<s:text name="createPlaylistLabel"/>--%>
<div class="container" id="containerCreatePlaylist">
    <div class="row">
        <div class="col-xs-4 col-sm-4">
            <s:label cssClass="labelForm" for="selectPlayer" value="Added songs:"/>
            <select multiple id="selectPlayer" name="selectPlayer" class="form-control">
               <%-- <s:set var="counter" value="0"/>
                <s:iterator var="player" value="#session.playersOnline" status="k">
                    <s:if test="%{#player.key != #session.login}">
                        <s:set var="counter" value="%{#counter+1}"/>
                        <option id="<s:property value="%{#counter}"/>-playerSelect" value="<s:property value="%{#player.key}"/>"><s:property value="%{#player.key}"/></option>
                    </s:if>
                </s:iterator>--%>
            </select>
        </div>
        <div class="col-xs-8 col-sm-8">
            <form class="form-group" id="searchForSong" accept-charset="UTF-8">

                <div class="form-group">
                    <label class="labelForm" for="inputUser">First step:</label>
                    <div class="form-inline">
                        <input type="text" class="form-control" id="inputUser" placeholder="Type the desired song" required>
                        <button type="submit" class="btn btn-primary pull-right">Research</button>
                    </div>
                </div>
                <div class="form-group">
                    <label class="labelForm" for="resultsResearch">Results</label>
                    <select class="selectpicker" id="resultsResearch">
                        <option></option>
                    </select>
                </div>
            </form>

        </div>

    </div>
</div>
</body>
</html>
