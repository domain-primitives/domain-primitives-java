package de.novatec.ddd.domainprimitives.assertion;

import de.novatec.ddd.domainprimitives.type.BooleanValueObject;
import de.novatec.ddd.domainprimitives.type.StringValueObject;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BooleanAssert;
import org.assertj.core.api.StringAssert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static de.novatec.ddd.domainprimitives.assertion.ValueObjectAssertion.assertThat;


class ValueObjectAssertTests {

	@Nested
	class StringValueObjectAssertTest {

		private StringExampleObject getExample(String value) {
			return new StringExampleObject(value);
		}

		@Nested
		class HasValueAssert {

			@Test
			void passesForCorrectValue() {
				StringExampleObject foo = getExample("foobar");

				assertThat(foo).hasValue("foobar");
			}

			@Test
			void failsForWrongValue() {
				StringExampleObject foo = getExample("foo");

				Assertions.assertThatThrownBy(() -> assertThat(foo).hasValue("notFoo"))
						.isInstanceOf(AssertionError.class);
			}
		}

		@Nested
		class ValueDelegate {

			@Test
			void delegatesToValueAssert() {
				StringExampleObject foo = getExample("foo");

				Assertions.assertThat(assertThat(foo).value()).isInstanceOf(StringAssert.class);
			}
		}

		@Nested
		class AssertionsProvideFluentApi {

			@Test
			void hasValue() {
				StringValueObjectAssert<StringValueObject> original = assertThat(getExample("foo"));
				StringValueObjectAssert<StringValueObject> returned = original.hasValue("foo");
				Assertions.assertThat(returned).isSameAs(original);
			}
		}
	}

	@Nested
	class BooleanValueObjectAssertTest {

		@Nested
		class HasValueAssert {

			@Test
			void passesForCorrectValue() {
				BooleanExampleObject foo = new BooleanExampleObject(true);

				assertThat(foo).hasValue(true);
			}

			@Test
			void failsForWrongValue() {
				BooleanExampleObject foo = new BooleanExampleObject(true);

				Assertions.assertThatThrownBy(() -> assertThat(foo).hasValue(false))
						.isInstanceOf(AssertionError.class);
			}
		}

		@Nested
		class ValueNotNull {

			@Test
			void passesForCorrectValue() {
				BooleanExampleObject foo = new BooleanExampleObject(true);

				assertThat(foo).hasNotNullValue();
			}

			@Test
			void failsForWrongValue() {
				BooleanExampleObject foo = new BooleanExampleObject(null);

				Assertions.assertThatThrownBy(() -> assertThat(foo).hasNotNullValue())
						.isInstanceOf(AssertionError.class);
			}
		}

		@Nested
		class ValueDelegate {

			@Test
			void delegatesToValueAssert() {
				BooleanExampleObject foo = new BooleanExampleObject(true);

				Assertions.assertThat(assertThat(foo).value()).isInstanceOf(BooleanAssert.class);
			}
		}


		@Nested
		class AssertionsProvideFluentApi {

			@Test
			void hasValue() {
				BooleanValueObjectAssert<BooleanValueObject> original = assertThat(new BooleanExampleObject(true));
				BooleanValueObjectAssert<BooleanValueObject> returned = original.hasValue(true);
				Assertions.assertThat(returned).isSameAs(original);
			}

			@Test
			void hasValueNotNull() {
				BooleanValueObjectAssert<BooleanValueObject> original = assertThat(new BooleanExampleObject(true));
				BooleanValueObjectAssert<BooleanValueObject> returned = original.hasNotNullValue();
				Assertions.assertThat(returned).isSameAs(original);
			}
		}
	}

	static class StringExampleObject extends StringValueObject {
		public StringExampleObject(String value) {
			super(value);
		}
	}

	static class BooleanExampleObject extends BooleanValueObject {
		public BooleanExampleObject(Boolean value) {
			super(value);
		}
	}
}
