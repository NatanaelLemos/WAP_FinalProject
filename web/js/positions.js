/* jshint esversion: 6 */
/* jshint browser: true */
$(()=>{
    "use strict";

    const tableType = $('#positionsTable').attr('data-type');
    const tableOptions = getTableOptions(tableType);

    function getTableOptions(tableType){
        if(tableType === 'application') {
            return applicationTableOptions();
        }else if(tableType === 'departments'){
            return departmentsTableOptions();
        }else if(tableType === 'employees'){
            return employeesTableOptions();
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
                { data: "description" },
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
                        showLoading($('body'));
                        window.location = `/positions/edit?id=${id}`;
                    }else{
                        if(!confirm('Are you sure?')){
                            return;
                        }

                        $.ajax({
                            url: `/positions?id=${id}`,
                            type: 'DELETE'
                        })
                        .done((res) => {
                            table.ajax.reload();
                        })
                        .fail((xhr, err, status) => {
                            alert(err);
                        });
                    }
                });
            },
            tableCallback: () => { }
        };
    }
    function departmentsTableOptions(){
        return {
            url: '/departments',
            columns: [
                { data: "name" },
                { data: "employeeNumber"},
                {
                    "data":"id",
                    "render": function (data ) {
                        console.log(data);
                        var link = "/employees?deptId="+data;

                        return "<a class='btn btn-warning' href='"+link+"'>"+
                            "<i class='fa fa-external-link'></i>Show</a>";
                    }
                },
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
                    var employeeNumber = data.employeeNumber;
                    if(btn.hasClass('edit')){
                        window.location.href = "/departments/edit?deptId="+id
                    }else{
                        if(employeeNumber != 0){
                            alert("A department containing employee(s) cannot be deleted");
                        }else {
                            if (!confirm('Are you sure?')) {
                                return;
                            }
                            $.ajax({
                                url: "/departments?deptId="+id,
                                type:"DELETE"
                            }).done(function() {
                                table.ajax.reload();
                            });

                        }
                    }
                });
            },
            tableCallback: () => { }
        };
    }

    function employeesTableOptions(){
        return {
            url: (function(){
                var employeeByDeptId = $("#employeeByDeptId").val();
                if(!employeeByDeptId){
                    console.log("1");
                    return "/employees";
                }else {
                    console.log("2");
                    return "/employees?deptId=" + employeeByDeptId;
                }
            })(),
            columns: [
                {data: "name" },
                {data: "positionName"},
                {data: "departmentName"},
                {data: "managerName"},
                {data: "salary"},
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
                        window.location.href = "/employees/edit?employeeId="+id;
                    }else{
                        if(!confirm('Are you sure?')){
                            return;
                        }
                        $.ajax({
                            url: "/employees?employeeId="+id,
                            type:"DELETE"
                        }).done(function() {
                            table.ajax.reload();
                        });
                    }
                });
            },
            tableCallback: () => { }
        };
    }
});