package cn.leancloud.rxleancloudcore;

import java.util.Map;

/**
 * Created by wujun on 07/06/2017.
 */

public class AVRequest {
    public RxAVApp app;
    public String relativeUri;
    public Map<String, Object> body;
    public String cmd;
    public String op;

    public static AVRequest createObjectRequest(Map<String, Object> encoded, MutableObjectState state) {
        AVRequest request = new AVRequest();
        request.body = encoded;
        boolean toUpdate = state.objectId != null && !state.objectId.isEmpty();
        request.app = state.app;
        request.relativeUri = toUpdate ? String.format("/classes/%s/%s", state.className, state.objectId) : String.format("/classes/%s", state.className);
        request.op = toUpdate ? "PUT" : "POST";
        return request;
    }

    public HttpRequest http() {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.Url = this.app.getUrl(this.relativeUri);
        httpRequest.Body = body;
        httpRequest.Method = this.op;
        httpRequest.Headers = this.app.getHeaders();
        return httpRequest;
    }

    public WebSocketRequest webSocket() {
        WebSocketRequest webSocketRequest = new WebSocketRequest();
        webSocketRequest.Cmd = this.cmd;
        webSocketRequest.Arguments = this.body;
        return webSocketRequest;
    }
}
