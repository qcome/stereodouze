/**
 * Created by Quentin on 01/03/2017.
 */
$( document ).ready(function() {
    $('#formLogin').submit(function (e) {
        e.preventDefault();
        var data = $(this).serialize();

        $.ajax({
            url: "userLogin.action?" + data,
            type: "POST",
            contentType: "application/json: charset=utf-8",
            dataType: "json",
            success: function (result) {
                if (result.validConnection) {

                    var urlUserAccount = "userAccount.action";
                    $('.navbar-right').prepend('<li><a href=' + urlUserAccount + '><b>My Account</b></a></li>');
                    $('.dropdown.open .dropdown-toggle').dropdown('toggle');
                    $(".nav li.dropdown").remove();
                    var urlDisconnection = "disconnection.action";
                    $(".nav").append('<li><a href=' + urlDisconnection + '><b>Logout</b></a></li>');
                    var urlCreatePlaylist = "createPlaylist.action";
                    $(".nav li:nth-child(2)").html('<a href=' + urlCreatePlaylist + '><b>Create Playlist</b></a>');
                    //$('#login-logout').html('<li><s:url action="disconnection" var="urlDisconnection"/> <s:a href="%{urlDisconnection}"><b>Disconnect</b></s:a></li>');
                }

            },
            error: function (result) {
                alert("Error connexion");
            }
        });
    });

    $('#btnLogin').click(function () {
        $('#myModal').css('display', 'block');
    });

    $('.close').click(function () {
        $('#myModal').css('display', 'none');
    });

    var modal = document.getElementById('myModal');
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };

});
