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
    $('#backToFirstPart').click(function () {
        $('#secondPartCreatePlaylist').removeClass().addClass('hidden');
        $('#firstPartCreatePlaylist').removeClass().addClass('show');
    });
    $('#backToSecondPart').click(function () {
        $('#thirdPartCreatePlaylist').removeClass().addClass('hidden');
        $('#secondPartCreatePlaylist').removeClass().addClass('show');
    });
    $('#addSongToPlaylist').click(function () {
        $('#btnValidateSecondPart').disable(false);

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
        var remainsSongsInList = false;
        $("#selectAddedSongs option").each(function () {
            remainsSongsInList = true;
            if (maxWidthRemainingOptions <  $.fn.textWidth($(this).val(), '14px Arial'))
                maxWidthRemainingOptions = $.fn.textWidth($(this).val(), '14px Arial');
        });
        if (!remainsSongsInList)
            $('#btnValidateSecondPart').disable(true);
        maxWidthRemainingOptions = maxWidthRemainingOptions-28;
        if(maxWidthRemainingOptions < widthSelect ) {
            if(maxWidthRemainingOptions<260){
                $('#selectAddedSongs').css('width', 260);
            }else{
                $('#selectAddedSongs').css('width', maxWidthRemainingOptions)
            }
        }


    });
    $.fn.extend({
        disable: function(state) {
            return this.each(function() {
                this.disabled = state;
            });
        }
    });

    $('#formCreatePlaylist').submit(function () {
        $("#selectAddedSongs option").prop('selected',true);
    });

    $("input[name=drugs]:radio").change(function() {
        $('#btnValidateFirstPart').disable(true);
        var drug = $(this).val();
        $.ajax({
            url: "updateMood.action?drugSelected=" + drug,
            type: "POST",
            contentType: "application/json: charset=utf-8",
            dataType: "json",
            success: function (result) {

                var html = '';
                var moodsList = result.moodsList;
                for (var i = 0; i < moodsList.length; i++) {
                    html += '<div class="radio"><label for="moods-' + i + '" class="radio">' +
                        '<input name="moods" id="moods-' + i + '" value="' + moodsList[i] + '" class="radio-inline" type="radio">' + moodsList[i] + '</label></div>';
                    /*html+='<input name="moods" id="radioMoods'+ moodsList[i] +'" value="'+ moodsList[i] +'" class="radio-inline" type="radio">' +
                     '<label for="radioMoods'+ moodsList[i] +'" class="radio-inline">'+ moodsList[i] +'</label>';*/
                }
                //html+= '</p>';
                $("#labelSelectMood").html('<p class="labelForm">Select the associated mood:</p>');
                $("#radioMoods").removeClass().addClass('show').find(" .controls").html(html);
                $("input[name=moods]:radio").change(function(){
                    $('#btnValidateFirstPart').disable(false);
                    $("#divBtnValidateFirstPart").show();

                })
            },
            error: function(result){
                alert("Error connexion");
            }
        });
    });
   // $("#radioMoods")
    $("#btnValidateFirstPart").click(function () {
        $('#firstPartCreatePlaylist').removeClass().addClass('hidden');
        $('#secondPartCreatePlaylist').removeClass().addClass('show');
        if(!$("#wrapperSelectMultiple").length) {
            //object already exists
            $('#selectAddedSongs').wrap("<div class='wrapperSelectMultiple' id='wrapperSelectMultiple' style='overflow-x:scroll; width:260px; overflow: -moz-scrollbars-horizontal; margin-bottom: 10px'>");
        }
        var parentWrapper = $('#wrapperSelectMultiple').parent();
        $('#deleteSong').detach().appendTo(parentWrapper);
        var widthButtonResearch = $('#searchForSong').outerWidth();
        $('#addSongToPlaylist').css('width', widthButtonResearch);

        /*$('form input').on('keypress', function(e) {
         return e.which !== 13;
         });*/
        $('#inputUser').on('keypress', function(e) {
            var key = e.which;
            if(key == 13)  // the enter key code
            {
                $('#searchForSong').click();
                return false;
            }
        });

    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#target').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#imageUpload").change(function(){
        readURL(this);

    });

    $("#btnValidateSecondPart").click(function () {
        $('#secondPartCreatePlaylist').removeClass().addClass('hidden');
        $('#thirdPartCreatePlaylist').removeClass().addClass('show');
        //var cw = $('#image-preview').parent().width();
        //$('#image-preview').css('height',cw+'px').draggable();
        /*$.uploadPreview({
            input_field: "#imageUpload",
            preview_box: "#image-preview",
            label_field: "#image-label"
        });*/

        $("#input").change(function () {
            var img = new Image;
            var canvas = document.getElementById('canvas');
            var file = this.files[0];
            img.src = URL.createObjectURL(file);
            img.onload = function() {
                //ctx.drawImage(img, 20,20);
                var MAX_WIDTH = 200;
                var MAX_HEIGHT = 200;
                var width = img.width;
                var height = img.height;
                /*
                if (width > height) {
                    if (width > MAX_WIDTH) {
                        height *= MAX_WIDTH / width;
                        width = MAX_WIDTH;
                    }
                } else {
                    if (height > MAX_HEIGHT) {
                        width *= MAX_HEIGHT / height;
                        height = MAX_HEIGHT;
                    }
                }*/
                alert('the image is drawn');
                //canvas.width = 200;
                //canvas.height = 200;
                var ctx = canvas.getContext("2d");
                //width then height
                ctx.drawImage(img, 0, 0, 200, 200);

                alert('the image is drawn');
            }

        });
    });


});

