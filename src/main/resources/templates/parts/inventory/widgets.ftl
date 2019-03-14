<div class="col-2">
    <!-- Categories Widget -->
        <div class="card my-4">
            <h5 class="card-header">Панель управления</h5>
            <div class="card-body">
                <div class="btn-group-justified" role="group" aria-label="Basic example">

                    <div class="col">
                        <button data-toggle="modal" data-target="#addItem" class="btn btn-block mr-1 btn-primary">Добавить новую запись</button>
                    </div>
                    <p></p>
                    <div class="col">





                    </div>
                    <p></p>
                    <div class="col">
                        <form method="post" action="/inventory/it/deleteall" >
                            <button type="submit" class="btn btn-block btn-primary">Удалить все записи</button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                        </form>

                    </div>





                </div>
            </div>
        </div>
        <!-- Side Widget -->
        <div class="card my-4">
            <h5 class="card-header">Сервис</h5>

            <div class="panel panel-default" id="p1">
                <div class="panel-body" id="p2">


                    <form action="/inventory/it/excel" method="post" enctype="multipart/form-data">
						<div class="btn btn-default image-preview-input"> <span class="glyphicon glyphicon-folder-open"></span> <span class="image-preview-input-title">Загрузить Excel</span>
							<input type="file" accept="image/png, image/jpeg, image/gif" required name="excel"/>
						</div>
						<button type="submit" class="btn btn-labeled btn-primary pull-right"> <span class="btn-label"><i class="glyphicon glyphicon-upload"></i> </span>Отправить</button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                </div>
            </div>

            <!-- Side Widget
            <div class="card-body">

            </div>

            -->
        </div>

    <div class="card my-4">
        <h5 class="card-header">Последние изменения </h5>

        <div class="panel panel-default" id="p2">
            <div class="panel-body" id="p3">

                <#include "chat.ftl">

            </div>

        </div>
        <button type="submit" class="btn btn-link card-footer"><i class="fa fa-trash"></i>Очистить</button>


    </div>


</div>


<div class="modal fade" role="dialog" tabindex="-1" id="addItem">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header  text-primary align-self-center">
                <h4 class="modal-title">Новая запись</h4></div>
            <div class="modal-body">
                <form method="post" action="/inventory/it" enctype="multipart/form-data" id="myform">
                    <div class="form-group text-center text-primary"><label>Наименование</label><textarea class="form-control" required name="name" rows="2"></textarea></div>
                    <div class="form-group text-center text-primary"><label>Срок эксплуатации (мес.)</label><input required type="number" class="form-control" name="usefull"></div>
                    <div class="form-group text-center text-primary"><label>Дата ввода в эксплуатацию</label><input required type="date" class="form-control" name="date"></div>
                    <div class="form-group text-center text-primary"><label>Инвентарный номер</label><input required type="text" class="form-control" name="invent"></div>
                    <div class="form-group text-center text-primary"><label>Серийный номер</label><input required type="text" class="form-control" name="serial"></div>
                    <div class="form-group text-center text-primary"><label>Расположение</label><input required type="text" class="form-control" name="dislocation"></div>
                    <label class="btn mr-1 btn text-center btn-block btn-file">
                        Загрузить фото <input type="file" name="file" style="display: none;">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            </div>
            <div class="modal-footer"><button class="btn btn-light" type="button" data-dismiss="modal">Закрыть</button><button class="btn btn-primary" form="myform" type="submit">Отправить</button></div>
        </div>
    </div>
</div>



