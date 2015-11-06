$(document).ready(function () {
    $(".sendPost").click(function () {
        var post = $("#post").val();
        $.ajax({
            url: 'posts/send',
            type: 'POST',
            data: {
                post: post
            },
            success: function (response) {
                $("#posts").prepend(response);
            }
        });
    });
});
