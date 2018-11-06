package com.github.k3286.creditcard;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author HINA
 *
 */
public class BinCodeReaderUtil {

    /**
     * カードの種類が「American Express」であるかを確認する
     * @param cardNumber カード番号
     * @return 「American Express」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isAmex(String cardNumber) {
        return StringUtils.isNotEmpty(cardNumber)//
                && (cardNumber.startsWith("34") || cardNumber.startsWith("37"));
    }

    /**
     * カードの種類が「中国銀聯」であるかを確認する
     * @param cardNumber カード番号
     * @return 「中国銀聯」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isChinaUnionPay(String cardNumber) {
        //622126-622925, 624-626, 6282-6288
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「Diners Club」であるかを確認する
     * @param cardNumber カード番号
     * @return 「Diners Club」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isDinersClub(String cardNumber) {
        //300-303574, 3095, 36, 38-39
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「Discover Card」であるかを確認する
     * @param cardNumber カード番号
     * @return 「Discover Card」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isDiscoverCard(String cardNumber) {
        //60110, 60112-60114, 601174-601179, 601186-601199, 644-649, 65
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「JCB」であるかを確認する
     * @param cardNumber カード番号
     * @return 「JCB」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isJCB(String cardNumber) {
        //3528-3589
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「MasterCard」であるかを確認する
     * @param cardNumber カード番号
     * @return 「MasterCard」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isMasterCard(String cardNumber) {
        //510000 - 559999, 222100 - 272099
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「UATP」であるかを確認する
     * @param cardNumber カード番号
     * @return 「UATP」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isUATP(String cardNumber) {
        return StringUtils.isNotEmpty(cardNumber)//
                && cardNumber.startsWith("1");
    }

    /**
     * カードの種類が「Visa」であるかを確認する
     * @param cardNumber カード番号
     * @return 「Visa」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isVisa(String cardNumber) {
        return StringUtils.isNotEmpty(cardNumber)//
                && cardNumber.startsWith("4");
    }
}
