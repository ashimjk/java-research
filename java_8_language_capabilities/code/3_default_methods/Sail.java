public interface Sail {
  default void cruise() { System.out.println("Sail::Cruise"); }
  default void turn() { System.out.println("Sail::turn"); }
}