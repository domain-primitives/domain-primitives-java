package de.novatec.ddd.domainprimitives.object.testdata;

import de.novatec.ddd.domainprimitives.object.Aggregate;

import static de.novatec.ddd.domainprimitives.validation.Constraints.conformsCheck;
import static de.novatec.ddd.domainprimitives.validation.Constraints.isNotNullObject;
import static de.novatec.ddd.domainprimitives.validation.ObjectValidation.check;
import static de.novatec.ddd.domainprimitives.validation.ObjectValidation.checks;

public class Person extends Aggregate {

	private final PersonId personId;
	private final Name name;


	/**
	 * This variant requires an all-args constructor
	 */
	public Person(PersonId personId, Name name) {
		super(checks(
				check(personId, "Person ID", isNotNullObject()),
				check(name, "Name", isNotNullObject()),
				check(() -> (personId != null && personId.getValue().equals(12L)) && (name != null &&"Peter".equals(name.getValue())),
						"PersonID and Name Constraint", conformsCheck(() -> "Name " +name + " with id "+ personId+ " is not allowed"))
		));
		this.personId = personId;
		this.name = name;
	}

	public Person(PersonId personId) {
		this(personId, new Name("defaultName"));
	}

	public Person(Name name) {
		this(new PersonId(123L), name);
	}

	public PersonId getPersonId() {
		return personId;
	}

	public Name getName() {
		return name;
	}
}
