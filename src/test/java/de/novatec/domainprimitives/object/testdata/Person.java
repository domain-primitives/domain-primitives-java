package de.novatec.domainprimitives.object.testdata;

import de.novatec.domainprimitives.object.Aggregate;

public class Person extends Aggregate {

    private final PersonId personId;
    private final Name name;

    public Person(PersonId personId, Name name) {
        this.personId = personId;
        this.name = name;

        this.validate();
    }

    public PersonId getPersonId() {
        return personId;
    }

    @Override
    protected void validate() {
        validateNotNull(personId, "Person ID");
        validateNotNull(name, "Name");

        if ((personId != null && personId.getValue().equals(12L)) &&
                (name != null && "Peter".equals(name.getValue()))) {
            addInvariantViolation("This is not allowed");
        }

        evaluateValidations();
    }
}
