package com.ryan.mmaccountserver.unifiedreturn;

public enum ResultCode {
     /* 成功状态码 */
     SUCCESS(200, "成功"),

     /* 失败状态码 */
     FAILURE(-1, "调用失败"),

     /* 系统500错误*/
     SYSTEM_ERROR(10000, "系统异常，请稍后重试"),
     UNAUTHORIZED(10401, "登录已过期"),

     /* 参数错误：10001-19999 */
     PARAM_IS_INVALID(10001, "参数无效"),

     /* 用户错误：20001-29999*/
     USER_HAS_EXISTED(20001, "用户名已存在"),
     USER_NOT_FIND(20002, "用户名不存在");

     private Integer code;
     private String message;
     ResultCode(Integer code, String message) {
         this.code = code;
         this.message = message;
     }
     public Integer code() {
         return this.code;
     }
     public String message() {
         return this.message;
     }
     public static int findCodeByMsg(String msg) {
          for (ResultCode eachEnum :ResultCode.values()) {
               if (eachEnum.message() == msg) {
                    return eachEnum.code();
               }
          }
          return -1;
     }
     public static String findMsgByCode(int code) {
          for (ResultCode eachEnum :ResultCode.values()) {
               if (eachEnum.code() == code) {
                    return eachEnum.message();
               }
          }
          return "调用失败";
     }
}
