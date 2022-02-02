package de.novatec.ddd.domainprimitives.validation;

import de.novatec.ddd.domainprimitives.validation.testdata.booleanprimitiv.BooleanNotNull;
import de.novatec.ddd.domainprimitives.validation.testdata.doubleprimitive.IsBetweenDouble;
import de.novatec.ddd.domainprimitives.validation.testdata.doubleprimitive.IsGreatThanOrEqualDouble;
import de.novatec.ddd.domainprimitives.validation.testdata.doubleprimitive.IsLessThanOrEqualDouble;
import de.novatec.ddd.domainprimitives.validation.testdata.doubleprimitive.NotNullDouble;
import de.novatec.ddd.domainprimitives.validation.testdata.integerprimitive.IsBetweenInteger;
import de.novatec.ddd.domainprimitives.validation.testdata.integerprimitive.IsGreatThanOrEqualInteger;
import de.novatec.ddd.domainprimitives.validation.testdata.integerprimitive.IsLessThanOrEqualInteger;
import de.novatec.ddd.domainprimitives.validation.testdata.integerprimitive.NotNullInteger;
import de.novatec.ddd.domainprimitives.validation.testdata.longprimitive.IsBetweenLong;
import de.novatec.ddd.domainprimitives.validation.testdata.longprimitive.IsGreatThanOrEqualLong;
import de.novatec.ddd.domainprimitives.validation.testdata.longprimitive.IsLessThanOrEqualLong;
import de.novatec.ddd.domainprimitives.validation.testdata.longprimitive.NotNullLong;
import de.novatec.ddd.domainprimitives.validation.testdata.stringprimitive.*;
import de.novatec.ddd.domainprimitives.validation.testdata.temporal.TemporalInFuture;
import de.novatec.ddd.domainprimitives.validation.testdata.temporal.TemporalInPast;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DateTimeException;
import java.time.temporal.Temporal;
import java.util.UUID;

import static de.novatec.ddd.domainprimitives.validation.argumentgenerator.TemporalGenerator.future;
import static de.novatec.ddd.domainprimitives.validation.argumentgenerator.TemporalGenerator.past;
import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.*;

public class ConstraintsTest {

    @Nested
    class StringValueObjectTest {
        private final String expectedString = "Test";

        @Test
        void should_create_object_if_value_is_not_null() {
            StringNotNull stringNotNull = new StringNotNull(expectedString);
            assertNotNull(stringNotNull);
            assertEquals(expectedString, stringNotNull.getValue());
        }

        @Test
        void should_throw_invariant_exception_if_string_is_null() {
            assertThrows(InvariantException.class, () -> new StringNotNull(null));
        }

        @Test
        void should_create_object_if_value_is_blank() {
            StringNotBlank stringNotBlankObj = new StringNotBlank(expectedString);
            assertNotNull(stringNotBlankObj);
            assertEquals(expectedString, stringNotBlankObj.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(strings = {"", " ", "     "})
        void should_throw_invariant_exception_if_string_is_empty(String getValue) {
            assertThrows(InvariantException.class, () -> new StringNotBlank(getValue));
        }

        @Test
        void should_create_object_if_value_is_pattern() {
            StringPattern stringPattern = new StringPattern(expectedString);
            assertNotNull(stringPattern);
            assertEquals(expectedString, stringPattern.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(strings = {"1234", "ABC1234"})
        void should_throw_invariant_exception_if_string_does_not_match_pattern(String getValue) {
            assertThrows(InvariantException.class, () -> new StringPattern(getValue));
        }

        @Test
        void should_create_object_if_valid_min_length() {
            String minLengthExample = "abc";
            System.out.println(minLengthExample.length());
            MinLengthString minLengthString = new MinLengthString(minLengthExample);
            assertNotNull(minLengthString);
            assertEquals(minLengthExample, minLengthString.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(strings = {"aa", "a", " ", ""})
        void should_throw_invariant_exception_if_string_does_not_have_min_length(String getValue) {
            assertThrows(InvariantException.class, () -> new MinLengthString(getValue));
        }

        @Test
        void should_create_object_if_valid_max_length() {
            String maxLengthExample = "abcde";
            MaxLengthString maxLengthString = new MaxLengthString(maxLengthExample);
            assertNotNull(maxLengthString);
            assertEquals(maxLengthExample, maxLengthString.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(strings = {"abcdef", "abcdefrf"})
        void should_throw_invariant_exception_if_string_does_not_have_max_length(String getValue) {
            assertThrows(InvariantException.class, () -> new MaxLengthString(getValue));
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc", "abcd", "abcd"})
        void should_create_object_if_valid_between(String getValue) {
            LengthBetweenString lengthBetweenString = new LengthBetweenString(getValue);
            assertNotNull(lengthBetweenString);
            assertEquals(getValue, lengthBetweenString.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(strings = {"ab", "abcdef"})
        void should_throw_invariant_exception_if_string_is_not_between_min_max(String getValue) {
            assertThrows(InvariantException.class, () -> new LengthBetweenString(getValue));
        }

        @Test
        void should_create_object_if_valid_uuid() {
            String uuidStringExample = UUID.randomUUID().toString();
            UUIDString uuidString = new UUIDString(uuidStringExample);
            assertNotNull(uuidString);
            assertEquals(uuidStringExample, uuidString.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(strings = {"abc", "123e4567-e89b-12d3-a456-42661417400"})
        void should_throw_invariant_exception_if_string_is_not_valid_uuid(String getValue) {
            assertThrows(InvariantException.class, () -> new UUIDString(getValue));
        }

        @Test
        void should_equal_if_object_value_is_equal() {
            StringNotNull stringNotNullOne = new StringNotNull(expectedString);
            StringNotNull stringNotNullTow = new StringNotNull(expectedString);
            assertEquals(stringNotNullOne, stringNotNullTow);
            assertEquals(expectedString, stringNotNullOne.getValue());
            assertEquals(expectedString, stringNotNullTow.getValue());
        }
    }

    @Nested
    class IntegerValueObjectTest {
        private final Integer expectedInteger = 4;

        @Test
        void should_create_object_if_is_valid_not_null() {
            NotNullInteger notNullInteger = new NotNullInteger(expectedInteger);
            assertNotNull(notNullInteger);
            assertEquals(expectedInteger, notNullInteger.getValue());
        }

        @Test
        void should_throw_invariant_exception_if_integer_is_null() {
            assertThrows(InvariantException.class, () -> new NotNullInteger(null));
        }

        @Test
        void should_create_object_if_is_valid_is_greater_than() {
            IsGreatThanOrEqualInteger isGreatThanOrEqualInteger = new IsGreatThanOrEqualInteger(expectedInteger);
            assertNotNull(isGreatThanOrEqualInteger);
            assertEquals(expectedInteger, isGreatThanOrEqualInteger.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(ints = {1, 2, 3})
        void should_throw_invariant_exception_if_integer_not_greater_than(Integer getValue) {
            assertThrows(InvariantException.class, () -> new IsGreatThanOrEqualInteger(getValue));
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4})
        void should_create_object_if_is_valid_is_less_than(Integer getValue) {
            IsLessThanOrEqualInteger isLessThanOrEqualInteger = new IsLessThanOrEqualInteger(getValue);
            assertNotNull(isLessThanOrEqualInteger);
            assertEquals(getValue, isLessThanOrEqualInteger.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(ints = {5, 6, 6})
        void should_throw_invariant_exception_if_long_not_less_than(Integer getValue) {
            assertThrows(InvariantException.class, () -> new IsLessThanOrEqualInteger(getValue));
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4})
        void should_create_object_if_is_valid_is_between(Integer getValue) {
            IsBetweenInteger isBetweenInteger = new IsBetweenInteger(getValue);
            assertNotNull(isBetweenInteger);
            assertEquals(getValue, isBetweenInteger.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(ints = {0, 5, 6, 6})
        void should_throw_invariant_exception_if_not_between(Integer getValue) {
            assertThrows(InvariantException.class, () -> new IsBetweenInteger(getValue));
        }

        @Test
        void should_equal_if_object_value_is_equal() {
            NotNullInteger notNullIntegerOne = new NotNullInteger(expectedInteger);
            NotNullInteger notNullIntegerTwo = new NotNullInteger(expectedInteger);
            assertEquals(notNullIntegerOne, notNullIntegerTwo);
            assertEquals(expectedInteger, notNullIntegerOne.getValue());
            assertEquals(expectedInteger, notNullIntegerTwo.getValue());
        }
    }

    @Nested
    class LongValueObjectTest {
        private final Long expectedLong = 4L;

        @Test
        void should_create_object_if_is_valid_not_null() {
            NotNullLong notNullLong = new NotNullLong(expectedLong);
            assertNotNull(notNullLong);
            assertEquals(expectedLong, notNullLong.getValue());
        }

        @Test
        void should_throw_invariant_exception_if_long_is_null() {
            assertThrows(InvariantException.class, () -> new NotNullLong(null));
        }

        @Test
        void should_create_object_if_is_valid_is_greater_than() {
            IsGreatThanOrEqualLong isGreatThanOrEqualLong = new IsGreatThanOrEqualLong(expectedLong);
            assertNotNull(isGreatThanOrEqualLong);
            assertEquals(expectedLong, isGreatThanOrEqualLong.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(longs = {1L, 2L, 3L})
        void should_throw_invariant_exception_if_long_not_greater_than(Long getValue) {
            assertThrows(InvariantException.class, () -> new IsGreatThanOrEqualLong(getValue));
        }

        @ParameterizedTest
        @ValueSource(longs = {1L, 2L, 3L, 4L})
        void should_create_object_if_is_valid_is_less_than(Long getValue) {
            IsLessThanOrEqualLong isLessThanOrEqualLong = new IsLessThanOrEqualLong(getValue);
            assertNotNull(isLessThanOrEqualLong);
            assertEquals(getValue, isLessThanOrEqualLong.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(longs = {5L, 6L, 6L})
        void should_throw_invariant_exception_if_long_not_less_than(Long getValue) {
            assertThrows(InvariantException.class, () -> new IsLessThanOrEqualLong(getValue));
        }

        @ParameterizedTest
        @ValueSource(longs = {1L, 2L, 3L, 4L})
        void should_create_object_if_is_valid_is_between(Long getValue) {
            IsBetweenLong isBetweenLong = new IsBetweenLong(getValue);
            assertNotNull(isBetweenLong);
            assertEquals(getValue, isBetweenLong.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(longs = {0L, 5L, 6L, 6L})
        void should_throw_invariant_exception_if_not_between(Long getValue) {
            assertThrows(InvariantException.class, () -> new IsBetweenLong(getValue));
        }

        @Test
        void should_equal_if_object_value_is_equal() {
            NotNullLong notNullLongOne = new NotNullLong(expectedLong);
            NotNullLong notNullLongTwo = new NotNullLong(expectedLong);
            assertEquals(notNullLongOne, notNullLongTwo);
            assertEquals(expectedLong, notNullLongOne.getValue());
            assertEquals(expectedLong, notNullLongTwo.getValue());
        }
    }

    @Nested
    class DoubleValueObjectTest {
        private final Double expectedValue = 1.0;

        @Test
        void should_create_object_if_is_valid_not_null() {
            NotNullDouble notNullDouble = new NotNullDouble(expectedValue);
            assertNotNull(notNullDouble);
            assertEquals(expectedValue, notNullDouble.getValue());
        }

        @Test
        void should_throw_invariant_exception_if_long_is_null() {
            assertThrows(InvariantException.class, () -> new NotNullDouble(null));
        }

        @Test
        void should_create_object_if_is_valid_is_greater_than() {
            IsGreatThanOrEqualDouble isGreatThanOrEqualDouble = new IsGreatThanOrEqualDouble(expectedValue);
            assertNotNull(isGreatThanOrEqualDouble);
            assertEquals(expectedValue, isGreatThanOrEqualDouble.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(doubles = {0.1, 0.3, 0.4})
        void should_throw_invariant_exception_if_double_not_greater_than(Double getValue) {
            assertThrows(InvariantException.class, () -> new IsGreatThanOrEqualDouble(getValue));
        }

        @ParameterizedTest
        @ValueSource(doubles = {1.0, 0.9, 0.8})
        void should_create_object_if_is_valid_is_less_than(Double getValue) {
            IsLessThanOrEqualDouble isLessThanOrEqualDouble = new IsLessThanOrEqualDouble(getValue);
            assertNotNull(isLessThanOrEqualDouble);
            assertEquals(getValue, isLessThanOrEqualDouble.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(doubles = {1.1, 2.0})
        void should_throw_invariant_exception_if_double_not_less_than(Double getValue) {
            assertThrows(InvariantException.class, () -> new IsLessThanOrEqualDouble(getValue));
        }

        @ParameterizedTest
        @ValueSource(doubles = {0.5, 0.7, 1.5})
        void should_create_object_if_is_valid_is_between(Double getValue) {
            IsBetweenDouble isBetweenDouble = new IsBetweenDouble(getValue);
            assertNotNull(isBetweenDouble);
            assertEquals(getValue, isBetweenDouble.getValue());
        }

        @ParameterizedTest
        @NullSource
        @ValueSource(doubles = {0.4, 1.6})
        void should_throw_invariant_exception_if_not_between(Double getValue) {
            assertThrows(InvariantException.class, () -> new IsBetweenDouble(getValue));
        }

        @Test
        void should_equal_if_object_value_is_equal() {
            NotNullDouble notNullDoubleOne = new NotNullDouble(expectedValue);
            NotNullDouble notNullDoubleTwo = new NotNullDouble(expectedValue);
            assertEquals(notNullDoubleOne, notNullDoubleTwo);
            assertEquals(expectedValue, notNullDoubleOne.getValue());
            assertEquals(expectedValue, notNullDoubleTwo.getValue());
        }
    }

    @Nested
    class BooleanPrimitivTypeTest {

        @Test
        void should_create_object_if_value_is_not_null() {
            BooleanNotNull booleanNotNull = new BooleanNotNull(TRUE);
            assertNotNull(booleanNotNull);
            assertTrue(booleanNotNull.getValue());
        }

        @Test
        void should_throw_invariant_exception_if_string_is_null() {
            assertThrows(InvariantException.class, () -> new BooleanNotNull(null));
        }
    }

    @Nested
    class TemporalPrimitivTypeTest {

        @Nested
        class FutureTemporalTest {

            @ParameterizedTest
            @MethodSource("de.novatec.ddd.domainprimitives.validation.argumentgenerator.TemporalGenerator#provideFutureTemporals")
            void should_create_object_if_value_is_in_the_future(Temporal futureTemporal) {
                TemporalInFuture dateInFuture = new TemporalInFuture(futureTemporal);
                assertNotNull(dateInFuture);
                assertEquals(futureTemporal, dateInFuture.getValue());
            }

            @ParameterizedTest
            @MethodSource("de.novatec.ddd.domainprimitives.validation.argumentgenerator.TemporalGenerator#provideUnsupportedTemporals")
            void should_throw_date_time_exception_if_temporal_type_is_unsupported(Temporal temporal) {
                assertThrows(DateTimeException.class, () -> new TemporalInFuture(temporal));
            }

            @Test
            void should_throw_invariant_exception_if_date_is_null() {
                assertThrows(InvariantException.class, () -> new TemporalInFuture(null));
            }

            @Test
            void should_throw_invariant_exception_if_date_is_now() {
                assertThrows(InvariantException.class, () -> new TemporalInFuture(now()));
            }

            @Test
            void should_throw_invariant_exception_if_date_has_passed() {
                assertThrows(InvariantException.class, () -> new TemporalInFuture(past()));
            }
        }

        @Nested
        class PastTemporalTest {

            @ParameterizedTest
            @MethodSource("de.novatec.ddd.domainprimitives.validation.argumentgenerator.TemporalGenerator#providePastTemporals")
            void should_create_object_if_value_is_in_the_past(Temporal pastTemporal) {
                TemporalInPast dateInPast = new TemporalInPast(pastTemporal);
                assertNotNull(dateInPast);
                assertEquals(pastTemporal, dateInPast.getValue());
            }

            @ParameterizedTest
            @MethodSource("de.novatec.ddd.domainprimitives.validation.argumentgenerator.TemporalGenerator#provideUnsupportedTemporals")
            void should_throw_date_time_exception_if_temporal_type_is_unsupported(Temporal temporal) {
                assertThrows(DateTimeException.class, () -> new TemporalInPast(temporal));
            }

            @Test
            void should_throw_invariant_exception_if_date_is_null() {
                assertThrows(InvariantException.class, () -> new TemporalInPast(null));
            }

            @Test
            void should_throw_invariant_exception_if_date_is_in_future() {
                assertThrows(InvariantException.class, () -> new TemporalInPast(future()));
            }
        }
    }
}

