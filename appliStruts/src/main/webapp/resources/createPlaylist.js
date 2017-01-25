/**
 * Created by Quentin on 23/01/2017.
 */
var KEY_API = 'j5dOQqQeUHPVHQGdVHRyu4hFrOTfR837';

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
    $('#addSongToPlaylist').submit(function (e) {
        e.preventDefault();
        var idSong = $(this).find('option:selected').attr('id');
        var titleSong = $(this).find('option:selected').val();
        $('#addedSongs').append('<option value='+ idSong +' id='+ idSong + '>' + titleSong + '</option>')
    });

    $('#formCreatePlaylist').submit(function (e) {
        $("#addedSongs option").prop('selected',true);
    })
});

