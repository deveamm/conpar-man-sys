package Programa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Puerta3Salen extends Edificio implements Runnable{

    int Saldran=0;
    int Esperar=0;
    
    String Aforo, Pasillos, Salen;
    
    public Puerta3Salen(int Espera){
        this.Esperar=Espera;
    }
    
    public void run(){
        while (true){
            //System.out.println(SemAforo.availablePermits());
            try{
                Mutex.acquire();
                
                Saldran = (int)(Math.random()*CountPasillos+1);

                if(CountPasillos-Saldran>=0){
                    
                    if(SemP3.tryAcquire()==true){
                        
                        Thread.sleep(Esperar);
                        
                        System.out.println("P3S Saldran = "+Saldran);
                        System.out.println("P3S Pasillos = "+CountPasillos);
                        System.out.println("P3S Pasillos-Saldran = "+(CountPasillos-Saldran));
                        System.out.println("P3S AforoTotal = "+(CountAforo-Saldran));
                        System.out.println();

                        CountPasillos=CountPasillos-Saldran;
                        CountAforo=CountAforo-Saldran;

                        Aforo= String.valueOf(CountAforo);
                        Mapa.AforoTotal.setText(Aforo);

                        Pasillos= String.valueOf(CountPasillos);
                        Mapa.ContPasillo.setText(Pasillos);

                        Salen= String.valueOf(Saldran);
                        Mapa.ContP3.setText(Salen);

                        Mapa.FlechaP3.setText("↓");
                        
                        Mapa.ContP1Entrada.setText("0");
                        Mapa.ContP1Salida.setText("0");
                        Mapa.ContP2.setText("0");

                        Mapa.FlechaP1Entrada.setText("");
                        Mapa.FlechaP1Salida.setText("");
                        Mapa.FlechaP2.setText("");

                        SemAforo.release(Saldran);

                        Mutex.release();
                        
                        SemP3.release();
                        
                    }else{
                        Mutex.release();
                    } 
                }else{
                    Mutex.release();
                }

            }catch (InterruptedException ex) {
                    Logger.getLogger(Lab1Entran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
