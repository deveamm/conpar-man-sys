package Programa;

import static Programa.Edificio.Mapa;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3Entran extends Edificio implements Runnable{
 
    int Entraran=0;
    int Esperar=0;
    
    String Aforo, Pasillos, Entran;
    
    Color SLab=new Color(116,76,43);
    
    public Lab3Entran(int Espera){
        this.Esperar=Espera;
    }
    
    public void run(){
        while (true){
            try{
                Entraran = (int)(Math.random()*AforoLabs+1);
                
                Mutex.acquire();
      
                if(CountPasillos-Entraran>=0){
                    
                    if(SemPLab3.tryAcquire()==true){
                        
                        if(SemLab3.tryAcquire(Entraran)){

                            Thread.sleep(Esperar);

                            System.out.println("Lab3 Entraran = "+Entraran);
                            System.out.println("Lab3 Pasillos = "+CountPasillos);
                            System.out.println("Lab3 Pasillos-Entraran = "+(CountPasillos-Entraran));
                            System.out.println("Lab3 AforoTotal = "+(Entraran+CountAforoLab3));
                            System.out.println("AforoTotal Edificio = "+(CountAforo));
                            System.out.println();

                            CountPasillos=CountPasillos-Entraran;
                            CountAforoLab3=CountAforoLab3+Entraran;

                            Aforo= String.valueOf(CountAforoLab3);
                            Mapa.TotalLab3.setText(Aforo);

                            Pasillos= String.valueOf(CountPasillos);
                            Mapa.ContPasillo.setText(Pasillos);

                            Mapa.Lab3Semaforo.setForeground(SLab);
                            
                            Mapa.Lab1Semaforo.setForeground(BLACK);
                            Mapa.Lab2Semaforo.setForeground(BLACK);
                            Mapa.Lab4Semaforo.setForeground(BLACK);
                            
                            Mapa.ContP1Entrada.setText("0");
                            Mapa.ContP1Salida.setText("0");
                            Mapa.ContP2.setText("0");
                            Mapa.ContP3.setText("0");

                            Mapa.FlechaP1Entrada.setText("");
                            Mapa.FlechaP1Salida.setText("");
                            Mapa.FlechaP2.setText("");
                            Mapa.FlechaP3.setText("");
                            
                            Mutex.release();

                            SemPLab3.release();
                            
                        }else{
                            Mutex.release();
                            SemPLab3.release();
                        }
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
