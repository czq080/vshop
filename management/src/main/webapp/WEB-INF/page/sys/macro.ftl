<!DOCTYPE html>
<html>
<head>
    <title>通用字典表</title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <Row :gutter="16">
            &nbsp;&nbsp;
            <i-button type="ghost" @click="reload"><i class="fa fa-refresh"></i>&nbsp;刷新</i-button>
            <#if shiro.hasPermission("sys:macro:save")>            <i-button type="info" @click="add"><i class="fa fa-plus"></i>&nbsp;新增</i-button>
            </#if>            <#if shiro.hasPermission("sys:macro:update")>            <i-button type="warning" @click="update"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</i-button>
            </#if>            <#if shiro.hasPermission("sys:macro:delete")>            <i-button type="error" @click="del"><i class="fa fa-trash-o"></i>&nbsp;删除</i-button>
            </#if>        </Row>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>

    <Card v-show="!showList">
        <p slot="title">{{title}}</p>
        <i-form ref="formValidate" :model="macro" :rules="ruleValidate" :label-width="80">
            <Form-item label="类型" prop="type">
                <Radio-group v-model="macro.type">
                    <Radio label="0">
                        <span>目录</span>
                    </Radio>
                    <Radio label="1">
                        <span>参数配置</span>
                    </Radio>
                </Radio-group>
            </Form-item>
            <Form-item label="状态">
                <Radio-group v-model="macro.status">
                    <Radio label="0">
                        <span>隐藏</span>
                    </Radio>
                    <Radio label="1">
                        <span>显示</span>
                    </Radio>
                </Radio-group>
            </Form-item>
            <Form-item v-if="macro.type==1" label="父级" prop="parentId" style="width: 268px;">
                <i-select v-model="macro.parentId" filterable>
                    <i-option v-for="macro in macros" :value="macro.id" :key="macro.id">{{macro.name}}</i-option>
                </i-select>
            </Form-item>
            <Form-item label="名称" prop="name">
                <i-input v-model="macro.name" placeholder="名称"/>
            </Form-item>
            <Form-item label="值" prop="value">
                <i-input v-model="macro.value" placeholder="值"/>
            </Form-item>
            <Form-item label="排序" prop="orderNum">
                <Input-number :min="0" :step="1" v-model="macro.orderNum" placeholder="排序" style="width: 188px;"/>
            </Form-item>
            <Form-item label="备注" prop="remark">
                <i-input type="textarea" v-model="macro.remark" placeholder="备注"/>
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
<script src="${rc.contextPath}/js/urls.js?_${.now?string("yyyyMMddHHmmss")}"></script>
<script src="${rc.contextPath}/js/sys/macro.js?_${.now?string("yyyyMMddHHmmss")}"></script>
</body>
</html>
