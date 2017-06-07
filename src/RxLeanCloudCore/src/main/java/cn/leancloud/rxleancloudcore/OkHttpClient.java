package cn.leancloud.rxleancloudcore;

import io.reactivex.*;

/**
 * Created by wujun on 06/06/2017.
 */

class OkHttpClient implements IHttpClient {
    OkHttpClient client = new OkHttpClient();

    @Override
    public Observable<HttpResponse> execute(HttpRequest httpRequest) {
        return null;
    }
}
