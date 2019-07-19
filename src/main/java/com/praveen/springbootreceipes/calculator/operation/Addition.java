package com.praveen.springbootreceipes.calculator.operation;

import com.praveen.springbootreceipes.calculator.Operation;
import org.springframework.stereotype.Component;

@Component
public class Addition implements Operation {
    @Override
    public int apply(int lhs, int rhs) {
        return lhs + rhs;
    }

    @Override
    public boolean handles(char op) {
        return '+' == op;
    }
}
