import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<int[]> list;
	static int[] curObject;
	static int len;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();;
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new int[] {s, e});
		}
		Collections.sort(list, (a, b) -> a[0]-b[0]);
		solution();
		System.out.println(len);
	}

	static void solution() {
		curObject = new int[] {list.get(0)[0], list.get(0)[1]};
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[1] <= curObject[1]) continue;
			if(list.get(i)[0] <= curObject[1]) {
				curObject[1] = list.get(i)[1];
			}
			else{
				len += curObject[1] - curObject[0];
				curObject[0] = list.get(i)[0];
				curObject[1] = list.get(i)[1];		
			}
		}
		len += curObject[1] - curObject[0];
	}
}