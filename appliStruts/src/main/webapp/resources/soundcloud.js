/**
 * Created by Quentin on 17/01/2017.
 */
$(document).on('ready',function() {
    SC.initialize({
        client_id: '6dca7c6a3dbbf44a7a30c5a2954f9d03'
    });
});

function resolveSCPlaylist(url) {
    if (!url) {
        alert('you have to fill the playlist URL input');
        return false;
    }
    SC.get('/resolve/?url=' + url, { limit: 1 }, function(result) {
        if (result && result.id) {
            var link = "https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/playlists/" + result.id + "&amp;color=7c7c7c&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false";
            $('#target').find("iframe").attr({'src':link});
        } else {
            alert('playlist not found');
        }
    });
}


