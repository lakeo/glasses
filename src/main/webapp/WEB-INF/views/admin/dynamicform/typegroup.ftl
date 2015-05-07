<div class="row" id="select_div">
    <div class="col-md-6">
        <select id="levelone" class="form-control">
            <option>一级品类</option>
        </select>
    </div>
    <div class="col-md-6">
        <select id="leveltwo" class="form-control">
            <option>二级品类</option>
        </select>
    </div>

    <h4>group列表</h4>
    <div class="col-md-12">
        <table class="table table-bordered mytable-class" id="grouptable">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
            </tr>
            </thead>
            <tbody>
            <#list groups as g>
            <tr>
                <td>${g.id}</td>
                <td>${g.name}</td>
                <td>${g.description}</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <h4>对应关系表列表(typeid = ${typeid!0})</h4>
    <div class="col-md-12">
        <table class="table table-bordered mytable-class">
            <thead>
            <tr>
                <th>id</th>
                <th>typeid</th>
                <th>groupid</th>
            </tr>
            </thead>
            <tbody>
            <#list relations as r>
            <tr>
                <td>${r.id}</td>
                <td>${r.typeid}</td>
                <td>${r.groupid}</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <h5>增加对应关系</h5>

    <div class="col-md-12">
        <form action="/admin/dynamicform/typegroup/add" class="form form-inline">
            <div class="form-group">
                <label for="groupid">groupid</label>
                <input id="groupid" name="groupid" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="typeid">typeid</label>
                <input id="typeid" name="typeid" type="text" class="form-control" />
            </div>
            <button type="submit" class="btn btn-default">submit</button>
        </form>
    </div>
</div>

<script type="application/javascript" src="/resources/assets/js/admin/df/typegroup.js"></script>