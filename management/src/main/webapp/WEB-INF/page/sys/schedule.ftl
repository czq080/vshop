<!DOCTYPE html>
<html>
<head>
    <title>定时任务</title>
    <#include "header.ftl"></head>
<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <Row :gutter="16">
            <i-col span="4">
                <i-input v-model="q.beanName" @on-enter="query" placeholder="bean名称"/>
            </i-col>
            <i-button @click="query">查询</i-button>
            <#if shiro.hasPermission("sys:schedule:save")>
                <i-button type="info" @click="add"><i class="fa fa-plus"></i>&nbsp;新增</i-button>
            </#if>            <#if shiro.hasPermission("sys:schedule:update")>
            <i-button type="warning" @click="update"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</i-button>
        </#if>            <#if shiro.hasPermission("sys:schedule:delete")>
            <i-button type="error" @click="del"><i class="fa fa-trash-o"></i>&nbsp;删除</i-button>
        </#if>            <#if shiro.hasPermission("sys:schedule:pause")>
            <i-button type="dashed" @click="pause"><i class="fa fa-pause"></i>&nbsp;暂停</i-button>
        </#if>            <#if shiro.hasPermission("sys:schedule:resume")>
            <i-button type="primary" @click="resume"><i class="fa fa-play"></i>&nbsp;恢复</i-button>
        </#if>            <#if shiro.hasPermission("sys:schedule:run")>
            <i-button type="warning" @click="runOnce"><i class="fa fa-arrow-circle-right"></i>&nbsp;立即执行</i-button>
        </#if>            <#if shiro.hasPermission("sys:schedule:log")>            <a class="btn btn-primary"
                                                                                      style="float:right;"
                                                                                      href="schedule_log.html">日志列表</a>
        </#if>        </Row>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>
    <Row :gutter="16" v-show="!showList">
        <i-col span="12">
            <Card>
                <p slot="title">{{title}}</p>
                <i-form ref="formValidate" :model="schedule" :rules="ruleValidate" :label-width="80">
                    <Form-item label="bean名称" prop="className">
                        <i-input v-model="schedule.className" placeholder="class名称，如：com.xxx.xxx.Test(实现了Job接口)"/>
                    </Form-item>
                    <Form-item
                            v-for="(item, index) in schedule.paramList"
                            v-if="item.status"
                            :key="index"
                            :label="'参数 ' + item.index">
                        <i-row>
                            <i-col span="8">
                                <i-input type="text" v-model="schedule.paramList[index].name" placeholder="请输入参数名"></i-input>
                            </i-col>
                            <i-col span="8">
                            <i-input type="text" v-model="schedule.paramList[index].value" placeholder="请输入参数值"></i-input>
                            </i-col>
                            <i-col span="4" offset="1">
                            <i-button type="ghost" @click="handleRemove(index)">删除</i-button>
                            </i-col>
                        </i-row>
                    </Form-item>
                    <Form-item>
                        <i-row>
                            <i-col span="12">
                                <i-button type="dashed" long @click="handleAddParam" icon="plus-round"></i-button>
                            </i-col>
                        </i-row>
                    </Form-item>
                    <Form-item label="cron表达式" prop="cronExpression">
                        <i-input v-model="schedule.cronExpression" placeholder="如：0 0 12 * * ?"/>
                    </Form-item>
                    <Form-item label="备注" prop="remark">
                        <i-input type="textarea" v-model="schedule.remark" placeholder="备注"/>
                    </Form-item>
                    <Form-item>
                        <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                        <i-button type="warning" @click="reload" style="margin-left: 8px">返回</i-button>
                        <i-button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置
                        </i-button>
                    </Form-item>
                </i-form>
            </Card>
        </i-col>
        <i-col span="12">
            <Card>
                <p slot="title" style="text-align: center">常用Cron表达式</p>
                <div class="panel-body">
                    <div class="col-sm-4 control-label">0 15 10 * * ? *</div>
                    <div class="col-sm-8 control-label">每天10点15分触发</div>
                    <div class="col-sm-4 control-label">0 15 10 * * ? 2017</div>
                    <div class="col-sm-8 control-label">2017年每天10点15分触发</div>
                    <div class="col-sm-4 control-label">0 * 14 * * ?</div>
                    <div class="col-sm-8 control-label">每天下午的 2点到2点59分每分触发</div>
                    <div class="col-sm-4 control-label">0 0/5 14 * * ?</div>
                    <div class="col-sm-8 control-label">每天下午的 2点到2点59分(整点开始，每隔5分触发)</div>
                    <div class="col-sm-4 control-label">0 0/5 14,18 * * ?</div>
                    <div class="col-sm-8 control-label">每天下午的 2点到2点59分、18点到18点59分(整点开始，每隔5分触发)</div>
                    <div class="col-sm-4 control-label">0 0-5 14 * * ?</div>
                    <div class="col-sm-8 control-label">每天下午的 2点到2点05分每分触发</div>
                    <div class="col-sm-4 control-label">0 15 10 ? * 6L</div>
                    <div class="col-sm-8 control-label">每月最后一周的星期五的10点15分触发</div>
                    <div class="col-sm-4 control-label">0 15 10 ? * 6#3</div>
                    <div class="col-sm-8 control-label">每月的第三周的星期五开始触发</div>
                </div>
            </Card>
        </i-col>
    </Row>
</div>
<script src="${rc.contextPath}/js/urls.js?_${.now?string("yyyyMMddHHmmss")}"></script>
<script src="${rc.contextPath}/js/sys/schedule.js?_${.now?string("yyyyMMddHHmmss")}"></script>
</body>
</html>
