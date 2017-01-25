/**
 * Created by Quentin on 23/01/2017.
 */
var KEY_API = 'd3bb97412667a7812924715ea66498af';
var tabResults=[];
var html = '';

$(document).ready(function(){
    var urlHome = "home.action";
    $('.navbar-brand').attr("href", urlHome);

    $('#searchForSong').submit(function(e)
    {
        e.preventDefault();
        var inputUser = $('#inputUser').val();

        researchForSong(inputUser);


        //$('#resultsResearch').html(html)

    });
});

function researchForSong(inputUser){
    html = '';
    $.get( "http://api.soundcloud.com/tracks/?q=" + inputUser + "&client_id=" + KEY_API, function( result ) {
        for (i = 0; i < result.length; i++) {
            var titleTrack=result[i].title;
            var idTrack=result[i].id;
            html+= '<option>' + titleTrack + '</option>';
        }
        $('#resultsResearch').html(html)
    });
}