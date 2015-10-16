<#import "patterns.ftl" as lib>
<#import "/spring.ftl" as spring>

<html>

    <head>
        <title> Home </title>
    </head>
    <body>
        <form action="/totalScore">
            <@lib.fio text="Show my total score"/>
        </form>
        <form action="/averageScore">
            <@lib.fio text="Show my average score"/>
        </form>
        <form action="/particularScore">
            <@lib.fio text="Show particular score">
                <@lib.subject id="eng" value=0 text="English lang"/>
                <@lib.subject id="matan" value=1 text="Math-l an-s"/>
                <@lib.subject id="discr" value=2 text="Discrete math"/>
                <@lib.subject id="algem" value=3 text="Algebra&Geom"/>
                <@lib.subject id="algr" value=4 text="Alg-s&DataStructs"/>
                <@lib.subject id="progr" value=5 text="Programming"/>
            </@lib.fio>
        </form>
        <h3>
            Score : <#if score??> ${score} <#else> no score </#if>
        </h3>
    </body>

</html>