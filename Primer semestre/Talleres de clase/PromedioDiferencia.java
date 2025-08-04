import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PromedioDiferencia {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.out.println("-1");
            sc.close();
            return;
        }

        int n = sc.nextInt();

        double[] arreglo = new double[n];

        double sPromedio = 0;
        double maxDiferencia = 0;

        if (n < 1 && n > 100){

            System.out.println(-1);
            sc.close();
            return;

        } else {

            for (int i = 0; i < n; i++){

                if (!sc.hasNextDouble()) {

                    System.out.println("-1");

                    sc.close();
                    return;
                }

                arreglo[i] = sc.nextDouble();

                sPromedio = sPromedio + arreglo[i];

            }

            for (int i = 0; i < n - 1; i++) {

                double diferencia = Math.abs(arreglo[i] - arreglo[i + 1]);

                if (diferencia > maxDiferencia) {

                    maxDiferencia = diferencia;

                }
            }

            BigDecimal maxDiff = BigDecimal.valueOf(maxDiferencia).setScale(2, RoundingMode.HALF_UP);

            BigDecimal suma = BigDecimal.ZERO;
            for (double num : arreglo) {
                suma = suma.add(BigDecimal.valueOf(num));
            }
            BigDecimal rawPromedio = suma.divide(BigDecimal.valueOf(n), 2, RoundingMode.HALF_UP);

            



            System.out.println(rawPromedio + " " + maxDiff);
        

        }

        sc.close();

    }

}