package dependency1;

import dependency2.Dep2;

public class Runner {

    public static void main(String[] args) {
        Dep2 dep2 = new Dep2();
        dep2.testing();
    }
}
