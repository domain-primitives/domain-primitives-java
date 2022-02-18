package de.novatec.ddd.domainprimitives.object;

import de.novatec.ddd.domainprimitives.object.testdata.Name;
import de.novatec.ddd.domainprimitives.object.testdata.Person;
import de.novatec.ddd.domainprimitives.object.testdata.PersonId;
import de.novatec.ddd.domainprimitives.validation.InvariantException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomainObjectTest {

    @Test
    void should_create_object_if_valid() {
        PersonId personId = new PersonId(1L);
        Name name = new Name("Peter");

        Person person = new Person(personId, name);

        assertNotNull(person);
        assertEquals(personId, person.getPersonId());
    }

    @Test
    void should_throw_invariant_exception_if_field_is_null() {
        Name name = new Name("Peter");
        InvariantException exception = assertThrows(InvariantException.class, () -> new Person(null, name));

        assertEquals("Value(s) of Person is not valid:\r\n"
                + "  Value(s) of Person ID is not valid: Person ID (null) should not be null.", exception.getMessage());
    }

    @Test
    void should_throw_invariant_exception_if_custom_violation() {
        PersonId personId = new PersonId(12L);
        Name name = new Name("Peter");
        InvariantException exception = assertThrows(InvariantException.class, () -> new Person(personId,name));

        assertEquals("Value(s) of Person is not valid:\r\n"
                + "  Value(s) of PersonID and Name Constraint is not valid: PersonID and Name Constraint Name Peter with id 12 is not allowed.", exception.getMessage());
    }

    @Test
    void should_throw_invariant_exception_if_field_is_null_with_multiple_fields() {
        InvariantException exception = assertThrows(InvariantException.class, () -> new Person(null, null));

        assertEquals("Value(s) of Person is not valid:\r\n"
                + "  Value(s) of Person ID is not valid: Person ID (null) should not be null.\r\n"
                + "  Value(s) of Name is not valid: Name (null) should not be null.", exception.getMessage());
    }
}
