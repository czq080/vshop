<!DOCTYPE html>
<html>
<head>
    <title>系统日志</title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <Row :gutter="16">
        <i-col span="4">
            <i-input v-model="q.key" @on-enter="query" placeholder="用户名、用户操作"/>
        </i-col>
        <Checkbox-group v-model="isLogin" @on-change="query" class="inline">
            <Checkbox label="登录"><span>登录日志</span></Checkbox>
        </Checkbox-group>
        <i-button @click="query">查询</i-button>
    </Row>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
</div>

<script src="${rc.contextPath}/js/sys/log.js?_${date.systemTime}"></script>
</body>
</html>
