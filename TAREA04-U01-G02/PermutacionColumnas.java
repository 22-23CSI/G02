import java.util.Scanner;

/*
 * 3. Algoritmo que realice el cifrado de un mensaje por permutación de columnas, teniendo como clave n columnas.
 */
public class PermutacionColumnas {

    public static String cifrado(int columnas, String texto) {
        char[][] matriz = new char[columnas][columnas];
        char[] arreglo = new char[columnas * columnas];
        char[] txtcifrado = new char[columnas * columnas];
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


        for (i = texto.length() - v; i < columnas * columnas; i++) {
            arreglo[i] = '0';
        }


        System.out.println(arreglo);

        for (f = 0, i = 0; f < matriz.length; f++) {
            for (c = 0; c < matriz[0].length; c++) {
                matriz[f][c] = arreglo[i];
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
                txtcifrado[i] = matriz[f][c];
                i++;
            }
        }
        System.out.println(" ");
        System.out.println("El texto crifrado es: ");
        return String.valueOf(txtcifrado);


    }

    public static String descifrado(String texto, int columnas) {

        char[][] matriz = new char[columnas][columnas];
        char[] txtcifrado = new char[columnas * columnas];
        char[] txtdescifrado = new char[columnas * columnas];
        int j, i, v, f, c;
        v = 0;

        for (i = 0; i < texto.length(); i++) {
            txtcifrado[i] = texto.charAt(i);
        }


        for (f = 0, i = 0; f < matriz[0].length; f++) {
            for (c = 0; c < matriz.length; c++) {
                matriz[f][c] = txtcifrado[i];
                i++;
            }
        }

        for (f = 0, i = 0; f < matriz.length; f++) {
            for (c = 0; c < matriz[0].length; c++) {
                if (matriz[c][f] != '0') {
                    txtdescifrado[i] = matriz[c][f];
                } else {
                    v++;
                }
                i++;
            }
        }


        for (i = texto.length() - v; i < columnas * columnas; i++) {
            txtdescifrado[i] = ' ';
        }


        System.out.println(" ");
        System.out.println("El texto descifrado es: ");
        return String.valueOf(txtdescifrado);
    }

    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);
        String texto;
        int columnas = 0;
        System.out.println("******Cifrado por permutación de columnas****** ");
        System.out.println("Ingrese el mensaje que desea cifrar:");
        texto = t.nextLine();
        System.out.println("Ingrese el número de columnas: ");
        columnas = t.nextInt();

        int cantidadDeEspacios = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') cantidadDeEspacios++;
        }

        if (texto.length() - cantidadDeEspacios >= columnas * columnas) {
            System.out.println("El mensaje debe tener una longitud menor que: " + columnas * columnas);
        } else {
            String cifrado = cifrado(columnas, texto);
            System.out.println(cifrado);
            System.out.println(descifrado(cifrado, columnas));
        }


    }
}
