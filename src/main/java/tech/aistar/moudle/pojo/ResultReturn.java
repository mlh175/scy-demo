package tech.aistar.moudle.pojo;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import java.io.Serializable;

/**
 * @author:马立皓
 * @time:9:39 2022/7/2
 */
public class ResultReturn implements Serializable {
    //属性
    private String code;//状态码
    private String msg;//描述信息
    private Object data;//查询结果

    public ResultReturn(String code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public ResultReturn(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultReturn() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
