package Pertemuan15.src;

public class GraphMatriks09 {
    int vertex;
    int[][] matriks;

    public GraphMatriks09(int v) {
        vertex = v;
        matriks = new int[v][v];
    }

    public void makeEdge(int asal, int tujuan, int jarak) {
        matriks[asal][tujuan] = jarak;
    }

    public void removeEdge(int asal, int tujuan) {
        matriks[asal][tujuan] = 0;
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.print("Gedung " + (char) ('A' + i) + ": ");
            for (int j = 0; j < vertex; j++) {
                System.out.print("Gedung " + (char) ('A' + j) + " (" + matriks[i][j] + " m), ");
            }
            System.out.println();
        }
    }

    public void degree(int index) {
        int inDeg = 0, outDeg = 0;
        //inDegree
        for (int i = 0; i < vertex; i++) {
            if (matriks[i][index] != 0) {
                inDeg++;
            }
        }
        //outDegree
        for (int i = 0; i < vertex; i++) {
            if (matriks[index][i] != 0) {
                outDeg++;
            }
        }
        System.out.println("InDegree dari Gedung " + (char) ('A' + index) + ": " + inDeg);
        System.out.println("outDegree dari Gedung " + (char) ('A' + index) + ": " + outDeg);
        System.out.println("Degree dari Gedung " + (char) ('A' + index) + ": " + (inDeg + outDeg));
        System.out.println("--------------------------");
    }
}