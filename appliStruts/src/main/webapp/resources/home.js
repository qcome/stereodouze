/**
 * Created by Quentin on 17/01/2017.
 */
$( window ).load(function() {
    $('#formFindId').submit(function(e)
    {
        e.preventDefault();
        var link = $('#link').val();
        getIdPlaylistAndUpdatePlayer(link);

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
                    var urlCreatePlaylist = "createPlaylist.action";
                    $(".nav li:nth-child(2)").html('<a href=' + urlCreatePlaylist + '><b>Create Playlist</b></a>');
                    //$('#login-logout').html('<li><s:url action="disconnection" var="urlDisconnection"/> <s:a href="%{urlDisconnection}"><b>Disconnect</b></s:a></li>');
                }

            },
            error: function(result){
                alert("Error connexion");
            }
        });
    });


    $('.wrapper-home-playlists').each(function (e) {
        var $container = $(this);
        var $liElements = $container.find('ul').children('li');
        var widthThumbnail = $liElements.outerWidth(true);
        var count = 0;

        if($liElements.length > 3){
            for( var i = 4 ; i < $liElements.length + 1 ; i++){
                $container.find("ul li:nth-child(" + i + ")").css('opacity', 0);
            }
        }
        var flagRight = false;
        $(this).find('.carousel-control.right').click(function () {
            if($liElements.length > 2 && $liElements.length - count > 1 && flagRight == false){
                flagRight = true;
                $container.find("ul li:nth-child(" + (count + 1) + ")").animate({
                    opacity: '0'
                }, 500);
                $container.find("ul li:nth-child(" + (count + 4) + ")").animate({
                    opacity: '1'
                }, 500);
                $container.find('ul').animate({
                    marginLeft: '-=' + widthThumbnail + 'px'
                }, 500);
                count++;
                setTimeout(function(){
                    flagRight = false;
                }, 500);
            }
        });
        var flagLeft = false;
        $(this).find('.carousel-control.left').click(function () {
            if (count > 0 && flagLeft == false) {
                flagLeft = true;
                $container.find("ul li:nth-child(" + count + ")").animate({
                    opacity: '1'
                }, 500);
                $container.find("ul li:nth-child(" + (count + 3) + ")").animate({
                    opacity: '0'
                }, 500);
                $container.find('ul').animate({
                    marginLeft: '+=' + widthThumbnail + 'px'
                }, 500);
                count--;
                setTimeout(function(){
                    flagLeft = false;
                }, 500);
            }
        });
    });


    /*$('.carousel-control.right').click(function () {

            //alert($liElements.length);
            $container.find("ul li:nth-child(" + (count + 1) + ")").animate({
                opacity: '0'
            }, 500);

            $container.find('ul').animate({
                marginLeft: '-=' + widthThumbnail + 'px'
            }, 500);
            count++;
    });
    $('.carousel-control.left').click(function () {
        if (count > 0) {

            $container.find("ul li:nth-child(" + count + ")").animate({
                opacity: '1'
            }, 500);

            $container.find('ul').animate({
                marginLeft: '+=' + widthThumbnail + 'px'
            }, 500);
            count--;
        }
    });*/
    $('.thumbnail').hover(function () {
        $(this).toggleClass('show')
    });
    $('#testbuttton').click(function () {
        $.get( "http://api.soundcloud.com/tracks/?q=lentourloop&client_id=d3bb97412667a7812924715ea66498af", function( data ) {
            alert( "Data Loaded: " + data[0].stream_url );
        });
        /*$.post( "http://api.soundcloud.com/tracks/",
            {
                q: "lentourloop",
                client_id: "d3bb97412667a7812924715ea66498af"
            },
            function(data, status){

            alert( "Data Loaded: " + data[0].stream_url +  "\nStatus: " + status);
        });*/

    });

    //var CLIENT_ID = '?client_id=6dca7c6a3dbbf44a7a30c5a2954f9d03';
    //var SOUNDCLOUD_API = 'http://api.soundcloud.com';







    //resolveSCPlaylist("https://soundcloud.com/samuel-salgado-6/sets/chill-trap-hip-hop");
});

