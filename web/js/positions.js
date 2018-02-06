/* jshint esversion: 6 */
/* jshint browser: true */
$(()=>{
    "use strict";

    let table = $('#positionsTable').DataTable({
        ajax: {
            url: '/positions',
            type: 'POST'
        },
        paging: true,
        pagingType: "full_numbers",
        serverSide: true,
        "bAutoWidth": false,
        "processing": true,
        columns: [
            { data: "name" },
            { data: "description", },
            { data: "openPosition" },
            {
                "targets": -1,
                "data": null,
                "defaultContent": "<button type='button' class='btn btn-primary edit'><i class='fa fa-pencil'></i></button>" +
                                  "<button type='button' class='btn btn-danger delete'><i class='fa fa-minus-circle'></i></button>",
                "width": "95px"
            }
        ],
        searching: false,
        scrollX: true,
        scrollCollapse: true,
        bLengthChange: false,
        ordering: false,
        bDestroy: true
    });

    $('#positionsTable tbody').on('click', 'button', function () {
        var btn = $(this);
        var data = table.row($(this).parents('tr')).data();
        var id = data.id;

        if(btn.hasClass('edit')){
            alert('edit' + id);
        }else{
            if(!confirm('Are you sure?')){
                return;
            }
            alert('delete' + id);
        }
    });
});