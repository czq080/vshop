<!DOCTYPE html>
<html>
<head>
<title>代码生成器</title>
<#include "header.ftl"></head>
<body>
<div id="rrapp">
	<div class="grid-btn">
		<div class="form-group col-sm-2">
			<i-input v-model="q.tableName" @on-enter="query" placeholder="表名"/>
		</div>
		<i-button @click="query">查询</i-button>
		<i-button type="primary" @click="generator"><i class="fa fa-file-code-o"></i>&nbsp;生成代码</i-button>
	</div>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
</div>

<script src="${rc.contextPath}/js/sys/generator.js?_${date.systemTime}"></script>
</body>
</html>
