package GraphDS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;

public class Graph {

	private Map<Integer,Node> nodeLookUp = new HashMap<Integer,Node>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noNodes;
		Graph g = new Graph();
		//String path = "/graph-1.txt";
		Path currentDir = Paths.get(".\\src\\GraphDS\\rescources\\File\\graph-1.txt");
		//currentDir.resolve(currentDir.toAbsolutePath()+path);
		//System.out.println(currentDir.toAbsolutePath());
		try (Stream<String> stream = Files.lines(currentDir.toAbsolutePath())) {
			
			//stream.forEach(System.out::println);
			
			stream.skip(1).forEach(line->{
				String[] eachRecord = line.split(":");
				g.addNodes(Integer.parseInt(eachRecord[0]));
				g.addNodes(Integer.parseInt(eachRecord[1]));
				g.addEdge(Integer.parseInt(eachRecord[0]),Integer.parseInt(eachRecord[1]));
				
				
			});
			
			/*List<Node> path = g.dfs(1,10);
			for(int i=0;i<path.size();i++)
				System.out.println(path.get(i).getId());
			
			List<Node> path2 = g.bfs(1,10);
			for(int i=0;i<path2.size();i++)
				System.out.println(path2.get(i).getId());*/
			
			List<Node> topoSort = new LinkedList<Node>();
			
			topoSort = g.topologicalSort();
			
			for(int i=0;i<topoSort.size();i++) {
				System.out.println(topoSort.get(topoSort.size()-1-i).getId());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public  void addNodes(int id) {
		if(nodeLookUp.containsKey(id))
			return;
		nodeLookUp.put(id, new Node(id));
			
	}
	
	public void addEdge(int source,int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		s.addAdjacentNodes(d);
	}
	
	private Node getNode(int id) {
		return nodeLookUp.get(id);
	}
	
	private List<Node> getAllVertices(){
		List<Node> vertices = new LinkedList<Node>();
		
		nodeLookUp.forEach((index,node)->{
			vertices.add(node);
		});
		
		return vertices;
	}
	
	public List<Node> dfs(int source,int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		List<Node> path = new LinkedList<Node>();
		path.add(s);
		Set<Integer> visited = new HashSet<Integer>();
		dfs(s,d,path,visited);
		return path;
		
	}
	 
	
	public void dfs(Node source,Node destination,List<Node> path,Set<Integer> visited) {
		
		if(visited.contains(source.getId()) || visited.contains(destination.getId()))
			return;
		
		
		visited.add(source.getId());
		for(Node child:source.getAdjacent()) {
			if(visited.contains(destination.getId()))
				return ;
			else if(child.getId() == destination.getId())
			{
				path.add(child);
				visited.add(child.getId());
				return;
				
			}
			
			path.add(child);
			dfs(child,destination,path,visited);
		}
		
	}
	
	public List<Node> bfs(int source,int destination) {
		Queue<Node> queue = new LinkedList<Node>();
		List<Node> path = new LinkedList<Node>();
		if(source==destination)
		{
			path.add(nodeLookUp.get(source));
			return path;
		}
			Node currentNode;
			Set<Integer> visited = new HashSet<Integer>();
			queue.add(nodeLookUp.get(source));
			//path.add(nodeLookUp.get(source));
		while(!queue.isEmpty()) {
			
			currentNode = queue.poll();
			if(visited.contains(currentNode.getId()))
				continue;
			if(currentNode.getId()==destination)
			{
				path.add(currentNode);
				return path;
			}
			for(Node child:currentNode.getAdjacent()) {
				queue.add(child);
				
				
				}
			visited.add(currentNode.getId());
			path.add(currentNode);
			
				
			}
			
			
		
		
		return path;
		
	}
	
	public List<Node> topologicalSort() {
		
		List<Node> vertices = new LinkedList<Node>();
		List<Node> topoSort = new Stack<Node>();
		Set<Integer> visited = new HashSet<Integer>();
		
		vertices = getAllVertices();
		
		vertices.forEach(v->{
			if(visited.contains(v.getId()))
				return;
			
			topoSortUtil(v,visited,topoSort);
			
		});
		
		return topoSort;
	}

	public void topoSortUtil(Node current,Set<Integer> visited,List<Node> topoSort) {
		
		visited.add(current.getId());
		current.getAdjacent().forEach(child->{
			if(visited.contains(child.getId()))
				return;
			topoSortUtil(child,visited,topoSort);
		});
		
		topoSort.add(current);
		
		
	}
	
	public List<Set<Node>> strongConnectedGraph(){
		List<Node> vertices = new LinkedList<Node>();
		List<Set<Node>> connectedComp = new LinkedList<Set<Node>>();
		List<Node> stack = new Stack<Node>();
		Set<Integer> visited = new HashSet<Integer>();
		vertices = getAllVertices();
		
		vertices.forEach(v->{
			if(visited.contains(v.getId()))
				return;
			sccFind(v,visited,stack);
		});
		
		List<Node> reverseGraph = reverse(vertices);
		
		return connectedComp;
	}
	
	public void sccFind(Node current,Set<Integer> visited,List<Node> stack) {
		
		visited.add(current.getId());
		
		current.getAdjacent().forEach(child->{
			if(visited.contains(child))
				return;
			sccFind(child,visited,stack);
			
		});
		
		stack.add(current);
	}
	
	public void reverses() {
		
	}
}
