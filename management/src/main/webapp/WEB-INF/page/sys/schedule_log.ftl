<!DOCTYPE html>
<html>
<head>
<title>定时任务日志</title>
<#include "header.ftl"></head>
<body>
<div id="rrapp">
	<div class="grid-btn">
		<div class="form-group col-sm-2">
			<i-input v-model="q.jobId" @on-enter="query" placeholder="任务ID"/>
		</div>
		<i-button @click="query">查询</i-button>
		&nbsp;&nbsp;<i-button type="warning" @click="back">返回</i-button>
	</div>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
</div>

<script src="${rc.contextPath}/js/sys/schedule_log.js?_${date.systemTime}"></script>
</body>
</html>
