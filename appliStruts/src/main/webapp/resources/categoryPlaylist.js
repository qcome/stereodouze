/**
 * Created by Quentin on 23/02/2017.
 */
$(document).ready(function() {
    $('.nav-tabs > li > a').bind('click', function (e) {
        $('.active').removeClass('active');
        $(this).parent().addClass('active');
    })
});