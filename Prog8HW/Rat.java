public class Rat {
    // box 1
    int num;
    int den;
    int comp;

    // box 2 //Constructors
    static int findGCD(int n, int m) {
        while (n != m) {
            if (n > m) {
                n = n - m;
            } else {
                m = m - n;
            }
        }
        return n;
    }

    public Rat(int m, int n) {
        int gcd;
        gcd = findGCD(m, n);
        m = m / gcd;
        n = n / gcd;
        num = m;
        den = n;
        comp = 0;
    }

    public Rat() {
        num = 1;
        den = 2;
        comp = 0;
    }

    public Rat(int n) {
        num = n;
        den = 1;
        comp = 0;
    }

    // box3
    public Rat(String s) {
        int whole = 0;
        int num = 0;
        int den = 1;
        if (s.contains(".")) {
            // Handle decimal input
            // ...
        } else if (s.contains("/")) {
            // Handle fraction input
            String[] parts = s.split("/");
            if (parts.length == 2) {
                // Proper fraction
                num = Integer.parseInt(parts[0]);
                den = Integer.parseInt(parts[1]);
            } else if (parts.length == 3) {
                // Mixed number
                whole = Integer.parseInt(parts[0]);
                num = Integer.parseInt(parts[1]);
                den = Integer.parseInt(parts[2]);
                // Convert to improper fraction
                num += whole * den;
            }
            // Reduce fraction
            int gcd = findGCD(num, den);
            num /= gcd;
            den /= gcd;
        } else {
            // Handle integer input
            num = Integer.parseInt(s);
            den = 1;
        }
        // Set object variables
        this.num = num;
        this.den = den;
        this.comp = 0;
    }

    Rat(double d) {
        String s = String.valueOf(d);
        String[] rAt = s.split("\\.");

        if (Integer.parseInt(rAt[0]) != 0) {
            num = Integer.parseInt(rAt[0]);
        }
        String bond = "1";
        for (int i = 0; i < rAt[1].length(); i++) {
            bond += "0";
        }
        num = (Integer.parseInt(rAt[0]) * Integer.parseInt(bond)) + Integer.parseInt(rAt[1]);
        den = Integer.parseInt(bond);
        if (num != 0) {
            int c = Rat.findGCD(num, den);
            num = num / c;
            den = den / c;
        }
        this.comp = 0;
    }

    public String toString() {
        String s;
        int w = num / den;
        int n = num % den;
        if (w == 0) {
            s = num + "/" + den;
        } else if (n == 0) {
            s = String.valueOf(w);
        } else {
            s = w + " " + Math.abs(n) + "/" + den;
        }
        if (comp < 0) {
            s = "-" + s;
        }
        return s;
    }

    public static void main(String[] args) {
        Rat r = new Rat(3.25);
        System.out.println("r = " + r);

        Rat r2 = new Rat("15/30");
        System.out.println("r2 = " + r2);
    }
}