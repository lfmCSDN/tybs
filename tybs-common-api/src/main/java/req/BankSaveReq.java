package req;

import java.math.BigDecimal;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 *
 *      存款请求参数
 *
 */
public class BankSaveReq {

    private String cardId;
    private String acctName;
    private BigDecimal amount;

    public BankSaveReq() {
    }

    public BankSaveReq(String cardId, String acctName, BigDecimal amount) {
        this.cardId = cardId;
        this.acctName = acctName;
        this.amount = amount;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
