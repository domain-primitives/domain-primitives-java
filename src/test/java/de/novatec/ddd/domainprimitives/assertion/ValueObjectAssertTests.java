package de.novatec.ddd.domainprimitives.assertion;

import de.novatec.ddd.domainprimitives.type.BooleanValueObject;
import de.novatec.ddd.domainprimitives.type.StringValueObject;
import org.assertj.core.api.Assertions;
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
				StringExampleObject foo = getExample("foo");

				assertThat(foo).hasValue("foo");
			}

			@Test
			void failsForWrongValue() {
				StringExampleObject foo = getExample("foo");

				Assertions.assertThatThrownBy(() -> assertThat(foo).hasValue("notFoo"))
						.isInstanceOf(AssertionError.class);
			}
		}

		@Nested
		class HasValueContainingAssert {

			@Test
			void passesForContainingValue() {
				StringExampleObject foo = getExample("FooBar");

				assertThat(foo).hasValueContaining("oB");
			}

			@Test
			void failsForNotContainingValue() {
				StringExampleObject foo = getExample("foo");

				Assertions.assertThatThrownBy(() -> assertThat(foo).hasValueContaining("b"))
						.isInstanceOf(AssertionError.class);
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

			@Test
			void hasValueContaining() {
				StringValueObjectAssert<StringValueObject> original = assertThat(getExample("Foobar"));
				StringValueObjectAssert<StringValueObject> returned = original.hasValueContaining("ob");
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
		class AssertionsProvideFluentApi {

			@Test
			void hasValue() {
				BooleanValueObjectAssert<BooleanValueObject> original = assertThat(new BooleanExampleObject(true));
				BooleanValueObjectAssert<BooleanValueObject> returned = original.hasValue(true);
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
