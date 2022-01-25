# Domain Primitives Java

![License](https://img.shields.io/hexpm/l/plug)

Primitive, self-validating immutable object types.

*As proposed by [Stefan Ludwig](https://github.com/slu-it) in his [strongly-typed-vs-javax-validation](https://github.com/slu-it/technology-examples/tree/master/strongly-typed-vs-javax-validation) prototype.*

# Table of Contents

* 🚀 [Features](#features)
* 📚 [Releases](#releases)
* 👩‍💻/👨‍💻 [Contributing](#contributing)
* 📨 [Contact](#contact)

# 🚀Features

## ValueObject Type

The `ValueObject<T>` could be used to create a self-validating immutable object:

```java
class Name extends ValueObject<String> {
    public Name(String value) {
        super(value, isNotNull().andThen(hasMinLength(3).andThen(hasMaxLength(20))));
    }
}
```

It's only possible to create a valid object if it matches the pattern. The `ValueObject` does only provide a getter resulting in an immutable object.

Creating a name object with an invalid value will throw an InvariantException:

```java
class NameTest {

    @Test
    void should_create_valid_object() {
        String nameValue = "Peter";
        Name name = new Name(nameValue);
        assertNotNull(name);
        assertEquals(nameValue, name.getValue());
    }

    @Nested
    class InvariantTest {
        @Test
        void should_throw_invariant_exception_if_value_is_null() {
            InvariantException exception = assertThrows(
                    InvariantException.class,
                    () -> new Name(null));

            assertEquals(
                    "Value(s) of Name is not valid: Name (null) should not be null. Name (null) should be longer than 3. Name (null) should not be longer than 20.",
                    exception.getMessage());
        }

        @Test
        void should_throw_invariant_exception_if_value_is_to_short() {
            String value = "AB";
            InvariantException exception = assertThrows(
                    InvariantException.class,
                    () -> new Name(value));

            assertEquals(
                    "Value(s) of Name is not valid: Name (" + value + ") should be longer than 3.",
                    exception.getMessage());
        }

        @Test
        void should_throw_invariant_exception_if_value_is_to_long() {
            String value = "ABCDEFGHIJKLMNOPQRSTU";
            InvariantException exception = assertThrows(
                    InvariantException.class,
                    () -> new Name(value));

            assertEquals(
                    "Value(s) of Name is not valid: Name (" + value + ") should not be longer than 20.",
                    exception.getMessage());
        }
    }
}
```

## Composed Value Objects, Aggregates and Entities

The abstract `ComposedValueObject`, `Aggregate` and `Entity` classes allow expressive definitions with some helpful methods for validation.

Have a look, e.g. at the [`Person`](src/test/java/de/novatec/domainprimitives/object/testdata/Person.java) example.

Providing methods for null-validation (`validateNotNull`) and adding custom validations (`addInvariantViolation`) to the list of violations, which could be evaluated (`evaluateValidations`).

# 📚Releases

tbd

# 👩‍💻/👨‍💻Contributing

Do you want to contribute to our open source project?
Read the [Contribution Guidelines](CONTRIBUTING.md) and get started 🙂 

# 📨Contact

If you have any questions or ideas feel free to create an [issue](https://github.com/domain-primitives/domain-primitives-java/issues).

This open source project is being developed by [Novatec Consulting GmbH](https://www.novatec-gmbh.de/) with the support of the open source community.

![Novatec Consulting GmbH](novatec.jpeg)