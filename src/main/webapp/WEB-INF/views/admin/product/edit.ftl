<div class="row" id="create_div">
    <h3>方案编辑</h3>
    <div class="col-md-10">
    <form class="form form-horizontal" action="" method="">
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
        <form class="form form-horizontal" action="" method="post" id="test_form">
            <input type="text" hidden name="productid" id="productid" value="${product.id}" readonly>
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
        //init df form
        var form = MyDynamicForm.create({
            el:'#test_form',
            dataurl:'/admin/dynamicform/product/data/${product.id}',
            showurl:'/admin/dynamicform/product/show/${product.type2id}'
        });

        //hook the submit
        $('#test_form').submit(function(event) {
            event.preventDefault();
            var elements = $(this).find('input[type=text], select, textarea');
            var data = [];
            var productid = 0;
            $.each(elements, function(index, element){
                if($(element).attr('name') != 'productid') {
                    data.push({name: $(element).attr('name'), value: $(element).val()})
                } else {

                    productid = $(element).val();
                }
            });
            data = JSON.stringify(data)
            var form = $('<form action="" method="post" ></form>');
            var frmProduct =  $('<input />',{name:'id', value:productid})
            var frmData = $('<input />', {name:'data',value:data})
            $(form).append(frmProduct);
            $(form).append(frmData);
            $(form).submit();
        })
    });
</script>
