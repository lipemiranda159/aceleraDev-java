package com.challenge.services;

import java.math.BigDecimal;

public class MathService {
        public static BigDecimal getBigDecimal( Object value ) {
            BigDecimal ret = null;
            if (value != null) {
                if (value instanceof BigDecimal) {
                    ret = (BigDecimal) value;
                }

            }
            return ret;
        }
}
