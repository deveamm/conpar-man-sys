package Programa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Puerta2Entran extends Edificio implements Runnable{

    int numEntero = 4;    
    int Entraran=0;
    int Saldran=0;
    int EntraOSale=0;
    
    int Esperar=0;
    
    String Aforo, Pasillos, Entran;
    
    public Puerta2Entran(int Espera){
        this.Esperar=Espera;
    }
    
    public void run(){
        while (true){
            try{
                Entraran = (int)(Math.random()*AforoRestringido+1);

                Mutex.acquire();
                
                if(SemP2.tryAcquire()==true){
                    
                    if(SemAforo.tryAcquire(Entraran)==true){
                        
                        Thread.sleep(Esperar);
                
                        System.out.println("P2E Entraran = "+Entraran);
                        System.out.println("P2E Pasillos = "+CountPasillos);
                        System.out.println("P2E Entrarn+Pasillos = "+(CountPasillos+Entraran));
                        System.out.println("P2E AforoTotal = "+(Entraran+CountAforo));
                        System.out.println();

                        CountPasillos=CountPasillos+Entraran;
                        CountAforo=CountAforo+Entraran;

                        Aforo= String.valueOf(CountAforo);
                        Mapa.AforoTotal.setText(Aforo);

                        Pasillos= String.valueOf(CountPasillos);
                        Mapa.ContPasillo.setText(Pasillos);

                        Entran= String.valueOf(Entraran);
                        Mapa.ContP2.setText(Entran);

                        Mapa.FlechaP2.setText("←");

                        Mapa.ContP1Entrada.setText("0");
                        Mapa.ContP1Salida.setText("0");
                        Mapa.ContP3.setText("0");

                        Mapa.FlechaP1Entrada.setText("");
                        Mapa.FlechaP1Salida.setText("");
                        Mapa.FlechaP3.setText("");

                        Mutex.release();
                        
                        SemP2.release();
                        
                    }else{
                        Mutex.release();
                        SemP2.release();
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
