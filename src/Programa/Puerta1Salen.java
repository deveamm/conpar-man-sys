package Programa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Puerta1Salen extends Edificio implements Runnable{

    int numEntero = 4;    
    int Saldran=0;
    int Esperar=0;
    
    String Aforo, Pasillos, Salen;
    
    public Puerta1Salen(int Espera){
        this.Esperar=Espera;
    }
    
    public void run() {
        while(true){
            try {
                Mutex.acquire();

                Saldran = (int)(Math.random()*CountPasillos+1);

                if(CountPasillos-Saldran>=0){

                    Thread.sleep(Esperar);

                    System.out.println("P1S Saldran = "+Saldran);
                    System.out.println("P1S Pasillos = "+CountPasillos);
                    System.out.println("P1S Pasillos-Saldran = "+(CountPasillos-Saldran));
                    System.out.println("P1S AforoTotal = "+(CountAforo-Saldran));
                    System.out.println();

                    CountPasillos=CountPasillos-Saldran;
                    CountAforo=CountAforo-Saldran;

                    Aforo= String.valueOf(CountAforo);
                    Mapa.AforoTotal.setText(Aforo);

                    Pasillos= String.valueOf(CountPasillos);
                    Mapa.ContPasillo.setText(Pasillos);

                    Salen= String.valueOf(Saldran);
                    Mapa.ContP1Salida.setText(Salen);

                    Mapa.FlechaP1Salida.setText("↑");
                    
                    Mapa.ContP1Entrada.setText("0");
                    Mapa.ContP2.setText("0");
                    Mapa.ContP3.setText("0");

                    Mapa.FlechaP1Entrada.setText("");
                    Mapa.FlechaP2.setText("");
                    Mapa.FlechaP3.setText("");

                    SemAforo.release(Saldran);

                    Mutex.release();

                }else{
                    Mutex.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Puerta1Salen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
