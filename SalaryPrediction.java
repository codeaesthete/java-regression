import java.util.Scanner;
class SalaryPrediction {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Salary Prediction");
        System.out.println("Enter number of rows of data");
        int a = scn.nextInt();
        double[] input = new double[2 * a];
        
        for (int i = 0, j = 1; i < 2 * a; i++, j++) {
            System.out.println(j + " Enter year ");
            double e = scn.nextDouble();
            input[i] = e;
            i++;
            System.out.println("Enter salary received on year " + e);
            input[i] = scn.nextDouble();
        }

        double mean_X = 0;
        double mean_Y = 0;
        for (int i = 0; i < 2 * a; i++) {
            if (i % 2 == 0) {
                mean_X += input[i];
            } else {
                mean_Y += input[i];
            }
        }

        mean_X = mean_X / a;
        mean_Y = mean_Y / a;
        double mean_X_Prod = 0;
        double[] mean_Deviation = new double[2 * a];
        for (int i = 0; i < 2 * a; i++) {
            if (i % 2 == 0) {
                mean_Deviation[i] = input[i] - mean_X;
                mean_X_Prod += mean_Deviation[i] * mean_Deviation[i];
            } else {
                mean_Deviation[i] = input[i] - mean_Y;
            }
        }
        double[] prod = new double[a];
        double prod_Mean = 0;
        for (int i = 0, j = 0; i < a; i++) {
            prod[i] = mean_Deviation[j] * mean_Deviation[j + 1];
            prod_Mean += prod[i];
            j += 2;
        }
        double w1 = prod_Mean / mean_X_Prod;

        System.out.println("The Linear Equation is:");
        System.out.println("Y = " + (mean_Y - (w1 * mean_X)) + " + " + w1 + "x");
    }
}
