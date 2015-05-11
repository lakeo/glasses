<div class="row" style="border:1px solid #e1e1e8;margin-top:10px;">
    <h4>属性组列表</h4>
    <div class="col-md-12">
        <table class="table table-bordered mytable-class" id="grouptable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>type</th>
                    <th>description</th>
                    <th>comment</th>
                </tr>
            </thead>
            <tbody>
                <#list groups as group>
                    <tr>
                        <td>${group.id}</td>
                        <td>${group.name}</td>
                        <td>${group.type}</td>
                        <td>${group.description}</td>
                        <td>${group.comment!''}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>

    <h5>属性组修改 -- 添加时不要填写id</h5>

    <div class="col-md-12">
        <form action="/admin/dynamicform/group/edit" class="form form-inline">
            <div class="form-group">
                <label for="id">ID</label>
                <input id="id" name="id" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">name</label>
                <input id="name" name="name" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="type">type</label>
                <input id="type" name="type" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="description">description</label>
                <input id="description" name="description" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="comment">comment</label>
                <input id="comment" name="comment" type="text" class="form-control" />
            </div>
            <button type="submit" class="btn btn-default">submit</button>
        </form>
    </div>
</div>


<div class="row" style="border:1px solid #e1e1e8; margin-top:10px;">
    <h4>属性列表</h4>
    <div class="col-md-12">
        <table class="table table-bordered mytable-class" id="itemtable">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <th>comment</th>
            </tr>
            </thead>
            <tbody>
            <#list items as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <td>${item.comment!''}</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <h5>属性修改 -- 添加时不要填写id</h5>

    <div class="col-md-12">
        <form action="/admin/dynamicform/item/edit" class="form form-inline">
            <div class="form-group">
                <label for="id">ID</label>
                <input id="id" name="id" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="name">name</label>
                <input id="name" name="name" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="description">description</label>
                <input id="description" name="description" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="comment">comment</label>
                <input id="comment" name="comment" type="text" class="form-control" />
            </div>
            <button type="submit" class="btn btn-default">submit</button>
        </form>
    </div>
</div>

<div class="row" style="border:1px solid #e1e1e8;margin-top:10px; margin-bottom:30px;">
    <h4>属性组-属性关系列表</h4>
    <div class="col-md-12">
        <table class="table table-bordered mytable-class" id="itemtable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>groupid</th>
                    <th>itemid</th>
                    <th>type</th>
                    <th>show data</th>
                    <th>is require</th>
                </tr>
            </thead>
            <tbody>
                <#list relations as r>
                <tr>
                    <td>${r.id}</td>
                    <td>${r.groupid}</td>
                    <td>${r.itemid}</td>
                    <td>${r.type}</td>
                    <td>${r.showData!''}</td>
                    <td>${r.isRequire!}</td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>

    <h5>修改 -- 添加时不要填写id</h5>

    <div class="col-md-12" >
        <form action="/admin/dynamicform/groupitem/edit" class="form">
            <div class="form-group">
                <label for="id">ID</label>
                <input id="id" name="id" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="groupid">groupid</label>
                <input id="groupid" name="groupid" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="itemid">itemid</label>
                <input id="itemid" name="itemid" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="type">type</label>
                <select id="type" name="type" class="form-control">
                    <option value="text">text</option>
                    <option value="selector">selector</option>
                    <option value="image">image</option>
                </select>
            </div>
            <div class="form-group">
                <label for="showData">showData</label>
                <input id="showData" name="showData" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="radio">isRequire</label>
                <div id="radio">
                    <label class="radio-inline">
                        <input type="radio" name="isRequire" value="1"> yes
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="isRequire" value="0"> no
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-default">submit</button>
        </form>
    </div>
</div>