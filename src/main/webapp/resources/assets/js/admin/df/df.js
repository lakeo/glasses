(function(root, factory){
    root.MyDynamicForm = factory({});
}(this,function(MyDynamicForm){
    var mdf = MyDynamicForm;
    /*
    config: {
        el,
        showurl,
        dataurl
    }
    * */
    var utils = mdf.utils = {};
    utils.addDom = function(el, item) {
        if(item.type == 'group') {
            utils.addgroup(el,item);
        } else {
            utils.additem(el,item);
        }
    }
    utils.addgroup = function(el,group) {
        $(el).append(utils.getGroupDOM(group));
    };
    utils.getGroupDOM = function(group) {
        var container = $('<div class="container-fluid df-form-container"></div>');
        $(container).append('<h4>'+group.description+'</h4>');
        if(!$.isEmptyObject(group.data)){
            $.each(group.data, function(index, item){
                utils.addDom(container,item);
            });
        }
        return container;
    }
    utils.getItemDOM = function(item) {
        var container = $('<div class="form-group"></div>');
        container.append('<label for="'+item.name+'" class="col-sm-2 control-label">'+item.description+'</label>');
        container.append('<div class="col-sm-10"> <input type="text" class="form-control" name="'+item.name+'" id="'+item.name+'" value="'+item.data+'"></div>');
        return container;
    }
    utils.additem = function(el, item) {
        $(el).append(utils.getItemDOM(item));
    }
    utils.setdata = function(el,data) {
        $.each(data, function(index, item) {
            $(el).find('input[name="'+item.name+'"]').val(item.value);
        });
    }
    utils.addSubmitBtn = function(el) {
        $(el).append('<div class="form-group"><div class="col-sm-offset-2 col-sm-10"> <input type="submit" value="修改" class="btn btn-default"> </div> </div>');
    }
    mdf.utils = utils;
    mdf.create = function(config) {
        var dataurl = config.dataurl;
        var showurl = config.showurl;
        var el = config.el;
        var dataModel = new (Backbone.Model.extend({
            url:dataurl,
            parse:function(response) {
                if(response.type != 0){
                    alert(response.args.error);
                    return;
                }
                return response.args;
            }
        }));
        var showModel = new (Backbone.Model.extend({
            url:showurl,
            parse:function(response) {
                if(response.type != 0){
                    alert(response.args.error);
                    return;
                }
                return response.args;
            }
        }));

        return new ( Backbone.View.extend({
            el: el,
            initialize:function() {
                this.dataModel = dataModel;
                this.showModel = showModel;
                this.listenToOnce(this.showModel,'change',this.showform);
                this.listenToOnce(this.dataModel,'change',this.setformdata);
                this.dataModel.listenToOnce(this.showModel,'change',this.getdata);
                this.showModel.fetch({
                    error:function(){
                        alert('The Internet has some problems');
                    }
                });
            },
            showform:function(e) {
                items = this.showModel.get('data');
                el = this.el;
                $.each(items,function(index,item) {
                    mdf.utils.addDom(el,item);
                });
                mdf.utils.addSubmitBtn(el);
            },

            setformdata:function(e) {
                mdf.utils.setdata(this.el, this.dataModel.get('data'));
            },

            getdata:function(e) {
                //this here stand for datamodel
                this.fetch({
                    error:function(){
                        alert('The Internet has some problems');
                    }
                });
            }
        }));
    }
    return mdf;
}));