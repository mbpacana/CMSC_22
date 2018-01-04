/**
    File created by Michael Loewe Alivio
**/
public class Account{
	private int accountNumber;
	private double balance;

	Account(){
		accountNumber = 0;
		balance = 0.0;
	}

	Account(int aNum, double bal){
	    if(aNum < 0){
            throw new IllegalArgumentException("Your Account Number is a negative... Please change it..");
	    }
		accountNumber = aNum;
		setBalance(bal);
	}

	Account(int aNum){
		accountNumber = aNum;  //Jace: can this anum be rewritten as aNum, to follow camelcase convention?
		balance = 0.0;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double bal){
		if(bal < 0.0){
			throw new IllegalArgumentException("WRONG set balance..negative value!");	//Jace: descriptive message, if possible
		}
		balance = bal;
	}

	public void credit(double amount){
		if(amount < 0.0){
			throw new IllegalArgumentException("WRONG set amount..negative value!"); //Jace: also here
		}

		balance = balance + amount;
	}

	public void debit(double amount){
		if(amount < 0.0){
			throw new IllegalArgumentException("WRONG set amount..negative value!"); //Jace: also here
		}

		if(balance >= amount){
			balance = balance - amount;

		}
		else{
			System.out.println("Amount Withdrawn exceeds the current balance!");
		}
	}

	public String toString(){
		String acc;
		acc = String.format("A/C no:%03d, Balance = $%.2f",accountNumber,balance);
		return acc;
	}

}
