class LuhnValidator {

	boolean isValid(String candidate) {
		StringBuilder sb = new StringBuilder(candidate);
		sb = sb.reverse();
		char[] digits = sb.toString().replace(" ", "").toCharArray();
		boolean isValid = false;
		int total = 0;
		int count = 1;
		for (char c : digits) {
			if (Character.isDigit(c)) {
				if (count % 2 == 0) {
					int res = 0;
					res = Integer.parseInt(Character.toString(c)) * 2;
					if(res > 9) {
						res = res - 9;
					}		
					total += res;
				} else {
					total += Integer.parseInt(Character.toString(c));
				}
			} else {
				return false;
			}
			count++;
		}
		if(total % 10 == 0 && digits.length > 1) {
			isValid = true;
		}
		return isValid;
	}

}
