package de.novatec.ddd.domainprimitives.object;

import de.novatec.ddd.domainprimitives.validation.ObjectValidation;

public abstract class Entity extends DomainObject {
	protected Entity(ObjectValidation checkList) {
		super(checkList);
	}
}
