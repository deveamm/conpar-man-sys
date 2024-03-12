package Programa;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab1Salen extends Edificio implements Runnable{
    
    int Saldran=0;
    int Esperar=5000;
    
    String Aforo, Pasillos, Salen;
    
    Color SLab=new Color(186,50,26);
    
    public Lab1Salen(int Espera){
        this.Esperar=Espera;
    }
    
    public void run(){
        while (true){
            try{
                Mutex.acquire();

                Saldran = (int)(Math.random()*CountAforoLab1+1);
                
                if(CountAforoLab1-Saldran>=0){

                    if(SemPLab1.tryAcquire()==true){
                        
                        Thread.sleep(Esperar);

                        System.out.println("Lab1 Saldran = "+Saldran);
                        System.out.println("Lab1 Pasillos = "+CountPasillos);
                        System.out.println("Lab1 Pasillos+Saldran = "+(CountPasillos+Saldran));
                        System.out.println("Lab1 AforoTotal = "+(CountAforoLab1-Saldran));
                        System.out.println("AforoTotal Edificio = "+(CountAforo));
                        System.out.println();
                        
                        CountPasillos=CountPasillos+Saldran;
                        CountAforoLab1=CountAforoLab1-Saldran;

                        Aforo= String.valueOf(CountAforoLab1);
                        Mapa.TotalLab1.setText(Aforo);

                        Pasillos= String.valueOf(CountPasillos);
                        Mapa.ContPasillo.setText(Pasillos);

                        Mapa.Lab1Semaforo.setForeground(SLab);
                        
                        Mapa.Lab2Semaforo.setForeground(BLACK);
                        Mapa.Lab3Semaforo.setForeground(BLACK);
                        Mapa.Lab4Semaforo.setForeground(BLACK);
                        
                        Mapa.ContP1Entrada.setText("0");
                        Mapa.ContP1Salida.setText("0");
                        Mapa.ContP2.setText("0");
                        Mapa.ContP3.setText("0");

                        Mapa.FlechaP1Entrada.setText("");
                        Mapa.FlechaP1Salida.setText("");
                        Mapa.FlechaP2.setText("");
                        Mapa.FlechaP3.setText("");
                        
                        SemLab1.release(Saldran);
                        
                        Mutex.release();
                        
                        SemPLab1.release();
                        
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
