package de.novatec.ddd.domainprimitives.object;

import de.novatec.ddd.domainprimitives.validation.ObjectValidation;

public abstract class ComposedValueObject extends DomainObject {
	protected ComposedValueObject(ObjectValidation checkList) {
		super(checkList);
	}
}
