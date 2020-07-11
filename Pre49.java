package SwordMeansOffer;
/**
* @author Helexy22
* @version Time：2020年6月29日 下午2:46:02
* @Issue:把字符串转换成整数
* 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
* 输入描述:输入一个字符串,包括数字字母符号,可以为空
* 输出描述:如果是合法的数值表达则返回该数字，否则返回0
*/
public class Pre49 {
	
	public static int StrToInt(String str) {
		if (str==null||str.equals(" ")) {
			return 0;
		}
		boolean isNegtive=false;
		int index=0;
		long result=0;
		if (str.charAt(0)=='-') {
			isNegtive=true;
			index++;
		}else if (str.charAt(0)=='+') {
			index++;
		}
		for (	;  index< str.length(); index++) {
			char ch=str.charAt(index);
			if (isNotDigit(ch)) {
				return 0;
			}else {
				result=result*10+(ch-'0');
				if (!isNegtive && result > 0x7fffffff
                        || isNegtive && result > 0x80000000L) {
					return 0;
				}
			}
		}
		return isNegtive?(int)-result:(int)result;
	}

	private static boolean isNotDigit(char ch) {
		// TODO Auto-generated method stub
		return ch<'0'||ch>'9';
	}
	
	public static void main(String[] args) {
		System.out.println("-123");
		System.out.println("123");
		System.out.println(Integer.MAX_VALUE);
	}
}
