<!DOCTYPE html>
<html lang="en">
<#include "parts/main.ftl">
<#include "parts/security.ftl">
<body>
<!------ Include the above in your HEAD tag
<h1>Привет , Юзер? )</h1>

<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
---------->

<nav class="main-navigation">
    <div class="navbar-header animated fadeInUp">
        <a class="navbar-brand" href="#">    <img class="mb-4" src="/static/img/logo.png">
        </a>

    </div>
    <ul class="nav-list">
        <#if isAdmin>
        <li class="nav-list-item">
            <a href="#" class="nav-link">Резерв</a>
        </li>
        <li class="nav-list-item">
            <a href="#" class="nav-link">Резерв</a>
        </li>
        <li class="nav-list-item">
            <a href="#" class="nav-link">Резерв</a>
        </li>

        <li class="nav-list-item">
            <a href="/admin" class="nav-link">Панель администратора</a>
        </li>
        </#if>
        <li class="nav-list-item">
            <form action="/logout" method="post">
            <input type="submit"  class="btn btn-secondary border-0 " value="Выйти">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
        </li>
        <li class="nav-list-item">
        </li>
    </ul>

</nav>




<div class="accordian">
    <ul>
        <li>
            <div class="image_title">
                <a href="/chronology">Хронология погрузки судов ЗПК</a>
            </div>
            <a href="/chronology">
                <img src="/static/img/sh.jpg"/>
            </a>
        </li>
        <li>
            <div class="image_title">
                <a href="https://www.youtube.com/channel/UCXTfDJ60DBmA932Du6B1ydg">Термометрия</a>
            </div>
            <a href="https://www.youtube.com/channel/UCXTfDJ60DBmA932Du6B1ydg">
                <img src="/static/img/sil.jpg"/>
            </a>
        </li>
        <li>
            <div class="image_title">
                <a href="https://www.youtube.com/channel/UCXTfDJ60DBmA932Du6B1ydg">Обработка ЖД</a>
            </div>
            <a href="https://www.youtube.com/channel/UCXTfDJ60DBmA932Du6B1ydg">
                <img src="/static/img/train.jpg"/>
            </a>
        </li>
        <li>
            <div class="image_title">
                <a href="#">Обработка Авто</a>
            </div>
            <a href="https://www.youtube.com/channel/UCXTfDJ60DBmA932Du6B1ydg">
                <img src="/static/img/auto.jpg"/>
            </a>
        </li>
        <li>
            <div class="image_title">
                <a href="#">Погрузка судов</a>
            </div>
            <a href="https://www.youtube.com/channel/UCXTfDJ60DBmA932Du6B1ydg">
                <img src="/static/img/ship.jpg"/>
            </a>
        </li>
    </ul>
</div>






<#include "parts/scripts.ftl">
</body>
</html>