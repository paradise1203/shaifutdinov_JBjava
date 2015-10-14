<#macro fio text>
    <fieldset>
        <legend> ${text} </legend>
        <label for="fName"> First name: </label>
        <input type="text" name="fName" id="fName" required>
        <label for="sName"> Surname: </label>
        <input type="text" name="sName" id="sName" required>
        <label for="lName"> Last name: </label>
        <input type="text" name="lName" id="lName" required>
        <input type="submit" value="Get">
        <#nested>
    </fieldset>
</#macro>

<#macro subject id value text>
    <label for=${id}> ${text} </label>
    <input type="radio" name="subject" id=${id} value=${value} required>
</#macro>