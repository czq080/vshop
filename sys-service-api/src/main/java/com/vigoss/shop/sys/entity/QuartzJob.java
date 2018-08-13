package com.vigoss.shop.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class QuartzJob implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quartz_job.job_id
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    private Long jobId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quartz_job.bean_name
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    private String className;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quartz_job.params
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    private String params;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quartz_job.cron_expression
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    private String cronExpression;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quartz_job.status
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quartz_job.remark
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column quartz_job.create_time
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quartz_job.job_id
     *
     * @return the value of quartz_job.job_id
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quartz_job.job_id
     *
     * @param jobId the value for quartz_job.job_id
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quartz_job.bean_name
     *
     * @return the value of quartz_job.bean_name
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quartz_job.bean_name
     *
     * @param className the value for quartz_job.class_name
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quartz_job.params
     *
     * @return the value of quartz_job.params
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public String getParams() {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quartz_job.params
     *
     * @param params the value for quartz_job.params
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quartz_job.cron_expression
     *
     * @return the value of quartz_job.cron_expression
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quartz_job.cron_expression
     *
     * @param cronExpression the value for quartz_job.cron_expression
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quartz_job.status
     *
     * @return the value of quartz_job.status
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quartz_job.status
     *
     * @param status the value for quartz_job.status
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quartz_job.remark
     *
     * @return the value of quartz_job.remark
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quartz_job.remark
     *
     * @param remark the value for quartz_job.remark
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quartz_job.create_time
     *
     * @return the value of quartz_job.create_time
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quartz_job.create_time
     *
     * @param createTime the value for quartz_job.create_time
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}