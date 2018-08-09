package req;

import java.math.BigDecimal;

/**
 * create by Lfm
 * on 2018-04-14 16:30
 */
public class ModifyPwdReq {
    private String CardId;
    private String transPwd;
    private String transPwd1;
    private String transPwd2;

    public ModifyPwdReq() {
    }

    public ModifyPwdReq(String cardId, String transPwd, String transPwd1, String transPwd2) {
        CardId = cardId;
        this.transPwd = transPwd;
        this.transPwd1 = transPwd1;
        this.transPwd2 = transPwd2;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public String getTransPwd() {
        return transPwd;
    }

    public void setTransPwd(String transPwd) {
        this.transPwd = transPwd;
    }

    public String getTransPwd1() {
        return transPwd1;
    }

    public void setTransPwd1(String transPwd1) {
        this.transPwd1 = transPwd1;
    }

    public String getTransPwd2() {
        return transPwd2;
    }

    public void setTransPwd2(String transPwd2) {
        this.transPwd2 = transPwd2;
    }
}
