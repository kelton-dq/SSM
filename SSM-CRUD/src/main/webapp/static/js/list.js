window.onload = function () {
    var vue = new Vue({
        el: "#div",
        data: {
            pageInfo: {},
            dept: {},
            v_name: 0,
            v_email: 0,
            name_check: 0,
            empData: null
        },
        methods: {
            getList: function (pn) {
                axios({
                    method: "GET",
                    url: "emps",
                    params: {
                        pn: pn
                    }
                })
                    .then(function (value) {
                        var pageInfo = value.data.extend.pageInfo;
                        vue.pageInfo = pageInfo;
                    })
                    .catch(function (reason) {
                    });
            },
            to_page: function (pn) {
                axios({
                    method: "GET",
                    url: "emps",
                    params: {
                        pn: pn
                    }
                })
                    .then(function (value) {
                        var pageInfo = value.data.extend.pageInfo;
                        vue.pageInfo = pageInfo;
                    })
                    .catch(function (reason) {
                    });
            },
            getDept: function () {
                axios({
                    method: "GET",
                    url: "depts",
                })
                    .then(function (value) {
                        var dept = value.data.extend.depts;
                        vue.dept = dept;
                    })
                    .catch(function (reason) {
                    });
            },
            addEmp: function () {
                $("#empAddModal form")[0].reset();
                $("#empAddModal").modal({
                    backdrop: "static"
                });
                vue.v_name=0;
                vue.v_email=0;
                vue.name_check=0
            },
            saveEmp: function () {
                if (!this.validate_name() || !this.validate_email()) {
                    return false;
                }
                var addForm = $("#addForm").serialize();
                axios({
                    method: "POST",
                    url: "emp",
                    data: addForm
                })
                    .then(function (value) {
                        //alert(value.data.msg);
                        $("#empAddModal").modal("hide");
                        //this.$options.methods.to_page.bind(this)(vue.pageInfo.total);
                    })
                    .catch(function (reason) {
                    });
                this.to_page(vue.pageInfo.pages);
            },
            validate_name: function () {
                //1、拿到要校验的数据，使用正则表达式
                var empName = $("#empName_add_input").val();
                var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
                if (!regName.test(empName)) {
                    //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
                    //this.show_validate_msg("#empName_add_input", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
                    vue.v_name = 2;
                    vue.name_check = 0;
                    return false;
                }
                this.checkName(empName);
                if (vue.name_check == 2) {
                    return false;
                }
                /*                else {
                                    this.show_validate_msg("#empName_add_input", "success", "");
                                }*/
                vue.v_name = 1;
                return true;
            },
            checkName: function (empName) {
                axios({
                    method: "get",
                    url: "check",
                    params: {
                        empName: empName
                    }
                })
                    .then(function (value) {
                        if (value.data.code == 100) {
                            vue.name_check = 1;
                        } else {
                            vue.name_check = 2;
                            vue.v_name = 3;
                        }
                    })
                    .catch(function (reason) {
                    });
            },
            validate_email: function () {
                //2、校验邮箱信息
                var email = $("#email_add_input").val();
                var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if (!regEmail.test(email)) {
                    //alert("邮箱格式不正确");
                    //应该清空这个元素之前的样式
                    //this.show_validate_msg("#email_add_input", "error", "邮箱格式不正确");
                    /* $("#email_add_input").parent().addClass("has-error");
                    $("#email_add_input").next("span").text("邮箱格式不正确"); */
                    vue.v_email = 2;
                    return false;
                }
                /*else {
                    this.show_validate_msg("#email_add_input", "success", "");
                }*/
                vue.v_email = 1;
                return true;
            },
            validate_email1: function () {
                //2、校验邮箱信息
                var email = $("#email_update_input").val();
                var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if (!regEmail.test(email)) {
                    //alert("邮箱格式不正确");
                    //应该清空这个元素之前的样式
                    //this.show_validate_msg("#email_add_input", "error", "邮箱格式不正确");
                    /* $("#email_add_input").parent().addClass("has-error");
                    $("#email_add_input").next("span").text("邮箱格式不正确"); */
                    vue.v_email = 2;
                    return false;
                }
                /*else {
                    this.show_validate_msg("#email_add_input", "success", "");
                }*/
                vue.v_email = 1;
                return true;
            },
            editEmp: function (event) {
                vue.v_email=0;
                // var id = $(this).attr("data-num");
                var id = event.target.getAttribute('data-num');
                this.getEmp(id);
                $("#empName_update_static").text(vue.empData.empName);
                $("#email_update_input").val(vue.empData.email);
                $("#empUpdateModal input[name=gender]").val([vue.empData.gender]);
                $("#empUpdateModal select").val([vue.empData.dId]);
                $("#empUpdateModal").modal({
                    backdrop: "static"
                });
            },
            getEmp: function (empId) {
                axios({
                    method: "get",
                    url: "emp/"+ empId
                })
                    .then(function (value) {
                        vue.empData = value.data.extend.employee;
                    })
                    .catch(function (reason) {
                    });
            },
            updateEmp: function () {
                if (!this.validate_email1()) {
                    return false;
                }
                var editForm = $("#editForm").serialize();
                axios({
                    //put请求时tomcat不会将请求体数据封装成map
                    method: "PUT",
                    url: "emp/" + vue.empData.empId,
                    data: editForm
                })
                    .then(function (value) {
                        //alert(value.data.msg);
                        $("#empUpdateModal").modal("hide");
                        //this.$options.methods.to_page.bind(this)(vue.pageInfo.total);
                    })
                    .catch(function (reason) {
                    });
                this.to_page(vue.pageInfo.pageNum);
            },
            deleteEmp: function (event) {
                var id = event.target.getAttribute('data-num');
                this.getEmp(id);
                var empName = vue.empData.empName;
                // alert(empName);
                if(confirm("确认删除【"+empName+"】吗？")){
                    axios({
                        method: "DELETE",
                        url: "emp/" + id
                    })
                        .then(function (value) {
                            alert(value.data.msg);
                        })
                        .catch(function (reason) {
                        });
                }
                this.to_page(vue.pageInfo.pageNum);
            },
            selectAll : function () {
                //prop修改和读取dom原生属性的值
                $(".check_item").prop("checked",$("#check_all").prop("checked"));
            },
            isChecked: function () {
                //判断当前选择中的元素是否5个
                var flag = $(".check_item:checked").length==$(".check_item").length;
                $("#check_all").prop("checked",flag);
            },
            deleteAll: function () {
                var empNames = "";
                var del_idstr = "";
                $.each($(".check_item:checked"),function(){
                    //this
                    empNames += $("#empDelete_btn").parents("tr").find("td:eq(2)").text()+",";
                    //组装员工id字符串
                    del_idstr += $("#empDelete_btn").parents("tr").find("td:eq(1)").text()+"-";
                });
                //去除empNames多余的,
                empNames = empNames.substring(0, empNames.length-1);
                //去除删除的id多余的-
                del_idstr = del_idstr.substring(0, del_idstr.length-1);
                if(confirm("确认删除【"+empNames+"】吗？")){
                    axios({
                        method: "DELETE",
                        url: "emp/" + del_idstr
                    })
                        .then(function (value) {
                            alert(value.data.msg);
                        })
                        .catch(function (reason) {
                        });
                    this.to_page(vue.pageInfo.pageNum);
                }
            }
        },
        "beforeMount": function () {
            this.getList(1);
            this.getDept();
        }

    });

}