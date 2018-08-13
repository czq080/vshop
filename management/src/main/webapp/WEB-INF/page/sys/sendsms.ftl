<!DOCTYPE html>
<html>
<head>
    <title></title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <Card>
        <i-form ref="formValidate" :model="smsLog" :rules="ruleValidate" :label-width="80">
            <Form-item label="发送时间" prop="stime">
                <Date-picker type="datetime" v-model="smsLog.stime" placeholder="发送时间，填写时已填写的时间发送，不填时为当前时间发送"
                             format="yyyy-MM-dd HH:mm:ss" style="width: 40%;"></Date-picker>
            </Form-item>
            <Form-item label="发送内容" prop="content">
                <i-input type="textarea" v-model="smsLog.content" placeholder="发送内容（1-500 个汉字）UTF-8编码"/>
            </Form-item>
            <Form-item label="手机号码" prop="mobile">
                <i-input type="textarea" v-model="smsLog.mobile" placeholder="手机号码。多个以英文逗号隔开"/>
            </Form-item>
            <Form-item>
                <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
            </Form-item>
        </i-form>
    </Card>
</div>
<script type="text/javascript">
    let vm = new Vue({
        el: '#rrapp',
        data: {
            smsLog: {
                type: 'pt'
            },
            ruleValidate: {
                content: [
                    {required: true, message: '发送内容不能为空', trigger: 'blur'}
                ],
                mobile: [
                    {required: true, message: '手机号码不能为空', trigger: 'blur'}
                ]
            }
        },
        methods: {
            handleSubmit: function (name) {
                handleSubmitValidate(this, name, function () {
                    vm.send();
                });
            },
            handleReset: function (name) {
                handleResetForm(this, name);
            },
            send: function () {
                let url = "../sys/smslog/sendSms";
                Ajax.request({
                    url: url,
                    params: JSON.stringify(vm.smsLog),
                    contentType: "application/json",
                    type: 'POST',
                    successCallback: function () {
                        alert('提交成功', function (index) {
                            vm.handleReset('formValidate');
                        });
                    }
                });
            }
        }
    });
</script>
</body>
</html>
