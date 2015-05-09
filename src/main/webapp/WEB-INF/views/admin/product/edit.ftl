<div class="row" id="create_div">
    <h3>方案编辑</h3>
    <div class="col-md-10">
    <form class="form form-horizontal" action="" method="post" id="test_form">
        <div class="container-fluid df-form-container">
            <h4>基本信息</h4>
            <div class="form-group">
                <label for="productid" class="col-sm-2 control-label">方案ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="productid" id="productid" value="${product.id}" readonly>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="name" placeholder="name" value="${product.name}" readonly>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="description" id="description" placeholder="description" value="${product.description!''}">
                </div>
            </div>
            <div class="form-group">
                <label for="levelone" class="col-sm-2 control-label">一级品类</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="levelone" id="levelone" readonly value="${product.type1id}" >
                </div>
            </div>
            <div class="form-group">
                <label for="levelone" class="col-sm-2 control-label">二级品类</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="levelone" id="levelone" readonly value="${product.type2id}">
                </div>
            </div>
        </div>
    </form>
    </div>
</div>


<script type="text/javascript" src="/resources/assets/js/jquery-ui.custom.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/echo.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/jquery.rateit.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/jquery.jcarousel.js"></script>
<script type="text/javascript" src="/resources/assets/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="/resources/assets/js/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/jquery.fitvids.js"></script>
<script type="text/javascript" src="/resources/assets/js/lightbox.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/wow.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/scripts.js"></script>
<script type="text/javascript" src="/resources/assets/js/underscore-min.js"></script>
<script type="text/javascript" src="/resources/assets/js/backbone-min.js"></script>
<script type="text/javascript" src="/resources/assets/js/admin/df/df.js"></script>

<script>
    $(function(){
        var form = MyDynamicForm.create({
            el:'#test_form',
            dataurl:'/admin/dynamicform/product/data/1',
            showurl:'/admin/dynamicform/product/show/2'
        });
    });
</script>
