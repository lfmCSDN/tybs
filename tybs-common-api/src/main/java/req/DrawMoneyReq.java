package req;

import java.math.BigDecimal;

/**
 * 取款请求
 * create by Lfm
 * on 2018-04-10 23:34
 */
public class DrawMoneyReq {

    private String cardId;
    private BigDecimal amount;
    private String transPwd;

    public DrawMoneyReq() {
    }

    public DrawMoneyReq(String cardId, BigDecimal amount, String transPwd) {
        this.cardId = cardId;
        this.amount = amount;
        this.transPwd = transPwd;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransPwd() {
        return transPwd;
    }

    public void setTransPwd(String transPwd) {
        this.transPwd = transPwd;
    }
}
