<div class="row">
    <form class="form form-inline" action="/admin/product/index.html", method="post">
        <div class="form-group">
            <label for="product.name">名称</label>
            <input class="form-control" type="text" placeholder="name" name="product.name" id="product.name">
        </div>
        <div class="form-group">
            <label for="product.id">方案ID</label>
            <input class="form-control" type="text" placeholder="product.id" name="product.id" id="product.id">
        </div>
        <input type="submit" value="search" class="btn btn btn-default">
    </form>
</div>
<div class="row">
    <div class="col-md-12">
        <table class="table">
            <thead>
                <tr>
                    <th>方案ID</th>
                    <th>方案名称</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <#list products as p>
                    <tr>
                        <td>${p.id}</td>
                        <td><a href="/admin/product/edit.html?productId=${p.id}">${p.name}</a></td>
                        <td>${p.ctime?datetime}</td>
                        <td>${p.mtime?datetime}</td>
                        <td>${p.statusString!''}</td>
                        <td>
                            <a href="/admin/product/edit.html?productId=${p.id}">编辑</a>
                            <#if p.status != 3 && p.status != 0>
                                <a href="/product/detail/${p.id}.html">预览</a>
                            </#if>
                            <#if p.status == 4>
                                <a href="/admin/product/confirm/${p.id}.html">审核通过</a>
                            </#if>
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>