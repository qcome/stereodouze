/**
 * Created by Quentin on 17/01/2017.
 */
$(document).on('ready',function() {
    SC.initialize({
        client_id: '6dca7c6a3dbbf44a7a30c5a2954f9d03'
    });
    var streamurlsong1;
    SC.get('/playlists/292573926', function(result) {
        streamurlsong1 = result.tracks[0].stream_url;
        alert(streamurlsong1);
    });

    var CLIENT_ID = '?client_id=6dca7c6a3dbbf44a7a30c5a2954f9d03';

    $('#testbuttton').click(function () {
        $("#jquery_jplayer_1").jPlayer({
            ready: function () {
               /* $(this).jPlayer("setMedia", {
                    mp3: streamurlsong1 + CLIENT_ID,
                    oga: "sounds/loop7.ogg"
                });*/
                $(this).jPlayer("setMedia", {
                    mp3: streamurlsong1 + CLIENT_ID
                    //oga: "http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"
                });
            },


            cssSelectorAncestor: "#jp_container_1",
            swfPath: "/js",
            supplied: "mp3",
            useStateClassSkin: true,
            autoBlur: false,
            smoothPlayBar: true,
            keyEnabled: true,
            remainingDuration: true,
            toggleDuration: true
        });
    });
});


function resolveSCPlaylist(url) {
    if (!url) {
        alert('you have to fill the playlist URL input');
        return false;
    }
    SC.get('/resolve/?url=' + url, { limit: 1 }, function(result) {
        alert(result.id);
        if (result && result.id) {
            var link = "https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/playlists/" + result.id + "&amp;color=7c7c7c&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false";
            $('#target').find("iframe").attr({'src':link});
        } else {
            alert('playlist not found');
        }
    });
}
