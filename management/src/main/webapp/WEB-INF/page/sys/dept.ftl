<!DOCTYPE html>
<html>
<head>
    <title>部门管理</title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <div class="grid-btn">
            <#if shiro.hasPermission("sys:dept:save")>            <i-button type="info" @click="add"><i class="fa fa-plus"></i>&nbsp;新增</i-button>
            </#if>            <#if shiro.hasPermission("sys:dept:update")>            <i-button type="warning" @click="update"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</i-button>
            </#if>            <#if shiro.hasPermission("sys:dept:delete")>            <i-button type="error" @click="del"><i class="fa fa-trash-o"></i>&nbsp;删除</i-button>
            </#if>        </div>
        <table id="deptTable" data-mobile-responsive="true" data-click-to-select="true">
            <thead>
            <tr>
                <th data-field="selectItem" data-checkbox="true"></th>
            </tr>
            </thead>
        </table>
    </div>

    <Card v-show="!showList">
        <p slot="title">{{title}}</p>
        <i-form ref="formValidate" :model="dept" :rules="ruleValidate" :label-width="80">
            <Form-item label="部门名称" prop="name">
                <i-input v-model="dept.name" placeholder="部门名称"/>
            </Form-item>

            <Form-item label="上级部门" prop="deptName">
                <i-input type="text" v-model="dept.parentName" icon="eye" readonly="readonly"
                         @on-click="deptTree" readonly="readonly" placeholder="一级部门"/>
            </Form-item>
            <Form-item label="排序号" prop="orderNum">
                <Input-number :min="0" :step="1" v-model="dept.orderNum" placeholder="排序号" style="width: 188px;"/>
            </Form-item>
            <Form-item>
                <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                <i-button type="warning" @click="reload" style="margin-left: 8px">返回</i-button>
            </Form-item>
        </i-form>
    </Card>
</div>

<!-- 选择部门 -->
<div id="deptLayer" style="display: none;padding:10px;">
    <ul id="deptTree" class="ztree"></ul>
</div>
<script src="${rc.contextPath}/js/urls.js?_${.now?string("yyyyMMddHHmmss")}"></script>
<script src="${rc.contextPath}/js/sys/dept.js?_${.now?string("yyyyMMddHHmmss")}"></script>
</body>
</html>
