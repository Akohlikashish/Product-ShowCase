package com.ashish.askme.util;

import android.text.TextUtils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class StringUtil {
    public static final String RUPEE_SYMBOL = "\u20B9 ";
    public static final String SPACE = " ";
    public static final String COMMA = ", ";
    public static final String COLON = ":";
    public static final String SEMI_COLON = "; ";
    public static final String FORWARD_SLASH = "/";
    public static final String BACKWARD_SLASH = "/";
    public static final String QUESTION_MARK = "?";
    public static final String AMPERSAND = "&";
    public static final String EQUAL = "=";
    public static final String EMPTY = "";

    public static String format(Number n) {
        NumberFormat format = DecimalFormat.getInstance();
        format.setRoundingMode(RoundingMode.HALF_EVEN);
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(1);
        return format.format(n);
    }

    public static String appendRupee(String text) {
        return RUPEE_SYMBOL + text;
    }


    public static String capitalizeFirstLetter(String text) {
        if (TextUtils.isEmpty(text)) return text;

        String firstLetter = text.substring(0, 1);
        String toRet = firstLetter.toUpperCase();

        if (text.length() > 1) {
            toRet += text.substring(1);
        }

        return toRet;
    }

}
