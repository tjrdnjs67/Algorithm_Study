import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dest{
    int x, y, cnt;

public Dest(int x, int y, int cnt) {
    this.x = x;
    this.y = y;
    this.cnt = cnt;
}    
}

public class Main {

    static int N, M, G;
    static int tx, ty;
    static int[][] map;
    static Dest[] dests;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};

public static void main(String[] args) throws Exception {
    //System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    
    map = new int[N][N];
    dests = new Dest[M+1];
    
    for(int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++) {
            int val = Integer.parseInt(st.nextToken());
            
            if(val == 1) {
                map[i][j] = -1;
            }else {
                map[i][j] = 0;
            }
        }
    }
    
    st = new StringTokenizer(br.readLine());
    int tx = Integer.parseInt(st.nextToken()) - 1;
    int ty = Integer.parseInt(st.nextToken()) - 1;
    
    for(int i = 1; i <= M; i++) {
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken()) - 1;
        int sy = Integer.parseInt(st.nextToken()) - 1;
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;
        
        map[sx][sy] = i;
        dests[i] = new Dest(ex,ey,0);
    }
    
    Queue<Dest> q = new LinkedList<Dest>();
    boolean[][] visited = new boolean[N][N];
    visited[tx][ty] = true;
    q.offer(new Dest(tx,ty,0));
    
    int cnt = 0;
    while(!q.isEmpty()) {
        
        Dest polled = q.poll();
        
        if(polled.cnt > G) {
            System.out.println(-1);
            System.exit(0);
        }
        
        if(map[polled.x][polled.y] > 0) {
        	
        	while(!q.isEmpty()) {
        		Dest polled2 = q.poll();
        		
        		if(polled2.cnt > polled.cnt) break;
        		
        		 if(map[polled2.x][polled2.y] > 0) {
        			 if(polled2.x < polled.x) {
        				 polled = polled2;
        			 }
        			 else if(polled2.x == polled.x) {
        				 if(polled2.y < polled.y) {
        					 polled = polled2;
            			 }
        			 }
        		 
        		 }		
        	}
        	
        	
            if(!rideTaxi(map[polled.x][polled.y], polled)) {
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
                
            if(cnt == M) break;
            
            Dest dest = dests[map[polled.x][polled.y]];
            map[polled.x][polled.y] = 0;
            q = new LinkedList<Dest>();
            visited = new boolean[N][N];
            
            visited[dest.x][dest.y] = true;
            q.offer(new Dest(dest.x,dest.y,0));
            continue;
        }
        
    
        for(int dir = 0; dir < 4; dir++) {
            int nx = polled.x + dx[dir];
            int ny = polled.y + dy[dir];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != -1 && !visited[nx][ny]) {
            	visited[nx][ny] = true;
                q.offer(new Dest(nx,ny,polled.cnt + 1));
            }
        }
        
        
    }
    
    if(cnt != M) {
    	System.out.println(-1);
    }else {
        System.out.println(G);
    }

}

private static boolean rideTaxi(int idx, Dest start) {
    G -= start.cnt;
    Dest dest = dests[idx];
    boolean[][] visited = new boolean[N][N];
    
    Queue<Dest> q = new LinkedList<Dest>();
    visited[start.x][start.y] = true;
    q.offer(new Dest(start.x, start.y,0));
    
    while(!q.isEmpty()) {
        
        Dest polled = q.poll();
        
        
        if(polled.cnt > G) return false;
        
        if(polled.x == dest.x && polled.y == dest.y) {
            G -= polled.cnt;
            G += polled.cnt * 2;            
            return true;
        }

        
        for(int dir = 0; dir < 4; dir++) {
            int nx = polled.x + dx[dir];
            int ny = polled.y + dy[dir];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != -1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                q.offer(new Dest(nx,ny,polled.cnt + 1));
            }
        }
        
    }
    
    
    
    return false;
}
}
