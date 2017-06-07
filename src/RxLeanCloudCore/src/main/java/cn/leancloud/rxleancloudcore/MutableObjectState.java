package cn.leancloud.rxleancloudcore;

import java.util.Date;
import java.util.Map;

/**
 * Created by wujun on 07/06/2017.
 */

public class MutableObjectState {
    public RxAVApp app;
    public String className;
    public String objectId;
    public Date createdAt;
    public Date updatedAt;
    public Map<String, Object> serverData;

    public Map<String, Object> mergeOperations(Map<String, Object> estimatedData) {
        return estimatedData;
    }

    public MutableObjectState mutableClone() {
        MutableObjectState cloned = new MutableObjectState();
        cloned.objectId = this.objectId;
        cloned.className = this.className;
        cloned.updatedAt = this.updatedAt;
        cloned.createdAt = this.createdAt;
        cloned.app = this.app;
        return cloned;
    }
}
