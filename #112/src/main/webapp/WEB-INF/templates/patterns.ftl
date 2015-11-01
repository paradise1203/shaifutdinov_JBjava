<#macro page user posts principal="">
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">Information:</div>
        <div class="panel-body">
            <ul>
                <li> Login: ${user.login} </li>
                <li> First name: ${user.firstName} </li>
                <li> Last name: ${user.lastName} </li>
                <li> Sex: ${user.sex.type} </li>
                <li> City: ${user.city} </li>
                <li> Mobile: ${user.mobilePhone} </li>
                <li> Email: ${user.email} </li>
            </ul>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">Board:</div>
        <div class="panel-body">
            <form role="form">
                <div class="form-group">
                    <label for="post">Write your post:</label>
                    <textarea id="post" class="form-control" rows="5"></textarea>
                </div>
                <#nested>
                <input type="button" class="btn btn-success sendPost" value="send">
            </form>

            <ul id="posts">
                <#list posts as post>
                    <#if principal=="" && post.author==user || principal==post.author>
                        <li> You at ${post.date?string('dd.MM.yyyy HH:mm:ss')} : ${post.text} </li>
                    <#else>
                        <li> ${post.author.firstName} at ${post.date?string('dd.MM.yyyy HH:mm:ss')} : ${post.text} </li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>
</div>
</#macro>