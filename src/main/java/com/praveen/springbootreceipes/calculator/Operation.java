package com.praveen.springbootreceipes.calculator;

public interface Operation {
    int apply(int lhs,int rhs);
    boolean handles(char op);
}
