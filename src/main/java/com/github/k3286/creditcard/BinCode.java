package com.github.k3286.creditcard;

/**
 *
 * @author HINA
 *
 */
public class BinCode {

    /** カード種別 */
    private String cardType_;

    /** */
    private String aaa_;

    public String getAaa(){
        return aaa_;
    }

    public void setAaa(String aaa){
        this.aaa_=aaa;
    }

    /**
     * @return cardType_
     */
    public String getCardType() {
        return cardType_;
    }

    /**
     * @param cardType セットする cardType_
     */
    public void setCardType(String cardType) {
        this.cardType_ = cardType;
    }

}
