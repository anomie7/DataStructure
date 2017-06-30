package Chaper1;

public class Polynomial {
	public char name;
	public Term[] terms;
	public int nTerms;
	
	public Polynomial(){
		terms = new Term[100];
		nTerms = 0;
	}
	public Polynomial(char name){
		this();
		this.name = name;
	}

	int calPolynomial(int x) {
		int result = 0;
		for(int i = 0; i < nTerms; i++){
			result += terms[i].calcTerm(x);
		}
		return result;
	}
	
	void printPolynomial() {
		for(int i = 0; i < nTerms; i++){
			terms[i].printTerm();;
			System.out.print("+");
		}
		System.out.println();
	}
	
	void addTerm(int c, int e) {
		int index = findTerm(e);
		if (index != -1){
			terms[index].coef += c;
		}else {
			int i = nTerms-1;
			while(i >= 0 && terms[i].expo < e){
				terms[i+1] = terms[i];
				i--;
			}
			terms[i+1] = new Term(c, e);
			nTerms++;
		}
	}

	int findTerm(int e) {
		for (int i = 0; i < nTerms && terms[i].expo >= e; i++ ){
			if(terms[i].expo == e)
				return i;
		}
		return -1;
	}

}
