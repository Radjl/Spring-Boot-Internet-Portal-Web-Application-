<!DOCTYPE html>
<html lang="en">
<#include "parts/inventory/inventorymain.ftl">
<#include "parts/security.ftl">
<body>
<#include "parts/inventory/navbar.ftl">


<div class="article-list">
    <div class="container">
        <div class="intro">
            <h2 class="text-center">Производственные отделы ЗПК</h2>
            <p class="text-center"></p>
        </div>
        <div class="row articles">
            <div class="col-sm-6 col-md-4 item"><a href="/inventory/it"><img class="img-fluid" src="/static/img/apcs.jpg"></a>
                <h3 class="name">IT</h3>
                <p class="description"></p><a href="#" class="action"><i class="fa fa-arrow-circle-right"></i></a></div>
            <div
                    class="col-sm-6 col-md-4 item"><a href="#"><img class="img-fluid" src="/static/img/mehanik.jpg"></a>
                <h3 class="name">Механизация</h3>
                <p class="description"></p><a href="#" class="action"><i class="fa fa-arrow-circle-right"></i></a></div>
            <div
                    class="col-sm-6 col-md-4 item"><a href="/inventory/kipia"><img class="img-fluid" src="/static/img/kipia.jpg"></a>
                <h3 class="name">Кип</h3>
                <p class="description"></p><a href="#" class="action"><i class="fa fa-arrow-circle-right"></i></a></div>
        </div>
    </div>
</div>




<#include "parts/inventory/footer.ftl">
<#include "parts/inventory/inventjs.ftl">
</body>
</html>