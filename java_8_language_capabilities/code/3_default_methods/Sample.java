// Rule of Default Interface
// 1. default methods get inherited automatically
// 2. can override default methods
// 3. methods in class hierarchy rules
// 4. if there is collision between two methods, save your self
// meaning: here fly and sail interface has two collisio methods
// cruise and turn method

// Abstract vs Interface
// 1. interface cannot have state but abstract can.
// 2. cannot inherit abstract class more than once.


public interface Fly {
  default void takeOff() { System.out.println("Fly::takeOff"); }
  default void land() { System.out.println("Fly::land"); }
  default void turn() { System.out.println("Fly::turn"); }
  default void cruise() { System.out.println("Fly::cruise"); }
}

public interface FastFly extends Fly {
  default void takeOff() { System.out.println("FastFly::takeOff"); }
}

public class Vehicle {
  public void turn() { System.out.println("Vehicle::turn"); }
}

public interface Sail {
  default void cruise() { System.out.println("Sail::Cruise"); }
  default void turn() { System.out.println("Sail::turn"); }
}

public class SeaPlane extends Vehicle implements FastFly, Sail {
  public void cruise() {
    System.out.println("SeaPlane::cruise");
    // calls the FastFly default cruise method
    // we have use super over here because interface can have static
    // method as well
    FastFly.super.cruise();
    Sail.super.cruise();
  }
}

public class Sample {
  public static void main(String[] args) {
    SeaPlane seaPlane = new SeaPlane();
    seaPlane.takeOff();
    seaPlane.turn();
    seaPlane.cruise();
    seaPlane.land();
  }
}
