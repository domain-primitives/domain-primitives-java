package io.github.domainprimitives.validation.argumentgenerator;

import org.junit.jupiter.params.provider.Arguments;

import java.time.*;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.temporal.TemporalAdjuster;
import java.util.stream.Stream;

import static java.time.LocalDateTime.now;
import static java.time.ZoneOffset.UTC;

public class TemporalGenerator {

    public static LocalDateTime future() {
        TemporalAdjuster temporalAdjusterHours = temporal -> temporal.plus(Duration.ofHours(1));
        TemporalAdjuster temporalAdjusterDay = temporal -> temporal.plus(Period.ofDays(1));
        return now().with(temporalAdjusterHours).with(temporalAdjusterDay);
    }

    public static LocalDateTime past() {
        TemporalAdjuster temporalAdjusterHours = temporal -> temporal.minus(Duration.ofHours(1));
        TemporalAdjuster temporalAdjusterDay = temporal -> temporal.minus(Period.ofDays(1));
        return now().with(temporalAdjusterHours).with(temporalAdjusterDay);
    }

    public static Stream<Arguments> provideFutureTemporals() {
        return buildTemporalStream(future());
    }

    public static Stream<Arguments> providePastTemporals() {
        return buildTemporalStream(past());
    }

    private static Stream<Arguments> buildTemporalStream(LocalDateTime localDateTime) {
        return Stream.of(
                Arguments.of(LocalDate.from(localDateTime)),
                Arguments.of(localDateTime),
                Arguments.of(LocalTime.from(localDateTime)),
                Arguments.of(ZonedDateTime.of(localDateTime, ZoneId.systemDefault())),
                Arguments.of(OffsetTime.of(LocalTime.from(localDateTime), UTC)),
                Arguments.of(OffsetDateTime.of(localDateTime, UTC))
        );
    }

    public static Stream<Arguments> provideUnsupportedTemporals() {
        return Stream.of(
                Arguments.of(HijrahDate.now()),
                Arguments.of(Instant.now()),
                Arguments.of(JapaneseDate.now()),
                Arguments.of(MinguoDate.now()),
                Arguments.of(ThaiBuddhistDate.now()),
                Arguments.of(Year.now()),
                Arguments.of(YearMonth.now())
        );
    }
}
