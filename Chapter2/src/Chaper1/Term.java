package Chaper1;

public class Term {
	public int coef; //계수
	public int expo; //지수

	public Term(int c, int e) {
		coef = c;
		expo = e;
	}

	int calcTerm(int x) {
		return (int) (coef * Math.pow(x, expo));
	}
	
	void printTerm() {
		System.out.print(coef + "x^" + expo);
	}
}
