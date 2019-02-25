<!DOCTYPE html>
<html>

<#include "parts/admin/adminpanel.ftl">

<body style="margin: 0px;padding: 0px;">
    <div>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
            <div class="container"><a class="navbar-brand text-info">Панель администратора</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav mr-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link  text-info" href="/">На главную</a></li>
                        <li class="dropdown nav-item"><a class="dropdown-toggle nav-link text-info" data-toggle="dropdown" aria-expanded="false" href="#">Меню</a>
                            <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#">First Item</a><a class="dropdown-item" role="presentation" href="#">Second Item</a><a class="dropdown-item" role="presentation" href="#">Third Item</a></div>
                        </li>
                        <form action="/logout" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </ul><span class="navbar-text actions"> <input class="btn btn-info shadow-sm submit-button" type="submit" value="Выйти"></span></form></div>
    </div>
    </nav>
    </div>
    <div class="container" style="padding: 30px;">
        <div class="row">
            <div class="col">

                <form class="custom-form" action="/register" method="post">
                    <h3 class="text-center text-info shadow-sm">Форма регистрации</h3>
                    <div class="form-row form-group">
                        <div class="col-sm-4 label-column"><label class="col-form-label" for="name-input-field">Логин</label></div>
                        <div class="col-sm-6 input-column"><input class="form-control" type="text" name="username"></div>
                    </div>
                    <div class="form-row form-group">
                        <div class="col-sm-4 label-column"><label class="col-form-label" for="email-input-field">Пароль</label></div>
                        <div class="col-sm-6 input-column"><input class="form-control" type="text" name="password"></div>
                    </div>
                    <div class="form-row form-group">
                        <div class="col-sm-4 label-column"><label class="col-form-label" for="pawssword-input-field">Пароль повторно</label></div>
                        <div class="col-sm-6 input-column"><input class="form-control" type="password"></div>
                    </div>
                    <div class="form-row form-group">
                        <div class="col-sm-4 label-column"><label class="col-form-label" for="repeat-pawssword-input-field">Почтовый ящик</label></div>
                        <div class="col-sm-6 input-column"><input class="form-control" type="password"></div>
                    </div>
                    <div class="form-check text-center"><input class="form-check-input" type="checkbox"  name="user" id="formCheck-4"><label class="form-check-label" for="formCheck-4">Пользователь</label></div>
                    <div class="form-check text-center"><input class="form-check-input" type="checkbox" name="admin" id="formCheck-4"><label class="form-check-label" for="formCheck-4">Администратор</label></div>
                    <div class="form-row">
                        <div class="col text-center"><button class="btn btn-info shadow-sm submit-button" type="submit" style="padding: 8px;margin: 0px;height: 45px;width: 110px;">Отправить</button></div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            </div>
            <div class="col">

                <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Имя</th>
                <th>Пароль</th>
                <th>Роль</th>
                <th>Активность</th>
                <th>Редактировать</th>
                <th>Удалить</th>
            </tr>
        </thead>
                    <#list users as user>
        <tbody>
            <tr>
                <td>${user.getUsername()}</td>
                <td>${user.getPassword()}</td>
                <td><#list user.roles as role>${role}<#sep>,  </#list></td>
                <td><#if user.active>Да<#else>Нет</#if></td>
                <td><a href="/user/${user.id}">Редактировать</a></td>
                <td><a href="/user/delete/${user.id}">Удалить</a></td>
            </tr>
            
        </tbody>
                    </#list>
    </table>

            </div>
        </div>
    </div>
    <#include "parts/admin/adminScripts.ftl">
</body>

</html>