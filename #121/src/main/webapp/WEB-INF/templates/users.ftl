<div class="container">
<#if hasUsers>
    <table class="table">
        <thead>
        <tr>
            <th> Firstname </th>
            <th> Lastname </th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <#list users as u>
            <tr>
                <td> ${u.firstName} </td>
                <td> ${u.lastName} </td>
                <td>
                    <form role="form">
                        <input type="text" style="display: none" value=${u.id}>
                        <input type="button" class="btn btn-success showPage" value="show page">
                    </form>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
<#else>
    <div class="panel panel-default">
        <div class="panel-body"> There are no other users yet </div>
    </div>
</#if>
</div>