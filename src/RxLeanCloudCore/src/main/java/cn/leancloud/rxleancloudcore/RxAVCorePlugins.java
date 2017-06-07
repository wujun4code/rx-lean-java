package cn.leancloud.rxleancloudcore;

/**
 * Created by wujun on 06/06/2017.
 */

public class RxAVCorePlugins {
    public static RxAVCorePlugins sharedInstance = new RxAVCorePlugins();

    private IHttpClient httpClient = new OkHttpClient();

    public RxAVCorePlugins httpClient(IHttpClient _httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    private IWebSocketClient webSocketClient;

    public RxAVCorePlugins webSocketClient(IWebSocketClient _webSocketClient) {
        this.webSocketClient = _webSocketClient;
        return this;
    }

    private IJsonClient jsonClient;

    public RxAVCorePlugins jsonClient(IJsonClient _jsonClient) {
        this.jsonClient = _jsonClient;
        return this;
    }

    private ObjectController objectController;

    public ObjectController getObjectController() {
        if (objectController == null) {
            AVExecutor executor = getAVExecutor();
            AVEncoder encoder = getEncoder();
            AVDecoder decoder = getDecoder();
            objectController = new ObjectController(executor, encoder, decoder);
        }
        return this.objectController;
    }

    private AVExecutor avExecutor;

    public AVExecutor getAVExecutor() {
        if (avExecutor == null) {
            avExecutor = new AVExecutor(this.httpClient, this.webSocketClient);
        }
        return avExecutor;
    }

    private AVEncoder encoder;

    public AVEncoder getEncoder() {
        if (encoder == null) {
            encoder = new AVEncoder();
        }
        return encoder;
    }

    private AVDecoder decoder;

    public AVDecoder getDecoder() {
        if (decoder == null) {
            decoder = new AVDecoder();
        }
        return decoder;
    }
}
