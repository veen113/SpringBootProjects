package com.praveen.springbootreceipes.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyChar;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    private Calculator calculator;
    private Operation mockOperation;

    @Before
    public void setUp() {
        mockOperation = Mockito.mock(Operation.class);
        calculator = new Calculator(Collections.singletonList(mockOperation));
    }

    @Test
    public void testAdditionCalculation() {
       when(mockOperation.handles(anyChar())).thenReturn(true);
       when(mockOperation.apply(3,5)).thenReturn(8);

       calculator.calculate(3,5,'+');
       verify(mockOperation,times(1)).apply(3,5);
    }
}
