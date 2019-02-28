<div class="col-2">
    <!-- Categories Widget -->
        <div class="card my-4">
            <h5 class="card-header">Панель управления</h5>
            <div class="card-body">
                <div class="row">
                    <div class="col-lg-6">
                        <ul class="list-unstyled mb-0">
                                    <button data-toggle="modal" data-target="#addItem" class="btn btn-primary  btn-sm center-block">Добавить</button>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Side Widget -->
        <div class="card my-4">
            <h5 class="card-header">Сервис</h5>
            <div class="card-body">
                <button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary  btn-sm center-block">Резерв</button>
            </div>
        </div>
</div>


<div class="modal fade" role="dialog" tabindex="-1" id="addItem">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header  text-primary align-self-center">
                <h4 class="modal-title">Добавление судна</h4></div>
            <div class="modal-body">
                <form method="post" action="/inventory/it" enctype="multipart/form-data" id="myform">
                    <div class="form-group text-center text-primary"><label>Название судна</label><input class="form-control" name="name" type="text"></div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            </div>
            <div class="modal-footer"><button class="btn btn-light" type="button" data-dismiss="modal">Закрыть</button><button class="btn btn-primary" form="myform" type="submit">Отправить</button></div>
        </div>
    </div>
</div>



