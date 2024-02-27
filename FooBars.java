import java.util.ArrayList;
public class FooBars {

    public static void main(String[] args) {
        ArrayList<String> foobars = new ArrayList<>();

        for (int i = 100; i >= 1; i--) {
            if (!(isPrime(i))) {
                if (i % 5 == 0 && i % 3 == 0) {
                    foobars.add("FooBar, ");
                } else if (i % 5 == 0) {
                    foobars.add("Bar, ");
                } else if (i % 3 == 0) {
                    foobars.add("Foo, ");
                } else {
                    foobars.add(String.valueOf(i) + ", ");
                }
            }
        }

        for (String s : foobars) {
            System.out.print(s);
        }
        System.out.print("%");
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
