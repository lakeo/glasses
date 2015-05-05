<div class="row">
    <div class="col-md-6">
        <h3>一级品类</h3>
        <ul>
        <#list levelOneList as item>
            <li><a href="/admin/type/index.html?id=${item.id}" target="_self">${item.name}(id:${item.id})</a></li>
        </#list>
        </ul>
    </div>
    <div class="col-md-6">
        <h3>对应二级品类-${(type.name)!''}</h3>
        <ul>
        <#list levelTwoList as item>
            <li>${item.name}</li>
        </#list>
        </ul>
    </div>
</div>