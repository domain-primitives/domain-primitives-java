package de.novatec.ddd.domainprimitives.object;

import de.novatec.ddd.domainprimitives.validation.ObjectValidation;

public abstract class Aggregate extends DomainObject {
	protected Aggregate(ObjectValidation checkList) {
		super(checkList);
	}
}
