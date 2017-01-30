/**
 * Created by Quentin on 23/01/2017.
 */
var KEY_API = 'j5dOQqQeUHPVHQGdVHRyu4hFrOTfR837';

var html = '';

$(document).ready(function(){
    var urlHome = "home.action";
    $('.navbar-brand').attr("href", urlHome);

    $('#searchForSong').click(function(e)
    {

        var inputUser = $('#inputUser').val();

        researchForSong(inputUser);


        //$('#resultsResearch').html(html)

    });
    $('#addSongToPlaylist').click(function () {
        var idSong = $('#resultsResearch').find('option:selected').attr('id');
        var titleSong = $('#resultsResearch').find('option:selected').val();
        $('#addedSongs').append('<option id='+ idSong + '>' + titleSong + '</option>');
        $('#'+idSong).val(idSong + "&" + titleSong)
    });

    $('#deleteSong').click(function () {

        $('#addedSongs').find('option:selected').each(function () {
            $(this).remove();
        })
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

                var html = '';
                var moodsList = result.moodsList;
                for(var i = 0; i<moodsList.length; i++){
                    html+='<div class="radio"><label for="moods-'+ i +'" class="radio">'+
                        '<input name="moods" id="moods-'+ i +'" value="'+ moodsList[i] +'" class="radio-inline" type="radio">'+ moodsList[i] +'</label></div>';
                    /*html+='<input name="moods" id="radioMoods'+ moodsList[i] +'" value="'+ moodsList[i] +'" class="radio-inline" type="radio">' +
                        '<label for="radioMoods'+ moodsList[i] +'" class="radio-inline">'+ moodsList[i] +'</label>';*/
                }
                //html+= '</p>';
                $("#labelSelectMood").html('<p class="labelForm">Select the associated mood:</p>');
                $("#radioMoods").removeClass().addClass('show').find(" .controls").html(html);
               // $("#radioMoods")
                $("input[name=moods]:radio").change(function(){
                    $("#divBtnValidateFirstPart").html('<button type="button" class="btn btn-primary btn-block" id="btnValidateFirstPart">Validate</button>');
                    $("#btnValidateFirstPart").click(function () {
                        $('#firstPartCreatePlaylist').removeClass().addClass('hidden');
                        $('#secondPartCreatePlaylist').removeClass().addClass('show')
                    })
                });


            },
            error: function(result){
                alert("Error connexion");
            }
        });
    });
    $("#btnValidateSecondPart").click(function () {
        $('#secondPartCreatePlaylist').removeClass().addClass('hidden');
        $('#thirdPartCreatePlaylist').removeClass().addClass('show');
    });



});

