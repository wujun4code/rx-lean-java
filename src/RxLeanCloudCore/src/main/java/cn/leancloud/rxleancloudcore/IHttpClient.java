package cn.leancloud.rxleancloudcore;
import io.reactivex.*;
/**
 * Created by wujun on 06/06/2017.
 */

public interface IHttpClient {
    Observable<HttpResponse> execute(HttpRequest httpRequest);
}
