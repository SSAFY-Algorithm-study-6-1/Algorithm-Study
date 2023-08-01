import java.io.*;
import java.util.*;
public class Main {
	static List<Integer> nums;
	static List<int[]> result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		nums = new LinkedList<Integer>(); 
		result = new ArrayList<int[]>();
		for(int i=0;i<N;i++) {
			nums.add(i+1);
		}
		
		permutation(nums,0,new int[M]);
		
		for(int i=0;i<result.size();i++) {
			for(int j=0;j<result.get(i).length;j++){
				System.out.print(result.get(i)[j]+" ");
			}
			System.out.println();
		}
	}
	private static void permutation(List<Integer> nums, int depth, int[] save) {
		if(depth==save.length) {
			int[] temp = new int[save.length];
			temp = save.clone();
			result.add(temp);            // 뽑은 리스트 저장
			return;
		}
		for(int i=0;i<nums.size();i++) {
			List<Integer>temp = new LinkedList<Integer>();
			temp.addAll(nums);  // 배열 복사 (백트래킹을 위함)
			save[depth]=nums.get(i);  // 뽑은 것 저장
			temp.remove(i); // 뽑은 것 삭제
			permutation(temp,depth+1,save);  // 다음것을 뽑기 위한 재귀
		}
		// 뽑은 것 prev에 저장

		// 뽑은 것 원상복귀
	}
}
