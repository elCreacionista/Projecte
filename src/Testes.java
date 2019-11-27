import java.util.Scanner;

public class Testes {
    public static void main(String[] args) {
        boolean pl1=true;
        boolean pl2=true;
        int a0[]= {0,0,0,0,0,0,0,0,0,0};
        int a1[]= {0,0,0,0,0,0,0,0,0,0};
        int a2[]= {0,0,0,0,0,0,0,0,0,0};
        int a3[]= {0,0,0,0,0,0,0,0,0,0};
        int a4[]= {0,0,0,0,0,0,0,0,0,0};
        int a5[]= {0,0,0,0,0,0,0,0,0,0};
        int a6[]= {0,0,0,0,0,0,0,0,0,0};
        int a7[]= {0,0,0,0,0,0,0,0,0,0};
        int a8[]= {0,0,0,0,0,0,0,0,0,0};
        //System.out.println(factorial(90));
        for (int turnos = 0; turnos<100; turnos++) {
            System.out.println("0 1 2 3 4 5 6 7 8");
            for (int i = 0; i < a0.length; i++) {
                conecta(a0[i]);
                conecta(a1[i]);
                conecta(a2[i]);
                conecta(a3[i]);
                conecta(a4[i]);
                conecta(a5[i]);
                conecta(a6[i]);
                conecta(a7[i]);
                conecta(a8[i]);
                System.out.println("");
            }
            String b;
            Scanner v =new Scanner(System.in);
            b=v.nextLine();
            valoresMapa(b,a0,a1,a2,a3,a4,a5,a6,a7,a8);

        }
    }

    static void valoresMapa(String b, int[] a0, int [] a1, int[] a2,int [] a3, int[] a4, int [] a5, int[] a6, int [] a7, int[] a8){
        switch (b){
            case "x0":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a0[i]==0){a0[i]=1;break;}
                }
            }break;
            case "o0":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a0[i]==0){a0[i]=2;break;}
                }
            }break;
            case "x1":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a1[i]==0){a1[i]=1;break;}
                }
            }break;
            case "o1":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a1[i]==0){a1[i]=2;break;}
                }
            }break;
            case "x2":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a2[i]==0){a2[i]=1;break;}
                }
            }break;
            case "o2":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a2[i]==0){a2[i]=2;break;}
                }
            }break;
            case "x3":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a3[i]==0){a3[i]=1;break;}
                }
            }break;
            case "o3":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a3[i]==0){a3[i]=2;break;}
                }
            }break;
            case "x4":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a4[i]==0){a4[i]=1;break;}
                }
            }break;
            case "o4":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a4[i]==0){a4[i]=2;break;}
                }
            }break;
            case "x5":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a5[i]==0){a5[i]=1;break;}
                }
            }break;
            case "o5":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a5[i]==0){a5[i]=2;break;}
                }
            }break;
            case "x6":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a6[i]==0){a6[i]=1;break;}
                }
            }break;
            case "o6":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a6[i]==0){a6[i]=2;break;}
                }
            }break;
            case "x7":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a7[i]==0){a7[i]=1;break;}
                }
            }break;
            case "o7":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a7[i]==0){a7[i]=2;break;}
                }
            }break;
            case "x8":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a8[i]==0){a8[i]=1;break;}
                }
            }break;
            case "o8":
            {
                for (int i = 0; i <a0.length ; i++) {
                    if (a8[i]==0){a8[i]=2;break;}
                }
            }break;
            default:
                System.out.println("Te has pasao");
        }
    }




    static void conecta(int n){
        switch (n){
            case 0:
                System.out.print("  ");break;
            case 1:
                System.out.print("x ");break;
            case 2:
                System.out.print("o ");break;
        }
    }















  /*  static double determint(double[][] mat) {
        double[][]      matrix= new double [mat.length][mat.length];
        double[][]      submatrix= new double [mat.length-1][mat.length-1];
        double          determinant = 1;


        for (int i = 0; i <mat.length ; i++) {
            if (mat.length == 2) {
                determinant=subdeterminant(submatrix = getMinor(mat, i, 0));
                return determinant;
            }
            else if (mat.length>=3){
                determint(submatrix=getMinor(mat,i,0));
                return determinant+determint(submatrix);
            }
        }

        return 0;
    }

    static double subdeterminant(double[][] mat) {
        double det;
            det=(mat[0][0]*mat[1][1])-(mat[1][0]*mat[0][1]);
        return det;
    }

    static double[][] getMinor(double[][] mat, int x, int y) {
        double[][]      matriz= new double[mat.length-1][mat[0].length-1];
        int cont1=0,cont2=0;
        for (int j = 0; j <mat.length ; j++) {
            for (int i = 0; i <mat[0].length ; i++) {
                if (i!=y&&j!=x){
                    matriz[cont1][cont2]=mat[j][i];
                    cont2++;
                }
            }
            cont2=0;
            if (j!=x) cont1++;
        }
        return matriz;
    }


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
double[][]      matrix= new double[mat.length][mat.length];
        double[]        det1=new double[mat.length];
        double          det=0;
        for (int i = -1; i <mat[0].length-1 ; i++) {
                for (int j = 0; j <mat.length ; j++) {
                    for (int k = 0; k <mat.length ; k++) {
                        switch (i) {
                            case -1:
                                matrix[j][k] = mat[j][k];break;
                            case 0: {
                                switch (j){
                                    case 0: matrix[k][j]=mat[k][3];break;
                                    case 1: matrix[k][j] = mat[k][j];break;
                                    case 2: matrix[k][j]=mat[k][j];break;
                                }break;
                            }
                            case 1: {
                                switch (j){
                                    case 0: matrix[k][j]=mat[k][j];break;
                                    case 1: matrix[k][j] = mat[k][3];break;
                                    case 2: matrix[k][j]=mat[k][j];break;
                                }break;
                            }
                            case 2: {
                                switch (j){
                                    case 0: matrix[k][0]=mat[k][j];break;
                                    case 1: matrix[k][j] = mat[k][j];break;
                                    case 2: matrix[k][j]=mat[k][3];break;
                                }break;
                            }
                            //0 0 - 0 1 - 0 2   |   0 3 - 0 1 - 0 2       0 0 - 0 3 - 0 2     0 0 - 0 1 - 0 3
                            //1 0 - 1 1 - 1 2   |   1 3 - 1 1 - 1 2       1 0 - 1 3 - 1 2     1 0 - 1 1 - 1 3
                            //2 0 - 2 1 - 2 2   |   2 3 - 2 1 - 2 2       2 0 - 2 3 - 2 2     2 0 - 2 1 - 2 3


                        }

                    }
                }
            if (i==-1) det=determinant(matrix);
            else det1[i]=determinant(matrix)/det;
        }
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++













    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        System.out.println(n);
        return n * factorial(n - 1);
    }*/
}