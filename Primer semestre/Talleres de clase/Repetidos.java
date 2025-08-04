import java.util.ArrayList;

public class Repetidos {
    
    public int detectorDeRepetidos(ArrayList<Integer> a) {

        int cRepetidos = 0;
        int actual = a.get(0);
        boolean enRepeticion = false;

        for (int i = 1; i < a.size(); i++) {

            if (a.get(i) == actual) {

                if (!enRepeticion) {

                    enRepeticion = true;
                    cRepetidos++;

                }
            } else {
                enRepeticion = false;
            }
            actual = a.get(i);
        }

        return cRepetidos;

    }
}