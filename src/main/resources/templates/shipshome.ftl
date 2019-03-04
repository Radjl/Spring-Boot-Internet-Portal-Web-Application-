<!DOCTYPE html>
<html lang="en">
<#include "parts/chronology/chronology.ftl">
<#include "parts/security.ftl">
  <body>





    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="/">Вернуться в меню</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>
    <!-- END Navigation -->




    <!-- Page Content -->
    <div class="container">

      <div class="row">


        <!-- Blog Entries Column -->
        <div class="col-md-8">

          <h1 class="my-4 text-center">Хронология погрузки судов

          </h1>



            <#list ships as ship>
          <div class="card mb-4">
         <#if ship.img?? >
             <img class="card-img-top" src="/img/ship/${ship.img}" height="400" alt="Card image cap">
              <#else>
                  <img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
         </#if>
            <div class="card-body">
              <h2 class="card-title">${ship.getShipname()}</h2>
              <p class="card-text"><i>Направление судна: </i>${ship.description}</p>
              <div class="btn-toolbar justify-content-between">
                <div class="btn-group">
                  <a href="/chronology/${ship.getId()}" class="btn btn-primary">Подробнее &rarr;</a>
                  <div>
                    <div class="dropdown">
                      <button class="btn btn-link dropdown-toggle"   type="button" id="gedf-drop1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-ellipsis-h"></i>
                      </button>

                      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
              <#if isAdmin>
                        <div class="h6 dropdown-header">Настройки</div>
                        <a class="dropdown-item" href="#">Изменить фото</a>
                        <a class="dropdown-item" href="#">Изменить название</a>
                        <a class="dropdown-item" href="#">Изменить направление</a>
              </#if>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="btn-group">
                  <#if isAdmin>
                  <div>

                    <!-- Вызов модального окна-->
                    <button class="btn btn-danger" data-toggle="modal" data-target="#deleteship" >Удалить судно</button>

                    <!-- Модальное окно удаления  -->
                    <div class="modal fade" id="deleteship" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

                      <div class="modal-dialog modal-dialog-centered" role="document">

                        <div class="modal-dialog vertical-align-center">
                          <div class="modal-content">

                            <div class="modal-body text-center font-weight-bold">Вы уверены ?</div>
                            <div class="modal-footer">
                              <form method="post" action="/chronology/delete/${ship.getId()}">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                                <button class="btn btn-danger" type="submit">Удалить судно</button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                              </form>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- Modal -->


                  </div>
                  </#if>
                </div>

              </div>

            </div>
              <#if ship.getTimeStamp()?? >
            <div class="card-footer ">
              Добавлено: ${ship.getTimeStamp()}
              <a></a>
            </div>
              <#else>
                <div class="card-footer text-muted">
                  Добавлено: Нет даты
                  <a></a>
                </div>
              </#if>
          </div>
            </#list>

        </div>





        <!-- Виджеты справа -->
        <div class="col-md-4">
            <!-- Search Widget -->
        <form method="post" action="filter">
          <div class="card my-4">
            <h5 class="card-header">Поиск</h5>
            <div class="card-body">
              <div class="input-group">
                <input type="text" class="form-control" name="filter"  placeholder="Введи название..."">
                <span class="input-group-btn">
                  <button class="btn btn-secondary" type="submit">Найти!</button>
                   <input type="hidden" name="_csrf" value="${_csrf.token}">
                </span>
              </div>
            </div>
          </div>
        </form>

          <!-- Categories Widget -->
          <#if isAdmin>
          <div class="card my-4">
            <h5 class="card-header">Меню</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                                              <#include "parts/chronology/modalAdd.ftl">
                         <p></p>
                    </li>

                  <!--Скрыто-->
                      <#if shos??>
                    <li>
                      <button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Резерв</button>
                    </li>

                  </ul>
                </div>
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Резерв</button>
                        <p></p>
                    </li>
                    <li>
                      <button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Резерв</button>
                    </li>
                    </#if>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          </#if>
          <#if shos??>
          <!-- Side Widget -->
          <div class="card my-4">
            <h5 class="card-header">Виджет</h5>
            <div class="card-body">
              Резерв
            </div>
          </div>
          </#if>
        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->




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
