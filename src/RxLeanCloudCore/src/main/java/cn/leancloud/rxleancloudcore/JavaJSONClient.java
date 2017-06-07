package cn.leancloud.rxleancloudcore;

import java.util.Map;

import org.json.JSONObject;

/**
 * Created by wujun on 07/06/2017.
 */

public class JavaJSONClient implements IJsonClient {

    @Override
    public String stringify(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }

    @Override
    public Map<String, Object> parse(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.toMap();
    }
}
