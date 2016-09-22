class Wurzel {
    public static void main(String[] args) {
	if (args.length < 1) {
	    System.err.println("needs a numeric argument");
	} else {
	    try {
		double x = Double.parseDouble(args[0]);
		double y = heron(x, 100);
		System.out.printf("sqrt(%f) = %f\n", x, y);
	    } catch (NumberFormatException e) {
		System.err.printf("'%s' is not a number\n", args[0]);
	    }
	}
    }

    private static double heron(double x, int n) {
	double y = x;
	for (int i = 0; i < n; i++) {
	    y = 0.5 * (y + x / y);
	}
	return y;
    }
}
