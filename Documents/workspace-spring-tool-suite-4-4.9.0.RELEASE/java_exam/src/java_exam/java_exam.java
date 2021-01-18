package java_exam;

public class java_exam {

	public static void main(String[] args) {
		
		VendingMachine vm = new VendingMachine();
		
		vm.printAllBeverages();
		vm.setinputedMoney(2000);
		
    // 출력 : 0.콜라 : 1000
    // 출력 : 1.사이다 : 1200
    // 출력 : 2.커피 : 800

		vm.setinputedMoney(2000);
    // 출력 : 현재 투입된 금액은 2000원입니다.

		String rst = vm.getBeverage(1);
    // 출력 : 사이다를 뽑으셨습니다.
    // 출력 : 잔액은 800원입니다.

		System.out.println(rst);
    // 출력 : 사이다

    String rst2 = vm.getBeverage(0);
    // 출력 : 잔액이 부족합니다.

		vm.setinputedMoney(500);
    // 출력 : 현재 투입된 금액은 1300원입니다.
		
    String rst3 = vm.getBeverage(0);
    // 출력 : 콜라를 뽑으셨습니다.
    // 출력 : 잔액은 300원입니다.
		System.out.println(rst3);
    // 출력 : 콜라
	}
}
class VendingMachine {
	int inputedMoney = 0;
	int change = 0;
	String beverageNames[] = {"콜라","사이다","커피"};
	int beveragePrices[] = {1000,1200,800};
	//금액 투입기능  
	void setinputedMoney(int money) {
		inputedMoney = inputedMoney+money;
		System.out.println("현재투입된 금액은"+inputedMoney+"입니다.");
	}
	void printAllBeverages() {
		for(int i=0; i<beverageNames.length; i++) {
			System.out.println(i+"."+beverageNames[i]+":"+beveragePrices[i]);
		}
	}
	String getBeverage(int bno) {
		if(inputedMoney < beveragePrices[bno]) {
			System.out.println("잔액이 부족합니다.");
			return "";
		}
		inputedMoney = inputedMoney - beveragePrices[bno]; //거스름돈 
		System.out.println("잔액은"+inputedMoney+"입니다.");
		return beverageNames[bno];
	}
}



