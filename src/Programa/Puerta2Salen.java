package Programa;

public class Puerta2Salen extends Edificio implements Runnable{

    int numEntero = 4;    
    int Saldran=0;
    int Esperar=0;
    
    String Aforo, Pasillos, Salen;
    
    public Puerta2Salen(int Espera){
        this.Esperar=Espera;
    }
    
    public void run(){
        while (true){
            try{
                Mutex.acquire();
                
                Saldran = (int)(Math.random()*CountPasillos+1);

                if(CountPasillos-Saldran>=0){
                    
                    if(SemP2.tryAcquire()==true){
                        
                        Thread.sleep(Esperar);
                        
                        System.out.println("P2S Saldran = "+Saldran);
                        System.out.println("P2S Pasillos = "+CountPasillos);
                        System.out.println("P2S Pasillos-Sladran = "+(CountPasillos-Saldran));
                        System.out.println("P2S AforoTotal = "+(CountAforo-Saldran));
                        System.out.println();
                        
                        CountPasillos=CountPasillos-Saldran;
                        CountAforo=CountAforo-Saldran;

                        Aforo= String.valueOf(CountAforo);
                        Mapa.AforoTotal.setText(Aforo);

                        Pasillos= String.valueOf(CountPasillos);
                        Mapa.ContPasillo.setText(Pasillos);

                        Salen= String.valueOf(Saldran);
                        Mapa.ContP2.setText(Salen);

                        Mapa.FlechaP2.setText("→");
                        
                        Mapa.ContP1Entrada.setText("0");
                        Mapa.ContP1Salida.setText("0");
                        Mapa.ContP3.setText("0");

                        Mapa.FlechaP1Entrada.setText("");
                        Mapa.FlechaP1Salida.setText("");
                        Mapa.FlechaP3.setText("");

                        SemAforo.release(Saldran);
 
                        Mutex.release();
                        
                        SemP2.release();
                        
                    }else{
                        Mutex.release();
                    } 
                }else{
                    Mutex.release();
                }

            }catch (InterruptedException ex) {
                    ex.printStackTrace();
            }
        }
    }

}
