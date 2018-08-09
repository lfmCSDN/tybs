package req;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询
 * create by Lfm
 * on 2018-04-14 20:17
 */
public class pageReq<T> {
    private List<T> data;//数据列表
    private int pagenum;//当前页数
    private int pagesize;//当前页显示条数
    private int rows;//总行数

    public pageReq(int rows, int pagenum, int pagesize) {
        super();
        data = new ArrayList<>();
        this.rows = rows;
        this.setPagesize(pagesize);
        this.setPagenum(pagenum);
    }

    public pageReq() {
        super();
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        if (pagenum > getTotalpage()) {
            this.pagenum = getTotalpage();
        } else {
            this.pagenum = pagenum;
        }
        if (pagenum < 1) {
            this.pagenum = 1;
        }
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalpage() {
        //计算总页数
        if (rows % pagesize == 0) {
            return rows / pagesize;
        } else {
            return rows / pagesize + 1;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getIndexnum() {
        //获取索引值
        return pagesize * (pagenum - 1);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
