package com.ryan.mmaccountserver.respbody;

import com.ryan.mmaccountserver.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespResult<T> {
      /**
       * 1.status状态值：代表本次请求response的状态结果。
       */
      private Integer code;
      /**
       * 2.response描述：对本次状态码的描述。
       */
      private String msg;
      /**
       * 3.data数据：本次返回的数据。
       */
      private T data;
      /**
       * 把RespResultCode枚举转换为ResRespResult
       */
      private void setRespResultCode(ResultCode code) {
            this.code = code.code();
            this.msg = code.message();
      }
      /**
       * 成功，创建ResRespResult：没data数据
       */
      public static RespResult suc() {
            RespResult RespResult = new RespResult();
            RespResult.setRespResultCode(ResultCode.SUCCESS);
            return RespResult;
      }
      /**
       * 成功，创建ResRespResult：有data数据
       */
      public static RespResult suc(Object data) {
            RespResult RespResult = new RespResult();
            RespResult.setRespResultCode(ResultCode.SUCCESS);
            RespResult.setData(data);
            return RespResult;
      }
      /**
       * 失败，指定status、desc
       */
      public static RespResult fail(Integer code, String msg) {
            RespResult RespResult = new RespResult();
            RespResult.setCode(code);
            RespResult.setMsg(msg);
            return RespResult;
      }
      /**
       * 失败，指定RespResultCode枚举
       */
      public static RespResult fail(ResultCode RespResultCode) {
            RespResult RespResult = new RespResult();
            RespResult.setRespResultCode(RespResultCode);
            return RespResult;
      }

}
