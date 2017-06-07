package cn.leancloud.rxleancloudcore;

import java.util.Map;

import io.reactivex.*;
import io.reactivex.functions.Function;

/**
 * Created by wujun on 07/06/2017.
 */

public class ObjectController {
    private AVExecutor executor;
    private AVEncoder encoder;
    private AVDecoder decoder;

    public ObjectController(AVExecutor _executor, AVEncoder _encoder, AVDecoder _decoder) {
        this.executor = _executor;
        this.encoder = _encoder;
        this.decoder = _decoder;
    }

    private MutableObjectState decode(AVResponse avResponse) {
        MutableObjectState serverState = new MutableObjectState();
        return serverState;
    }

    public Observable<MutableObjectState> save(MutableObjectState state, Map<String, Object> estimatedData, String sesstionToken) {
        Map<String, Object> unEncoded = state.mergeOperations(estimatedData);
        Map<String, Object> encoded = this.encoder.Encode(unEncoded);
        AVRequest avRequest = new AVRequest();
        avRequest.body = encoded;
        boolean toUpdate = state.objectId != null && !state.objectId.isEmpty();
        avRequest.app = state.app;
        avRequest.relativeUri = toUpdate ? String.format("/classes/%s/%s", state.className, state.objectId) : String.format("/classes/%s", state.className);
        avRequest.op = toUpdate ? "PUT" : "POST";
        return this.executor.execute(avRequest).map(new Function<AVResponse, MutableObjectState>() {
            @Override
            public MutableObjectState apply(AVResponse avResponse) throws Exception {
                MutableObjectState serverState = decode(avResponse);
                return serverState;
            }
        });
    }
}
