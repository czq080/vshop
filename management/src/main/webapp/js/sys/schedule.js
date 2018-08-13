$(function () {
    $("#jqGrid").jqGrid({
        url: uris.sysschedule_list,
        datatype: "json",
        colModel: [
            {label: '任务ID', name: 'jobId', width: 60, key: true},
            {label: 'class名称', name: 'className', width: 100},
            {label: '参数', name: 'params', width: 100},
            {label: 'cron表达式 ', name: 'cronExpression', width: 100},
            {label: '备注 ', name: 'remark', width: 100},
            {
                label: '状态', name: 'status', width: 60, formatter: function (value, options, row) {
                    if (value === 0)
                        return '<span class="label label-success">未运行</span>';
                    else if (value === 1)
                        return '<span class="label label-danger">暂停</span>';
                    else if (value === 2)
                        return '<span class="label label-info">运行中</span>';
                    else
                        return '<span class="label label-warning-light">未知</span>';
                }
            }
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        index: 0,
        q: {
            className: null
        },
        showList: true,
        title: null,
        schedule: {
            paramList: []
        },
        ruleValidate: {
            className: [
                {required: true, message: 'class名称不能为空', trigger: 'blur'}
            ],
            cronExpression: [
                {required: true, message: 'cron表达式不能为空', trigger: 'blur'}
            ]
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.index = 0;
            vm.schedule = {paramList: []};
        },
        update: function () {
            var jobId = getSelectedRow();
            if (jobId == null) {
                return;
            }

            $.get(uris.sysschedule_info_query + jobId, function (r) {
                vm.showList = false;
                vm.title = "修改";
                vm.schedule = r.data;
                vm.schedule.paramList = [];
                vm.index = 0;
                var params = eval('(' + r.data.params + ')');
                for (var item in params) {
                    if (typeof(params[item]) != "function")
                        vm.index++;
                    vm.schedule.paramList.push({
                        name: item,
                        value: params[item],
                        index: vm.index,
                        status: 1
                    });
                }
                // vm.schedule.paramList = ;
            });
        },
        saveOrUpdate: function (event) {
            var url = vm.schedule.jobId == null ? uris.sysschedule_save : uris.sysschedule_update;
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify(vm.schedule),
                success: function (r) {
                    if (r.code == 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var jobIds = getSelectedRows();
            if (jobIds == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: uris.sysschedule_delete,
                    contentType: "application/json",
                    data: JSON.stringify(jobIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        pause: function (event) {
            var jobIds = getSelectedRows();
            if (jobIds == null) {
                return;
            }

            confirm('确定要暂停选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: uris.sysschedule_pause,
                    contentType: "application/json",
                    data: JSON.stringify(jobIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        resume: function (event) {
            var jobIds = getSelectedRows();
            if (jobIds == null) {
                return;
            }

            confirm('确定要恢复选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: uris.sysschedule_resume,
                    contentType: "application/json",
                    data: JSON.stringify(jobIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        runOnce: function (event) {
            var jobIds = getSelectedRows();
            if (jobIds == null) {
                return;
            }

            confirm('确定要立即执行选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: uris.sysschedule_run,
                    contentType: "application/json",
                    data: JSON.stringify(jobIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'beanName': vm.q.beanName},
                page: page
            }).trigger("reloadGrid");
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        },
        handleAddParam: function () {
            vm.index++;
            vm.schedule.paramList.push({
                value: '',
                name: '',
                index: vm.index,
                status: 1
            });
        },
        handleRemoveParam: function (index) {
            vm.schedule.paramList[index].status = 0;
        }
    }
});