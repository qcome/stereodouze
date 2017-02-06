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
</head>
<body>
<s:text name="createPlaylistLabel"/>
</body>
</html>
