package programmers.DfsBfs;

import java.util.Stack;

public class DfsExample {
	
	//방문 여부를 확인할 배열 선어
	static boolean[] visited = new boolean[9];
	
	//그래프의 인덱스가 연결된 각각의 노드 번호가 되는 그래프
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	//재귀적으로 수행하는 DFS
	static void dfsRecur(int nodeIndex) {
		
		//방문 처리
		visited[nodeIndex] = true;
		
		//방문 노드 출력
		System.out.print(nodeIndex + " -> ");
		
		//방문한 노드에 인접한 노드 찾기
		for(int node : graph[nodeIndex]) {
			//인접한 노드가 방문한 적 없다면 DFS 수행
			if(!visited[node]) {
				dfsRecur(node);
			}
		}
	}
	
	
	//스택으로 수행하는 DFS
	static Stack<Integer> stack = new Stack<>();
	
	static void dfsStack() {
		
		//시작 노드를 스택에 넣어줍니다
		stack.push(1);
		//시작 노드 방문처리
		visited[1] = true;
		
		while(!stack.isEmpty()) {
			//스택에서 하나를 꺼냅니다
			int nodeIndex = stack.pop();
			
			// 방문 노드 출력
			System.out.print(nodeIndex + " -> ");
			
			for(int LinkedNode : graph[nodeIndex]) {
				//인접한 노드를 방문하지 않았을 경우 스택에 넣고 방문처리
				if(!visited[LinkedNode]) {
					stack.push(LinkedNode);
					visited[LinkedNode] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		dfsRecur(1);
		System.out.println();
		visited = new boolean[9];
		dfsStack();
	}

}
