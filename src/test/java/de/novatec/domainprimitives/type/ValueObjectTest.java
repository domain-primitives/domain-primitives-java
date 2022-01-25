package de.novatec.domainprimitives.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueObjectTest {

    @Test
    void should_set_simple_class_name_as_lable_if_none_provided() {
        PrimitiveStringNoLable stringNotNull = new PrimitiveStringNoLable(null);
        assertEquals(PrimitiveStringNoLable.class.getSimpleName(), stringNotNull.getLabel());
    }
}

class PrimitiveStringNoLable extends ValueObject<String> {
    protected PrimitiveStringNoLable(String value) {
        super(value);
    }
}