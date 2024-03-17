package PW4.CC;

import java.math.BigDecimal;

public class CreditCard {


    private BigDecimal creditLimit;
    private BigDecimal balance;

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public boolean isLimitAssigned(){
        return creditLimit!=null;
    }
    public void AssignCreditCardLimit(BigDecimal creditLimit){
        if(this.isLimitAssigned()){
            throw new LimitAlreadyAssignedException();
        }
        if(creditLimit.intValue()<100){
            throw new LimitBelowTresholdException();
        }
        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }
    public boolean isWithdrawOverBalance(BigDecimal value){
        return balance.compareTo(value)<0;

    }
    public void withdraw(BigDecimal value){
        if(isWithdrawOverBalance(value)){
            throw new WithdrawOverBalanceException();
        }
        balance = balance.subtract(value);

    }
}
