package Programa;

import static Programa.Edificio.Mapa;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab2Salen extends Edificio implements Runnable{
    
    int Saldran=0;
    int Esperar=5000;
    
    String Aforo, Pasillos, Salen;
    
    Color SLab=new Color(255,218,26);
    
    public Lab2Salen(int Espera){
        this.Esperar=Espera;
    }
    
    public void run(){
        while (true){
            try{
                Mutex.acquire();

                Saldran = (int)(Math.random()*CountAforoLab2+1);
                
                if(CountAforoLab2-Saldran>=0){

                    if(SemPLab2.tryAcquire()==true){
                        
                        Thread.sleep(Esperar);

                        System.out.println("Lab2 Saldran = "+Saldran);
                        System.out.println("Lab2 Pasillos = "+CountPasillos);
                        System.out.println("Lab2 Pasillos+Saldran = "+(CountPasillos+Saldran));
                        System.out.println("Lab2 AforoTotal = "+(CountAforoLab2-Saldran));
                        System.out.println("AforoTotal Edificio = "+(CountAforo));
                        System.out.println();
                        
                        CountPasillos=CountPasillos+Saldran;
                        CountAforoLab2=CountAforoLab2-Saldran;

                        Aforo= String.valueOf(CountAforoLab2);
                        Mapa.TotalLab2.setText(Aforo);

                        Pasillos= String.valueOf(CountPasillos);
                        Mapa.ContPasillo.setText(Pasillos);

                        Mapa.Lab2Semaforo.setForeground(SLab);
                        
                        Mapa.Lab1Semaforo.setForeground(BLACK);
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
                        
                        SemLab2.release(Saldran);
                        
                        Mutex.release();
                        
                        SemPLab2.release();
                        
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
