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
    });

    $("input[name=drugs]:radio").change(function(){
        var drug = $(this).val();
        $.ajax({
            url: "updateMood.action?drugSelected=" + drug,
            type: "POST",
            contentType: "application/json: charset=utf-8",
            dataType: "json",
            success: function(result)
            {
                var html = '<p>';
                var moodsList = result.moodsList;
                for(i = 0; i<moodsList.length; i++){
                    html+='<input name="moods" id="radioMoods'+ moodsList[i] +'" value="'+ moodsList[i] +'" class="radio-inline" type="radio">' +
                        '<label for="radioMoods'+ moodsList[i] +'" class="radio-inline">'+ moodsList[i] +'</label>';
                }
                html+= '</p>';
                $("#labelSelectMood").html('<p class="labelForm">Select the associated mood:</p>');
                $("#radioMoods").html(html);
                $("input[name=moods]:radio").change(function(){
                    $("#divBtnValidateFirstPart").html('<button class="btn btn-primary btn-block" id="btnValidateFirstPart">Validate</button>')
                });
            },
            error: function(result){
                alert("Error connexion");
            }
        });
    });
    $("#formPlaylistProperties").submit(function (e) {
        e.preventDefault();
        $('#firstPartCreatePlaylist').removeClass().addClass('hidden');
        $('#secondPartCreatePlaylist').removeClass().addClass('show')
    })

});

