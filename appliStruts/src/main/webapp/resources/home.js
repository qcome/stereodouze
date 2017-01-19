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
                $('.dropdown.open .dropdown-toggle').dropdown('toggle');
            },
            error: function () {

            }
        });
    });
    //resolveSCPlaylist("https://soundcloud.com/samuel-salgado-6/sets/chill-trap-hip-hop");
});

