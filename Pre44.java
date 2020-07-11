package SwordMeansOffer;

import java.util.Arrays;

/**
* @author Helexy22
* @version Time：2020年6月29日 下午1:44:37
* @Issue:翻转单词顺序列
* 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
* 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
* 例如，“student. a am I”。
* 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
* Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
* 字符串、较难
*/
public class Pre44 {
	
	public static String ReverseSentence(String str) {
		return str.lastIndexOf(" ")==-1?str:str.substring(str.lastIndexOf(" ")+1)+" "+
	ReverseSentence(str.substring(0,str.lastIndexOf(" ")));
	}
	
	//------------
	public static String ReverSentence2(String str) {
		if (str==null||str.equals("")) {
			return str;
		}
		char[] chars=str.toCharArray();
		reverse(chars,0,str.length()-1);
		int start=0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i]!=' ') {
				start=i;
				while ((++i)<chars.length&&chars[i]!=' ');
				reverse(chars,start,i-1);
			}
		}
		return new String(chars);
	}

	private static void reverse(char[] chars, int start, int end) {
		// TODO Auto-generated method stub
		for (int i = start,j=end; i <j; i++,j--) {
			char temp=chars[i];
			chars[i]=chars[j];
			chars[j]=temp;
		}
	}
	
	//----------
	public static String ReverseSentence3(String str) {
		if (str==null||str.equals(" ")) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)==' ') {
				sb.insert(0,temp.toString());
				sb.insert(0," ");
				temp.delete(0,temp.length());
			}else {
				temp.append(str.charAt(i));
			}
		}
		sb.insert(0,temp.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str1="23     4";
		System.out.println(Arrays.toString(str1.split(" ")));
		String str="I am a student";
		System.out.println(ReverseSentence(str));
		
	}
}
