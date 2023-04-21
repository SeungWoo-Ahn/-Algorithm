package programmers.DfsBfs;

import java.util.Stack;

public class DfsExample {
	
	//�湮 ���θ� Ȯ���� �迭 ����
	static boolean[] visited = new boolean[9];
	
	//�׷����� �ε����� ����� ������ ��� ��ȣ�� �Ǵ� �׷���
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	//��������� �����ϴ� DFS
	static void dfsRecur(int nodeIndex) {
		
		//�湮 ó��
		visited[nodeIndex] = true;
		
		//�湮 ��� ���
		System.out.print(nodeIndex + " -> ");
		
		//�湮�� ��忡 ������ ��� ã��
		for(int node : graph[nodeIndex]) {
			//������ ��尡 �湮�� �� ���ٸ� DFS ����
			if(!visited[node]) {
				dfsRecur(node);
			}
		}
	}
	
	
	//�������� �����ϴ� DFS
	static Stack<Integer> stack = new Stack<>();
	
	static void dfsStack() {
		
		//���� ��带 ���ÿ� �־��ݴϴ�
		stack.push(1);
		//���� ��� �湮ó��
		visited[1] = true;
		
		while(!stack.isEmpty()) {
			//���ÿ��� �ϳ��� �����ϴ�
			int nodeIndex = stack.pop();
			
			// �湮 ��� ���
			System.out.print(nodeIndex + " -> ");
			
			for(int LinkedNode : graph[nodeIndex]) {
				//������ ��带 �湮���� �ʾ��� ��� ���ÿ� �ְ� �湮ó��
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
