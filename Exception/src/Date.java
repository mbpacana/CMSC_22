/**
    File by Michael Loewe L. Alivio
**/
public class Date{ //comment by jace: signature?
	private int day;
	private int month;
	private int year;

	Date(){
		year = 1000;
		month = 1;
		day = 1;
	}

	Date(int yr, int mnth, int dy){
		setYear(yr);
		setMonth(mnth);
		setDay(dy);
	}

	public int getYear(){ return year; }

	public int getMonth(){ return month; }

	public int getDay(){ return day; }

	public void setYear(int yr){
		if(yr < 1000 || yr > 9999){
			throw new IllegalArgumentException("YEAR is either less than 1000 or greater than 9999!"); //comment by Jace: or pwede ra pud nimo i-describe ang error diri.
		}
		year = yr;
	}

	public void setMonth(int mnth){
		if(mnth < 1 || mnth > 12){
			throw new IllegalArgumentException("MONTH is either below 1 or greater than 12!"); //Jace: also here.
		}
		month = mnth;
	}

	public void setDay(int dy){
		if(dy < 1 || dy > 31 || febdays(dy) == false){ //comment by jace: too many compound conditions. Could this be placed in a function, too?
			throw new IllegalArgumentException("WRONG DAY INPUT");
		}
		else if((month == 4 || month == 6 || month == 9 || month == 11) && dy > 30){
			throw new IllegalArgumentException("WRONG DAY of the month");
		}
		day = dy;
	}

	public void setDate(int yr,int mnth,int dy){
		setYear(yr);
		setMonth(mnth);
		setDay(dy);
	}

	public String toString(){
		String datee;
		datee = String.format("%02d/%02d/%d",day,month,year);

		return datee;
	}

	private boolean leapyear(int yr){ //comment by Jace: I like how this is private instead of public. Nice one!
		if(yr % 4 == 0){
			if((yr % 100 == 0 && yr % 400 == 0) || yr % 100 != 0){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
    private boolean febdays(int d){
        boolean value;
        if(month == 2){
            value = leapyear(year);
            if(value == true && d > 29){
                return false;
            }
            else if(value == false && d >= 29){
                return false;
            }
            return true;
        }
        return true;
    }
}
