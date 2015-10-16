<#macro fio text>
    <fieldset>
        <legend> ${text} </legend>
        First name:<@spring.formInput "student.firstName"/>
        Surname:<@spring.formInput "student.surname"/>
        Last name:<@spring.formInput "student.lastName"/>
        <input type="submit" value="send">
        <#nested>
    </fieldset>
</#macro>

<#macro subject id value text>
    <label for=${id}> ${text} </label>
    <input type="radio" name="subject" id=${id} value=${value} required>
</#macro>