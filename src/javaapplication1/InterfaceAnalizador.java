/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication1;

import Codigo.Lexer;
import Codigo.Listas;
import Codigo.Parser;
import Codigo.arbol;
import Codigo.nodoSym;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Javier Avila
 */
public class InterfaceAnalizador extends javax.swing.JFrame {

      private String nombreArchivo;
      private ArrayList<String> imgs = new ArrayList();
      int indiceActual;
    /**
     * Creates new form InterfaceAnalizador
     */
    public InterfaceAnalizador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ConsolaTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LabelImgGrafica = new javax.swing.JLabel();
        PestañasPanel = new javax.swing.JTabbedPane();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        NuevoArchivoOp = new javax.swing.JMenuItem();
        AbrirArchivoOp = new javax.swing.JMenuItem();
        GuardarArchivoOp = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        EliminarPestañasOp = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        ConsolaTextArea.setEditable(false);
        ConsolaTextArea.setBackground(new java.awt.Color(153, 153, 153));
        ConsolaTextArea.setColumns(20);
        ConsolaTextArea.setRows(5);
        jScrollPane1.setViewportView(ConsolaTextArea);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("CONSOLE");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Anterior");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Siguiente");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelImgGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelImgGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PestañasPanel.setBackground(new java.awt.Color(102, 102, 102));

        jButton3.setText("Limpiar consola");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PestañasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(30, 30, 30))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PestañasPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));

        jMenu2.setText("Archivo");

        NuevoArchivoOp.setText("Nuevo");
        NuevoArchivoOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoArchivoOpActionPerformed(evt);
            }
        });
        jMenu2.add(NuevoArchivoOp);

        AbrirArchivoOp.setText("Abrir");
        AbrirArchivoOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirArchivoOpActionPerformed(evt);
            }
        });
        jMenu2.add(AbrirArchivoOp);

        GuardarArchivoOp.setText("Guardar");
        GuardarArchivoOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarArchivoOpActionPerformed(evt);
            }
        });
        jMenu2.add(GuardarArchivoOp);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Pestañas");

        EliminarPestañasOp.setText("Eliminar");
        EliminarPestañasOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPestañasOpActionPerformed(evt);
            }
        });
        jMenu1.add(EliminarPestañasOp);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Ejecutar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
anterior();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AbrirArchivoOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirArchivoOpActionPerformed
        // TODO add your handling code here:
         String contenidoObtenido ;
        try{
            contenidoObtenido = abrirArchivoConExtensionDF();
            agregarPestaña(contenidoObtenido, this.nombreArchivo);
        }catch(Exception e){
            mensaje("No se selecciono ningun archivo");
        }
            
        
    }//GEN-LAST:event_AbrirArchivoOpActionPerformed

    private void NuevoArchivoOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoArchivoOpActionPerformed
        // TODO add your handling code here:
        String plantillaContenido = "PROGRAM\n\nEND PROGRAM";
       agregarPestaña(plantillaContenido, "Pestaña Nueva.df");
        
    }//GEN-LAST:event_NuevoArchivoOpActionPerformed

    private void GuardarArchivoOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarArchivoOpActionPerformed
        // TODO add your handling code here:
         int indicePestanaActual = this.PestañasPanel.getSelectedIndex();
         String name = this.PestañasPanel.getTitleAt(indicePestanaActual);
        saveFile(name);
    }//GEN-LAST:event_GuardarArchivoOpActionPerformed

    private void EliminarPestañasOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPestañasOpActionPerformed
        // TODO add your handling code here:
        
        int var = solicitarConfirmacion("Desea eliminar la pestaña actual?");
        if (var == JOptionPane.YES_OPTION){
            eliminarPestanaActual();
        }
    }//GEN-LAST:event_EliminarPestañasOpActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        JTextArea entrada = obtenerTextAreaDePestanaActual();
        ejecutar(entrada.getText());
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.ConsolaTextArea.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
siguiente();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        Listas.generarTablaHTMLErrores();
        Listas.generarTablaHTMLTokens();
        Listas.generarTablaHTMLTS();
        
    }//GEN-LAST:event_jMenu4MouseClicked

    private void saveFile (String name){
JFileChooser fileChooser = new JFileChooser();
fileChooser.setSelectedFile(new File(name));
FileNameExtensionFilter filter = new FileNameExtensionFilter ( "Archivos de texto (*.df)", "df");
fileChooser.setFileFilter(filter);
int result = fileChooser.showSaveDialog ( this);
if (result == JFileChooser .APPROVE_OPTION) {
try {
String filePath = fileChooser.getSelectedFile().getAbsolutePath();
if (!filePath. toLowerCase().endsWith( ".df")){
 filePath += ".df";   
}
JTextArea currentTextArea = obtenerTextAreaDePestanaActual();
String contentToSave = currentTextArea.getText();
try (BufferedWriter writer = new BufferedWriter (new FileWriter (filePath))) {
writer.write( contentToSave);
}
} catch (IOException ex) {
    

ex.printStackTrace();

}
}}
    
    private JTextArea obtenerTextAreaDePestanaActual() {
        // Obtener el índice de la pestaña actualmente seleccionada
        int indicePestanaActual = this.PestañasPanel.getSelectedIndex();

        // Verificar si hay alguna pestaña seleccionada
        if (indicePestanaActual != -1) {
            // Obtener el componente asociado a la pestaña actual
            Component componentePestanaActual = this.PestañasPanel.getComponentAt(indicePestanaActual);

            // Verificar si el componente es un JTextArea
            if (componentePestanaActual instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) componentePestanaActual;
                Component componenteInterno = scrollPane.getViewport().getView();

                if (componenteInterno instanceof JTextArea) {
                    // Castear y devolver el JTextArea
                    return (JTextArea) componenteInterno;
                }
            }
        }

        // Si no se encuentra un JTextArea, puedes devolver null o manejar la lógica según tus necesidades
        return null;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceAnalizador().setVisible(true);
            }
        });
    }
    
     private int solicitarConfirmacion(String mensaje) {
        // Configurar opciones de botones
        Object[] opciones = {"Sí", "No"};
        
        // Mostrar el cuadro de diálogo de opciones
        int seleccion = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        return seleccion;
    }
    
       private void eliminarPestanaActual() {
        // Obtener el índice de la pestaña actualmente seleccionada
        int indicePestanaActual = this.PestañasPanel.getSelectedIndex();

        // Verificar si hay alguna pestaña seleccionada
        if (indicePestanaActual != -1) {
            // Eliminar la pestaña en el índice actual
            this.PestañasPanel.remove(indicePestanaActual);
        }
    }

    private String buscarArchivoTexto() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.df)", "df");
        fc.setFileFilter(filtro);

        int resp = fc.showOpenDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
           this.nombreArchivo = fc.getSelectedFile().getName();
            return leerContenidoArchivo(fc.getSelectedFile().getPath());
        }
        return "";
    }

    private String leerContenidoArchivo(String rutaArchivo) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores (puedes personalizarlo según tus necesidades)
        }

        return contenido.toString();
    }

    // Otro código de tu aplicación aquí

    // Ejemplo de cómo podrías usar el método buscarArchivoTexto
    private String abrirArchivoConExtensionDF() {
        String contenido = buscarArchivoTexto();
        if (!contenido.isEmpty()) {
            // Hacer algo con el contenido del archivo de texto
            return  contenido;
        } else {
            throw new NullPointerException("¡No se selecciono archivo!");
        }
    }


    public static void analizadores(){
       try{
                        String path = "./src/Codigo/";
                        String[] opJflex = {path+"Lexico.jflex","-d",path};
                        JFlex.Main.generate(opJflex);
                        String[] opCup = {"-destdir",path,"-parser","Parser",path+"Parser.cup"};
                        java_cup.Main.main(opCup);
                    } catch (Exception e){
                    }
                    
    }
    
    public void ejecutar(String entrada){
        try{
            Listas.inicializarListas();
           LabelImgGrafica.setIcon(null);
         ArrayList<nodoSym> TS = new ArrayList();
                    Lexer lex = new Lexer(new StringReader(entrada));
                    Parser sintax = new Parser(lex);
                    arbol raiz = (arbol) sintax.parse().value;
                    raiz.consola = "";
                    raiz.run(raiz, TS);
                    System.out.println("TABLA ---------");
                    for(nodoSym n : TS){
                        System.out.println(n.getNombre()+ " valor: "+ n.getValor());
                    }
                    
                    this.ConsolaTextArea.setText(raiz.consola);
                    this.imgs = raiz.ListaImagenes;
                    Listas.setTS(TS);
                    if(!imgs.isEmpty()){
                   indiceActual = imgs.size() - 1;
                    asignarIconoAJLabel(imgs.get(indiceActual));
                    }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void siguiente(){
        
        if (indiceActual < imgs.size() - 1) {
                        indiceActual++;
                        asignarIconoAJLabel(imgs.get(indiceActual));
                    } else {
                        mensaje("Ya estás en el último dato.");
                    }
                    
    }
    
    public void anterior(){
        if (indiceActual > 0) {
                        indiceActual--;
                        asignarIconoAJLabel(imgs.get(indiceActual));
                    } else {
                        mensaje("Ya estás en el primer dato.");
                    }
                   
    }
    
    public void asignarIconoAJLabel(String rutaImagen) {
        // Cargar la imagen desde la ruta proporcionada
         ImageIcon icono = new ImageIcon(rutaImagen);

    // Obtener la imagen del icono y ajustar el tamaño
    java.awt.Image imagen = icono.getImage();
    java.awt.Image nuevaImagen = imagen.getScaledInstance(LabelImgGrafica.getWidth(), LabelImgGrafica.getHeight(), java.awt.Image.SCALE_SMOOTH);

    // Crear un nuevo ImageIcon con la imagen redimensionada
    ImageIcon iconoRedimensionado = new ImageIcon(nuevaImagen);

        // Establecer el icono en el JLabel
        LabelImgGrafica.setIcon(iconoRedimensionado);
    }
    
    public void mensaje(String mjs){
        JOptionPane.showMessageDialog(null, mjs, "Aviso:", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void agregarPestaña(String contenido, String nombre){
         JTextArea textArea = new JTextArea();
        String nombrePestana = nombre;
        textArea.append(contenido);
        this.PestañasPanel.addTab(nombrePestana, new JScrollPane(textArea));
    }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbrirArchivoOp;
    private javax.swing.JTextArea ConsolaTextArea;
    private javax.swing.JMenuItem EliminarPestañasOp;
    private javax.swing.JMenuItem GuardarArchivoOp;
    private javax.swing.JLabel LabelImgGrafica;
    private javax.swing.JMenuItem NuevoArchivoOp;
    private javax.swing.JTabbedPane PestañasPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
