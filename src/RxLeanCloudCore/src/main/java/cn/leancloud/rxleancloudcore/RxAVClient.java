package cn.leancloud.rxleancloudcore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujun on 07/06/2017.
 */

public class RxAVClient {
    public static RxAVClient sharedInstance = new RxAVClient();

    private List<RxAVApp> remoteApps;

    {
        remoteApps = new ArrayList<>();
    }

    public static RxAVClient Init(RxAVApp app) {
        return sharedInstance.add(app);
    }

    public RxAVClient add(RxAVApp app) {
        this.remoteApps.add(app);
        return this;
    }

    public RxAVApp get() {
//        if (remoteApps.size() == 0) {
//            throw new Exception("这里得有一个比较标准的 LeanCloud 异常告知用户必须初始化 SDK 才能开始调用 API");
//        }
        return remoteApps.get(0);
    }
}
