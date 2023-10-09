
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        Lamp lamp1 = new Lamp();
        System.out.println(lamp1.isOn());
        lamp1.turnOn();
        System.out.println(lamp1.isOn());
        lamp1.turnOn();
        System.out.println(lamp1.isOn());
        lamp1.turnOff();
        System.out.println(lamp1.isOn());
    }
}
