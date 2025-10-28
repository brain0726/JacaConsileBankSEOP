package banking_4;

import java.util.Objects;


//계좌정보를 표현한 클래스로 NormalAccount, HighCreditAccount의 부모클래스가 된다. 
abstract public class Account implements ICustomDefine{
	//고객의 계좌정보는 계좌번호(String형), 이름(String형), 잔액(int형) 3가지만 저장 및 관리한다.
	String number;
	String name;
	int money;
	
	public Account (String number, String name,	int money) {
		this.number=number;
		this.name=name;
		this.money=money;
	}
	
	public void addMoney(int money){    // 입    금
		this.money+=money;
	}

	public void subMoney(int money){ // 출    금
		this.money-=money;
	}
	
	public void showAccInfo(){  // 전체계좌정보출력
        System.out.printf("계좌번호 : %s\n"
        		+ "고객이름 : %s\n"
        		+ "잔고 : %d\n",number,name,money);
	}
	
	@Override
	public int hashCode() {
		//방법1 : 멤버변수의 hash값을 얻어온 후 적당히 연산한다.
		int retCode1 = this.number.hashCode() 
			+ this.name.hashCode();	
		return retCode1;
	}
	@Override
	public boolean equals(Object obj) {
		//매개변수로 전달된 객체를 다운캐스팅 한다. 
		Account av = (Account) obj;
		if(av.number.equals(this.number))  {
			/* 3개의 멤버변수를 비교하여 동일한 객체가 발견되면
			true를 반환한다. 그러면 set에는 저장되지 않는다.*/
			System.out.println("중복계좌발견됨. 덮어쓸까요?(y or n)");
			
			return true;
		}
		else {
			/* 다른 객체라면 false를 반환하고, set에 저장된다.*/
			return false;
		}
	}
}
