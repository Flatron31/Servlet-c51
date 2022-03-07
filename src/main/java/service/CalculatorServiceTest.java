package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void getResultOperationCalculator() {
        String result = calculatorService.getResultOperationCalculator("2", "2" , "sum");
        assertEquals("4.0", result);
    }
}