/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * spoilers alert... click to show requirements for atoi.
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @author linali
 * 
 */
public class StringToInt {
	public static int atoi(String str) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.

		// get rid of all the leading whitespace
		String newStr = str.trim();
		// if it is empty, return 0
		if (newStr.length() == 0) {
			return 0;
		}

		// use a flag to indicate whether this is positive or negative
		int flag = 1;
		int result = 0;
		int i = 0;
		int intMax = 2147483647;
		int intMin = -2147483648;

		// check the first optional sign
		if (newStr.charAt(i) == '-') {
			i++;
			flag = -1;
		}
		if (newStr.charAt(i) == '+') {
			i++;
			flag = 1;
		}

		// go through all the char at the string
		while (i < newStr.length()) {

			// if there are illegal char at the string, break
			if (newStr.charAt(i) > (int) '9' || newStr.charAt(i) < (int) '0') {
				break;
			}
			result = result * 10 + (newStr.charAt(i) - (int) '0');

			// check the bound of int
			if (i != newStr.length() - 1) {
				int nextInt = (newStr.charAt(i + 1) - (int) '0');
				if (nextInt >= 0 && nextInt <= 9 && result > 0) {
					for (int j = 2; j <= 10; j++) {
						if (result * j < 0) {
							if (flag == 1) {
								return intMax;
							}
							if (flag == -1) {
								return intMin;
							}
						}
					}
					if (result * 10 + nextInt < 0) {
						if (flag == 1) {
							return intMax;
						}
						if (flag == -1) {
							return intMin;
						}
					}
				}
			}
			i++;
		}
		return result * flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = atoi("10522545459");
		System.out.println(result);
	}
}
