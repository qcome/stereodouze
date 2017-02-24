<%@ taglib prefix="s" uri="/struts-tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 20/01/2017
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <s:url action="home" var="home"/>
    <s:a href="%{home}"><b>Douze</b></s:a>
</div>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav navbar-right">
        <li role="separator" class="divider"></li>
        <li>
            <s:if test="%{#session.idUser == null}">
                <s:url action="register" var="urlRegister"/>
                <s:a href="%{urlRegister}"><b>Register</b></s:a>
            </s:if>
            <s:else>
                <s:url action="createPlaylist" var="urlCreatePlaylist"/>
                <s:a href="%{urlCreatePlaylist}"><b>Create Playlist</b></s:a>
            </s:else>
        </li>
        <s:if test="%{#session.idUser == null}">
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
        </s:if>
        <s:else>
            <li>
                <s:a href="disconnection.action"><b>Logout</b></s:a>
            </li>
        </s:else>

    </ul>
</div>
