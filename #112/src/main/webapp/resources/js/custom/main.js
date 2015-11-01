$(document).ready(function () {
    $("#showU").click(function () {
        $.ajax({
            url: 'home',
            type: 'GET',
            dataType: 'html',
            success: function (response) {
                $("title").text("home");
                $("#showU").parent("li").addClass("active");
                $("#showF").parent("li").removeClass("active");
                $("#content").html(response);
                $.getScript("/resources/js/custom/home.js");
            }
        });
    });

    $("#showOtherU").click(function () {
        $.ajax({
            url: 'users',
            type: 'GET',
            dataType: 'html',
            success: function (response) {
                $("title").text("users");
                $("#showF").parent("li").addClass("active");
                $("#showU").parent("li").removeClass("active");
                $("#content").html(response);
                $.getScript("/resources/js/custom/users.js");
            }
        });
    });
});
