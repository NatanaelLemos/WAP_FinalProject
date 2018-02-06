/* jshint esversion: 6 */
/* jshint browser: true */
$(()=>{
    "use strict";

    const tableType = $('#positionsTable').attr('data-type');
    const tableOptions = getTableOptions(tableType);

    function getTableOptions(tableType){
        if(tableType === 'application') {
            return applicationTableOptions();
        }else{
            return positionsTableOptions();
        }
    }

    let table = $('#positionsTable').DataTable({
        ajax: {
            url: tableOptions.url,
            type: 'POST'
        },
        paging: true,
        pagingType: "full_numbers",
        serverSide: true,
        "bAutoWidth": false,
        "processing": true,
        columns: tableOptions.columns,
        searching: false,
        scrollX: true,
        scrollCollapse: true,
        bLengthChange: false,
        ordering: false,
        bDestroy: true,
        fnDrawCallback: tableOptions.tableCallback
    });

    tableOptions.tableClick();

    function applicationTableOptions() {
        return {
            url: '/application',
            columns: [
                { data: "name" },
                { data: "description", },
                {
                    "targets": -1,
                    "data": null,
                    "defaultContent": `<button type='button' class='btn btn-success edit' disabled>
                                            <i class='fa fa-check-circle'></i>
                                            Already Applied &nbsp;&nbsp;&nbsp;
                                        </button>`,
                    "width": "95px"
                }
            ],
            tableClick: () => {
                $('#positionsTable tbody').on('click', 'button', function () {
                    var btn = $(this);
                    var data = table.row($(this).parents('tr')).data();
                    var id = data.id;

                    showLoading($('#positionsTable'));
                    $.post('/application/new', {id: id})
                    .done(() =>{
                        btn
                        .removeClass('btn-primary')
                        .addClass('btn-success')
                        .attr('disabled', 'disabled')
                        .html('<i class="fa fa-check-circle"></i> Already Applied &nbsp;&nbsp;&nbsp;');
                    })
                    .fail((xhr, err, status) => {
                        alert(err);
                    })
                    .always(() => {
                        hideLoading($('#positionsTable'));
                    });
                });
            },
            tableCallback: () => {
                $('#positionsTable tbody tr').each(function (idx, el) {
                    const row = $(this);

                    const data = table.row(row).data();
                    if (!data) { return; }

                    $.get('/application/new', { id: data.id })
                    .done((res) => {
                        if(res.applied === false) {
                            row.find('button')
                            .removeClass('btn-success')
                            .addClass('btn-primary')
                            .removeAttr('disabled')
                            .html('<i class="fa fa-check-circle"></i> Apply for this position');
                        }
                    })
                    .fail((xhr, err, status) => {
                        alert(err);
                    });
                });
            }
        };
    }

    function positionsTableOptions(){
        return {
            url: '/positions',
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
            tableClick: () => {
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
            },
            tableCallback: () => { }
        };
    }
});