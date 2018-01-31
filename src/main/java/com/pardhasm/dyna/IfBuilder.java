package com.pardhasm.dyna;

import javax.xml.bind.ValidationException;
import java.util.List;

public enum IfBuilder {
    instance;

    public String build(List<String> expressions, List<String> operators, List<String> statements)
            throws ValidationException {
        validate(expressions, statements);
        StringBuilder builder = new StringBuilder();
        builder.append(" if( ")
               .append(expressions.get(0));
        for (int i = 0; i < expressions.size(); i++) {
            builder.append(" ");
            builder.append(operators.get(i));
            builder.append(" ");
            builder.append(expressions.get(i + 1));
        }
        builder.append(" ){");
        for (String st : statements) {
            builder.append(st);
            builder.append(";");
        }
        builder.append(" }");
        return builder.toString();
    }

    private void validate(List<String> expressions, List<String> operators) throws ValidationException {

        if (expressions.isEmpty()) {
            throw new ValidationException("No expressions provided");
        }

        if (expressions.size() - operators.size() != 1) {
            throw new ValidationException("Number of operators should be 1 less than expressions provided");
        }
    }
}
