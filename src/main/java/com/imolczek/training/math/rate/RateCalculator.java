package com.imolczek.training.math.rate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BisectionSolver;

import com.imolczek.training.finance.model.CashFlow;

public class RateCalculator {
    
    
    public static void main(String[] args) {
        
        List<CashFlow> installments = new ArrayList<CashFlow>();
        
        installments.add(
            new CashFlow(
                new BigDecimal(-5000),
                LocalDate.of(2019, Month.JANUARY, 1)
                )
            );
        
        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.FEBRUARY, 1)
                )
            );
        
        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.MARCH, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.APRIL, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.MAY, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.JUNE, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.JULY, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.AUGUST, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.SEPTEMBER, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.OCTOBER, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.NOVEMBER, 1)
                )
            );

        installments.add(
            new CashFlow(
                new BigDecimal(500),
                LocalDate.of(2019, Month.DECEMBER, 1)
                )
            );
        
        UnivariateFunction discountedValueEquation = new DiscountedValueEquation(installments);
        
        BisectionSolver bisectionSolver = new BisectionSolver();
        double rate = bisectionSolver.solve(100, discountedValueEquation, -1d, 1d);
        
        System.out.println("Rate: " + rate);
    }
    
}
