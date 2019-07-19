package com.praveen.springbootreceipes.calculator;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Calculator {
    private final Collection<Operation> operations;

    public Calculator(Collection<Operation> operations) {
        this.operations = operations;
    }

    public void calculate(int lhs, int rhs, char op) {
        for(Operation operation: operations) {
            if(operation.handles(op)) {
                int result = operation.apply(lhs,rhs);
                System.out.println(String.format("%d %s %d = %s%n",lhs, op, rhs, result));
                return;
            }
        }
        throw new IllegalArgumentException("Un-Known Operation" + op);
    }
}
