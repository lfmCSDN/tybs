package req;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.math.BigDecimal;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 *
 *      转账请求参数
 *
 */
public class TransferReq {

    private String payCardId;
    private String receiptName;
    private String receiptCardId;
    private BigDecimal amount;
    private String transPwd;



    public TransferReq() {
    }


    public TransferReq(String payCardId, String receiptName, String receiptCardId, BigDecimal amount, String transPwd) {
        this.payCardId = payCardId;
        this.receiptName = receiptName;
        this.receiptCardId = receiptCardId;
        this.amount = amount;
        this.transPwd = transPwd;
    }

    public String getPayCardId() {
        return payCardId;
    }

    public void setPayCardId(String payCardId) {
        this.payCardId = payCardId;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptCardId() {
        return receiptCardId;
    }

    public void setReceiptCardId(String receiptCardId) {
        this.receiptCardId = receiptCardId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransPwd() { return transPwd; }

    public void setTransPwd(String transPwd) { this.transPwd = transPwd; }
}
