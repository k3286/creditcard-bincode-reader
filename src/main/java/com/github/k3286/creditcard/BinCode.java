package com.github.k3286.creditcard;

/**
 * Binコード
 * @author HINA
 *
 */
public class BinCode {

    /** カード種別 */
    private String cardType_;

    /** カード発行会社 */
    private String issuer_;

    public String getIssuer() {
        return issuer_;
    }

    public void setIssuer(String issuer) {
        this.issuer_ = issuer;
    }

    public String getCardType() {
        return cardType_;
    }

    public void setCardType(String cardType) {
        this.cardType_ = cardType;
    }

}
