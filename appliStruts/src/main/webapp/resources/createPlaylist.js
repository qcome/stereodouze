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

        var alreadyExists = false;
        var actualSizeSelect = $('#selectAddedSongs').outerWidth();
        $('#selectAddedSongs option').each(function () {
            if ($(this).attr('id') === idSong)
                alreadyExists = true;

        });
        //alert($.fn.textWidth(titleSong, '14px Arial'));

        if(!alreadyExists){
            $('#selectAddedSongs').append('<option id='+ idSong + '>' + titleSong + '</option>');
            $('#'+idSong).val(idSong + "&" + titleSong);
            var lengthAddedSong = $.fn.textWidth(titleSong, '14px Arial');
            //alert('actualSizeSelect: ' + actualSizeSelect + ' | lengthAddedSong: ' + (lengthAddedSong+46));
            if(actualSizeSelect < lengthAddedSong+46)
                $('#selectAddedSongs').css('width', lengthAddedSong+46)
        }

    });
    $.fn.textWidth = function(text, font) {
        if (!$.fn.textWidth.fakeEl)
            $.fn.textWidth.fakeEl = $('<span>').hide().appendTo(document.body);
        $.fn.textWidth.fakeEl.text(text || this.val() || this.text()).css('font', font || this.css('font'));
        return $.fn.textWidth.fakeEl.width();
    };
    $('#deleteSong').click(function () {
        var widthSelect = $('#selectAddedSongs').outerWidth();

        $('#selectAddedSongs').find('option:selected').each(function () {

            $(this).remove();
        });
        var maxWidthRemainingOptions = 0;
        $("#selectAddedSongs option").each(function () {
            if (maxWidthRemainingOptions <  $.fn.textWidth($(this).val(), '14px Arial'))
                maxWidthRemainingOptions = $.fn.textWidth($(this).val(), '14px Arial');
        });
        maxWidthRemainingOptions = maxWidthRemainingOptions-28;
        if(maxWidthRemainingOptions < widthSelect ) {
            if(maxWidthRemainingOptions<260){
                $('#selectAddedSongs').css('width', 260);
            }else{
                $('#selectAddedSongs').css('width', maxWidthRemainingOptions)
            }
        }


    });


    $('#formCreatePlaylist').submit(function () {
        $("#selectAddedSongs option").prop('selected',true);
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
                        $('#secondPartCreatePlaylist').removeClass().addClass('show');
                        $('#selectAddedSongs').wrap("<div class='wrapperSelectMultiple' id='wrapperSelectMultiple' style='overflow-x:scroll; width:260px; overflow: -moz-scrollbars-horizontal; margin-bottom: 10px'>");
                        var parentWrapper = $('#wrapperSelectMultiple').parent();
                        $('#deleteSong').detach().appendTo(parentWrapper);
                        var widthButtonResearch = $('#searchForSong').outerWidth();
                        $('#addSongToPlaylist').css('width', widthButtonResearch);

                        /*$('form input').on('keypress', function(e) {
                            return e.which !== 13;
                        });*/
                        $('form input').on('keypress', function(e) {
                            return e.which !== 13;
                        });

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

