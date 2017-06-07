package cn.leancloud.rxleancloudcore;

import java.util.Map;

/**
 * Created by wujun on 07/06/2017.
 */

public interface IJsonClient {
    String stringify(Map<String,Object> map);
    Map<String,Object> parse(String jsonString);
}
