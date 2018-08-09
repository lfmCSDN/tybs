package qo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User:honc.z
 * Date:2018-03-30
 */
public class TransListInfoQo {
    //    主键
    private String transListInfoId;
    private String transName;
    private String transId;
    //    交易类型
    private String transType;
    //    交易金额
    private BigDecimal transAmount;
    //    交易时间
    private String transTime;

    public String getTransListInfoId() {
        return transListInfoId;
    }

    public void setTransListInfoId(String transListInfoId) {
        this.transListInfoId = transListInfoId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getTransName() { return transName; }

    public void setTransName(String transName) { this.transName = transName; }

}
