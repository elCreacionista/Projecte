

public class Matrix {
    public static void main(String[] args) {}
    static double[][] add(double[][] mat1, double[][] mat2) {
        for (int i = 0; i <mat1.length ; i++) {
            for (int j = 0; j <mat1[i].length ; j++) {
                mat1[i][j]=mat1[i][j]+mat2[i][j];
                //La suma dels valors de una casella de una matriu mes el valor de l'altre
            }
        }
        return mat1;
        //retorna el valor de la matriu resultant
    }

    static double[][] transpose(double[][] mat) {
        double ayuda[][]=new double[mat.length][mat[0].length];
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat.length ; j++) {
                ayuda[j][i]=mat[i][j];
                //Gira els valors de mat
            }
        }
        return ayuda;
        //retorna la nova variable amb els valors girats
    }

    static double[][] mult(double[][] mat1, double[][] mat2) {

        double[][] matrix = new double[mat1.length][mat1.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int cont = 0; cont < matrix.length; cont++) {
                    matrix[i][j] = mat1[i][cont] * mat2[cont][j] + matrix[i][j];
                    //La nova variable = operació 1 + el valor que ja té la variable, per això se acumulen els valors i no es perden
                }
            }
        }
        return matrix;
        //retorna la nova variable
    }
                //AQUÍ HE POSAT UN RESUM DEL QUE PASSA DINS DEL LOOP,
                //EM VAIG DONAR COMPTE QUE POSANT 3 LOOPS ES PODIA FER LA MULTIPLICACIÓ DE FORMA MOLT SIMPLE


                //LA i ES LA VARIABLA QUE TARDA MÉS EN FER EL LOOP: 3 OPERACIÓNS
                //LA j CAMBIA UNA VEGADA A CADA OPERACIÓ
                //LA VARIABLE cont: c FA EL LOOP TRES VEGADES DINS CADA OPERACIÓ

                //i j     i c*c j+ i c*c j+ i c*c j

                //0 0     0 0*0 0+ 0 1*1 0+ 0 2*2 0
                //0 1     0 0*0 1+ 0 1*1 1+ 0 2*2 1
                //0 2     0 0*0 2+ 0 1*1 2+ 0 2*2 2
                //1 0     1 0*0 0+ 1 1*1 0+ 1 2*2 0
                //1 1     1 0*0 1+ 1 1*1 1+ 1 2*2 1
                //1 2     1 0*0 2+ 1 1*1 2+ 1 2*2 2
                //2 0     2 0*0 0+ 2 1*1 0+ 2 2*2 0
                //2 1     2 0*0 1+ 2 1*1 1+ 2 2*2 1
                //2 2     2 0*0 2+ 2 1*1 2+ 2 2*2 2


    static double trace(double[][] mat) {
        double contador=0;
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i==j)contador=contador+mat[i][j];
            }
        }
//Suma els valors que hi ha a la diagonal, la diagonal té els mateixos valors a la x i a la y
        return contador;
        //Retorna el valor
    }
    static double[][] mult(double[][] mat, double n) {
        double[][]      matrix= new double [mat.length][mat.length];
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat.length ; j++) {
                matrix[i][j]=mat[i][j]*n;
                //Es multiplica cada valor de la matriu per el nombre n
            }
        }
        return matrix;
    }

    static double[][] power(double[][] mat, int p) {
        double[][]      matrix= { {0,0,0}, {0,0,0}, {0,0,0} };
        if (p==-1){
            //En cas que es demani una matriu elevada a -1 només es multiplica la matriu per -1
                 matrix=mult(mat,-1);
        }
        else if (p==1){ System.out.println("es igual"); }//Aquesta operació no té ningun sentit
        else if (p<-1){
            //En cas de que sigui un numero negatiu i menor de -1
            for (int i = 0; i>p ; i--) {
                if (i==0){matrix=mult(mat,mat);i++;} else matrix=mult(mat,matrix);
                //Quan la i és 0 es multiplica la matriu per ella mateixa i es "resta" 2 al exponent (quan acaba el loop)
                //Quan la i és major a 2 es multiplica el resultat de la operació anterior per la matriu inicial, fins que acaba el loop
            }
        }
        //En cas de que sigui un numero positiu major a 1
        else if (p>=2){
            for (int i = 0; i <p ; i++) {
                if (i==0){matrix=mult(mat,mat);i++;} else matrix=mult(mat,matrix);
                //Quan la i és 0 es multiplica la matriu per ella mateixa i es "resta" 2 al exponent (quan acaba el loop)
                //Quan la i és major a 2 es multiplica el resultat de la operació anterior per la matriu inicial, fins que acaba el loop
            }
        }
        return matrix;
        //Retorna el resultat
    }
                                                //1       0       2       2
    static double[][] submatrix(double[][] mat, int x1, int y1, int x2, int y2) {
        double[][]      matrixPequena= new double[x1+x2][y1+y2];
        int cont1=0,cont2=0;
        for (int y = 0; y <mat.length ; y++) {
            for (int x = 0; x <mat[0].length ; x++) {
                //Aquest loop recorre la matriu inicial
                if (x==x1 && x1<=x2 && y==y1 && y1<=y2){
                    //En aquest loop es mira si la posició actual del loop es la mateixa que on comença la submatriu
                    //Les variables cont1 i cont2 corresponen a la x i la y de la nova matriu, fins que no estás dins la submatriu son 0
                    matrixPequena[cont2][cont1]=mat[y][x];
                    //quan es dóna valor a la casella incrementen cont1 i x1: Per saber on acaba la submatriu
                    x1++;cont1++;
                }
            }
            x1=1;cont1=0;
            //Al acabar un loop es torna cont1 a 0 i es sumen els altres dos localitzadors: cont2 i y1
            if (y==y1 && y1<=y2){y1++;cont2++;}
        }

        return matrixPequena;
        //Es retorna la matriu nova
    }

    static double[][] getMinor(double[][] mat, int x, int y) {
        //Es crea una matriu amb 1 casilla mes petita per cada costat
        double[][]      matrix= new double[mat.length-1][mat[0].length-1];
        int cont1=0,cont2=0;
        for (int j = 0; j <mat.length ; j++) {
            for (int i = 0; i <mat[0].length ; i++) {
                if (i!=y&&j!=x){
                    //Aqui es mira si la matriu no està dins la + que forma la posició que ens dónen
                    //Si es aixi s'asignen els valors i s'incrementa la variable que equival a la y sino pasa al seguent
                    matrix[cont1][cont2]=mat[j][i];
                    cont2++;
                }
            }
            //Aquí es torna la variable que equival a y a 0, i incrementa la variable que equival a la x
            cont2=0;
            if (j!=x) cont1++;
        }
        return matrix;
        //Retorna la matriu resultant
    }

    static double determinant(double[][] mat) {
        //El determinant es una funció recursiva
        double det=0;
        for (int i = 0; i < mat.length; i++) {
            if (mat.length == 2) {
                det = subdeterminant(mat);
                //Si la matriu es un 2x2 la variable det és igual al subdeterminant
            }
            else if (mat.length >= 3) {
                det = det+ valores(i)* (mat[0][i]*(determinant(getMinor(mat, 0, i))));
                //Si la matriu és major o igual a un 3x3 det és igual a ella mateixa (Per guardar els valors que es resolen en el loop)mes valores
                //mes el metode valores multiplicat per el valor amb el que estam treballant (0,i) per el determinant del menor en aquesta posició
            }
        }
        return det;
    }
    static int valores(int i){
        //Mira si la i es par o impar i retorna un 1 o -1
        //Aquest mètode es purament de ajuda, per si la multiplicació es positiva o negativa
        if (i % 2 == 0) {return 1;}
        else {return -1;}
    }
    static double subdeterminant(double[][] mat) {
        //Retorna el valor de un determinant de 2x2
        double det;
        det=(mat[0][0]*mat[1][1])-(mat[1][0]*mat[0][1]);
        return det;
    }



    static double[] cramer(double[][] mat) {
        //{ {2, 1, 1,3},
        //  {1,-1,-1,0},
        //  {1, 2, 1,0} }
        double[] cramer = new double[mat.length];
        double[][] matrix = new double[mat.length][mat[0].length];
        for (int i = 0; i <cramer.length ; i++) {
            //Es recorr la matriu 3x1 cramer i es dóna el valor
            cramer[i]=determinant(hacerCramer(mat, i))/determinant(hacerMatrix(mat));
        }
        return cramer;
    }
    static double[][] hacerCramer(double[][]mat, int columna){

        //Aquest mètode fa les matrius amb les columnes girades
        double[][] pepitogrillo= new double[mat.length][mat.length];
        for (int i = 0; i <mat.length; i++) {
            for (int j = 0; j <mat.length ; j++) {
             if (columna==j){
                 //Columna mira la posició en la que està l'array quan entra al mètode
                 //Si aquesta posició equival a la columna actual es sustitueix la columna que tocaria per la darrera de mat
                 pepitogrillo[i][j]=mat[i][mat[0].length-1];
             }else {pepitogrillo [i][j]=mat[i][j];}
            }
        }
        return pepitogrillo;
    }


    static double[][] hacerMatrix(double[][]mat){
        double[][] matrix= new double[mat.length][mat.length];
        //Es fa la matriu 3x3 que hi ha dins mat
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                matrix[i][j]=mat[i][j];
            }
        }
        return matrix;
    }

    //2  1  1       |       3  1  1               2  3  1             2  1  3
    //1 -1 -1       |       0 -1 -1               1  0 -1             1 -1  0
    //1  2  1       |       0  2  1               1  0  1             1  2  0

    //k j   k j   k j 3 |    0    k j   k j       k j    1    k j     k j   k j    2
    //c 0   c 1   c 2   |   c 3   c 1   c 2       c 0   c 3   c 2     c 0   c 1   c 3

    //0 0 - 0 1 - 0 2   |   0 3 - 0 1 - 0 2       0 0 - 0 3 - 0 2     0 0 - 0 1 - 0 3
    //1 0 - 1 1 - 1 2   |   1 3 - 1 1 - 1 2       1 0 - 1 3 - 1 2     1 0 - 1 1 - 1 3
    //2 0 - 2 1 - 2 2   |   2 3 - 2 1 - 2 2       2 0 - 2 3 - 2 2     2 0 - 2 1 - 2 3

    static double[][] div(double[][] mat1, double[][] mat2) {

        return mult(mat1,power(mat2,-1));
    }

    static double[][] invert(double[][] mat) {
        double[][] matrix= new double[mat.length][mat[0].length];
        if (determinant(mat)==0) {System.out.println("És una matriu singular");}
        mat=transpose(mat);
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                matrix[i][j]=valores(i) *determinant(getMinor(mat,i,j))/determinant(mat);
            }
        }
        return matrix;
    }

    static double[][] calcMinors(double[][] mat) {
        return null;
    }

    static boolean isOrtho(double[][] mat) {
        return false;
    }

    // Funció que mostra una matriu per pantalla
    static void printMat(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%06.2f ", mat[i][j]);
            }
            System.out.println();
        }
    }
}