package cn.leancloud.rxleancloudcore;

/**
 * Created by wujun on 06/06/2017.
 */

public class RxAVCorePlugins {
    public static RxAVCorePlugins sharedInstance = new RxAVCorePlugins();

    private IAVExecutor httpClient = new OkHttpClient();

    public RxAVCorePlugins httpClient(IAVExecutor _httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    private IAVExecutor webSocketClient;

    public RxAVCorePlugins webSocketClient(IAVExecutor _webSocketClient) {
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
            AVExecutorSelector executor = getAVExecutor();
            AVEncoder encoder = getEncoder();
            AVDecoder decoder = getDecoder();
            objectController = new ObjectController(executor, encoder, decoder);
        }
        return this.objectController;
    }

    private AVExecutorSelector avExecutorSelector;

    public AVExecutorSelector getAVExecutor() {
        if (avExecutorSelector == null) {
            avExecutorSelector = new AVExecutorSelector(this.httpClient, this.webSocketClient);
        }
        return avExecutorSelector;
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
