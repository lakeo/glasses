<div class="row">
    <#if msg??>
        <span class="warning">${msg}</span>
    </#if>
    <div class="col-md-12">
        <form action="/admin/type/add" method="post" class="form">
            <label for="name">名称：</label>
            <input id="name" name="name" type="text"/>
            <label for="alias">英文名：</label>
            <input id="alias" name="alias" type="text"/>
            <label for="level">level：</label>
            <input id="level" name="level" type="text"/>
            <label for="parentid">parentid：</label>
            <input id="parentid" name="parentid" type="text"/>
            <label for="description">description：</label>
            <input id="description" name="description" type="text"/>

            <input type="submit" value="提交"/>

        </form>
    </div>
</div>