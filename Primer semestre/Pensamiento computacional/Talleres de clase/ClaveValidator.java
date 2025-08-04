public class ClaveValidator {

    public static void main(String[] args) {
        
        System.out.println(validarClave("Ab12"));

    }
    
    public static boolean validarClave(String clave) {
        
        char[] LClave = clave.toCharArray();

        boolean LetMay = false, LetMin = false;

        if (clave.length() == 4) {

            for (int i = 0; i < clave.length(); i++) {

                if (Character.isLetterOrDigit(LClave[i]) == false) {return false;}

            }


            for (int i = 0; i < clave.length(); i++) {

                if (Character.isUpperCase(LClave[i])) {LetMay = true;}

            }

            if (LetMay == true) {

                for (int i = 0; i < clave.length(); i++) {

                    if (Character.isLowerCase(LClave[i])) {LetMin = true;}
    
                }

                if (LetMin == true) {

                    for (int i = 0; i < clave.length(); i++) {
    
                        if (Character.isDigit(LClave[i])) {

                            return true;

                        }
        
                    }   
    
                }

            }

        }
        
        return false;

    }
}