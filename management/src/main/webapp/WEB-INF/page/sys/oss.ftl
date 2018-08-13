<!DOCTYPE html>
<html>
<head>
    <title>文件上传</title>
    <#include "header.ftl">
    <script src="${rc.contextPath}/statics/libs/ajaxupload.js"></script>
</head>
<body>
<div id="rrapp" v-cloak>
    <div v-show="showList">
        <div class="grid-btn">
            <i-button type="success" @click="addConfig"><i class="fa fa-sun-o"></i>&nbsp;云存储配置</i-button>
            <i-button type="primary" id="upload"><i class="fa fa-plus"></i>&nbsp;上传文件</i-button>
            <i-button type="error" @click="del"><i class="fa fa-trash-o"></i>&nbsp;删除</i-button>
            <i-button type="success" @click="lookImg"><i class="fa fa-eye"></i>&nbsp;预览</i-button>
        </div>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>

    <Card v-show="!showList">
        <p slot="title">{{title}}</p>
        <i-form :label-width="130">
            <Form-item label="存储类型" prop="type">
                <Radio-group v-model="config.type">
                    <Radio label="2">
                        <span>阿里云</span>
                    </Radio>
                    <Radio label="3">
                        <span>腾讯云</span>
                    </Radio>
                    <Radio label="1">
                        <span>七牛</span>
                    </Radio>
                </Radio-group>
            </Form-item>
            <i-form v-if="config.type == 1" ref="formValidate" :label-width="130">
                <Form-item>
                    <Alert type="info" show-icon>
                        <a href="http://www.renren.io/open/qiniu.html" target="_blank">免费申请(七牛)10GB储存空间</a>
                    </Alert>
                </Form-item>
                <Form-item label="域名" prop="qiniuDomain">
                    <i-input v-model="config.qiniuDomain" placeholder="七牛绑定的域名"/>
                </Form-item>
                <Form-item label="路径前缀" prop="qiniuPrefix">
                    <i-input v-model="config.qiniuPrefix" placeholder="不设置默认为空"/>
                </Form-item>
                <Form-item label="AccessKey" prop="qiniuAccessKey">
                    <i-input v-model="config.qiniuAccessKey" placeholder="七牛AccessKey"/>
                </Form-item>
                <Form-item label="SecretKey" prop="qiniuSecretKey">
                    <i-input v-model="config.qiniuSecretKey" placeholder="七牛SecretKey"/>
                </Form-item>
                <Form-item label="空间名" prop="qiniuBucketName">
                    <i-input v-model="config.qiniuBucketName" placeholder="七牛存储空间名"/>
                </Form-item>
            </i-form>
            <i-form v-if="config.type == 2" ref="formValidate" :model="config" :rules="aliRuleValidate"
                    :label-width="130">
                <Form-item label="域名" prop="aliyunDomain">
                    <i-input v-model="config.aliyunDomain" placeholder="阿里云绑定的域名"/>
                </Form-item>
                <Form-item label="路径前缀" prop="aliyunPrefix">
                    <i-input v-model="config.aliyunPrefix" placeholder="不设置默认为空"/>
                </Form-item>
                <Form-item label="EndPoint" prop="aliyunEndPoint">
                    <i-input v-model="config.aliyunEndPoint" placeholder="阿里云EndPoint"/>
                </Form-item>
                <Form-item label="AccessKeyId" prop="aliyunAccessKeyId">
                    <i-input v-model="config.aliyunAccessKeyId" placeholder="阿里云AccessKeyId"/>
                </Form-item>
                <Form-item label="AccessKeySecret" prop="aliyunAccessKeySecret">
                    <i-input v-model="config.aliyunAccessKeySecret" placeholder="阿里云AccessKeySecret"/>
                </Form-item>
                <Form-item label="BucketName" prop="aliyunBucketName">
                    <i-input v-model="config.aliyunBucketName" placeholder="阿里云BucketName"/>
                </Form-item>
            </i-form>
            <i-form ref="formValidate" :model="config" :rules="qcloudRuleValidate" v-if="config.type == 3"
                    :label-width="130">
                <Form-item label="域名" prop="qcloudDomain">
                    <i-input v-model="config.qcloudDomain" placeholder="腾讯云绑定的域名"/>
                </Form-item>
                <Form-item label="路径前缀" prop="qcloudPrefix">
                    <i-input v-model="config.qcloudPrefix" placeholder="不设置默认为空"/>
                </Form-item>
                <Form-item label="AppId" prop="qcloudAppId">
                    <i-input v-model="config.qcloudAppId" placeholder="腾讯云AppId"/>
                </Form-item>
                <Form-item label="SecretId" prop="qcloudSecretId">
                    <i-input v-model="config.qcloudSecretId" placeholder="腾讯云SecretId"/>
                </Form-item>
                <Form-item label="SecretKey" prop="qcloudSecretKey">
                    <i-input v-model="config.qcloudSecretKey" placeholder="腾讯云SecretKey"/>
                </Form-item>
                <Form-item label="BucketName" prop="qcloudBucketName">
                    <i-input v-model="config.qcloudBucketName" placeholder="腾讯云BucketName"/>
                </Form-item>
                <Form-item label="Bucket所属地区" prop="qcloudRegion">
                    <i-input v-model="config.qcloudRegion" placeholder="如：sh（可选值 ，华南：gz 华北：tj 华东：sh）"/>
                </Form-item>
            </i-form>
            <Form-item>
                <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                <i-button type="warning" @click="reload" style="margin-left: 8px">返回</i-button>
                <i-button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</i-button>
            </Form-item>
        </i-form>
    </Card>
</div>

<script src="${rc.contextPath}/js/sys/oss.js?_${date.systemTime}"></script>
</body>
</html>
