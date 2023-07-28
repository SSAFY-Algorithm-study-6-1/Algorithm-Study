import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int X,Y,Z;
	static int[][][] arr;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = {0,0,1,-1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};

	public static void detection() {
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cz = cur[0];
			int cx = cur[1];
			int cy = cur[2];
			for(int d=0;d<dx.length;d++) {
				int nz = cz + dz[d];
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(nx<0|| nx>=X || ny<0|| ny>=Y ||nz<0|| nz>=Z || arr[nz][nx][ny]==-1 || arr[nz][nx][ny]==1) continue;
				
				if(arr[nz][nx][ny]==0 || arr[nz][nx][ny]>arr[cz][cx][cy]+1) {
					arr[nz][nx][ny]=arr[cz][cx][cy]+1;
					q.add(new int[] {nz,nx,ny});
				}
				

			}
		}
	}
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sizes = br.readLine().split(" ");
		Y = Integer.parseInt(sizes[0]);
		X = Integer.parseInt(sizes[1]);
		Z = Integer.parseInt(sizes[2]);
		arr = new int[Z][X][Y];
		int result = 0;
		boolean flag = false;
		
		for(int i=0;i<Z;i++) {
			for(int j=0;j<X;j++) {
				String[] str = br.readLine().split(" ");
				for(int z=0;z<Y;z++) {					
					arr[i][j][z] = Integer.parseInt(str[z]);
					if(arr[i][j][z]==1) {
						q.offer(new int[]{i,j,z});
					}
				}
			}
		}
		detection();
		
		for(int i=0;i<Z;i++) {
			for(int j=0;j<X;j++) {
				for(int z=0;z<Y;z++) {
					if(arr[i][j][z] == 0) {
						result = 0;
						flag = true;
						break;
					}
					else {
						result = Math.max(result, arr[i][j][z]);
					}
				}
				if(flag)break;
			}
			if(flag)break;
		}
		System.out.println(result-1);
	}

}