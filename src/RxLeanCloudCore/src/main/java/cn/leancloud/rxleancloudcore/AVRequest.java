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

    public HttpRequest http() {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.Url = this.app.getUrl(this.relativeUri);
        httpRequest.Body = body;
        httpRequest.Method = this.op;
        httpRequest.Headers = this.app.getHeaders();
        return httpRequest;
    }

    public boolean isWebSocket() {
        return cmd != null && !cmd.isEmpty();

    }
}
