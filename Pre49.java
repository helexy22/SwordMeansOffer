package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��6��29�� ����2:46:02
* @Issue:���ַ���ת��������
* ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
* ��������:����һ���ַ���,����������ĸ����,����Ϊ��
* �������:����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
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
