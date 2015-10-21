<html>
    <head>
        <title> Home </title>
    </head>
    <body>
        <form action="/getClinicInfo">
            <label for="name"> Clinic name: </label>
            <input type="text" name="name" id="name" required>
            <input type="submit" value="get">
        </form>
        Average salary: <#if avgSal??> ${avgSal} </#if> <br>
        Average check: <#if avgClinicCheck??> ${avgClinicCheck} </#if>
        <hr>
        <form action="/getOfficeInfo">
            <label for="city"> City: </label>
            <input type="text" name="city" id="city" required>
            <label for="street"> Street: </label>
            <input type="text" name="street" id="street" required>
            <label for="provider"> Provider: </label>
            <input type="text" name="provider" id="provider">
            <input type="submit" value="get">
        </form>
        Average check: <#if avgOfficeCheck??> ${avgOfficeCheck} </#if> <br>
        Provider has delivered out stuff: <#if hasDelivered??> <#if hasDelivered==true> Yep! <#else> No! </#if> </#if>
        <hr>
        <form action="/getParticularEmployee">
            <label for="fio"> Employee fio: </label>
            <input type="text" name="fio" id="fio" required>
            <input type="submit" value="get">
        </form>
        Particular salary: <#if partSal??> ${partSal} </#if> <br>
        Particular working experience: <#if partWorExp??> ${partWorExp} days </#if>
        <hr>
        <form action="/getTop">
            <input type="submit" value="getTop">
        </form>
        <#if topClCheck??> The most profitable clinic: ${topClCheck} </#if> <br>
        <#if topOffCheck??> The most profitable office: ${topOffCheck} </#if>
    </body>
</html>