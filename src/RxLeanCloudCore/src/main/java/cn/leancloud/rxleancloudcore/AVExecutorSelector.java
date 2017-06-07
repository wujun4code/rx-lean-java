package cn.leancloud.rxleancloudcore;

import io.reactivex.*;
import io.reactivex.functions.Function;

/**
 * Created by wujun on 07/06/2017.
 */

public class AVExecutorSelector {

    private IAVExecutor httpClient;
    private IAVExecutor webSocketClient;

    public IAVExecutor select(AVRequest avRequest) {

        if (isWebSocket(avRequest) || !avRequest.app.isHttpSchema()) {
            return webSocketClient;
        }

        return httpClient;
    }

    public AVExecutorSelector(IAVExecutor _httpClient, IAVExecutor _webSocketClient) {
        this.httpClient = _httpClient;
        this.webSocketClient = _webSocketClient;
    }

    public boolean isWebSocket(AVRequest avRequest) {
        return avRequest.cmd != null && !avRequest.cmd.isEmpty();
    }
}
