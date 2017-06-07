package cn.leancloud.rxleancloudcore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wujun on 07/06/2017.
 */

public class RxAVApp {

    private static final String api_public_cn;
    private static final String push_router_public_cn;

    static {
        api_public_cn = "api.leancloud.cn";
        push_router_public_cn = "router.g0.push.leancloud.cn/v1/route?appId={0}";
    }

    public RxAVApp(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
        String appSubDomain = this.appId.substring(0, 8);
        this.api = String.format("%s.api.lncld.net", appSubDomain);
        this.engine = String.format("%s.engine.lncld.net", appSubDomain);
        this.stats = String.format("%s.stats.lncld.net", appSubDomain);
        this.push = String.format("%s.push.lncld.net", appSubDomain);
        this.pushRouter = String.format("%s.rtm.lncld.net", appSubDomain);
    }

    private String appId;
    private String appKey;
    private String apiVersion = "1.1";
    private String schema = "https://";
    private String api;
    private String engine;
    private String stats;
    private String push;
    private String pushRouter;
    private String wss;
    private String shortName = "default";
    private String contentType = "application/json";

    public RxAVApp wss(String _wss) {
        this.wss = _wss;
        return this;
    }

    public RxAVApp schema(String _schema) {
        this.schema = _schema;
        return  this;
    }

    private Map<String, String> headers;

    public Map<String, String> getHeaders() {
        if (headers == null) {
            headers = new HashMap<String, String>();
            headers.put("X-LC-Id", this.appId);
            headers.put("X-LC-Key", this.appKey);
            headers.put("Content-Type", this.contentType);
        }

        return headers;
    }

    public String getUrl(String relativeUri) {
        if (relativeUri.startsWith("/push")) {
            return String.format("%s%s%s%s", this.schema, this.push, this.apiVersion, relativeUri);
        }
        return String.format("%s%s%s%s", this.schema, this.api, this.apiVersion, relativeUri);
    }

    public boolean isHttpSchema() {
        return this.schema.startsWith("http");
    }
}
