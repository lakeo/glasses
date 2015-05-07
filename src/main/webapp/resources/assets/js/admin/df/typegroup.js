$(function(){

    //type collection
    var TypeCollection = Backbone.Collection.extend({
        url:"/admin/type/all",
        parse: function(response) {
            if(response.type != 0){
                alert(response.args.error);
                return;
            }
            return response.args.data;
        }
    });
    var typeCollection = new TypeCollection;

    //view => refer to the two selectors
    var SelectDiv = Backbone.View.extend({
        collection:typeCollection,
        el:'#select_div',
        initialize: function(){
            this.listenToOnce(this.collection,'reset',this.initlevelone);
            this.collection.fetch({
                error:function(){
                    alert('The Internet has some problems');
                },
                reset:true
            });
        },
        events: {
            'change #levelone': 'event_levelone_select',
            'change #leveltwo': 'event_leveltwo_select'
        },
        event_levelone_select: function(){
            var pp = this.$('#levelone').val();
            if(pp == null || pp == 0) {
                return;
            }
            var opt = {
                parentid:parseInt(pp),
                level:2
            }

            var items = this.collection.where(opt);
            if($.isEmptyObject(items)) {
                console.log('level tow is emptry');
                return;
            }

            var twoselector = this.$('#leveltwo');
            twoselector.empty();
            twoselector.append('<option>二级品类</option>');
            $.each(items,function(index,value) {
                twoselector.append('<option value="'+value.get('id')+'">'+value.get('name')+'</option>');
            });
        },
        event_leveltwo_select: function(e){
            var typeid = $(e.target).val();
            if(typeid == null || typeid <= 0) {
                return;
            }
            $(location).attr('href','?typeid='+typeid);
        },
        initlevelone: function() {
            var levelones = this.collection.where({'level':1});
            var oneselector = this.$('#levelone');
            if($.isEmptyObject(levelones)) {
                console.log('level one is emptry');
                return;
            }
            oneselector.empty();
            oneselector.append('<option>一级品类</option>');
            $.each(levelones,function(index,value) {
                oneselector.append('<option value="'+value.get('id')+'">'+value.get('name')+'</option>');
            });
        },
        render: function(){
            console.log('in render');
        }
    });
    var selectdiv = new SelectDiv;
});