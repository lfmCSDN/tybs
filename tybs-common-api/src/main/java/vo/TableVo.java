package vo;

import java.util.List;

/**
 * User:honc.z
 * Date:2018-04-03
 * 用于返回table数据
 */
public class TableVo<T> {
    int code;
    String msg;
    int count;
    //详细表格数据
    List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
