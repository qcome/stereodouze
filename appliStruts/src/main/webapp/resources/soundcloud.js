/**
 * Created by Quentin on 17/01/2017.
 */
var myjPlayerPlaylist;

/*------------EXEMPLES--------------
 *
 * Requete recherche tracks
 * http://api.soundcloud.com/tracks/?q=lentourloop&client_id=6dca7c6a3dbbf44a7a30c5a2954f9d03
 *
 */


$( window ).load('ready',function() {
    SC.initialize({
        client_id: '6dca7c6a3dbbf44a7a30c5a2954f9d03'
    });
    var cssSelector = {
        jPlayer: "#jquery_jplayer_1",
        cssSelectorAncestor: "#jp_container_1"
    };
    var options = {
        playlistOptions: {
            autoPlay: true,
            enableRemoveControls: true
        },
        swfPath: "/js",
        supplied: "mp3",
        wmode: "window",
        useStateClassSkin: true,
        autoBlur: false,
        smoothPlayBar: true,
        keyEnabled: true
    };
    myjPlayerPlaylist = new jPlayerPlaylist(cssSelector,[], options);

    $('#testbuttton').click(function () {

    });
});


function getIdPlaylistAndUpdatePlayer(url) {
    var idPlaylist = null;
    if (!url) {
        alert('you have to fill the playlist URL input');
    }else{
        SC.get('/resolve/?url=' + url, { limit: 1 }, function(result) {
            if (result && result.id) {
                idPlaylist = result.id;
                updtatePlayerPlaylist(idPlaylist);
            } else {
                alert('playlist not found');
            }
        });
    }
}

function updtatePlayerPlaylist(idPlaylist){
    var playlist=[];
    var CLIENT_ID = '?client_id=6dca7c6a3dbbf44a7a30c5a2954f9d03';
    SC.get('/playlists/' + idPlaylist, function(result) {
        for (i = 0; i < result.tracks.length; i++) {
            var titleTrack=result.tracks[i].title;
            var mp3Track=result.tracks[i].stream_url + CLIENT_ID;
            playlist.push({
                title:titleTrack,
                mp3:mp3Track
            });
        }
    });

    setTimeout( function() { myjPlayerPlaylist.setPlaylist(playlist); }, 100);
}
function sleep(miliseconds) {
    var currentTime = new Date().getTime();

    while (currentTime + miliseconds >= new Date().getTime()) {
    }
}


/*function resolveSCPlaylist(url) {
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
 }*/
