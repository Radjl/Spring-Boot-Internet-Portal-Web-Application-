<!DOCTYPE html>
<html lang="en">
<#include "parts/inventory/inventorymain.ftl">
<#include "parts/security.ftl">

<body>
<#include "parts/inventory/navbar.ftl">







<div class="container-fluid">

















    <div class="row">

        <div class="col">
             <table data-toggle="table"
                    data-show-export="true"
                    data-search="true"
                    data-page-list="[10, 25, 50, 100, 200, All]"
                    data-page-size="10"
                    data-pagination="true"
                    id="table"
                    data-pagination-pre-text="Назад"
                    data-pagination-next-text="Вперёд"
                    class="table-xs table-bordred table-striped text-center">



                 <thead>

                    <th data-sortable="true">Наименование</th>
                    <th data-sortable="true">Срок эксплуатации (мес.)</th>
                    <th data-sortable="true">Дата ввода в эксплуатацию</th>
                    <th data-sortable="true">Инвентарный номер</th>
                    <th data-sortable="true">Серийный номер</th>
                    <th data-sortable="true">Расположение</th>
                    <th>Детально</th>

                    <!--   <th>Удалить</th> -->
                    </thead>

                    <tbody>
                    <#list inventory as item>
                    <#if item.isBroken()>
                    <tr>
                        <td  class="table-danger"><#if item.getName()??>${item.getName()}</#if></td>
                        <td  class="table-danger"><#if item.getSrokEkspluatacii()??>${item.getSrokEkspluatacii()}</#if> </td>
                        <td  class="table-danger"><#if item.getVvodEkspluatacii()??>${item.getVvodEkspluatacii()?string('yyyy-MM-dd')}</#if></td>
                        <td  class="table-danger"><#if item.getInventoryNumber()??>${item.getInventoryNumber()}</#if></td>
                        <td  class="table-danger"><#if item.getSerialNumber()??>${item.getSerialNumber()}</#if></td>
                        <td  class="table-danger"><#if item.getDislocation()??>${item.getDislocation()}</#if></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-sm" data-title="Edit"  data-toggle="modal" data-target="#modal${item.getId()?c}" ><span class="glyphicon glyphicon-pencil">Открыть</span></button></p></td>
                        <!--    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-sm identifyingClass"   data-id="${item.getId()}"  data-toggle="modal" data-target="#my_modal" ><span class="glyphicon glyphicon-trash">Удалить</span></button></p></td>  -->
                    </tr>
                        <#else>

                            <tr>
                                <td><#if item.getName()??>${item.getName()}</#if></td>
                                <td><#if item.getSrokEkspluatacii()??>${item.getSrokEkspluatacii()}</#if> </td>
                                <td><#if item.getVvodEkspluatacii()??>${item.getVvodEkspluatacii()?string('yyyy-MM-dd')}</#if></td>
                                <td><#if item.getInventoryNumber()??>${item.getInventoryNumber()}</#if></td>
                                <td><#if item.getSerialNumber()??>${item.getSerialNumber()}</#if></td>
                                <td><#if item.getDislocation()??>${item.getDislocation()}</#if></td>
                                <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-sm" data-title="Edit"  data-toggle="modal" data-target="#modal${item.getId()?c}" ><span class="glyphicon glyphicon-pencil">Открыть</span></button></p></td>
                            <!--    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-sm identifyingClass"   data-id="${item.getId()?c}"  data-toggle="modal" data-target="#my_modal" ><span class="glyphicon glyphicon-trash">Удалить</span></button></p></td>  -->
                            </tr>
                    </#if>

                        <!-- детальное отображение одной позиции  -->
                        <div class="modal fade " id="modal${item.getId()?c}" tabindex="-1" role="dialog" aria-labelledby="my_modalLabel">
                            <div class="modal-dialog modal-dialog-centered" role="document">

                                <div class="modal-dialog vertical-align-center">
                                    <div class="modal-content">


                                        <div class="card text-center">
                                            <!-- получая айди нужно обязательно указать на ?с  -->
                                            <form method="post" enctype="multipart/form-data" action="/inventory/properties/${item.getId()?c}">
                                            <#if item.img??>
                                            <img class="card-img-top" src="/img/it/${item.getImg()}" alt="Card image cap">
                                                <label class="btn-bs-file btn btn-sm btn-light">
                                                    Сменить фото
                                                    <input type="file" name="photo"/>
                                                </label>
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
                                                            <li class="list-group-item"> <input type="text" name="firstbroke"  value="${item.getFirstBroke()!}" class="border-0 text-center form-control"></li>
                                                            <li class="list-group-item"><input type="text" name="secondbroke"  value="${item.getSecondBroke()!}" class="border-0 text-center form-control"></li>
                                                            <li class="list-group-item"><input type="text" name="thirdbroke"  value="${item.getThirdBroke()!}" class="border-0 text-center form-control"></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                    </#if>
                                            </div>
                                            <div class="card-footer text-muted">
                                                <div class="row">
                                                    <div class="col">
                                                        <a class="btn-sm btn-info" data-toggle="collapse" data-target="#collapseExample1" href="#" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                            Обслуживание
                                                        </a>

                                                    </div>

                                                    <div class="col">
                                                        <a class="btn-sm btn-info" data-toggle="collapse" href="#" data-target="#collapseExample2" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                            Ремонт
                                                        </a>
                                                    </div>
                                                    <div class="col">
                                                        <a class="btn-sm btn-info" data-toggle="collapse" href="#" data-target="#collapseExample3" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                            Поставщик
                                                        </a>
                                                    </div>

                                                </div>

                                                    <p></p>
                                                <!--Дополнительная информация  -->
                                                <div class="col">
                                                    <div class="collapse multi-collapse" id="collapseExample1">
                                                        <div class="card card-body">
                                                            Последняя запрвка:
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="collapse multi-collapse" id="collapseExample2">
                                                        <div class="card card-body">
                                                            Последний ремонт:
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="collapse multi-collapse" id="collapseExample3">
                                                        <div class="card card-body">
                                                            Поставщик:
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--Дополнительная информация  -->

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
                 <!--  Модалка удаления     -->
                                </div>
                            </div>
                        </div>
                    </#list>
                    </tbody>

                </table>


        </div>
        <#include "parts/inventory/widgets.ftl">


    </div>

</div>






<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Mohsin">
                </div>
                <div class="form-group">

                    <input class="form-control " type="text" placeholder="Irshad">
                </div>
                <div class="form-group">
                    <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>


                </div>
            </div>
            <div class="modal-footer ">
                <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>


<div class="modal fade" id="my_modal" tabindex="-1" role="dialog" aria-labelledby="my_modalLabel">
    <div class="modal-dialog modal-dialog-centered" role="document">

        <div class="modal-dialog vertical-align-center">
        <div class="modal-content">
            <div class="modal-body text-center font-weight-bold">Вы уверены ?</div>
            <div class="modal-footer">
                <form method="post" action="/inventory/it/delete">
                    <input type="hidden" name="hiddenValue" id="hiddenValue" value="" />
                <button type="button" class="btn btn-info" data-dismiss="modal">Нет</button>
                <button type="submit" class="btn btn-danger">Да</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            </div>
        </div>
        </div>
        </div>
    </div>











<#include "parts/inventory/footer.ftl">
<#include "parts/inventory/inventjs.ftl">


    <script type="text/javascript">
        $(function () {
            $(".identifyingClass").click(function () {
                var my_id_value = $(this).data('id');
                $(".modal-footer #hiddenValue").val(my_id_value);
            })
        });
    </script>

</body>
</html>