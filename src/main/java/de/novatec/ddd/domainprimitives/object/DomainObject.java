package de.novatec.ddd.domainprimitives.object;

import de.novatec.ddd.domainprimitives.validation.ObjectValidation;

public abstract class DomainObject {

    protected DomainObject(ObjectValidation checkList) {
        validate(checkList);
    }

    private void validate(ObjectValidation checkList) {
        checkList.forObject(this.getClass().getSimpleName());
        checkList.validate();
    }
}
