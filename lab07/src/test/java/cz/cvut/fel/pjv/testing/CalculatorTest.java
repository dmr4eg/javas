package cz.cvut.fel.pjv.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest{
    @Test
    public void testAdd() {
        int a = 1;
        int b = 2;
        int expected = 3;
        int actual = new Calculator().add(a, b);
        assertEquals(expected, actual);
    }

    public void testSubtract() {
    }

    public void testMultiply() {
    }

    @Test
    public void testDivide() {
        int a = 15;
        int b = 50;
        assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                int actual = new Calculator().divide(a, b);
            }
        }
        );
    }
}