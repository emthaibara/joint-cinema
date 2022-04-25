package scbc.liyongjie.serviceffmpegapi.util;

import scbc.liyongjie.serviceffmpegapi.enums.CodeMsgEnums;
import scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/12
 */


public class ResultUtils {

    public static ResultResponse getSuccessResultResponse(String result){
        return ResultResponse
                .newBuilder()
                .setStatus(1)
                .setCodeMsg("")
                .setResult(result)
                .build();
    }

    public static ResultResponse getErrorResultResponse(CodeMsgEnums codeMsgEnums){
        return ResultResponse
                .newBuilder()
                .setResult("")
                .setCodeMsg(codeMsgEnums.getCodeMsg())
                .setStatus(codeMsgEnums.getStatus())
                .build();
    }

}
