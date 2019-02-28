<!DOCTYPE html>
<html lang="en">
<#include "parts/inventory/inventorymain.ftl">
<#include "parts/security.ftl">
<body>
<#include "parts/inventory/navbar.ftl">







<div class="container-fluid">
    <div class="row">

        <div class="col">
             <table data-toggle="table"  data-show-export="true"   data-search="true"   id="table"  class="table-xs table-bordred table-striped text-center">



                 <thead>

                    <th data-sortable="true">Наименование</th>
                    <th data-sortable="true">Срок эксплуатации</th>
                    <th data-sortable="true">Дата ввода в эксплуатацию</th>
                    <th data-sortable="true">Инвентарный номер</th>
                    <th data-sortable="true">Серийный номер</th>
                    <th data-sortable="true">Расположение</th>
                    <th>Детально</th>

                    <th>Удалить</th>
                    </thead>

                    <tbody>
                    <#list inventory as item>
                    <tr>
                        <td>${item.getName()}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-sm" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil">Открыть</span></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-sm identifyingClass"   data-id="${item.getId()}"  data-toggle="modal" data-target="#my_modal" ><span class="glyphicon glyphicon-trash">Удалить</span></button></p></td>
                    </tr>
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