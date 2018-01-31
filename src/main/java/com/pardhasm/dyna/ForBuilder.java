package com.pardhasm.dyna;

import javax.xml.bind.ValidationException;
import java.util.List;

public enum ForBuilder {
    instance;

    public String build(List<String> expressions, List<String> statements) throws ValidationException {
        validate(expressions, statements);
        StringBuilder builder = new StringBuilder();
        builder.append("for( ");
        builder.append(expressions.get(0))
               .append("; ");
        builder.append(expressions.get(1))
               .append("; ");
        builder.append(expressions.get(2))
               .append(" )");
        builder.append(" {");
        for (String st : statements) {
            builder.append(st);
            builder.append(";");
        }
        builder.append(" }");
        return builder.toString();
    }

    private void validate(List<String> expressions, List<String> operators) throws ValidationException {

        if (expressions.isEmpty() || expressions.size() != 3) {
            throw new ValidationException(" 3 expressions required");
        }

        if (expressions.size() - operators.size() != 1) {
            throw new ValidationException("Number of operators should be 1 less than expressions provided");
        }
    }
}
