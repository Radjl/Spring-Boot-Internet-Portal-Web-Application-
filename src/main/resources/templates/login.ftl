<!DOCTYPE html>
<html lang="en">

<#include "parts/headLogin.ftl">
<body class="text-center">





<form class="form-signin" action="/login" method="post">
    <img class="mb-4" src="/static/img/logo.png" alt="" width="86" height="67">
    <h1 class="h4 mb-3 font-weight-normal">Пожалуйста авторизируйтесь</h1>
    <input type="text" id="username" name="username" class="form-control" placeholder="Логин" required autofocus>
    <input type="text" id="password" name="password" class="form-control" placeholder="Пароль" required>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Запомнить меня
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2019 ЗПК-Бруклин-Киев</p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>







<#include "parts/scripts.ftl">
</body>
</html>
