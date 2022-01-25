package de.novatec.domainprimitives.validation;

import java.util.function.Consumer;

import static java.lang.String.format;

public class Constraints {

    private static final String NULL = "null";
    private static final String NULL_ERROR_MESSAGE_TEMPLATE = "%s should not be " + NULL;
    private static final String ERROR_MESSAGE_RANGE_TEMPLATE = "%s should be between %s and %s";
    private static final String ERROR_MESSAGE_GREATER_THAN_TEMPLATE = "%s should be greater then %s";
    private static final String ERROR_MESSAGE_LESS_THAN_TEMPLATE = "%s should be less then %s";

    private static final String UUID_PATTERN = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}";

    private Constraints() {
    }

    // String

    public static Consumer<Validation<String>> isNotNull() {
        return val -> val.constraint(
                isNotNull(val.value()), () -> format(NULL_ERROR_MESSAGE_TEMPLATE, getValueFormatted(val))
        );
    }

    public static Consumer<Validation<String>> isNotBlank() {
        return val -> val.constraint(
                isNotBlank(val.value()), () -> format("%s should not be blank", getValueFormatted(val))
        );
    }

    private static boolean isNotBlank(String value) {
        return isNotNull(value) && !value.trim().isEmpty();
    }

    public static Consumer<Validation<String>> isPattern(String pattern) {
        return val -> val.constraint(
                isValidPattern(val.value(), pattern),
                () -> format("%s should match the pattern %s", getValueFormatted(val), pattern)
        );
    }

    private static boolean isValidPattern(String value, String pattern) {
        return isNotNull(value) && value.matches(pattern);
    }

    public static Consumer<Validation<String>> hasMinLength(int minLength) {
        return val -> val.constraint(
                hasMinLength(val.value(), minLength),
                () -> format("%s should be longer than %s", getValueFormatted(val), minLength)
        );
    }

    private static boolean hasMinLength(String value, int minLength) {
        return isNotNull(value) && value.length() >= minLength;
    }

    public static Consumer<Validation<String>> hasMaxLength(int maxLength) {
        return val -> val.constraint(
                hasMaxLength(val.value(), maxLength),
                () -> format("%s should not be longer than %s", getValueFormatted(val), maxLength)
        );
    }

    private static boolean hasMaxLength(String value, int maxLength) {
        return isNotNull(value) && value.length() <= maxLength;
    }

    public static Consumer<Validation<String>> isBetween(int minLength, int maxLength) {
        return val -> val.constraint(
                hasMinLength(val.value(), minLength) && hasMaxLength(val.value(), maxLength),
                () -> format(ERROR_MESSAGE_RANGE_TEMPLATE, getValueFormatted(val), minLength, maxLength)
        );
    }

    public static Consumer<Validation<String>> isUUID() {
        return val -> val.constraint(
                isValidPattern(val.value(), UUID_PATTERN),
                () -> format("%s should be a UUID", getValueFormatted(val))
        );
    }

    // Integer

    public static Consumer<Validation<Integer>> isNotNullInteger() {
        return val -> val.constraint(
                isNotNull(val.value()), () -> format(NULL_ERROR_MESSAGE_TEMPLATE, getValueFormatted(val))
        );
    }

    public static Consumer<Validation<Integer>> isGreatThanOrEqual(Integer minSize) {
        return val -> val.constraint(
                isGreatThanOrEqual(val.value(), minSize),
                () -> format(ERROR_MESSAGE_GREATER_THAN_TEMPLATE, getValueFormatted(val), minSize)
        );
    }

    private static boolean isGreatThanOrEqual(Integer value, Integer minSize) {
        return isNotNull(value) && value >= minSize;
    }

    public static Consumer<Validation<Integer>> isLessThanOrEqual(Integer maxSize) {
        return val -> val.constraint(
                isLessThanOrEqual(val.value(), maxSize),
                () -> format(ERROR_MESSAGE_LESS_THAN_TEMPLATE, getValueFormatted(val), maxSize)
        );
    }

    private static boolean isLessThanOrEqual(Integer value, Integer maxSize) {
        return isNotNull(value) && value <= maxSize;
    }

    public static Consumer<Validation<Integer>> isInRange(Integer minSize, Integer maxSize) {
        return val -> val.constraint(
                isGreatThanOrEqual(val.value(), minSize) && isLessThanOrEqual(val.value(), maxSize),
                () -> format(ERROR_MESSAGE_RANGE_TEMPLATE, getValueFormatted(val), minSize, maxSize)
        );
    }

    // Long

    public static Consumer<Validation<Long>> isNotNullLong() {
        return val -> val.constraint(
                isNotNull(val.value()), () -> format(NULL_ERROR_MESSAGE_TEMPLATE, getValueFormatted(val))
        );
    }

    public static Consumer<Validation<Long>> isGreatThanOrEqual(Long minSize) {
        return val -> val.constraint(
                isGreatThanOrEqual(val.value(), minSize),
                () -> format(ERROR_MESSAGE_GREATER_THAN_TEMPLATE, getValueFormatted(val), minSize)
        );
    }

    private static boolean isGreatThanOrEqual(Long value, Long minSize) {
        return isNotNull(value) && value >= minSize;
    }

    public static Consumer<Validation<Long>> isLessThanOrEqual(Long maxSize) {
        return val -> val.constraint(
                isLessThanOrEqual(val.value(), maxSize),
                () -> format(ERROR_MESSAGE_LESS_THAN_TEMPLATE, getValueFormatted(val), maxSize)
        );
    }

    private static boolean isLessThanOrEqual(Long value, Long maxSize) {
        return isNotNull(value) && value <= maxSize;
    }

    public static Consumer<Validation<Long>> isBetween(Long minSize, Long maxSize) {
        return val -> val.constraint(
                isGreatThanOrEqual(val.value(), minSize) && isLessThanOrEqual(val.value(), maxSize),
                () -> format(ERROR_MESSAGE_RANGE_TEMPLATE, getValueFormatted(val), minSize, maxSize)
        );
    }

    // Double

    public static Consumer<Validation<Double>> isNotNullDouble() {
        return val -> val.constraint(
                isNotNull(val.value()), () -> format(NULL_ERROR_MESSAGE_TEMPLATE, getValueFormatted(val))
        );
    }

    public static Consumer<Validation<Double>> isGreatThanOrEqual(Double minSize) {
        return val -> val.constraint(
                isGreatThanOrEqual(val.value(), minSize),
                () -> format(ERROR_MESSAGE_GREATER_THAN_TEMPLATE, getValueFormatted(val), minSize)
        );
    }

    private static boolean isGreatThanOrEqual(Double value, Double minSize) {
        return isNotNull(value) && value >= minSize;
    }

    public static Consumer<Validation<Double>> isLessThanOrEqual(Double maxSize) {
        return val -> val.constraint(
                isLessThanOrEqual(val.value(), maxSize),
                () -> format(ERROR_MESSAGE_LESS_THAN_TEMPLATE, getValueFormatted(val), maxSize)
        );
    }

    private static boolean isLessThanOrEqual(Double value, Double maxSize) {
        return isNotNull(value) && value <= maxSize;
    }

    public static Consumer<Validation<Double>> isBetween(Double minSize, Double maxSize) {
        return val -> val.constraint(
                isGreatThanOrEqual(val.value(), minSize) && isLessThanOrEqual(val.value(), maxSize),
                () -> format(ERROR_MESSAGE_RANGE_TEMPLATE, getValueFormatted(val), minSize, maxSize)
        );
    }

    // Boolean

    public static Consumer<Validation<Boolean>> isNotNullBoolean() {
        return val -> val.constraint(
                isNotNull(val.value()), () -> format(NULL_ERROR_MESSAGE_TEMPLATE, getValueFormatted(val))
        );
    }

    private static boolean isNotNull(Object value) {
        return value != null;
    }

    private static <T> String getValueFormatted(Validation<T> value) {
        String val = value != null ? String.valueOf(value.value()) : NULL;
        return "("  + val + ")";
    }
}
