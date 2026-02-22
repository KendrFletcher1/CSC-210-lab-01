public class Creature {

    String name;
    int size;

    public Creature(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void move() {
        System.out.println(name + " is moving.");
    }

    public void talk() {
        System.out.println(name + " says hello!");
    }

    public static void main(String[] args) {
        Creature creature1 = new Creature("Dragon", 10);

        creature1.talk();
        creature1.move();
        creature1.eat();
    }
}
