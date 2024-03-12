package Programa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Puerta1Entran extends Edificio implements Runnable{
    
    int Entraran=0;
    int Esperar=0;
    
    String Aforo, Pasillos, Entran;
    
    public Puerta1Entran(int Espera){
        this.Esperar=Espera;
    }
    
    public void run(){
        while(true){
            try {
                
                Entraran = (int)(Math.random()*AforoRestringido+1);
                
                Mutex.acquire();
                
                if(SemAforo.tryAcquire(Entraran)==true){
                    
                    Thread.sleep(Esperar);
                
                    System.out.println("P1E Entraran = "+Entraran);
                    System.out.println("P1E Pasillos = "+CountPasillos);
                    System.out.println("P1E Entrarn+Pasillos = "+(CountPasillos+Entraran));
                    System.out.println("P1E AforoTotal = "+(Entraran+CountAforo));
                    System.out.println();

                    CountPasillos=CountPasillos+Entraran;
                    CountAforo=CountAforo+Entraran;

                    Aforo= String.valueOf(CountAforo);
                    Mapa.AforoTotal.setText(Aforo);

                    Pasillos= String.valueOf(CountPasillos);
                    Mapa.ContPasillo.setText(Pasillos);

                    Entran= String.valueOf(Entraran);
                    Mapa.ContP1Entrada.setText(Entran);

                    Mapa.FlechaP1Entrada.setText("↓");

                    Mapa.ContP1Salida.setText("0");
                    Mapa.ContP2.setText("0");
                    Mapa.ContP3.setText("0");

                    Mapa.FlechaP1Salida.setText("");
                    Mapa.FlechaP2.setText("");
                    Mapa.FlechaP3.setText("");

                    Mutex.release();
                }else{
                    Mutex.release();
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Puerta1Entran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
