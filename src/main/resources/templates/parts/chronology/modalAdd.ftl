<div class="container">
    <button type="button" class="btn btn-primary center-block" data-toggle="modal" data-target="#myModal">Добавить</button>

    <div class="modal fade" role="dialog" tabindex="-1" id="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header  text-primary align-self-center">
                    <h4 class="modal-title">Добавление судна</h4></div>
                <div class="modal-body">
                    <form method="post" action="/chronology" enctype="multipart/form-data" id="myform">
                        <div class="form-group text-center text-primary"><label>Название судна</label><input class="form-control" name="shipname" type="text"></div>
                        <div class="form-group text-center text-primary"><label>Направление судна</label><input class="form-control" name="description" type="text"></div>
                        <div class="form-group text-center"><label class="text-primary">Фото судна</label></div>
                        <div class="form-group text-center text-primary"><input class="shadow-sm" name="file" type="file"></div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                </div>
                <div class="modal-footer"><button class="btn btn-light" type="button" data-dismiss="modal">Закрыть</button><button class="btn btn-primary" form="myform" type="submit">Отправить</button></div>
            </div>
        </div>
    </div>


</div>
