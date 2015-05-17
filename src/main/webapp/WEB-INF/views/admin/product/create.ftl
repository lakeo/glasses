<div class="row" id="create_div">
    <h3>方案创建</h3>
    <form class="form form-horizontal" action="" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" placeholder="name">
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="description" id="description" placeholder="description">
            </div>
        </div>
        <div class="form-group">
            <label for="levelone" class="col-sm-2 control-label">一级品类</label>
            <div class="col-sm-10">
                <select id="levelone" class="form-control" name="type1id">
                    <option>一级品类</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="levelone" class="col-sm-2 control-label">二级品类</label>
            <div class="col-sm-10">
                <select id="leveltwo" class="form-control" name="type2id">
                    <option>二级品类</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="创建" class="btn btn-default">
            </div>
        </div>
    </form>
</div>

<script>
    MYJS_FILES = ['/resources/assets/js/admin/product/create.js']
</script>