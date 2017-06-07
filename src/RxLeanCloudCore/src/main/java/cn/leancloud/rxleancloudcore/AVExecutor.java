package cn.leancloud.rxleancloudcore;

import io.reactivex.*;
import io.reactivex.functions.Function;

/**
 * Created by wujun on 07/06/2017.
 */

public class AVExecutor {

    private IHttpClient httpClient;
    private IWebSocketClient webSocketClient;

    public AVExecutor(IHttpClient _httpClient, IWebSocketClient _webSocketClient) {
        this.httpClient = _httpClient;
        this.webSocketClient = _webSocketClient;
    }

    public Observable<AVResponse> execute(AVRequest avRequest) {
        if (!avRequest.app.isHttpSchema() || avRequest.isWebSocket()) {
            this.webSocketClient.execute(avRequest).map(new Function<AVResponse, Object>() {
                @Override
                public Object apply(AVResponse avResponse) throws Exception {
                    return null;
                }
            });
        }
        HttpRequest httpRequest = avRequest.http();
        return  this.httpClient.execute(httpRequest).map(new Function<HttpResponse, AVResponse>() {
            @Override
            public AVResponse apply(HttpResponse httpResponse) throws Exception {
                return null;
            }
        });
    }


}
