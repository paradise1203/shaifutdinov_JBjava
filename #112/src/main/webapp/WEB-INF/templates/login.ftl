<html>

<head>
    <title> Login </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/css/lib/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h3> Welcome to login page! </h3>

    <form role="form" method="post" action="/login/process">
        <div class="form-group">
            <label for="login">Login: </label>
            <input id="login" name="login" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Password: </label>
            <input id="password" name="password" class="form-control" type="password">
        <#if error??> Invalid login or password! </#if>
        </div>
        <input type="submit" class="btn btn-primary" value="Login">
    </form>
</div>
<script type="text/javascript" src="/resources/js/lib/jquery-2.1.4.js"></script>
<script type="text/javascript" src="/resources/js/lib/bootstrap.min.js"></script>
</body>

</html>