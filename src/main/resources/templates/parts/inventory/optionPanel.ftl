<div class="modal fade " id="modal${item.getId()?c}" tabindex="-1" role="dialog" aria-labelledby="my_modalLabel">
    <div class="modal-dialog modal-dialog-centered" role="document">

        <div class="modal-dialog vertical-align-center">
            <div class="modal-content">


                <div class="card text-center">
                    <!-- получая айди нужно обязательно указать на ?с  -->
                    <form method="post" enctype="multipart/form-data" action="/inventory/properties/${item.getId()?c}">
                        <#if item.img??>
                            <img class="card-img-top" src="/img/it/${item.getImg()}" alt="Card image cap">
                        <#else>
                            <img class="card-img-top" src="https://picsum.photos/1900/1080?image=235" alt="Card image cap">
                        </#if>
                        <div class="card-body">
                            <h5 class="card-title">${item.getName()}</h5>
                            <hr>
                            <label>
                                Неисправен:
                                <input type="checkbox" <#if item.isBroken()>checked="checked" </#if> name="checkbox">
                                <input type="hidden" name="text" value="no" >
                            </label>
                            <#if item.isBroken()>
                                <p>
                                    <a class="btn-sm btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        Детально
                                    </a>
                                </p>
                                <div class="collapse" id="collapseExample">
                                    <div class="card card-body">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item"> <input type="text" name="firstbroke"  value="${item.getFirstBroke()}" class="border-0 text-center form-control"></li>
                                            <li class="list-group-item"><input type="text" name="secondbroke"  value="${item.getSecondBroke()}" class="border-0 text-center form-control"></li>
                                            <li class="list-group-item"><input type="text" name="thirdbroke"  value="${item.getThirdBroke()}" class="border-0 text-center form-control"></li>
                                        </ul>
                                    </div>
                                </div>
                            </#if>
                        </div>
                        <div class="card-footer text-muted">
                            <div class="row">
                                <div class="col">
                                    <a class="btn-sm btn-info" data-toggle="collapse" href="#" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        Обслуживание
                                    </a>
                                </div>
                                <div class="col">
                                    <a class="btn-sm btn-info" data-toggle="collapse" href="#" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        Ремонт
                                    </a>
                                </div>
                                <div class="col">
                                    <a class="btn-sm btn-info" data-toggle="collapse" href="#" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        Поставщик
                                    </a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <p></p>
                                    <button type="submit" class="btn btn-link"><i class="fa"></i>Сохранить изменения</button>

                                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                                    <input type="hidden"  name="id" value="${item.getId()?c}">
                    </form>
                    <a href="/inventory/it/delete/${item.getId()?c}"  class="btn btn-link"><i class="fa"></i>Удалить запись</a>
                </div>
            </div>
        </div>
    </div>
</div>