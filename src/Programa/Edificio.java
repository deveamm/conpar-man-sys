package Programa;

import java.util.concurrent.Semaphore;

public class Edificio{
    static Mapa Mapa;
    
    static boolean iniciados=false;
    static boolean detenidos=false;
    
    static int AforoTotal=(40*4);
    static int AforoRestringido=(AforoTotal*40)/100;
    
    static int AforoLabs=(AforoRestringido/4);
    
    static int CountAforoLab1=0;
    static int CountAforoLab2=0;
    static int CountAforoLab3=0;
    static int CountAforoLab4=0;
    
    static int TiempoEsperando=250;
    static int TiempoEsperandoLab=250;
    
    static int CountPasillos=0;
    static int CountAforo=0;
    
    static Semaphore SemP3=new Semaphore(0);
    static Semaphore SemP2=new Semaphore(0);
    
    static Semaphore SemPLab1=new Semaphore(0);
    static Semaphore SemPLab2=new Semaphore(0);
    static Semaphore SemPLab3=new Semaphore(0);
    static Semaphore SemPLab4=new Semaphore(0);
    
    static Semaphore SemLab1=new Semaphore(0);
    static Semaphore SemLab2=new Semaphore(0);
    static Semaphore SemLab3=new Semaphore(0);
    static Semaphore SemLab4=new Semaphore(0);
    
    static Semaphore SemPasillos=new Semaphore(0);
    static Semaphore SemAforo=new Semaphore(0);
    static Semaphore Mutex=new Semaphore(0);
    
    
    static    Thread Lab1E=new Thread(new Lab1Entran(TiempoEsperandoLab));
    static    Thread Lab1S=new Thread(new Lab1Salen(TiempoEsperandoLab));
    
    static    Thread Lab2E=new Thread(new Lab2Entran(TiempoEsperandoLab));
    static    Thread Lab2S=new Thread(new Lab2Salen(TiempoEsperandoLab));
    
    static    Thread Lab3E=new Thread(new Lab3Entran(TiempoEsperandoLab));
    static    Thread Lab3S=new Thread(new Lab3Salen(TiempoEsperandoLab));
    
    static    Thread Lab4E=new Thread(new Lab4Entran(TiempoEsperandoLab));
    static    Thread Lab4S=new Thread(new Lab4Salen(TiempoEsperandoLab));
    
    static    Thread Puerta1E=new Thread(new Puerta1Entran(TiempoEsperando));
    static    Thread Puerta1S=new Thread(new Puerta1Salen(TiempoEsperando));
    
    static    Thread Puerta2E=new Thread(new Puerta2Entran(TiempoEsperando));
    static    Thread Puerta2S=new Thread(new Puerta2Salen(TiempoEsperando));
    
    static    Thread Puerta3E=new Thread(new Puerta3Entran(TiempoEsperando));
    static    Thread Puerta3S=new Thread(new Puerta3Salen(TiempoEsperando));
    
    public static void main(String[] args){
        Mapa=new Mapa();
        Mapa.setVisible(true);
    }
    
    public static void IniciarHilos(){
        
    }
    
    public void CrearHilos(){
        
        iniciados=true;
            
        Mapa.EstadoPrograma.setText("Iniciado");

        Mutex.release(1);

        SemAforo.release(AforoRestringido);

        SemLab1.release(AforoLabs);
        SemLab2.release(AforoLabs);
        SemLab3.release(AforoLabs);
        SemLab4.release(AforoLabs);

        SemP2.release(1);
        SemP3.release(1);

        SemPLab1.release(1);
        SemPLab2.release(1);
        SemPLab3.release(1);
        SemPLab4.release(1);

        System.out.println("Aforo: "+AforoRestringido);
        System.out.println("Aforo Total: "+AforoTotal);
        System.out.println("AforoLabs: "+AforoLabs);
        System.out.println();

        Puerta1E.setPriority(2);
        Puerta1E.start();
        Puerta1S.setPriority(1);
        Puerta1S.start();

        Puerta2E.setPriority(2);
        Puerta2E.start();
        Puerta2S.setPriority(2);
        Puerta2S.start();

        Puerta3E.setPriority(2);
        Puerta3E.start();
        Puerta3S.setPriority(1);
        Puerta3S.start(); 

        Lab1E.setPriority(10);
        Lab1E.start(); 
        Lab1S.setPriority(1);
        Lab1S.start();

        Lab2E.setPriority(9);
        Lab2E.start();
        Lab2S.setPriority(1);
        Lab2S.start();

        Lab3E.setPriority(8);
        Lab3E.start();
        Lab3S.setPriority(1);
        Lab3S.start();

        Lab4E.setPriority(7);
        Lab4E.start();
        Lab4S.setPriority(1);
        Lab4S.start();
        
    }
    
    public void DetenerHilos(){
        
    }
}
