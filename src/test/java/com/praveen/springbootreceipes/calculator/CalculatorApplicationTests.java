package com.praveen.springbootreceipes.calculator;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class)
public class CalculatorApplicationTests {

    @Autowired
    private Calculator calculator;

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test(expected = IllegalArgumentException.class)
    public void doingDivisionShouldFail() {
        calculator.calculate(12,13,'/');
    }

    @Test
    public void doingMultiplicationShouldSucced() {
        calculator.calculate(3,4,'*');
        capture.expect(Matchers.containsString("3 * 4 = 12"));
    }

}
