package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��6��29�� ����11:19:55
* @Issue:����ת�ַ���
* �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
* ����һ���������ַ�����S���������ѭ������Kλ������������
* ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
*/
public class Pre43 {

	//ƴ��+��ȡ
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

	//��ת����
	private void reverse(char[] chars, int start, int end) {
		// TODO Auto-generated method stub
		for (int i = start,j=end; i <j; i++,j--) {
			char temp=chars[i];
			chars[i]=chars[j];
			chars[j]=temp;
		}
	}
}
