<!DOCTYPE html>
<html lang="en">
<#include "parts/chronology/shipsdetail.ftl">
<#include "parts/security.ftl">
<body>





<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/chronology">Вернуться к списку судов</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<!-- END Navigation -->


<div class="container-fluid gedf-wrapper">
    <div class="row">
        <div class="col-md-3">
            <div class="card">
                <div class="card-body">
                    <div class="h5">${ship.getShipname()}</div>
                    <div class="h7 text-muted">Направление : ${ship.getDescription()}</div>
                    <div class="h7">Резерв.
                    </div>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <div class="h6 text-muted">Каргоплан</div>
                        <div class="h5">10 000</div>
                    </li>
                    <li class="list-group-item">
                        <div class="h6 text-muted">Доп резерв</div>
                        <div class="h5">10 000</div>
                    </li>
                    <li class="list-group-item">Резерв</li>
                </ul>
            </div>
        </div>
        <div class="col-md-6 gedf-main">

            <!--- \\\\\\\Post-->
            <#if isAdmin>
            <div class="card gedf-card">
                <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="posts-tab" data-toggle="tab" href="#posts" role="tab" aria-controls="posts" aria-selected="true">Добавить запись</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="images-tab" data-toggle="tab" role="tab" aria-controls="images" aria-selected="false" href="#images">Добавить Фото</a>
                        </li>
                    </ul>
                </div>

                <div class="card-body">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                            <div class="form-group">
                                <label class="sr-only" for="message">post</label>
                                <form method="post" action="/chronology/addMessage/${ship.getId()?c}" id="addmessageform">
                                    <div class="form-group">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                                        <textarea class="form-control  "  name="message" rows="5" placeholder="Введите текст..."></textarea>
                                        </div>
                                </form>
                            </div>




                        </div>
                        <div class="tab-pane fade" id="images" role="tabpanel" aria-labelledby="images-tab">
                            <div class="form-group">
                                <div class="custom-file">
                                    <form method="post" action="/chronology/addPhoto/${ship.getId()?c}" enctype="multipart/form-data" id="addcommentform">
                                    <input type="file" name="image" class="custom-file-input mt-1" id="customFile">
                                    <label class="custom-file-label" for="customFile">Загрузить фото</label>
                                    <input class="form-control" type="text" name="name" id="photocomment" placeholder="Комментарий к фото">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}">

                                    </form>
                                </div>
                            </div>
                            <div class="py-4"></div>
                        </div>
                    </div>
                    <div class="btn-toolbar justify-content-between">
                        <div class="btn-toolbar pull-right">
                            <button type="submit"  class="btn btn-primary mr-3" form="addmessageform">Добавить запись</button>
                            <button class="btn btn-primary mr-3" form="addcommentform" type="submit">Добавить фото</button>
                        </div>
                        <div class="btn-toolbar pull-right">
                            <div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Post /////-->
            </#if>



            <!--- \\\\\\\Post-->
            <#list ship.shipmessage as message>
            <div class="card gedf-card">
                <div class="card-header">
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="mr-2">
                                <img class="rounded-circle" width="50" src="/static/img/logo.png" alt="">
                            </div>
                            <div class="ml-2">
                                <div class="fa m-0 fa-clock-o">Добавлено: ${message.getTimeStamp()}</div>
                            </div>
                        </div>
                        <div>
                            <#if isAdmin>
                            <div class="dropdown">
                                <button class="btn btn-link dropdown-toggle"   type="button" id="gedf-drop1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-ellipsis-h"></i>
                                </button>

                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
                                    <div class="h6 dropdown-header">Настройки</div>

                                    <form class="" method="post" action="/chronology/deletemessage/${message.getId()?c}">
                                        <input type="hidden" name="shipId" value="${ship.getId()?c}">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                                        <button type="submit" class="dropdown-item btn btn-link">Удалить</button>
                                    </form>

                                </div>

                            </div>
                            </#if>
                        </div>
                    </div>

                </div>
                <form method="post" action="/chronology/editmessage/${ship.getId()?c}">
                <div class="card-body">
                    <!--- \\\\\\\ <div class="text-muted h7 mb-2"> <i class="fa fa-clock-o"></i>Время публикации</div>  -->
                    <a class="card-link" href="#">
                    </a>
                        <textarea class="form-control airmode" name="message1" rows="5" placeholder="">${message.getText()}</textarea>
                        <input type="hidden" name="messageId" value="${message.getId()?c}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                </div>

                <div class="card-footer">
                    <div class="btn-toolbar justify-content-between">
                        <#if isAdmin>
                    <button type="submit" class="btn btn-link"><i class="fa fa-gittip"></i>Сохранить изменения</button>
                        </#if>
                        <button class="btn btn-primary"   type="button" data-target="#target${message.getId()?c}" data-toggle="collapse"  aria-expanded="false" aria-controls="collapseExample">
                            Дополнительный текст
                        </button>
                    </div>
                </div>
                </form>

                <!-- Дополнительный раскрывающийся английский текст -->
                <div class="collapse" id="target${message.getId()}">
                    <form class="" method="post" action="/chronology/english/${message.getId()}">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1"></label>
                            <textarea class="form-control" name="englishtext" id="exampleFormControlTextarea1"  rows="30">${message.getEnglishtext()}</textarea>
                        </div>
                        <input type="hidden" name="shipId" value="${ship.getId()?c}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                <#if isAdmin>
                        <button type="submit" class="btn btn-primary">Сохранить</button>
                </#if>
                    </form>
                </div>
                <!-- Дополнительный раскрывающийся английский текст -->
            </div>


            </#list>
            <!-- Post /////-->
        </div>

        <div class="col-md-3">
            <#list ship.images as image>
            <div class="card gedf-card">
                <img class="card-img-top" src="/img/ship/${image.image}" height="250" alt="Card image cap">
                <div class="card-body">
                    <div>
                    <h5 class="card-title">${image.name}</h5>
                    </div>
                    <!--- \\\\\\\Post <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6> -->
                    <form class="" method="post" action="/chronology/deleteimage/${image.getId()?c}">
                         <#if isAdmin>
                        <button class="btn btn-danger pull-right"  type="submit">Удалить</button>
                             </#if>
                        <input type="hidden" name="shipId" value="${ship.getId()?c}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                </div>
            </div>
            </#list>
        </div>
    </div>
</div>





<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">ЗПК Бруклин-Киев 2019</p>
    </div>
    <!-- /.container -->

</footer>





<#include "parts/chronology/Chrono.ftl">
</body>
</html>