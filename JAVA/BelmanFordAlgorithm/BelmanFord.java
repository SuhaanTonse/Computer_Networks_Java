package BelmanFordAlgorithm;
import java.util.Scanner;
public class BelmanFord{
	int noOfVertices=0;
	public static void main(String[] args){
		int noOfVertices=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of vertices");
		noOfVertices =sc.nextInt();
		System.out.println("Enter the adjacency matrix");
		int [][] adjacencyMatrix = new int[noOfVertices+1][noOfVertices+1];
		for(int sn=1; sn<=noOfVertices; sn++){
			for(int dn=1; dn<=noOfVertices; dn++){
				adjacencyMatrix[sn][dn]=sc.nextInt();
				if(sn==dn){
					adjacencyMatrix[sn][dn]=0;
					continue;
				}
				if(adjacencyMatrix[sn][dn]==0){
					adjacencyMatrix[sn][dn]=999;
				}
			}
		}
		System.out.println("Enter source vertex");
		int source=sc.nextInt();
		System.out.println("The entered matrix is :");
		for(int sn=1; sn<=noOfVertices;sn++){
			for(int dn =1; dn<=noOfVertices;dn++){
				System.out.print(adjacencyMatrix[sn][dn]+"\t");
			}
			System.out.println();
		}
		BelmanFord bf = new BelmanFord(noOfVertices);
		bf.bfEvaluation(source,adjacencyMatrix);
	}
	private int [] distance;
	public BelmanFord(int noOfVertices){
		this.noOfVertices=noOfVertices;
		distance=new int[noOfVertices+1];
	}
	
	public void bfEvaluation(int source,int[][] adjacencyMatrix){
		for(int node =1; node<=noOfVertices; node++){
			distance[node]=999;
		}
		distance[source]=0;
		for (int node=1; node<=noOfVertices-1;node++){
			for(int sn=1; sn<=noOfVertices; sn++){
				for(int dn=1; dn<=noOfVertices; dn++){
					if(adjacencyMatrix[sn][dn]!=999){
						if(distance[dn]>distance[sn]+adjacencyMatrix[sn][dn]){
							distance[dn]=distance[sn]+adjacencyMatrix[sn][dn];
						}
					}
				}
			}
		}
		
			for(int sn=1; sn<=noOfVertices; sn++){
				for(int dn=1; dn<=noOfVertices; dn++){
					if(adjacencyMatrix[sn][dn]!=999){
						if(distance[dn]>distance[sn]+adjacencyMatrix[sn][dn]){
							System.out.println("Graph contains negative edge cycle");
						}
					}
				}
			}
		
		for(int vertex =1; vertex<=noOfVertices; vertex++){
			System.out.println("Distance from source\t"+source+" to vertex\t"+vertex+" is\t"+ distance[vertex]);
		}
	}
	
	
}
