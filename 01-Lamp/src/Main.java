
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp myLamp1 = new Lamp();
		Lamp myLamp2 = new Lamp();
		System.out.println(myLamp1.isOn());
		myLamp2.turnOn();
		System.out.println(myLamp1.isOn());
		myLamp1.turnOn();
		System.out.println(myLamp2.isOn());
		System.out.println(myLamp1.isOn());
	}

}
