package com.github.k3286.creditcard;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author HINA
 *
 */
public class BinCodeReaderUtil {

    /**
     * カード番号からBinコードを判定する
     * @param cardNumber カード番号
     * @return Binコード情報
     */
    public static BinCode reader(String cardNumber) {

        BinCode binCode = new BinCode();

        if (isAmex(cardNumber)) {
            binCode.setCardType("American Express");

        } else if (isChinaUnionPay(cardNumber)) {
            binCode.setCardType("中国銀聯");

        } else if (isDinersClub(cardNumber)) {
            binCode.setCardType("Diners Club");

        } else if (isDiscoverCard(cardNumber)) {
            binCode.setCardType("Discover Card");

        } else if (isJCB(cardNumber)) {
            binCode.setCardType("JCB");

        } else if (isMasterCard(cardNumber)) {
            binCode.setCardType("MasterCard");

        } else if (isUATP(cardNumber)) {
            binCode.setCardType("UATP");

        } else if (isVisa(cardNumber)) {
            binCode.setCardType("Visa");

        } else {
            throw new BinCodeRuntimeException(//
                    MessageFormat.format("Card type not found. cardNumber=[{0}]", cardNumber));
        }
        return binCode;
    }

    /**
     * カードの種類が「American Express」であるかを確認する
     * @param cardNumber カード番号
     * @return 「American Express」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isAmex(String cardNumber) {
        //34, 37
        if (StringUtils.isNotEmpty(cardNumber)//
                && NumberUtils.isParsable(cardNumber.substring(0, 6))) {
            int prefix = NumberUtils.toInt(cardNumber.substring(0, 2));
            if (prefix == 34 || prefix == 37) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「中国銀聯」であるかを確認する
     * @param cardNumber カード番号
     * @return 「中国銀聯」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isChinaUnionPay(String cardNumber) {
        //622126-622925, 624-626, 6282-6288
        if (StringUtils.isNotEmpty(cardNumber)//
                && NumberUtils.isParsable(cardNumber.substring(0, 6))) {
            int prefix = NumberUtils.toInt(cardNumber.substring(0, 6));
            if (622126 <= prefix && prefix <= 622925) {
                return Boolean.TRUE;
            }
            prefix = NumberUtils.toInt(cardNumber.substring(0, 3));
            if (624 <= prefix && prefix <= 626) {
                return Boolean.TRUE;
            }
            prefix = NumberUtils.toInt(cardNumber.substring(0, 4));
            if (6282 <= prefix && prefix <= 6288) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「Diners Club」であるかを確認する
     * @param cardNumber カード番号
     * @return 「Diners Club」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isDinersClub(String cardNumber) {
        //300-303574, 3095, 36, 38-39
        if (StringUtils.isNotEmpty(cardNumber)//
                && NumberUtils.isParsable(cardNumber.substring(0, 6))) {
            int prefix = NumberUtils.toInt(cardNumber.substring(0, 6));
            if (300000 <= prefix && prefix <= 303574) {
                return Boolean.TRUE;
            }
            prefix = NumberUtils.toInt(cardNumber.substring(0, 4));
            if (prefix == 3095) {
                return Boolean.TRUE;
            }
            prefix = NumberUtils.toInt(cardNumber.substring(0, 2));
            if (prefix == 36 || prefix == 38 || prefix == 39) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「Discover Card」であるかを確認する
     * @param cardNumber カード番号
     * @return 「Discover Card」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isDiscoverCard(String cardNumber) {
        //60110, 60112-60114, 601174-601179, 601186-601199, 644-649, 65
        if (StringUtils.isNotEmpty(cardNumber)//
                && NumberUtils.isParsable(cardNumber.substring(0, 6))) {
            int prefix = NumberUtils.toInt(cardNumber.substring(0, 5));
            if (prefix == 60110) {
                return Boolean.TRUE;
            }
            if (60112 <= prefix && prefix <= 60114) {
                return Boolean.TRUE;
            }
            prefix = NumberUtils.toInt(cardNumber.substring(0, 6));
            if (601174 <= prefix && prefix <= 601179) {
                return Boolean.TRUE;
            }
            if (601186 <= prefix && prefix <= 601199) {
                return Boolean.TRUE;
            }
            prefix = NumberUtils.toInt(cardNumber.substring(0, 3));
            if (644 <= prefix && prefix <= 649) {
                return Boolean.TRUE;
            }
            prefix = NumberUtils.toInt(cardNumber.substring(0, 2));
            if (prefix == 65) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「JCB」であるかを確認する
     * @param cardNumber カード番号
     * @return 「JCB」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isJCB(String cardNumber) {
        //3528-3589
        if (StringUtils.isNotEmpty(cardNumber)//
                && NumberUtils.isParsable(cardNumber.substring(0, 6))) {
            int prefix = NumberUtils.toInt(cardNumber.substring(0, 4));
            if (3528 <= prefix && prefix <= 3589) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「MasterCard」であるかを確認する
     * @param cardNumber カード番号
     * @return 「MasterCard」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isMasterCard(String cardNumber) {
        //510000 - 559999, 222100 - 272099
        if (StringUtils.isNotEmpty(cardNumber)//
                && NumberUtils.isParsable(cardNumber.substring(0, 6))) {
            int prefix = NumberUtils.toInt(cardNumber.substring(0, 6));
            if (510000 <= prefix && prefix <= 559999) {
                return Boolean.TRUE;
            }
            if (222100 <= prefix && prefix <= 272099) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「UATP」であるかを確認する
     * @param cardNumber カード番号
     * @return 「UATP」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isUATP(String cardNumber) {
        if (StringUtils.isNotEmpty(cardNumber)//
                && NumberUtils.isParsable(cardNumber.substring(0, 6))) {
            int prefix = NumberUtils.toInt(cardNumber.substring(0, 1));
            if (prefix == 1) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * カードの種類が「Visa」であるかを確認する
     * @param cardNumber カード番号
     * @return 「Visa」の場合はTRUE、それ以外はFALSE
     */
    public static boolean isVisa(String cardNumber) {
        if (StringUtils.isNotEmpty(cardNumber)//
                && NumberUtils.isParsable(cardNumber.substring(0, 6))) {
            int prefix = NumberUtils.toInt(cardNumber.substring(0, 1));
            if (prefix == 4) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
