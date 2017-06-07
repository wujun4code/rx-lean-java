package cn.leancloud.rxleancloudcore;
import io.reactivex.*;

/**
 * Created by wujun on 07/06/2017.
 */

public interface IAVExecutor {
    boolean canAchieve(AVRequest avRequest);
    Observable<AVResponse> execute(AVRequest avRequest);
}
