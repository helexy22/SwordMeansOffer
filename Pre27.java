package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
* @author Helexy22
* @version Time��2020��6��27�� ����9:17:38
* @Issue:�ַ���������
* ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
* ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
*/
public class Pre27 {

	//----���ظ��ַ���ȫ��������
	//�� str ��ȥ��
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str==null||str.equals(" ")) {
			return result;
		}
		char[] chars=str.toCharArray();
		Arrays.sort(chars);
		Set<String> set=new LinkedHashSet<>();
		boolean[] vis = new boolean[chars.length];
		char[] temp=new char[chars.length];
		permutation(0,temp,chars,set,vis);
		result.addAll(set);
		return result;
	}
	
	/**
     * dfs��ʽ�����ַ�����
     * ���÷���������ȷ��ĳһλ�õ�Ԫ���Ƿ��Ѿ�����
     * @param index
     * @param temp
     * @param chars
     * @param set
     * @param vis
     */
	private static void permutation(int index, char[] temp, char[] chars, Set<String> set, boolean[] vis) {
		// TODO Auto-generated method stub
		if (index==chars.length) {
			set.add(new String(temp));
			return;
		}
		for (int i = 0; i < chars.length; i++) {
			if (!vis[i]) {
				temp[index]=chars[i];
				vis[i]=true;
				permutation(index-1,temp,chars,set,vis);
				vis[i]=false;
			}
		}
	}
	
	//-------������
	public static ArrayList<String> Permutation2(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str==null||str.equals(" ")) {
			return result;
		}
		char[] chars=str.toCharArray();
		Set<String> set=new TreeSet<>();
		permutation2(0,chars,set);
		result.addAll(set);
		return result;
	}

	private static void permutation2(int index, char[] chars, Set<String> set) {
		// TODO Auto-generated method stub
		if (index==chars.length-1) {
			set.add(new String(chars));
			return;
		}
		for (int i = index; i < chars.length; i++) {
			swap(chars,index,i);
			permutation2(index+1,chars,set);
			swap(chars,index,i);
		}
	}

	private static void swap(char[] chars, int i, int j) {
		// TODO Auto-generated method stub
		char temp=chars[i];
		chars[i]=chars[j];
		chars[j]=temp;
	}
	
	
	//----������
	
	public static ArrayList<String> Permutation3(String str) {
		ArrayList<String> result=new ArrayList<>();
		if (str!=null&&str.length()>0) {
			permutation3(0,str.toCharArray(),result);
			Collections.sort(result);
		}
		return result;
	}

	private static void permutation3(int index, char[] chars, ArrayList<String> result) {
		// TODO Auto-generated method stub
		if (index==chars.length-1) {
			result.add(new String(chars));
			return;
		}
		
		//��¼��λ���ѳ��ֹ���Ԫ��
		Set<Character> character = new HashSet<>();
		for (int i = index; i < chars.length; i++) {
			if (!(i!=index&&character.contains(chars[i]))) {
				character.add(chars[i]);
				swap(chars,index,i);
				permutation3(index+1,chars,result);
				swap(chars,index,i);
			}
		}
	}
	 
	//-------�����ģ��ֵ����㷨
	public static ArrayList<String> Permutation4(String str) {
		ArrayList<String> result=new ArrayList<>();
		if (str!=null&&str.length()>0) {
			char[] chars=str.toCharArray();
			Arrays.sort(chars);
			result.add(new String(chars));
			while (true) {
				int firstPositiveOrder=chars.length-2;
				while (firstPositiveOrder>=0
						&&chars[firstPositiveOrder]>=chars[firstPositiveOrder+1]) {
					firstPositiveOrder--;
				}
				if (firstPositiveOrder==-1) {
					break;
				}
				int index=chars.length-1;
				while (chars[index]<=chars[firstPositiveOrder]) {
					index--;
				}
				swap(chars,firstPositiveOrder,index);
				reverse(chars,firstPositiveOrder+1,chars.length);
				result.add(new String(chars));
			}
		}
		return result;
	}

	private static void reverse(char[] chars, int begin, int end) {
		// TODO Auto-generated method stub
		for (int i = begin,j=end-1; i <j; j--) {
			swap(chars,i,j);
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str=input.next();
			List<String> result=Permutation4(str);
			for (String item : result) {
				System.out.println(item+" ");
			}
			System.out.println();
		}
	}
	
}
