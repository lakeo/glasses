$(function(){
    var TypeCollection = Backbone.Collection.extend({
        url:"/admin/type/all",
        parse: function(response) {
            if(response.type != 0){
                alert(response.args.error);
                return;
            }
            console.log('parse data:',response.args.data);
            return response.args.data;
        }
    });
    var typeCollection = new TypeCollection;
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
            console.log('one');
        },
        event_leveltwo_select: function(){
            console.log('two',this.collection);
        },
        initlevelone: function() {
            var levelones = this.collection.where({'level':1});
            for(ll in levelones) {

            }
        },
        render: function(){
            console.log('in render');
        }
    });
    var selectdiv = new SelectDiv;
});