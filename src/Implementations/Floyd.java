package Implementations;

import static java.lang.Math.min;

public class Floyd {

    private int v;

    private int[][] matrix;

    public Floyd(int[][] matrix){
        this.matrix = matrix;
        this.refactorMatrix();

        this.v = this.matrix.length;
    }

    public void play(){
        for (int i = 0; i < this.v; i++) {
            for (int j = 0; j < this.v; j++) {
                for (int k = 0; k < this.v; k++) {
                    this.matrix[j][k] = min( this.matrix[j][k],
                            ( this.matrix[j][i] + this.matrix[i][k] ) );
                }
            }
        }
    }

    private void refactorMatrix()
    {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                if(this.matrix[i][j] == 0)
                    this.matrix[i][j] = 9999;
            }
        }
    }
}