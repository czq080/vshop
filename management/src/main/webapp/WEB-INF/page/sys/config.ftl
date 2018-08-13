<!DOCTYPE html>
<html>
<head>
    <title>参数管理</title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <Row :gutter="16">
            <i-col span="4">
                <i-input v-model="q.key" @on-enter="query" placeholder="参数名"/>
            </i-col>
            <i-button @click="query">查询</i-button>

            <i-button type="info" @click="add"><i class="fa fa-plus"></i>&nbsp;新增</i-button>
            <i-button type="warning" @click="update"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</i-button>
            <i-button type="error" @click="del"><i class="fa fa-trash-o"></i>&nbsp;删除</i-button>
        </Row>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>

    <Card v-show="!showList">
        <p slot="title">{{title}}</p>
        <i-form ref="formValidate" :model="config" :rules="ruleValidate" :label-width="80">
            <Form-item label="参数名" prop="key">
                <i-input v-model="config.key" placeholder="参数名"/>
            </Form-item>
            <Form-item label="参数值" prop="value">
                <i-input v-model="config.value" placeholder="参数值"/>
            </Form-item>
            <Form-item label="备注" prop="remark">
                <i-input type="textarea" v-model="config.remark" placeholder="备注"/>
            </Form-item>
            <Form-item>
                <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                <i-button type="warning" @click="reload" style="margin-left: 8px">返回</i-button>
                <i-button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</i-button>
            </Form-item>
        </i-form>
    </Card>
</div>
<script src="${rc.contextPath}/js/urls.js?_${.now?string("yyyyMMddHHmmss")}"></script>
<script src="${rc.contextPath}/js/sys/config.js?_${.now?string("yyyyMMddHHmmss")}"></script>
</body>
</html>
