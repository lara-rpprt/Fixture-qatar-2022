/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fixture.view;

import fixture.model.Equipo;
import fixture.model.Grupo;
import static java.util.Objects.nonNull;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abreg
 */
public class TablaDePosiciones extends javax.swing.JFrame {

    private Grupo grupo;

    /**
     * Creates new form TablaDePosiciones
     *
     * @param g
     */
    public TablaDePosiciones(Grupo g) {
        grupo = g;

        initComponents();

        DefaultTableModel tablaPosicionesModel = (DefaultTableModel) tablaPosiciones.getModel();

        for (Equipo equipo : grupo.getEquipos()) {
            if (nonNull(equipo)) {
                // Calculo la diferencia de goles
                int diferenciaDeGoles = equipo.getGolesHechos() - equipo.getGolesEnContra();

                // Creo la fila con los datos del equipo iterado
                Object[] filaTablaPosiciones = {
                    equipo.getNombre(),
                    equipo.getPartidosJugados(),
                    equipo.getPartidosGanados(),
                    equipo.getPartidosEmpatados(),
                    equipo.getPartidosPerdidos(),
                    equipo.getGolesHechos(),
                    equipo.getGolesEnContra(),
                    diferenciaDeGoles,
                    equipo.getPuntos()
                };

                // Agrego la fila creada a la tabla
                tablaPosicionesModel.addRow(filaTablaPosiciones);
            }
        }
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
        tablaPosiciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPosiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipo", "PJ", "G", "E", "P", "GF", "GC", "DG", "Pts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPosiciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaPosiciones);
        if (tablaPosiciones.getColumnModel().getColumnCount() > 0) {
            tablaPosiciones.getColumnModel().getColumn(0).setResizable(false);
            tablaPosiciones.getColumnModel().getColumn(0).setPreferredWidth(200);
            tablaPosiciones.getColumnModel().getColumn(1).setResizable(false);
            tablaPosiciones.getColumnModel().getColumn(2).setResizable(false);
            tablaPosiciones.getColumnModel().getColumn(3).setResizable(false);
            tablaPosiciones.getColumnModel().getColumn(4).setResizable(false);
            tablaPosiciones.getColumnModel().getColumn(5).setResizable(false);
            tablaPosiciones.getColumnModel().getColumn(6).setResizable(false);
            tablaPosiciones.getColumnModel().getColumn(7).setResizable(false);
            tablaPosiciones.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPosiciones;
    // End of variables declaration//GEN-END:variables
}
