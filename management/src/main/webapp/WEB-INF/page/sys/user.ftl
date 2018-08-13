<!DOCTYPE html>
<html>
<head>
    <title>管理员列表</title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <Row :gutter="16">
            <i-col span="4">
                <i-input v-model="q.username" @on-enter="query" placeholder="用户名"/>
            </i-col>
            <i-button @click="query">查询</i-button>
            <#if shiro.hasPermission("sys:user:save")>            <i-button type="info" @click="add"><i class="fa fa-plus"></i>&nbsp;新增</i-button>
            </#if>
            <#if shiro.hasPermission("sys:user:update")>            <i-button type="warning" @click="update"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</i-button>
            </#if>
            <#if shiro.hasPermission("sys:user:delete")>            <i-button type="error" @click="del"><i class="fa fa-trash-o"></i>&nbsp;删除</i-button>
            </#if>        </Row>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>

    <Card v-show="!showList">
        <p slot="title">{{title}}</p>
        <i-form ref="formValidate" :model="user" :rules="ruleValidate" :label-width="80">
            <Form-item label="用户名" prop="username">
                <i-input v-model="user.username" placeholder="登录账号"/>
            </Form-item>
            <Form-item label="所属部门" prop="deptName">
                <i-input type="text" v-model="user.deptName" icon="eye" readonly="readonly"
                         @on-click="deptTree" readonly="readonly" placeholder="所属部门"/>
            </Form-item>
            <Form-item label="邮箱" prop="email">
                <i-input v-model="user.email" placeholder="邮箱"/>
            </Form-item>

            <Form-item label="手机号" prop="mobile">
                <i-input v-model="user.mobile" placeholder="手机号"/>
            </Form-item>
            <Form-item label="角色" prop="roleIdList">
                <Checkbox-group v-model="user.roleIdList">
                    <Checkbox :label="role.roleId" v-for="role in roleList">{{role.roleName}}</Checkbox>
                </Checkbox-group>
            </Form-item>

            <Form-item label="状态" prop="status">
                <Radio-group v-model="user.status">
                    <Radio label="0">
                        <span>禁用</span>
                    </Radio>
                    <Radio label="1">
                        <span>正常</span>
                    </Radio>
                </Radio-group>
            </Form-item>
            <Form-item>
                <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                <i-button type="warning" @click="reload" style="margin-left: 8px">返回</i-button>
                <i-button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</i-button>
            </Form-item>
        </i-form>
    </Card>
</div>
<!-- 选择部门 -->
<div id="deptLayer" style="display: none;padding:10px;">
    <ul id="deptTree" class="ztree"></ul>
</div>
<script src="${rc.contextPath}/js/urls.js?_${.now?string("yyyyMMddHHmmss")}"></script>
<script src="${rc.contextPath}/js/sys/user.js?_${.now?string("yyyyMMddHHmmss")}"></script>
</body>
</html>
