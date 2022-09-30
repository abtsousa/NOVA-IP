
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
	
	public boolean isExceptional() {return ( (p1*p2*t1*t2*ex*dx != 0) && (ex==1) && (dx==1) && (p1>=16) && (p2>=16) && ( (p1>=18) || (p2>=18)) && (t1>=16) && (t2>=16) && (tpGrade>17) ); }

}
