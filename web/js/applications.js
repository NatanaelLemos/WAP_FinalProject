/* jshint esversion: 6 */
/* jshint browser: true */
$(()=>{
    "use strict";

    const columns = [
        { data: "position" },
        { data: "applicant", },
        { data: "status" }
    ];

    if(userRole === 'JOB_APPLICANT'){
        columns.push({
            "targets": -1,
            "data": null,
            "defaultContent": "",
            "width": "95px"
        });
    } else {
        columns.push({
            "targets": -1,
            "data": null,
            "defaultContent": "<button type='button' class='btn btn-primary interviewed' title='Interviewed'><i class='fa fa-pencil'></i></button>" +
                              "<button type='button' class='btn btn-danger rejected' title='Rejected'><i class='fa fa-minus-circle'></i></button>" +
                              "<button type='button' class='btn btn-success accepted' title='Accepted'><i class='fa fa-check-circle'></i></button>",
            "width": "95px"
        });
    }

    let table = $('#applicationsTable').DataTable({
        ajax: {
            url: '/applications',
            type: 'POST'
        },
        paging: true,
        pagingType: "full_numbers",
        serverSide: true,
        "bAutoWidth": false,
        "processing": true,
        columns: columns,
        searching: false,
        scrollX: true,
        scrollCollapse: true,
        bLengthChange: false,
        ordering: false,
        bDestroy: true,
        fnDrawCallback: () => {
            $('#applicationsTable tbody tr').each(function (idx, el) {
                const row = $(this);

                const data = table.row(row).data();
                if (!data) { return; }

                if(data.status == 'Interviewed'){
                    row.find('.interviewed').attr('disabled', 'disabled');
                } else if(data.status == 'Rejected' || data.status == 'Accepted') {
                    row.find('.interviewed').attr('disabled', 'disabled');
                    row.find('.rejected').attr('disabled', 'disabled');
                    row.find('.accepted').attr('disabled', 'disabled');
                }
            });
        }
    });

    $('#applicationsTable tbody').on('click', 'button', function () {
        const btn = $(this);
        const data = table.row($(this).parents('tr')).data();
        const id = data.id;

        let status = '';

        if(btn.hasClass('interviewed')){
            status = 'interviewed';
        }else if(btn.hasClass('rejected')){
            if(!confirm('Are you sure?')){
                return;
            }

            status = 'rejected';
        }else if(btn.hasClass('accepted')){
            if(!confirm('Are you sure?')){
                return;
            }
            status = 'accepted';
        }else{
            return;
        }

        $.post('/applications/edit', { id: id, status: status })
            .done(() => {
                table.ajax.reload();
            })
            .fail((xhr, err, status) => {
                alert(err);
            });
    });
});