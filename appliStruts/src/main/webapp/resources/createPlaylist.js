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
    });

    $('#backToFirstPart').click(function () {
        $('#secondPartCreatePlaylist').removeClass().addClass('hidden');
        $('#firstPartCreatePlaylist').removeClass().addClass('show');
    });
    $('#backToSecondPart').click(function () {
        $('#thirdPartCreatePlaylist').removeClass().addClass('hidden');
        $('#secondPartCreatePlaylist').removeClass().addClass('show');
    });





    var widthMaxSelect = 0;

    //add song
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

        //ajout dans le select
        var widthWrapperSelect = $('#wrapperSelectMultiple').outerWidth();
        if(!alreadyExists){
            $('#selectAddedSongs').append('<option id='+ idSong + '>' + titleSong + '</option>');
            $('#'+idSong).val(idSong);
            var lengthAddedSong = $.fn.textWidth(titleSong, '14px Arial')+35;
            var ratio = (lengthAddedSong)/widthWrapperSelect;
            //alert((lengthAddedSong+30)/actualSizeSelect);
            //alert(ratio*100);
            if(actualSizeSelect < lengthAddedSong) {
                $('#selectAddedSongs').css('width', lengthAddedSong);
            }
            widthMaxSelect = lengthAddedSong;
        }
    });

    //delete song
    $('#deleteSong').click(function () {
        var widthWrapperSelect = $('#wrapperSelectMultiple').outerWidth();
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
        widthMaxSelect = maxWidthRemainingOptions-30;
        if (!remainsSongsInList)
            $('#btnValidateSecondPart').disable(true);
        maxWidthRemainingOptions = maxWidthRemainingOptions-28;
        if(maxWidthRemainingOptions < widthSelect ) {
            if(maxWidthRemainingOptions<widthWrapperSelect){
                $('#selectAddedSongs').css('width', widthWrapperSelect);
            }else{
                $('#selectAddedSongs').css('width', maxWidthRemainingOptions)
            }
        }
    });

    /*function setSelectWidth(){
        var remaingSongsInList = false;
        var widthSelect = $('#selectAddedSongs').outerWidth();
        var maxWidthRemainingOptions = 0;
        $("#selectAddedSongs option").each(function () {
            remaingSongsInList = true;
            if (maxWidthRemainingOptions <  $.fn.textWidth($(this).val(), '14px Arial'))
                maxWidthRemainingOptions = $.fn.textWidth($(this).val(), '14px Arial');
        });
        if (maxWidthRemainingOptions < widthSelect){
            $('#selectAddedSongs').css('width', 100 + '%')
        }else{
            var ratio = (maxWidthRemainingOptions+30)/widthSelect;
            $('#selectAddedSongs').css('width', (ratio*100) + '%')
        }

        console.log($('#selectAddedSongs').width());
    }*/


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
            //$('#selectAddedSongs').wrap("");
        }
        var myCirclePlayer = new CirclePlayer("#jquery_jplayer_1",{}, {cssSelectorAncestor: "#cp_container_1", supplied: "mp3", swfPath: "js", wmode: "window"});
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
        //up and down
        $('#chevronUp').click(function () {
            var $selected = $('#selectAddedSongs option:selected');
            $selected.first().prev().before($selected)
        });
        $('#chevronDown').click(function () {
            var $selected = $('#selectAddedSongs option:selected');
            $selected.first().next().after($selected)
        });
        $(document).mousemove(function (e) {
            mouseX = e.pageX;
            mouseY = e.pageY;
        });

        $('#resultsResearch').on('mouseenter', 'option', function (e) {
            //console.log(objectNameImageurl[this.id]);
            //var $image = '<img src=' + objectNameImageurl[this.id] + '>';
            //$("#divImageSong").html($image).show().css({ 'top': mouseY, 'left': mouseX }).fadeIn('slow');
        }).change(function () {
            var idSong = $(this).children(":selected").attr('id');
            $("#cp_container_1").css("background", 'url("' + objectNameImageurl[idSong] + '") 0 0 no-repeat');
            //myCirclePlayer.setMedia({m4a: "http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a"});
            /*var myCirclePlayer = new CirclePlayer("#jquery_jplayer_1",
                {
                    m4a: "http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a",
                    oga: "http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"
                }, {
                    cssSelectorAncestor: "#cp_container_1"
                });*/
            console.log(objectMediaUrl[idSong] + '/?client_id=' + KEY_API);
            myCirclePlayer.setMedia({
                mp3: objectMediaUrl[idSong] + '/?client_id=' + KEY_API
            })
        });


        //add resize event to selectmultiple
        //var sizeSelect;
       // $(window).resize(setSelectWidth ());




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
    $.fn.textWidth = function(text, font) {
        if (!$.fn.textWidth.fakeEl)
            $.fn.textWidth.fakeEl = $('<span>').hide().appendTo(document.body);
        $.fn.textWidth.fakeEl.text(text || this.val() || this.text()).css('font', font || this.css('font'));
        return $.fn.textWidth.fakeEl.width();
    };
    $.fn.extend({
        disable: function(state) {
            return this.each(function() {
                this.disabled = state;
            });
        }
    });
    $("#btnValidateSecondPart").click(function () {
        $('#secondPartCreatePlaylist').removeClass().addClass('hidden');
        $('#thirdPartCreatePlaylist').removeClass().addClass('show');
        $("#input").change(function () {
            readFile(this);
        });
        var $uploadCrop;
        function readFile(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $uploadCrop.croppie('bind', {
                        url: e.target.result
                    }).then(function(){
                        console.log('jQuery bind complete');
                    });

                };

                reader.readAsDataURL(input.files[0]);
            }
            else {
                alert("Sorry - you're browser doesn't support the FileReader API");
            }
        }
        $uploadCrop = $('#wrapperCropper').croppie({
            viewport: {
                width: 200,
                height: 200
            },
            enableExif: true
        }).bind('update', function (ev) {
            console.log('update', ev);
            console.log('result', {
                type: 'base64'
            });
            $('#cssCroppedImage').val(encodeURIComponent(JSON.stringify($uploadCrop.croppie('get'))));
            console.log($(this).croppie('get'));
            console.log($(this).croppie('get').points);
            console.log($(this).croppie('get').zoom);

        });
    });


});

