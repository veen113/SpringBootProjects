package com.praveen.springbootreceipes.calculator;

import com.praveen.springbootreceipes.calculator.operation.Multiplication;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class MultiplicationTest {

    private final Multiplication multiplication = new Multiplication();

    @Test
    public void shouldMatchOperation() {
        assertThat(true,is(multiplication.handles('*')));
        assertFalse( multiplication.handles('+'));
    }

    @Test
    public void shouldCorrectlyApplyFormula() {
        assertEquals(20,multiplication.apply(4,5));
        assertEquals(36,multiplication.apply(6,6));
    }
}
