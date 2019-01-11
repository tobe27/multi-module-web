package com.example.common.util;

import com.example.common.enums.DatePatternEnum;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringUtilTest {

    @Test
    public void EL() {
        String phone = "13445577889";
        String  NUMERIC = "((^[1-9]+[0-9]*[.]?)|(^[0]+[.]))[0-9]*$";

        String PHONE_NUMBER = "^1?[3|4|5|6|7|8|9]?[0-9]{9}$";
        String d = "03300.333";
        System.out.println(StringUtil.isNumeric(d, 18));
        System.out.println(String.valueOf(d).matches(NUMERIC));
        System.out.println(phone.matches(PHONE_NUMBER));
    }

    @Test
    public void time() {
        long beforeLong = DateConvertUtil.convertDate2Long("19490101", DatePatternEnum.DATE_TIME_SECOND);
        long Long1900 = DateConvertUtil.convertDate2Long("19000101", DatePatternEnum.DATE_TIME_SECOND);
        long afterLong = DateConvertUtil.convertDate2Long("20500101", DatePatternEnum.DATE_TIME_SECOND);
        System.out.println(Long1900);
        System.out.println(afterLong);
    }

    @Test
    public void verifyIdCard() {
        String idNumberTrue = "34222419680405061X";
        String id1 = "460121197306205517";
        String id2 = "460121199609245515";
        System.out.println(StringUtil.isIdNumber(idNumberTrue));
        System.out.println(StringUtil.isIdNumber(id1));
        System.out.println(StringUtil.isNotIdNumber(id2));
    }

}