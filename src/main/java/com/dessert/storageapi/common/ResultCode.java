package com.dessert.storageapi.common;

import lombok.Getter;



@Getter
public class ResultCode {
    //通用信息
    /** 成功 */
    public static ResultCode SUCCESS = new ResultCode(0, "success");
    /** 服务器异常 */
    public static ResultCode SERVER_ERROR = new ResultCode(500000,"服务端异常:%s");
    /** 参数校验异常 */
    public static ResultCode BIND_ERROR = new ResultCode(500001,"参数校验异常:%s");
    /** 传入参数为空 */
    public static ResultCode PARAMS_IS_EMPTY = new ResultCode(500002,"传入参数为空:%s");
    /** 参数解析失败 */
    public static ResultCode PARAMS_PARSE_ERROR = new ResultCode(500003,"参数解析失败:%s");


    //登录模块 5001XX
    /** 账号不存在 */
    public static ResultCode ACCOUNT_NOT_EXIST = new ResultCode(500100,"账号不存在:%s");
    /** 账号已存在 */
    public static ResultCode ACCOUNT_EXISTS = new ResultCode(500101,"账号已存在:%s");
    /** 密码不正确 */
    public static ResultCode PASSWORD_ERROR = new ResultCode(500102,"密码不正确:%s");

    //权限模块 5002XX

    //云中间件模块 5003XX
    /** 云存储异常 */
    public static ResultCode OSS_ERROR = new ResultCode(500300,"云存储异常:%s");


    /**
     * 参数为空
     */
    public static ResultCode PARAM_EMPTY = new ResultCode(400001,"参数：%s不能为空！");
    /**
     * 表中已经存在该字段
     */
    public static ResultCode FIELD_EXIST = new ResultCode(400002,"%s");

    /**
     * 状态为已发布
     */
    public static ResultCode PUBLIC_STATUS = new ResultCode(400003,"状态为已发布，不允许修改或删除操作！");

    //执行数据库操作异常模块  5004XX

    /**执行新增时数据库异常*/
    public static ResultCode MYSQL_INSERT_EXCEPTION = new ResultCode(500401,"执行新增时数据库异常:%s");

    /**执行修改时数据库异常*/
    public static ResultCode MYSQL_UPDATE_EXCEPTION = new ResultCode(500402,"执行修改时数据库异常:%s");

    /**执行删除时数据库异常*/
    public static ResultCode MYSQL_DELETE_EXCEPTION = new ResultCode(500403,"执行删除时数据库异常:%s");

    /**执行查询时数据库异常*/
    public static ResultCode MYSQL_QUERY_EXCEPTION = new ResultCode(500404,"执行查询时数据库异常:%s");

    /**执行批量插入时插入条数小于入参条数*/
    public static ResultCode MYSQL_BATCH_INSERT_EXCEPTION = new ResultCode(500405,"批量插入数量不对:%s");


    /**数据状态不允许进行某些操作*/
    public static ResultCode STATUS_ERROR = new ResultCode(500406,"%s");



    /** 返回码 */
    private int code;
    /** 返回信息 */
    private String msg;
    /** 无参构造方法 */
    private ResultCode() {
    }
    /** 构造方法 */
    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    /** 填充动态参数 */
    public ResultCode fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new ResultCode(code, message);
    }
}
