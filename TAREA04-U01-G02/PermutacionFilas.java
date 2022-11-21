import java.util.Scanner;

/*
 * 2. Algoritmo que realice el cifrado de un mensaje por permutación de filas, teniendo como clave n filas.
 */
public class PermutacionFilas {

    public static String cifrado(int filas, String texto) {

        char[][] matriz = new char[filas][filas];
        char[] arreglo = new char[filas * filas];
        char[] txtcifrado = new char[filas * filas];
        int j, i, v, f, c;
        v = 0;

        System.out.println(texto);
        for (i = 0, j = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ') {
                arreglo[j] = texto.charAt(i);
                j++;
            } else {
                v++;
            }
        }


        for (i = texto.length() - v; i < filas * filas; i++) {
            arreglo[i] = '0';
        }


        System.out.println(arreglo);

        for (f = 0, i = 0; f < matriz.length; f++) {
            for (c = 0; c < matriz[0].length; c++) {
                matriz[c][f] = arreglo[i];
                i++;
            }
        }


        System.out.println(" ");
        System.out.println("Matriz: ");
        for (f = 0; f < matriz.length; f++) {
            for (c = 0; c < matriz[0].length; c++) {
                System.out.print(matriz[f][c] + "\t");
            }
            System.out.println();
        }

        //Cifrado
        for (c = 0, i = 0; c < matriz[0].length; c++) {
            for (f = 0; f < matriz.length; f++) {
                txtcifrado[i] = matriz[c][f];
                i++;
            }
        }
        System.out.println(" ");
        System.out.println("El texto crifrado es: ");
        return String.valueOf(txtcifrado);


    }

    public static String descifrado(String texto, int filas) {

        char[][] matriz = new char[filas][filas];
        char[] txtcifrado = new char[filas * filas];
        char[] txtdescifrado = new char[filas * filas];
        int j, i, v, f, c;
        v = 0;

        for (i = 0; i < texto.length(); i++) {
            txtcifrado[i] = texto.charAt(i);
        }


        for (f = 0, i = 0; f < matriz[0].length; f++) {
            for (c = 0; c < matriz.length; c++) {
                matriz[c][f] = txtcifrado[i];
                i++;
            }
        }
        for (f = 0, i = 0; f < matriz.length; f++) {
            for (c = 0; c < matriz[0].length; c++) {
                if (matriz[f][c] != '0') {
                    txtdescifrado[i] = matriz[f][c];

                } else {
                    v++;
                }
                i++;
            }
        }


        for (i = texto.length() - v; i < filas * filas; i++) {
            txtdescifrado[i] = ' ';
        }


        System.out.println(" ");
        System.out.println("El texto original es: ");
        return String.valueOf(txtdescifrado);
    }

    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);
        String texto;
        int filas = 0;
        System.out.println("******Cifrado por permutación de filas****** ");
        System.out.println("Ingrese el mensaje que desea cifrar");
        texto = t.nextLine();
        System.out.println("Ingrese el número de filas");
        filas = t.nextInt();

        int cantidadDeEspacios = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') cantidadDeEspacios++;
        }

        if (texto.length() - cantidadDeEspacios >= filas * filas) {
            System.out.println("El mensaje debe tener una longitud menor que: " + filas * filas);
        } else {
            String cifrado = cifrado(filas, texto);
            System.out.println(cifrado);
            System.out.println(descifrado(cifrado, filas));
        }


    }
}
