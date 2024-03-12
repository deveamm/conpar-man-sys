package Programa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Puerta3Entran extends Edificio implements Runnable{
  
    int Entraran=0;
    int Esperar=0;
    
    String Aforo, Pasillos, Entran;
    
    public Puerta3Entran(int Espera){
        this.Esperar=Espera;
    }
    
    public void run(){
        while (true){
            //System.out.println(SemAforo.availablePermits());
            try{
                Entraran = (int)(Math.random()*AforoRestringido+1);

                Mutex.acquire();
                
                if(SemP3.tryAcquire()==true){
                    
                    if(SemAforo.tryAcquire(Entraran)){
                        
                        Thread.sleep(Esperar);
                
                        System.out.println("P3E Entraran = "+Entraran);
                        System.out.println("P3E Pasillos = "+CountPasillos);
                        System.out.println("P3E Entrarn+Pasillos = "+(CountPasillos+Entraran));
                        System.out.println("P3E AforoTotal = "+(Entraran+CountAforo));
                        System.out.println();

                        CountPasillos=CountPasillos+Entraran;
                        CountAforo=CountAforo+Entraran;

                        Aforo= String.valueOf(CountAforo);
                        Mapa.AforoTotal.setText(Aforo);

                        Pasillos= String.valueOf(CountPasillos);
                        Mapa.ContPasillo.setText(Pasillos);

                        Entran= String.valueOf(Entraran);
                        Mapa.ContP3.setText(Entran);

                        Mapa.FlechaP3.setText("↑");

                        Mapa.ContP1Entrada.setText("0");
                        Mapa.ContP1Salida.setText("0");
                        Mapa.ContP2.setText("0");

                        Mapa.FlechaP1Entrada.setText("");
                        Mapa.FlechaP1Salida.setText("");
                        Mapa.FlechaP2.setText("");

                        Mutex.release();
                        
                        SemP3.release();
                        
                    }else{
                        Mutex.release();
                        
                        SemP3.release();
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
