package cn.leancloud.rxleancloudcore;

import java.util.Map;

import io.reactivex.*;
import io.reactivex.functions.Function;

/**
 * Created by wujun on 07/06/2017.
 */

public class ObjectController {
    private AVExecutorSelector executorSelector;
    private AVEncoder encoder;
    private AVDecoder decoder;

    public ObjectController(AVExecutorSelector _executor, AVEncoder _encoder, AVDecoder _decoder) {
        this.executorSelector = _executor;
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

        AVRequest avRequest = AVRequest.createObjectRequest(encoded, state);

        return this.executorSelector.select(avRequest).execute(avRequest).map(new Function<AVResponse, MutableObjectState>() {
            @Override
            public MutableObjectState apply(AVResponse avResponse) throws Exception {
                MutableObjectState serverState = decode(avResponse);
                return serverState;
            }
        });
    }
}
