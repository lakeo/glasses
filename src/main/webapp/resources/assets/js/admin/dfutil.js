$(function(){
    var MyTableCollection = Backbone.Collection.extend({

    });
    var MyTableView = Backbone.View.extend({
        initialize: function(){
            this.listenToOnce(this.model,'reset',this.render);
            this.model.fetch({
                reset:true,
                error: function() {
                    alert('The Internet has problems');
                }
            });
        },
        events: {
            'click tbody tr .add': 'event_add',
            'click tbody tr .save': 'event_save',
            'click tbody tr .edit': 'event_edit'
        },
        event_add: function(e) {
            var cols = $(this.tableheader).length;
            var txt = '<tr>';
            for(i=0; i<cols-1; i++) {
                txt += '<td><input type="text" name="'+this.tableheader[i]['name']+'"'+this.tableheader[i]['edit']+'/></td>';
            }
            txt += '<td><a href="javascript:void(0)" class="add">add</a></td></tr>';
            this.$('tbody').append(txt);
        },
        event_edit: function(e) {
            var tr = $(e.target).closest('tr');
            var inputs = tr && tr.children('input');
            $.each(inputs, function(input){
                console.log(input);
            });
        },
        render: function(){
            console.log('in render');
        }
    });

    var groupcollection = new (MyTableCollection.extend({
        url:'/admin/dynamicform/group/all',
        parse: function(response) {
            if(response.type != 0) {
                alert('The Internet has problems');
                return;
            }
            console.log(response.args.data);
            return response.args.data;
        }
    }));

    var groupheader = [
        {name:'id', edit:'readonly'},
        {name:'name',edit:''},
        {name:'description',edit:''},
        {name:'op',edit:''}];
    var groupview = new (MyTableView.extend({
        model:groupcollection,
        el:'#grouptable',
        tableheader:groupheader
    }));
});