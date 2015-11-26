$(document).ready(function () {
    $(".showPage").click(function () {
        var id = $(this).closest('form').find('input').first().val();
        $.ajax({
            url: 'users/showPage',
            type: 'GET',
            data: {
                id: id
            },
            success: function (response) {
                $("#content").html(response);
                $.getScript("/resources/js/custom/user.js");
            }
        });
    });
});
