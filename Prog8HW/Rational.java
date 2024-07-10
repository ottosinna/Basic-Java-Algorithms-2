public class Rational {
	//box 1
	int num;
	int den;
	int comp;
	
	//box 2  //Constructors
	static int findGCD(int n, int m) {
		while(n != m) {
			if(n>m) {
				n = n - m;
			}
			else {
				m = m - n;
			}
		}
		return n;
	}
	public Rational(int m, int n) {
		int gcd;
		gcd =findGCD(m,n);
		m = m/gcd; 
		n = n/gcd;
		num = m;
		den = n;
	}
	public Rational() {
		num = 1;
		den = 2;
	}
	
	public Rational(int n) { 
		num = n; 
		den = 1;
	}	

	// box3
	public Rational(String s) {
		int whole = 0;
		int num = 0;
		int den = 1;
		if (s.contains(".")) {
			// Handle decimal input
			// ... (implement this part if needed)
		} else if (s.contains("/")) {
			// Handle fraction input
			String[] parts = s.split("\\s+|/");  // Split by space and slash
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
				num = Math.abs(whole) * den + num;
				if (whole < 0) num = -num;  // Handle negative mixed numbers
			}
			// Reduce fraction
			int gcd = findGCD(Math.abs(num), den);
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
	}
	//box 3 
	public String toString() {
		if (den == 1) {
			return String.valueOf(num);
		}
		int whole = num / den;
		int remainderNum = Math.abs(num % den);
		if (whole == 0) {
			return num + "/" + den;
		} else {
			return whole + " " + remainderNum + "/" + den;
		}
	}

	Rational(double d) {
		String s = String.valueOf(d);
		String[] rAt = s.split("\\.");
		
		if(Integer.parseInt(rAt[0])!= 0) {
			num = Integer.parseInt(rAt[0]);
		}
		String bond = "1";
		for(int i = 0; i < rAt[1].length();i++); {
			bond +="0";
		}
		num = (Integer.parseInt(rAt[0]) *Integer.parseInt(bond)) + Integer.parseInt(rAt[1]);
		den = Integer.parseInt(bond);
		if(num!=0) {
			int c = Rational.findGCD(num,den);
			num = num/c;
			den = den/c;
		}
	}
	
	public static void main(String[] args) {
		Rational r;
		r=new Rational(2.25);
		System.out.println("r= "+r);
		Rational r2 = new Rational("30/15");
		System.out.println("r2 = " + r2);
		Rational r3 = new Rational("1 1/2");
		System.out.println("r3 = " + r3);
		Rational r4 = new Rational("-2 1/4");
    	System.out.println("r4 = " + r4);
	}
}

