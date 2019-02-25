<!-- Получаем сессию , у сессии получаем контекст безопасности , получаем пользователя и узнаем его права и передаём в шаблон результат метода пользователя isAdmin   -->
<#assign
 know = Session.SPRING_SECURITY_CONTEXT??
>


<#if know>
    <#assign

        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
    >
<#else>
    <#assign
        name = "unknow"
        isAdmin = false
>
</#if>
