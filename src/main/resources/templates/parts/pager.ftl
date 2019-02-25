<#macro pager url ships>
    <div>
       <ul class="pagination">
           <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Страницы</a>
           </li>
           <#list 1..ships.getTotalPages() as p>
               <#if p == ships.getNumber()>
           <li class="page-item active">
               <a class="page-link" href="#" tabindex="-1">${p}</a>
               <#else>
           </li> <li class="page-item">
               <a class="page-link" href="${url}?page=${p}" tabindex="-1">${p}</a>
           </li>
               </#if>
           </#list>


       </ul>
    </div>
</#macro>

<@p.pager url ships>     </@p.pager>
<#import "parts/pager.ftl" as p>

