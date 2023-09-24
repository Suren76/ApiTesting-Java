package models;

import java.util.Map;

public class SimpleRequestBody extends BaseModel {
    private Map<String, Object> map;

    public SimpleRequestBody(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public Map<String, Object> getMap() {
        return map;
    }
}
