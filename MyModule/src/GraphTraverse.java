import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {
    private Character label;
    private boolean isVisited;


    public Vertex(Character label) {
        this.label = label;
        this.isVisited = isVisited;
    }

    public Character getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}


class Graph{

    private final int MAX_VERTEX_COUNT =10;
    private Vertex[] vertexArray;
    private int[][] adjArray;
    private int vertexCount;

    public Graph() {
        vertexArray =new Vertex[MAX_VERTEX_COUNT];
        adjArray=new int[MAX_VERTEX_COUNT][MAX_VERTEX_COUNT];
        vertexCount =0;
        for (int i = 0; i < MAX_VERTEX_COUNT; i++) {
            for (int j = 0; j < MAX_VERTEX_COUNT; j++) {
                adjArray[i][j]=0;
            }
        }
    }



    public void traverseGraphDepth(){

        int enterVertexIndex=0;

        Stack<Integer> stack=new Stack<>();
        System.out.print(vertexArray[enterVertexIndex].getLabel()+" ");
        vertexArray[enterVertexIndex].setVisited(true);
        stack.push(enterVertexIndex);


        while (!stack.empty()){


            int currentVertexIndex=stack.peek();
            int unvisitedVertexIndex = getUnvisitedVertex(currentVertexIndex);

            if (unvisitedVertexIndex==-1) {
                stack.pop();
            }
            else {
                stack.push(unvisitedVertexIndex);
                System.out.print(vertexArray[unvisitedVertexIndex].getLabel()+" ");
                vertexArray[unvisitedVertexIndex].setVisited(true);
            }
        }

        System.out.println();

        for (int i = 0; i < vertexCount; i++) {
            vertexArray[i].setVisited(false);
        }



    }


    public void traverseGraphBreadth(){

        int enterVertexIndex=0;
        int unvisitedVertexIndex;

        Queue<Integer> queue=new LinkedList<>();
        System.out.print(vertexArray[enterVertexIndex].getLabel()+" ");
        vertexArray[enterVertexIndex].setVisited(true);
        queue.add(enterVertexIndex);


        while (!queue.isEmpty()){


            int currentVertexIndex=queue.poll();

            while (( unvisitedVertexIndex= getUnvisitedVertex(currentVertexIndex))!=-1)
            {
                queue.add(unvisitedVertexIndex);
                System.out.print(vertexArray[unvisitedVertexIndex].getLabel()+" ");
                vertexArray[unvisitedVertexIndex].setVisited(true);
            }
        }

        System.out.println();

        for (int i = 0; i < vertexCount; i++) {
            vertexArray[i].setVisited(false);
        }

    }


    private int getUnvisitedVertex(int currentVerteceIndex) {
        for (int i = 0; i < MAX_VERTEX_COUNT; i++) {
            if(adjArray[i][currentVerteceIndex]==1 && !vertexArray[i].isVisited()) return i;
        }
        return -1;
    }

    void addVertex(Character label) {
        vertexArray[vertexCount++]=new Vertex(label);

    }

    public void addEdge(int i, int j) {
        adjArray[i][j]=1;
        adjArray[j][i]=1;
    }
}






public class GraphTraverse {


    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5
        graph.addVertex('G'); //6

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);

        System.out.println("Deep traverse");
        graph.traverseGraphDepth();

        System.out.println("Wide traverse");
        graph.traverseGraphBreadth();
    }

}
