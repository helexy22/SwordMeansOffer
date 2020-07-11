package SwordMeansOffer;
/**
* @author Helexy22
* @version Time：2020年6月29日 上午11:19:55
* @Issue:左旋转字符串
* 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
* 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
* 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
*/
public class Pre43 {

	//拼接+截取
	public String LeftReotateString(String str,int n) {
		if (str!=null) {
			int length=str.length();
			if (n>0&&n<length) {
				str=str+str;
				str=str.substring(n,length+n);
			}
		}
		return str;
	}
	
	private String LeftReotateString2(String str,int n) {
		if (str!=null) {
			char[] chars=str.toCharArray();
			int length=str.length();
			if (n>0&&n<length) {
				reverse(chars,0,n-1);
				reverse(chars,n,str.length()-1);
				reverse(chars,0,str.length()-1);
			}
			str=new String(chars);
		}
		return str;
	}

	//翻转数组
	private void reverse(char[] chars, int start, int end) {
		// TODO Auto-generated method stub
		for (int i = start,j=end; i <j; i++,j--) {
			char temp=chars[i];
			chars[i]=chars[j];
			chars[j]=temp;
		}
	}
}
