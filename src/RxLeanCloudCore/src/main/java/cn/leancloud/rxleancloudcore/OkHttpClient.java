package cn.leancloud.rxleancloudcore;

import io.reactivex.*;

/**
 * Created by wujun on 06/06/2017.
 */

public class OkHttpClient implements IAVExecutor {
    OkHttpClient client = new OkHttpClient();

    public Observable<AVResponse> execute(AVRequest avRequest) {
        HttpRequest httpRequest = avRequest.http();
        return null;
    }

    public boolean canAchieve(AVRequest avRequest) {
        return avRequest.app.isHttpSchema();
    }
}
