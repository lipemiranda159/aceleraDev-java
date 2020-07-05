package com.challenge.services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataExtractorService {
    public static BigDecimal GetSumValues(Class<? extends Annotation> annototation, Object obj)
    {
        List<Field> fields =
                Arrays.stream(obj.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(annototation))
                        .map(field ->
                        {
                            field.setAccessible(true);
                            return field;
                        })
                .collect(Collectors.toList());

            return SumValues(fields, obj);
    }

    private static BigDecimal SumValues(List<Field> fields, Object obj) {
        BigDecimal value = BigDecimal.ZERO;

        value = getBigDecimalStream(fields, obj).reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        return value;
    }

    private static Stream<BigDecimal> getBigDecimalStream(List<Field> fields, Object obj) {
        return fields.stream().map(field ->
        {
            try {
                return (BigDecimal) field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return BigDecimal.ZERO;
        });
    }
}
