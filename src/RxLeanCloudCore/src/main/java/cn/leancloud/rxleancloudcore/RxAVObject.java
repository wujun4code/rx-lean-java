/**
 * Created by wujun on 06/06/2017.
 */
package cn.leancloud.rxleancloudcore;

import io.reactivex.*;
import io.reactivex.functions.Function;

import java.util.HashMap;
import java.util.Map;

public class RxAVObject {

    private boolean isDirty;
    private MutableObjectState state;
    private Map<String, Object> estimatedData;

    private ObjectController getController() {
        return RxAVCorePlugins.sharedInstance.getObjectController();
    }

    public RxAVObject(String className) {
        state = new MutableObjectState();
        state.className = className;
        state.app = RxAVClient.sharedInstance.get();
        isDirty = true;
        estimatedData = new HashMap<String, Object>();

    }

    private void mergeSavedResult(MutableObjectState state) {

    }

    private void applyFetchedResult() {

    }

    public void set(String key, Object value) {
        estimatedData.put(key, value);
    }

    public Object get(String key) {
        return estimatedData.get(key);
    }

    public String getClassName() {
        return state.objectId;
    }

    public Observable<Boolean> save() {
        final RxAVObject self = this;
        return this.getController().save(state, estimatedData, "").map(new Function<MutableObjectState, Boolean>() {
            @Override
            public Boolean apply(MutableObjectState mutableObjectState) throws Exception {
                self.mergeSavedResult(state);
                return true;
            }
        });
    }
}
