package Programa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class Mapa extends javax.swing.JFrame {

    FondoPanel fondo=new FondoPanel();
    Edificio edificio;
    
    public Mapa() {
        this.setContentPane(fondo);
        initComponents();
        
        edificio=new Edificio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        AforoTotal = new javax.swing.JTextField();
        FlechaP1Entrada = new javax.swing.JTextField();
        FlechaP1Salida = new javax.swing.JTextField();
        FlechaP2 = new javax.swing.JTextField();
        FlechaP3 = new javax.swing.JTextField();
        ContP1Entrada = new javax.swing.JTextField();
        ContP1Salida = new javax.swing.JTextField();
        ContP2 = new javax.swing.JTextField();
        ContP3 = new javax.swing.JTextField();
        Lab1Semaforo = new javax.swing.JTextField();
        Lab2Semaforo = new javax.swing.JTextField();
        Lab3Semaforo = new javax.swing.JTextField();
        Lab4Semaforo = new javax.swing.JTextField();
        TotalLab1 = new javax.swing.JTextField();
        TotalLab2 = new javax.swing.JTextField();
        TotalLab3 = new javax.swing.JTextField();
        TotalLab4 = new javax.swing.JTextField();
        ContPasillo = new javax.swing.JTextField();
        EstadoPrograma = new javax.swing.JTextField();
        BotonIniciar = new javax.swing.JButton();
        BotonDetener = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AforoTotal.setEditable(false);
        AforoTotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        AforoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AforoTotal.setText("0");
        jPanel1.add(AforoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 110, 50));

        FlechaP1Entrada.setEditable(false);
        FlechaP1Entrada.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        FlechaP1Entrada.setForeground(new java.awt.Color(0, 0, 255));
        FlechaP1Entrada.setBorder(null);
        FlechaP1Entrada.setOpaque(false);
        jPanel1.add(FlechaP1Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 40, 100));

        FlechaP1Salida.setEditable(false);
        FlechaP1Salida.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        FlechaP1Salida.setForeground(new java.awt.Color(0, 0, 255));
        FlechaP1Salida.setBorder(null);
        FlechaP1Salida.setOpaque(false);
        FlechaP1Salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlechaP1SalidaActionPerformed(evt);
            }
        });
        jPanel1.add(FlechaP1Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 40, 100));

        FlechaP2.setEditable(false);
        FlechaP2.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        FlechaP2.setForeground(new java.awt.Color(0, 0, 255));
        FlechaP2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FlechaP2.setBorder(null);
        FlechaP2.setOpaque(false);
        FlechaP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlechaP2ActionPerformed(evt);
            }
        });
        jPanel1.add(FlechaP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 80, 50));

        FlechaP3.setEditable(false);
        FlechaP3.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        FlechaP3.setForeground(new java.awt.Color(0, 0, 255));
        FlechaP3.setBorder(null);
        FlechaP3.setOpaque(false);
        FlechaP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlechaP3ActionPerformed(evt);
            }
        });
        jPanel1.add(FlechaP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 50, 80));

        ContP1Entrada.setEditable(false);
        ContP1Entrada.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ContP1Entrada.setText("0");
        jPanel1.add(ContP1Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 50, 40));

        ContP1Salida.setEditable(false);
        ContP1Salida.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ContP1Salida.setText("0");
        jPanel1.add(ContP1Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 50, 40));

        ContP2.setEditable(false);
        ContP2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ContP2.setText("0");
        jPanel1.add(ContP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 50, 40));

        ContP3.setEditable(false);
        ContP3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ContP3.setText("0");
        jPanel1.add(ContP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 50, 40));

        Lab1Semaforo.setEditable(false);
        Lab1Semaforo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Lab1Semaforo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Lab1Semaforo.setText("■");
        Lab1Semaforo.setBorder(null);
        Lab1Semaforo.setOpaque(false);
        jPanel1.add(Lab1Semaforo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 50, 60));

        Lab2Semaforo.setEditable(false);
        Lab2Semaforo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Lab2Semaforo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Lab2Semaforo.setText("■");
        Lab2Semaforo.setBorder(null);
        Lab2Semaforo.setOpaque(false);
        jPanel1.add(Lab2Semaforo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 50, 60));

        Lab3Semaforo.setEditable(false);
        Lab3Semaforo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Lab3Semaforo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Lab3Semaforo.setText("■");
        Lab3Semaforo.setBorder(null);
        Lab3Semaforo.setOpaque(false);
        jPanel1.add(Lab3Semaforo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 50, 60));

        Lab4Semaforo.setEditable(false);
        Lab4Semaforo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Lab4Semaforo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Lab4Semaforo.setText("■");
        Lab4Semaforo.setBorder(null);
        Lab4Semaforo.setOpaque(false);
        jPanel1.add(Lab4Semaforo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 50, 60));

        TotalLab1.setEditable(false);
        TotalLab1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TotalLab1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalLab1.setText("0");
        TotalLab1.setBorder(null);
        TotalLab1.setOpaque(false);
        jPanel1.add(TotalLab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 50, 50));

        TotalLab2.setEditable(false);
        TotalLab2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TotalLab2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalLab2.setText("0");
        TotalLab2.setBorder(null);
        TotalLab2.setOpaque(false);
        jPanel1.add(TotalLab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 50, 50));

        TotalLab3.setEditable(false);
        TotalLab3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TotalLab3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalLab3.setText("0");
        TotalLab3.setBorder(null);
        TotalLab3.setOpaque(false);
        jPanel1.add(TotalLab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 50, 50));

        TotalLab4.setEditable(false);
        TotalLab4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TotalLab4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalLab4.setText("0");
        TotalLab4.setBorder(null);
        TotalLab4.setOpaque(false);
        jPanel1.add(TotalLab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 50, 50));

        ContPasillo.setEditable(false);
        ContPasillo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ContPasillo.setText("0");
        jPanel1.add(ContPasillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 50, 40));

        EstadoPrograma.setEditable(false);
        EstadoPrograma.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        EstadoPrograma.setText("No Iniciado");
        EstadoPrograma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(EstadoPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 190, 50));

        BotonIniciar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BotonIniciar.setText("Iniciar");
        BotonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, 120, 40));

        BotonDetener.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        BotonDetener.setText("Detener");
        BotonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDetenerActionPerformed(evt);
            }
        });
        jPanel1.add(BotonDetener, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 600, 120, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bitmap.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FlechaP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlechaP2ActionPerformed
        
    }//GEN-LAST:event_FlechaP2ActionPerformed

    private void FlechaP1SalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlechaP1SalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FlechaP1SalidaActionPerformed

    private void FlechaP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlechaP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FlechaP3ActionPerformed

    private void BotonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarActionPerformed
        edificio.CrearHilos();
    }//GEN-LAST:event_BotonIniciarActionPerformed

    private void BotonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDetenerActionPerformed
        edificio.DetenerHilos();
    }//GEN-LAST:event_BotonDetenerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField AforoTotal;
    private javax.swing.JButton BotonDetener;
    private javax.swing.JButton BotonIniciar;
    public javax.swing.JTextField ContP1Entrada;
    public javax.swing.JTextField ContP1Salida;
    public javax.swing.JTextField ContP2;
    public javax.swing.JTextField ContP3;
    public javax.swing.JTextField ContPasillo;
    public javax.swing.JTextField EstadoPrograma;
    public javax.swing.JTextField FlechaP1Entrada;
    public javax.swing.JTextField FlechaP1Salida;
    public javax.swing.JTextField FlechaP2;
    public javax.swing.JTextField FlechaP3;
    public javax.swing.JTextField Lab1Semaforo;
    public javax.swing.JTextField Lab2Semaforo;
    public javax.swing.JTextField Lab3Semaforo;
    public javax.swing.JTextField Lab4Semaforo;
    public javax.swing.JTextField TotalLab1;
    public javax.swing.JTextField TotalLab2;
    public javax.swing.JTextField TotalLab3;
    public javax.swing.JTextField TotalLab4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen=new ImageIcon(getClass().getResource("/Imagenes/bitmap.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}


