package homework;
import java.util.*;
public class Daily3_problem_3_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int answer = 0;
			int N = sc.nextInt();
			char arr[];
			int[] dx = {1,-1,1,-1};
			int[] dy = {1,-1,-1,1};
			sc.nextLine();
			arr = sc.nextLine().toCharArray();
		
			if(arr[0]==arr[2] || arr[1]==arr[3]) {
				answer=1;
			}else {
				int diffX = Math.abs(arr[2]-arr[0]);
				int diffY = Math.abs(arr[3]-arr[1]);
				if(diffX==diffY)answer=1;
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}

}
