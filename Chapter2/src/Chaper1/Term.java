package Chaper1;

public class Term {
	public int coef; //���
	public int expo; //����

	int calcTerm(int x) {
		return (int) (coef * Math.pow(x, expo));
	}
	
	void printTerm() {
		System.out.print(coef + "x^" + expo);
	}
}
