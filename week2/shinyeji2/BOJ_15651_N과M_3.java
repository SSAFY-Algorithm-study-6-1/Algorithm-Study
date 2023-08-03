import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int nums[] = new int[N];
		result = new ArrayList<int[]>();
		
		for(int i=0;i<N;i++) {
			nums[i] = i+1;
		}
		permutation(nums,0,new int[M]);
		
		//StringBuilder
		StringBuilder sb = new StringBuilder();	
		
		
		for(int i=0;i<result.size();i++) {
			for(int j=0;j<M;j++) {
				sb.append(result.get(i)[j]+" ");
//				System.out.print(result.get(i)[j]+" ");
			}
//			System.out.println();
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
	}
	// 배열 탐색하여 하나씩 뽑기 (중복 허용)
	private static void permutation(int[] nums, int depth, int[] save) {
		if(depth==save.length) {
			int temp[] = new int[save.length];
			temp = save.clone();
			result.add(temp);//결과 배열에 넣기
			return;
		}
		for(int i=0;i<nums.length;i++) {
			save[depth] = nums[i];
			permutation(nums,depth+1,save);
		}
	}

}