/**
 * Created by Quentin on 17/01/2017.
 */
$(document).ready(function() {
    $('#formFindId').submit(function(e)
    {

        e.preventDefault();
        var link = $('#link').val();
        resolveSCPlaylist(link);
    });
    $('#formLogin').submit(function(e)
    {
        e.preventDefault();

        var data = $(this).serialize();

        $.ajax({
            url: "userLogin.action?" + data,
            type: "POST",
            contentType: "application/json: charset=utf-8",
            dataType: "json",
            success: function(result)
            {
                if(result.validConnection){
                    $('.dropdown.open .dropdown-toggle').dropdown('toggle');
                    $(".nav li.dropdown").remove();
                    var urlDisconnection = "disconnection.action";
                    $(".nav").append('<li><a href=' + urlDisconnection + '><b>Logout</b></a></li>');
                    //$('#login-logout').html('<li><s:url action="disconnection" var="urlDisconnection"/> <s:a href="%{urlDisconnection}"><b>Disconnect</b></s:a></li>');
                }

            },
            error: function(result){
                alert("Erreur connexion");
            }
        });
    });

    //var CLIENT_ID = '?client_id=6dca7c6a3dbbf44a7a30c5a2954f9d03';
    //var SOUNDCLOUD_API = 'http://api.soundcloud.com';







    //resolveSCPlaylist("https://soundcloud.com/samuel-salgado-6/sets/chill-trap-hip-hop");
});

