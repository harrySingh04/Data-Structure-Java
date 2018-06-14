package GraphDS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Graph<E> {
	
	public static AdjacentList adjacentList = new AdjacentList();
	
	public static void main(String[] args) {
		String path = "rescources/File/graph-1.txt";
		Graph g = new Graph();
		String[] graphValues= {};
		int noLines = 0;
		try {
			graphValues = g.readFile(path).split("\n");
			noLines = Integer.parseInt(graphValues[0]);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(noLines>0) {
			Node fromNode,toNode;
			int weight;
			String[] eachLines;
			
			
			for(int i=0;i<graphValues.length-1;i++) {
				eachLines = graphValues[i+1].split(":");
				
				fromNode = new Node(Integer.parseInt(eachLines[0]));
				toNode = new Node(Integer.parseInt(eachLines[1]));
				weight = Integer.parseInt(eachLines[2]);
				
				adjacentList.addNode(fromNode);
				adjacentList.addNode(toNode);
				adjacentList.addEdge(new Edge(fromNode,toNode,weight));
				
		
				
			}
			/*<Edge> edges = new LinkedList<Edge>();
			 Iterator it;
			for (Map.Entry<Node,LinkedList<Edge>> entry : adjacentList.adjacentList.entrySet()) {
				  
				System.out.print("\n"+entry.getKey().data+"===>");
				
				edges = entry.getValue();
				for(Edge e:edges) {
					System.out.print(e.toNode.data); 
					System.out.print(" | "+e.weight);
					System.out.print("      ");
					
				}
				   
				}*/
				
			
		}
		
		
	}

	public String readFile(String path) throws IOException {

		URL url = getClass().getResource(path);
		//File file = new File(url.getPath())
		InputStream in = new FileInputStream(new File(url.getPath()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder out = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			out.append(line+"\n");
		}
		reader.close();
		
		return out.toString();   //Prints the string content read from input stream
		
	}
	
	

}
