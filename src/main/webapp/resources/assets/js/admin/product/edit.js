$(function(){
    var form = MyDynamicForm.create({
        el:'#test_form',
        dataurl:'/admin/dynamicform/product/data/1',
        showurl:'/admin/dynamicform/product/show/2'
    });
    console.log(form);
});