
public class Grade {
	private double p1, p2, t1, t2, ex, dx, pGrade, tpGrade;
	public static final double passingGrade = 9.5;
	
	public Grade(double a, double b, double c, double d, double e, double f) {
		p1=a;
		p2=b;
		t1=c;
		t2=d;
		ex=e;
		dx=f;
		pGrade = Math.round( ( (0.1*p1+0.25*p2) /0.35 )*100.0 )/100.0;
		tpGrade = Math.round( ( (0.2*t1+0.35*t2) /0.55 )*100.0)/100.0;
	}
	
	public boolean hasFreq() {return (pGrade >= passingGrade);}
	
	public double finalGrade() {
		if (this.hasFreq()==false) {
			return 0;
		}
		else if (tpGrade < passingGrade) {
			return tpGrade;
		}
		else {
			return Math.round(pGrade*0.35+tpGrade*0.55+ex+dx);
		}
	}
	
	public double neededExamGrade() {
		if (tpGrade < passingGrade) {
			return passingGrade;
		}
		else {
			return Math.round(( (passingGrade-(0.35*pGrade)-ex-dx)/0.55) * 100.0)/100.0;
		}
	}
}
