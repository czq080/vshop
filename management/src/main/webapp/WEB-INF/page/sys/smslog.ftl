<!DOCTYPE html>
<html>
<head>
    <title></title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <Row :gutter="16">
            <div class="search-group">
                <i-col span="4">
                    <i-input v-model="q.sendId" @on-enter="query" placeholder="发送编号"/>
                </i-col>
                <i-button @click="query">查询</i-button>
                <i-button @click="reloadSearch">重置</i-button>
            </div>
            <div class="buttons-group">
                <i-button type="success" @click="addConfig"><i class="fa fa-sun-o"></i>&nbsp;短信配置</i-button>
                <i-button type="info" @click="sendSms"><i class="ivu-icon ivu-icon-android-send"></i>&nbsp;发送短信
                </i-button>
            </div>
        </Row>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>

    <Card v-show="!showList">
        <p slot="title">{{title}}</p>
        <i-form ref="formValidate" :model="config" :rules="ruleValidate" :label-width="80">
            <Form-item label="短信类型" prop="type">
                <Radio-group v-model="config.type">
                    <Radio label="1">
                        <span>创瑞云SMS</span>
                    </Radio>
                </Radio-group>
            </Form-item>
            <Form-item label="发送域名" prop="domain">
                <i-input v-model="config.domain" placeholder="必填参数。用户签名"/>
            </Form-item>
            <Form-item label="用户名" prop="name">
                <i-input v-model="config.name" placeholder="用户名"/>
            </Form-item>
            <Form-item label="接口密钥" prop="pwd">
                <i-input v-model="config.pwd" placeholder="接口密钥"/>
            </Form-item>
            <Form-item label="签名" prop="sign">
                <i-input v-model="config.sign" placeholder="【公司简称】"/>
            </Form-item>
            <Form-item>
                <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                <i-button type="warning" @click="reload" style="margin-left: 8px"/>
                返回</i-button>
                <i-button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</i-button>
            </Form-item>
        </i-form>
    </Card>
</div>

<script src="${rc.contextPath}/js/sys/smslog.js?_${date.systemTime}"></script>
</body>
</html>
