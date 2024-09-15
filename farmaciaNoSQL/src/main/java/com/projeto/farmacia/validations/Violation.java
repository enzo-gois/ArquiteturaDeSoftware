package com.projeto.farmacia.validations;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Violation {

    private final String fieldName;
    private final String message;
    public Violation(String fieldName, String message) {
        super();
        this.fieldName = fieldName;
        this.message = message;
    }

    @Override
    public int hashCode() {return Objects.hash(fieldName,message);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)

            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Violation other = (Violation) obj;
        return Objects.equals(fieldName, other.fieldName) && Objects.equals(message, other.message);
    }


}
