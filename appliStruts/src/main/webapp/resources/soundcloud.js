/**
 * Created by Quentin on 17/01/2017.
 */
var myjPlayerPlaylist;
var KEY_API = 'j5dOQqQeUHPVHQGdVHRyu4hFrOTfR837';


/*------------EXEMPLES--------------
 *
 * Requete recherche tracks
 * http://api.soundcloud.com/tracks/?q=lentourloop&client_id=d3bb97412667a7812924715ea66498af
 *
 */


$(document).ready(function() {
    SC.initialize({
        client_id: KEY_API
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
    //myjPlayerPlaylist = new jPlayerPlaylist(cssSelector,[], options);
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
    SC.get('/playlists/' + idPlaylist, function(result) {
        for (i = 0; i < result.tracks.length; i++) {
            var titleTrack=result.tracks[i].title;
            var mp3Track=result.tracks[i].stream_url + '/?client_id=' + KEY_API;
            playlist.push({
                title:titleTrack,
                mp3:mp3Track
            });
        }
    });

    setTimeout( function() { myjPlayerPlaylist.setPlaylist(playlist); }, 100);

}

/*************************************************
 *              CREATE PLAYLIST                  *
 *************************************************/
var objectNameImageurl={};
var objectMediaUrl={};
var html = '';
function researchForSong(inputUser){
    objectNameImageurl = {};
    html = '';
    SC.get('/tracks/?q=' + inputUser, function(result) {
        for (i = 0; i < result.length; i++) {
            var titleTrack=result[i].title.toUpperCase();
            var idTrack=result[i].id;
            var artworkUrl=result[i].artwork_url;
            html+= '<option id=' + idTrack + '>' + titleTrack + '</option>';
            objectNameImageurl[idTrack] = artworkUrl;
            objectMediaUrl[idTrack] = result[i].stream_url
        }
        $('#resultsResearch').html(html)
    });
}

/*************************************************
 *              PLAY USER PLAYLIST               *
 *************************************************/

function playuserplaylist(idPlaylist){
    var playli=[];
   /* var list = (listTracks);
    for(var i = 0; i <listTracks.length; i++){
        var titleTrack=result.tracks[i].title;
        var mp3Track=result.tracks[i].stream_url + '/?client_id=' + KEY_API;
        playlist.push({
            title:titleTrack,
            mp3:mp3Track
        });
        alert (listTracks[i]);
    }*/
    $.ajax({
        url: "playPlaylist.action?idPlaylist=" + idPlaylist,
        type: "POST",
        contentType: "application/json: charset=utf-8",
        dataType: "json",
        success: function (result) {
            for(var j = 0; j<result.playlist.idSongs.length ; j++){
                SC.get('/tracks/' + result.playlist.idSongs[j], function(res){
                    var titleTrack=res.title;
                    var mp3Track=res.stream_url + '/?client_id=' + KEY_API;
                    playli.push({
                        title:titleTrack,
                        mp3:mp3Track
                    });
                });
            }
            setTimeout( function() { myjPlayerPlaylist.setPlaylist(playli); }, 200);
        }
    });
}

/*************************************************
 *                LISTEN PLAYLIST                *
 *************************************************/

var arraySongs;
var lengthPlaylist;
function setSongArray(idSongs) {
    arraySongs = idSongs;
    lengthPlaylist = arraySongs.length;
}
function playFirstSong(media){
    $('#jquery_jplayer').jPlayer({
        ready: function () {
            $(this).jPlayer("setMedia", {
                mp3: media + '/?client_id=' + KEY_API
            }).jPlayer("play")
        },
        ended: function () {
            if(posSong+1 < lengthPlaylist){
                posSong++;
                updatePlayerUserPlaylist(posSong)
            }
        },
        cssSelectorAncestor: "#jp_container_1",
        swfPath: "/js",
        supplied: "mp3",
        useStateClassSkin: true,
        autoBlur: false,
        smoothPlayBar: true,
        keyEnabled: true,
        remainingDuration: true,
        toggleDuration: false
    });
}
var firstTime = true;
var posSong = 0;
function updatePlayerUserPlaylist(posSong){
    SC.get('/tracks/' + arraySongs[posSong], function(res){
        //$('#jquery_jplayer_1').jPlayer("setMedia", {mp3 : media}).play();
        //var splitedTitle = res.title.split(" - ");
        $('#artistSpanTitle').html(res.user.username.toUpperCase());
        $('#titleSong').html(res.title.toUpperCase());
        $('#imageSong').attr("src", res.artwork_url);
        if(posSong == 0 && firstTime) {
            playFirstSong(res.stream_url);
            firstTime = false;
        }
        else
            playSong(res.stream_url)
    });
}
function playSong(media){
    $('#jquery_jplayer').jPlayer("setMedia", {
                mp3: media + '/?client_id=' + KEY_API
            }).jPlayer("play")
}

$(document).ready(function() {
    $('.jp-next').click(function () {
      if(posSong+1 < lengthPlaylist){
          posSong++;
          updatePlayerUserPlaylist(posSong)
      }
    });
    $('.jp-previous').click(function () {
        if(posSong-1 >= 0){
            posSong--;
            updatePlayerUserPlaylist(posSong)
        }
    })
});



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
