<!DOCTYPE html>
<html>
<head>
    <title>菜单管理</title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <Row :gutter="16">
            &nbsp;&nbsp;
            <i-button type="ghost" @click="reload"><i class="fa fa-refresh"></i>&nbsp;刷新</i-button>
            <#if shiro.hasPermission("sys:menu:save")>            <i-button type="info" @click="add"><i class="fa fa-plus"></i>&nbsp;新增</i-button>
            </#if>            <#if shiro.hasPermission("sys:menu:update")>            <i-button type="warning" @click="update"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</i-button>
            </#if>            <#if shiro.hasPermission("sys:menu:delete")>            <i-button type="error" @click="del"><i class="fa fa-trash-o"></i>&nbsp;删除</i-button>
            </#if>        </Row>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>

    <Card v-show="!showList">
        <p slot="title">{{title}}</p>
        <i-form ref="formValidate" :model="menu" :rules="ruleValidate" :label-width="80">
            <Form-item label="类型" prop="type">
                <Radio-group v-model="menu.type">
                    <Radio label="0">
                        <span>目录</span>
                    </Radio>
                    <Radio label="1">
                        <span>菜单</span>
                    </Radio>
                    <Radio label="2">
                        <span>按钮</span>
                    </Radio>
                </Radio-group>
            </Form-item>
            <Form-item label="菜单名称" prop="name">
                <i-input v-model="menu.name" placeholder="菜单名称或按钮名称"/>
            </Form-item>

            <Form-item label="上级菜单" v-if="menu.type == 2" prop="parentName">
                <i-input v-model="menu.parentName" @on-click="menuTree" icon="eye" readonly="readonly"
                         placeholder="一级菜单"/>
            </Form-item>
            <Form-item label="上级菜单" v-if="menu.type != 2">
                <i-input v-model="menu.parentName" @on-click="menuTree" icon="eye" readonly="readonly"
                         placeholder="一级菜单"/>
            </Form-item>

            <Form-item v-if="menu.type == 1" label="菜单URL" prop="url">
                <i-input v-model="menu.url" placeholder="菜单URL"/>
            </Form-item>
            <Form-item v-if="menu.type == 1 || menu.type == 2" label="授权标识" prop="perms">
                <i-input v-model="menu.perms" placeholder="多个用逗号分隔，如：user:list,user:create"/>
            </Form-item>
            <Form-item v-if="menu.type != 2" label="排序号" prop="orderNum">
                <Input-number :min="0" :step="1" v-model="menu.orderNum" placeholder="排序号" style="width: 188px;"/>
            </Form-item>
            <Form-item v-if="menu.type != 2" label="图标" prop="icon">
                <i-input v-model="menu.icon" placeholder="图标，点击右边按钮选取图标" @on-click="selectIcon" icon="eye"/>
            </Form-item>
            <Form-item label="状态" prop="status">
                <Radio-group v-model="menu.status">
                    <Radio label="0">
                        <span>有效</span>
                    </Radio>
                    <Radio label="1">
                        <span>无效</span>
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

<!-- 选择菜单 -->
<div id="menuLayer" style="display: none;padding:10px;">
    <ul id="menuTree" class="ztree"></ul>
</div>
<script src="${rc.contextPath}/js/urls.js?_${.now?string("yyyyMMddHHmmss")}"></script>
<script src="${rc.contextPath}/js/sys/menu.js?_${.now?string("yyyyMMddHHmmss")}"></script>
</body>
</html>
