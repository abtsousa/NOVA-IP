import java.util.Scanner;

public class Main {

	// Cria círculo
	private static Circle createCircle(Scanner in) {
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		in.nextLine();
		Circle cx = new Circle(a,b,c);
		return cx;
	}
	
	//Ler comando e valores se necessário
	private static String readCmd(Scanner in) {
		return in.next().toUpperCase(); //converte o input para maiúsculas
	}
	
	private static void fetchPerimeter(Circle c) {
		System.out.printf("Perímetro: %.2f\n",c.getPerimeter());
	}
	
	private static void fetchArea(Circle c) {
		System.out.printf("Área: %.2f\n",c.getArea());
	}
	
	private static void fetchPoint(Circle c, Scanner in) {
		double p1 = in.nextDouble();
		double p2 = in.nextDouble();
		in.nextLine(); //descarta o \n
		boolean result = c.containsPoint(p1,p2);
		if (result) {
			System.out.println("O ponto pertence ao círculo");
		} else {
			System.out.println("O ponto não pertence ao círculo");
		}
	}
	
	private static void fetchCircle(Circle c1, Scanner in) {
		double p1 = in.nextDouble();
		double p2 = in.nextDouble();
		double p3 = in.nextDouble();
		Circle c2 = new Circle(p1,p2,p3);
		in.nextLine(); //descarta o \n
		if (c1.containsCircle(c2)) {
			System.out.println("O primeiro círculo contém o segundo");
		} else if (c1.intersectsCircle(c2)) {
			System.out.println("O primeiro círculo interseta uma parte do segundo");
		} else {
			System.out.println("O primeiro círculo não interseta o segundo");
		}
	}
	
	//Executar comandos
	private static void executeCmd(String option, Circle circle, Scanner in) {
		switch (option) {
		case "P":
			fetchPerimeter(circle);
			break;
		case "A":
			fetchArea(circle);
			break;
		case "LP":
			fetchPoint(circle, in);
			break;
		case "LC":
			fetchCircle(circle, in);
			break;
		}
	}
	
	//Main
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Criar círculo
		Circle c1 = createCircle(in);
		
		//Ler comando
		String option = readCmd(in);
		
		//Executar comando
		executeCmd(option, c1, in);
		
		in.close();
	}

}
