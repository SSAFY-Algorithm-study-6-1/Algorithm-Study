import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static PriorityQueue<Mold> molds = new PriorityQueue<>();
	private static int move;
	
	private static class Mold implements Comparable<Mold>{
		int y;
		int x;
		int speed;
		int dir;
		int size;
		
		public Mold(int y, int x, int speed, int dir, int size) {
			this.y = y;
			this.x = x;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public int compareTo(Mold s) {
			if(this.x < s.x) {
				return -1;
			}
			else if(this.x > s.x) {
				return 1;
			}
			else {
				if(this.y < s.y) return -1;
				else if(this.y > s.y) return 1;
				else return 0;
			}
		}
	}


	private static void eat(int r, int c) {
		if(molds.isEmpty()) return;
		
		PriorityQueue<Mold> pq = new PriorityQueue<>();
		Mold head = molds.peek();
		
		while(!molds.isEmpty()) {
			Mold current = molds.poll();

			if(head.y == current.y && head.x == current.x) {
				if(head.size < current.size) {
					head = new Mold(current.y, current.x, current.speed, current.dir, current.size);
				}
			}
			else {
				pq.offer(head);											
				head = new Mold(current.y, current.x, current.speed, current.dir, current.size);
			}
			if(molds.isEmpty()) pq.offer(head);			
		}

		while(!pq.isEmpty()) molds.offer(pq.poll());
	}

	private static Mold wandering(int leng, Mold s, int dir, boolean flag) {
		int value = (leng - 1) * 2;
		
		if(flag) {								
			if(move >= value) move %= value;
			if(dir == 1) {
				if(move <= s.y) {					
					s.y -= move;
					move = 0;
				}
				else {								
					move = Math.abs(move - s.y);
					s.y = 0;
					
					dir = 2;						
				}
			}
			else {
				if(move + s.y <= leng - 1) {
					s.y += move;
					move = 0;
				}
				else {
					move -= Math.abs(s.y - (leng - 1));
					s.y = leng - 1;
					dir = 1;
				}
			}
		}
		else {									
			if(move >= value) move %= value;
			
			if(dir == 3) {
				if(move + s.x <= leng - 1) {
					s.x += move;
					move = 0;
				}
				else {
					move -= Math.abs(s.x - (leng - 1));
					s.x = leng - 1;
					
					dir = 4;
				}
			}
			else {
				if(move <= s.x) {
					s.x -= move;
					move = 0;
				}
				else {
					move = Math.abs(move - s.x);
					s.x = 0;
					
					dir = 3;
				}
			}
		}
		
		return new Mold(s.y, s.x, s.speed, dir, s.size);
	}
	
	
	private static void moldMove(int r, int c) {
		PriorityQueue<Mold> pq = new PriorityQueue<>();
		
		while(!molds.isEmpty()) {
			Mold current = molds.poll();
			move = current.speed;
			
			while(move > 0) {
				switch (current.dir) {
				case 1:
					current = wandering(r, current, 1, true);
					break;
					
				case 2:			
					current = wandering(r, current, 2, true);
					break;
					
				case 3:
					current = wandering(c, current, 3, false);
					break;
					
				case 4:
					current = wandering(c, current, 4, false);
					break;
				}
			}

			pq.offer(current);
		}

		while(!pq.isEmpty()) molds.offer(pq.poll());
	}
	

	private static int getMold(int target) {
		PriorityQueue<Mold> pq = new PriorityQueue<>();
		Mold catched = new Mold(0, 0, 0, 0, 0);
		
		while(!molds.isEmpty()) {
			Mold current = molds.poll();
			
			if(current.x == target) {
				catched = new Mold(current.y, current.x, current.speed, current.dir, current.size);
				break;
			}
			
			pq.offer(current);
		}
		
		while(!pq.isEmpty()) molds.offer(pq.poll());
		return catched.size;
	}

	private static int collect(int r, int c) {
		int sum = 0;
		
		for(int i = 0; i < c; i++) {
			sum += getMold(i);			
			moldMove(r, c);			
			eat(r, c);					
		}
		
		return sum;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			molds.offer(new Mold(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		System.out.println(collect(R, C));
	}
}