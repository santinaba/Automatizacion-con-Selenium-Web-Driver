package com.example.service;

import com.example.model.OperationModel;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculateSimpleTest {
    
    CalculateSimple calc = new CalculateSimple();
    
    @Test
    public void testAdd() {
        OperationModel operationModel = new OperationModel(5, 4);
        int expResult = 9;
        int result = calc.add(operationModel);
        
        // Uso de assertThat y importamos el hamcreast is e equalTo
        assertThat(result, is(expResult));  // Matcher esta en los imports
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void testSubtract() {
        OperationModel operationModel = new OperationModel(10, 6);
        int expResult = 4;
        int result = calc.subtract(operationModel);
        
        // Uso de assertThat y importamos el hamcreast is e equalTo
        assertThat(result, is(expResult));  // Matcher esta en los imports
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void testMultiply() {
        OperationModel operationModel = new OperationModel(5, 4);
        int expResult = 20;
        int result = calc.multiply(operationModel);
        
        // Uso de assertThat y importamos el hamcreast is e equalTo
        assertThat(result, is(expResult));  // Matcher esta en los imports
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void testDivide() {
        OperationModel operationModel = new OperationModel(15, 3);
        double expResult = 5.0;
        double result = calc.divide(operationModel);
        
        // Uso de assertThat y importamos el hamcreast is e equalTo
        assertThat(result, is(expResult));  // Matcher esta en los imports
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void testFactorial() {
        OperationModel operationModel = new OperationModel(5);
        int expResult = 120;
        int result = calc.factorial(operationModel);
        
        // Uso de assertThat y importamos el hamcreast is e equalTo
        assertThat(result, is(expResult));  // Matcher esta en los imports
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void testFibonacci() {
        OperationModel operationModel = new OperationModel(5);
        int expResult = 5;
        int result = calc.fibonacci(operationModel);
        
        // Uso de assertThat y importamos el hamcreast is e equalTo
        assertThat(result, is(expResult));  // Matcher esta en los imports
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void testSqrt() {
        OperationModel operationModel = new OperationModel(81);
        double expResult = 9;
        double result = calc.sqrt(operationModel);
        
        // Uso de assertThat y importamos el hamcreast is e equalTo
        assertThat(result, is(expResult));  // Matcher esta en los imports
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void testPower() {
        OperationModel operationModel = new OperationModel(4);
        int expResult = 16;
        int result = calc.power(operationModel);
        
        // Uso de assertThat y importamos el hamcreast is e equalTo
        assertThat(result, is(expResult));  // Matcher esta en los imports
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void testClearSimple() {
        OperationModel operationModel = new OperationModel(10, 6);
        
        OperationModel expResult = new OperationModel(0, 0);
        OperationModel result = calc.clearSimple(operationModel);
        
        // Uso de diversos métodos assert
        assertThat(expResult.getA(), is(result.getA()));
        assertThat(expResult.getB(), is(result.getB()));
        assertThat(expResult.getA(), equalTo(result.getA()));
        assertThat(expResult.getB(), equalTo(result.getB()));
    }

    @Test
    public void testClearAdvanced() {
        OperationModel operationModel = new OperationModel(6);
        
        OperationModel expResult = new OperationModel(0);
        OperationModel result = calc.clearAdvanced(operationModel);
        
        // Uso de diversos métodos assert
        assertThat(expResult.getC(), is(result.getC()));
        assertThat(expResult.getC(), equalTo(result.getC()));
    }
    
}
