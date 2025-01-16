
public class ValidityCheck {

	public static boolean isValidPNR(String number) {

		int sum = 0;
		int num;
		
		if(number.length() != 10) {
			return false;
		}
		
		for (int i = 0; i < number.length(); i++) {

			num = Character.getNumericValue(number.charAt(i));

			if (i % 2 == 0) {
				num *= 2;
			}

			if (num > 9) {
				int temp = num;
				while (temp > 0) {
					sum += temp % 10;
					temp /= 10;
				}
			} else {
				sum += num;
			}

		}

		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String personNumber = "9103259876";
		if (isValidPNR(personNumber)) {
			System.out.println("Giltigt nummer.");
		} else {
			System.out.println("Ej ett giltigt nummer.");
		}
	}
}
