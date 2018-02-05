package com.pardhasm.dyna;

import org.apache.commons.collections4.CollectionUtils;

import javax.xml.bind.ValidationException;
import java.util.List;

public enum  ELSEBuilder {
    instance;

    public String build(List<String> expressions, List<String> operators, List<String> statements)
            throws ValidationException {
        StringBuilder builder = new StringBuilder();
        builder.append("else ");
        if(CollectionUtils.isNotEmpty(expressions)){
            IfBuilder.instance.build(expressions,operators,statements);
        }else{
            builder.append("{");
            for (String st : statements) {
                builder.append(st)
                       .append(";");
            }
            builder.append(" }");
        }
        return  builder.toString();
    }


}
