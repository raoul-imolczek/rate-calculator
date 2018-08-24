package com.imolczek.training.finance.rate;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math3.analysis.UnivariateFunction;

import com.imolczek.training.finance.model.CashFlow;

public class DiscountedValueEquation implements UnivariateFunction {

    private List<CashFlow> cashFlow;
    
    public DiscountedValueEquation(List<CashFlow> cashFlow) {
        this.cashFlow = cashFlow;
    }

    @Override
    public double value(double rate) {
        sortCashFlowItems();
        LocalDate startDate = this.cashFlow.get(0).getDate();
        
        double result = 0;
        
        System.out.println("Rate: " + rate);
        System.out.println("Start date: " + startDate);
        
        Iterator<CashFlow> cashFlowIterator = cashFlow.iterator();
        while(cashFlowIterator.hasNext()) {
            CashFlow cashFlowItem = cashFlowIterator.next();
            result += cashFlowItem.getDiscountedValue(startDate, rate);        
            System.out.println(cashFlowItem.getAmount() + " - " + cashFlowItem.getDate());            
        }

        System.out.println("Result: " + result);
        
        System.out.println("----");

        return result;
    }
    
    private void sortCashFlowItems() {
        this.cashFlow.sort(Comparator.comparing(CashFlow::getDate));    
    }
    
}
