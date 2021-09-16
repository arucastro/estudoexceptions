package model.entities;

import model.exceptions.LimitException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		setWithdrawLimit(withdrawLimit);;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) throws LimitException {
		//este m�todo realiza um saque e lan�a um erro caso 
		//os valores n�o respeitem as regras de neg�cio
		if (amount > this.getBalance()) {
			throw new LimitException("Not enough balance");
		}
		if (amount > this.getWithdrawLimit()) {
			throw new LimitException("Amount exceeds withdraw limit");
		}
		
		this.balance -= amount;
	}
}
