/**
 * Created by Quentin on 01/03/2017.
 */
$( document ).ready(function() {

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