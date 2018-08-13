package com.vigoss.wechat.enterprise.core.util;

public class Constants {
	
	public static final long time24=1000*60*60*24;
	public static final String top_datadir_info_parentid="0";
	public static final String LOGIN_COMSUMER="login_consumer";
	public static final String LOGINUSER_OPENID="UserOpenid";
	public static final String LOGINUSER_CARD_TYPE="LOGINUSER_CARD_TYPE";
	public static final String Register_Action_TYPE = "Register_Action_TYPE";
	public static final String LOGINUSER_ACCOUNTID="UserAccountid";
	public static final String bindValidataCode="bindValidataCode";
	/**/
	public static final String SubscribeReplay="SubscribeReplay";
	
	public static final String WX_UNBIND_DEBIT_CARD_MSG="WX_UNBIND_DEBIT_CARD_MSG";
	public static final String WX_UNBIND_CREDIT_CARD_MSG="WX_UNBIND_CREDIT_CARD_MSG";
	
	public static final String SMS_SEND_CONTENT_MSG="SMS_SEND_CONTENT_MSG";
	
	public static final String Session_Check_Image="Session_Check_Image";

	public static final String LOCAL_RUNNING="N";
	
	public static final int userid_num=6;

    public static final String BelongArea = "BelongArea";//所属区域父ID
	/**
	 * 客戶禁用
	 */
	public static final String consumer_active_status_nouse="0";
	/**
	 * 客戶启用
	 */
	public static final String consumer_active_status_use="1";
	public static final int bindweixin=1;//绑定
	public static final int unbindweixin=0;//解绑
	/**
	 * 微信回复方式 NEWS：图文
	 */
	public static final String weixin_replay_type_news="NEWS";//
	public static final String weixin_replay_type_module="MODULE";//
	/**
	 * 借记卡
	 */
	public static final String debitCard="debitCard";
	/**
	 * 公务卡
	 */
	public static final String creditCard="creditCard";
	
	public static final String isvalidata="0";
	public static final String notvalidata="1";
	
	/**
	 * 解绑
	 */
	public static final String unbind_all="unbind_all";
	
	public static final int consumer_lock=1;
	public static final int consumer_unlock=0;
	/**
	 * 0：判断用户是否被锁，若被锁超过24小时，则解锁 
	 */
	public static final int check_type_0=0;
	/**
	 * 密码错误增加错误次数
	 */
	public static final int check_type_1=1;
	
	/**
	 *签约
	 */
	public static final String notify_bind="1";
	/**
	 * 解约
	 */
	public static final String notify_unbind="2";
	/**
	 * 贷款申请应用ID
	 */
	public static final String qy_agentid="qy_agentid";
	/**
	 * 注册应用ID
	 */
	public static final String qy_registerid="qy_registerid";

    /**
     * 日报、月报应用ID
     */
    public static final String rpt_agentid = "rpt_agentid";
	/*
	 * 信贷负责人和经理
	 */
	public static final String loan_leader= "XDFZR";
	public static final String loan_manager= "XDJL";
	/*
	 * 模板ID
	 */
	public static final String moduletemple= "moduletemple";

    //日报、月报订阅类型
    public static final String RB_RPT_CLASS = "RbRptClass";

    public static final String YBJG_RPT_CLASS = "YbjgRptClass";

    //是否机构、部门
    public static final Short IS_DEPART_ORG = 2;

    public static final Short IS_DEPART_YES = 1;

    public static final String WEIXIN_QYHAO_MSG_URL = "weixin_qyhao_msg";
    
    public static final String RPT_RB_URL = "/main/hkimrptldjsc/day_performance.html";

    public static final String RPT_YB_URL = "/main/hkimrptldjsc/month_performance.html";

    public static final String toAuth = "/WECHAT/wxauth/toWxAuth.do";

    public static final String errorurl = "/extfunc/500.html";

    public static final String unsubscribeurl = "/main/notWeChatBrowser.html";
    
    public static final String back_agentid = "back_agentid";
    
    public static final String BACK_AGENTID_URL = "/main/mergerSearch.html";
	/** 图片URL分隔符*/
	public final static String URLSPLITSIGN = "\\|";
	/** 图片下载路径*/
	public final static String DOWNROOT = "exposure/";
	/** 新曝光者提醒标题 */
	public final static String NEWEXPOSURETITLE = "新曝光提醒";
	/** 该身份证号已被曝光*/
	public final static String IDNOREPEAT = "该身份证号已经被曝光";
	
	public final static String CE_Replay = "CE_Replay";
	// 投票调研agentid
	public static final String WXQY_AGENTID_VOTE="wxqy_agentid_vote";
	// 抢办贷款agentid
    public static final String WXQY_AGENTID_RUSHLOAN="wxqy_agentid_rushloan";
    public static final String WXQY_SECRET_RUSHLOAN="wxqy_secret_rushloan";
	// 投票调研secret
	public static final String WXQY_SECRET_VOTE="wxqy_secret_vote";
	// 员工关怀agentid
    public static final String WXQY_AGENTID_CARE="wxqy_agentid_care";
    //当前企业号
    public static final String WXQY_CURRENT_ACCOUNTID="wxqy_current_accountid";
    //当前服务号
    public static final String WECHAT_CURRENT_ACCOUNTID="wechat_current_accountid";
    //访问员工关怀图片路径	
   	public static final String WX_WEB_SERVER_URL="wx_web_server_url";
   	//上下文
   	public static final String WX_WEB_SERVER_CONTEXT="wx_web_server_context";
	
	//5分钟将异常次数推送给运维人员，次数 userid
	public static final String WXQY_SEND_ERROR_USERID="WXQY_SEND_ERROR_USERID";
	//测试投票与员工关怀应用id
	public static final String WX_CORPID="WX_CORPID";
	//工作流应用id
	public static final String qy_workflowid="qy_workflowid";
	//工作流提醒的查看的链接
	public static final String qy_workflowUrl="qy_workflowurl";
	//用车申请应用id
	public static final String qy_vehiclesApply_agendid="qy_vehiclesApply_agendid";
	//用车申请查看的链接
	public static final String qy_vehiclesApplyUrl="qy_vehiclesApplyUrl";
	//任务管理
    public static final String WXQY_AGENTID_TASK="wxqy_agentid_task";
    
    //总裁
    public static final String president = "jch_zc";
	//主任委员
    public static final String chairman = "jch_zrwy";
	//决策会成员
    public static final String decisionmen = "jch_jchcy";

}
