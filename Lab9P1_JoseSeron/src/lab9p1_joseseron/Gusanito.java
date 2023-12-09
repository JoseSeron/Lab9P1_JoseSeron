
package lab9p1_joseseron;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Seron
 */
public class Gusanito {
    
    Random random = new Random();
    
    
    //Atributos
    ArrayList<String> instrucciones = new ArrayList();
    char [][] tablero;
    int coorXGus = 0;
    int coorYGus = 0;
    int coorXMan = 0;
    int coorYMan = 0; 
    
    //Constructor
    
    
    public void printMatriz (char [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[ "+matriz[i][j]+" ]");
            }
        }
    
    }

    
    public String mostrarPaso(int paso) {
        String cadena = "";

        if (paso >= 0 && paso < instrucciones.size()) {

            for (int i = 0; i <= paso; i++) {
                String instruccion = instrucciones.get(i);
                int magnitud = Integer.parseInt(instruccion.substring(0, instruccion.length() - 2));
                char direccion = instruccion.charAt(instruccion.length() - 2);

                switch (direccion) {
                    case 'U':
                        coorXMan -= magnitud;
                        break;
                    case 'D':
                        coorXMan += magnitud;
                        break;
                    case 'R':
                        coorYMan += magnitud;
                        break;
                    case 'L':
                        coorYMan -= magnitud;
                        break;
                }

            }

            tablero[coorXMan][coorYMan] = '0';

            cadena += printCadena(tablero);

            tablero[coorXMan][coorYMan] = ' ';

            coorXMan = coorXGus;
            coorYMan = coorYGus;

            return cadena;
        } else {
            return "Número de paso inválido.";
        }
    }


    
    
    
        public String printCadena(char[][] matriz) {
        String cadena = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                cadena += "[ ";
                cadena += matriz[i][j];
                cadena += " ]";
              }
              cadena+="\n";
        }
    return cadena;
    }

    public Gusanito(int tamFilas, int tamColumnas) {
//        this.tablero = tablero;

        // Crear tablero pasando int filas e int columnas
        tablero = new char[tamFilas][tamColumnas];
        
        coorXGus = random.nextInt(tamFilas);
        coorYGus = random.nextInt(tamColumnas);
        coorXMan = random.nextInt(tamFilas);
        coorYMan = random.nextInt(tamColumnas);

        
        //random (mayor, menor)
        int cantObstaculos = 0;
        if (tamFilas>tamColumnas) {
            cantObstaculos = random.nextInt(tamColumnas, tamFilas);
        }else if(tamColumnas>tamFilas){
            cantObstaculos = random.nextInt(tamFilas, tamColumnas);
        }else{
        cantObstaculos = random.nextInt(tamFilas);
        }
        
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
        
        tablero[coorXGus][coorYGus] = 'S';
        tablero[coorXMan][coorYMan] = '0';

        for (int i = 0; i < cantObstaculos; i++) {

            int XObs = 0;
            int YObs = 0;

            do {
                XObs = random.nextInt(tamFilas);
                YObs = random.nextInt(tamColumnas);
            } while ((XObs == coorXGus || XObs == coorXMan) || (YObs == coorYGus || YObs == coorYMan));

            tablero[XObs][YObs] = '#';

        }

    }


}
