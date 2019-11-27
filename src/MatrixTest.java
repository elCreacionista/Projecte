import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void add() {
        double[][] mat1 = { {1,2,3}, {4,5,6}, {7,8,9} };
        double[][] mat2 = { {3,4,7}, {5,9,1}, {9,7,3} };
        assertArrayEquals(new double[][]{
                {4,6,10}, {9,14,7}, {16,15,12}
        }, Matrix.add(mat1, mat2));
    }

    @Test
    public void transpose() {
        double[][] mat1 = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertArrayEquals(new double[][]{
                {1,4,7}, {2,5,8}, {3,6,9}
        }, Matrix.transpose(mat1));
    }

    @Test
    public void trace() {
        double[][] mat1 = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertEquals(15, Matrix.trace(mat1), 0.01);
    }

    @Test
    public void mult() {
        double[][] mat1 = { {1,2,3}, {4,5,6}, {7,8,9} };
        double[][] mat2 = { {3,4,7}, {5,9,1}, {9,7,3} };
        assertArrayEquals(new double[][]{
                {40,43,18}, {91,103,51}, {142,163,84}
        }, Matrix.mult(mat1, mat2));

        assertArrayEquals(new double[][]{
                {15,20,35}, {25,45,5}, {45,35,15}
        }, Matrix.mult(mat2, 5));
    }

    @Test
    public void power() {
        double[][] mat = { {3,4,7}, {5,9,1}, {9,7,3} };
        assertArrayEquals(new double[][]{
                {294178, 388259, 196952}, {281601,371646,185767}, {369637, 485478,243491}
        }, Matrix.power(mat, 5));
    }

    @Test
    public void subMatrix() {
        double[][] mat = { {1,2,3,5}, {4,5,6,8}, {7,8,9,3} };
        assertArrayEquals(new double[][]{
                {2,3},{5,6},{8,9}
        }, Matrix.submatrix(mat, 1,0,2,2));

        assertArrayEquals(new double[][]{
                {2,3},{5,6},{8,9}
        }, Matrix.submatrix(mat, 1,0,2,2));
    }

    @Test
    public void getMinor() {
        double[][] mat = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertArrayEquals( new double[][]{{5,6}, {8,9}}, Matrix.getMinor(mat, 0, 0));
        assertArrayEquals( new double[][]{{1,3}, {7,9}}, Matrix.getMinor(mat, 1, 1));
        assertArrayEquals( new double[][]{{2,3}, {8,9}}, Matrix.getMinor(mat, 1, 0));
        assertArrayEquals( new double[][]{{4,5}, {7,8}}, Matrix.getMinor(mat, 0, 2));
    }

    @Test
    public void testDeterminant() {
        double[][] mat1 = { {1,2,3}, {4,5,6}, {7,2,7} };
        assertEquals(-30, Matrix.determinant(mat1), 0.001);

        double[][] mat2 = { {1,2,3}, {4,5,6}, {7,8,9} };
        assertEquals(0, Matrix.determinant(mat2), 0.001);
    }

    @Test
    public void cramer() {
        double[][] mat1 = { {2,1,1,3}, {1,-1,-1,0}, {1,2,1,0} };
        compare(new double[]{1,-2,3}, Matrix.cramer(mat1));

        double[][] mat2 = { {2,-1,6,10}, {-3,4,-5,11}, {8,-7,-9,12} };
        compare(new double[]{10.63, 10.58, -0.11}, Matrix.cramer(mat2));
    }

    @Test
    public void div() {
        double[][] mat1 = { {13,-22,63}, {4,95,6}, {7,8,9} };
        double[][] mat2 = { {53,47,7}, {5,29,11}, {91,72,3} };
        assertArrayEquals(new double[][]{
                {24,-5,-12}, {-11,5,5}, {1,0,-1}
        }, Matrix.div(mat1, mat2));
    }

    @Test
    public void testInv1() {
        double[][] mat = { {1,2,3}, {4,5,6}, {7,2,7} };
        compareArraysDouble(new double[][]{{-0.77, 0.26, 0.1}, {-0.47, 0.47, -0.2}, {0.9, -0.4, 0.1}},
                Matrix.invert(mat), 0.01);
    }

    @Test
    public void testInv2() {
        double[][] mat = { {1,2,3,3}, {4,5,6,2}, {7,2,7,7}, {1,6,5,2} };
        compareArraysDouble(new double[][]{{-1.55, -0.63, 0.60, 0.84}, {-1.84, -1.10, 0.68, 1.47}, {2.81, 1.78, -1.13, -2.05}, {-0.74, -0.84, 0.47, 0.79}},
                Matrix.invert(mat), 0.01);
    }

    @Test
    public void isOrtho() {
        double[][] mat = { {2,1,1}, {1,-1,-1}, {1,2,1} };
        assertFalse(Matrix.isOrtho(mat));

        mat = new double[][]{ {1,0,0}, {0,1,0}, {0,0,1}};
        assertTrue(Matrix.isOrtho(mat));
    }

    private void compareArraysDouble(double[][] doubles, double[][] invert, double v) {
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 0; j < doubles.length; j++) {
                assertEquals(doubles[i][j], invert[i][j], v);
            }
        }
    }

    private void compare(double[] m1, double[] m2) {
        if (m1.length != m2.length) {
            assertEquals(true, false);
        }

        for (int i = 0; i < m1.length; i++) {
            assertEquals(m1[i], m2[i], 0.01);
        }
    }

}