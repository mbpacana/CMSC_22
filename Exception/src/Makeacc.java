public class Makeacc{
	public static void main(String[] args){
		Account a = new Account(511,1000.00);

		a.credit(500.00);
		System.out.println(a);
		a.credit(1000.00);
		System.out.println(a);
		a.debit(2000.00);
		System.out.println(a);
		a.debit(1000.00);
		a.credit(-1);
		a.debit()

	}

}
