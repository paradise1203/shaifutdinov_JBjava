$(document).ready(function () {
    $(".sendPost").click(function () {
        var id = $(this).closest('form').find('input').first().val();
        var post = $("#post").val();
        $.ajax({
            url: 'posts/send',
            type: 'POST',
            data: {
                post: post,
                id: id
            },
            success: function (response) {
                $("#posts").prepend(response);
            }
        });
    });
});