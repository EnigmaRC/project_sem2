package presentatie.RelDB;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olivier PC
 */
public class DB_Graph extends javax.swing.JPanel {

    Graphics g;
    private ArrayList<Double> measurements;
    private int height;
    private int width;

    /**
     * Creates new form DB_Graph
     */
    public DB_Graph() {
        initComponents();
        this.measurements = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
        g.setColor(Color.BLACK);
        this.drawAxis();
        this.drawGraph();
        this.drawLines();
        this.repaint();
    }

    private void drawGraph() {
        if (!this.measurements.isEmpty()) {
            this.height = this.getHeight();
            this.width = this.getWidth();
            for (int i = 0; i < this.measurements.size(); i++) {
                if (this.measurements.get(i) != null) {
                    this.g.drawOval(i * 9, (int) (this.height - 2 - this.height * this.measurements.get(i) / 12), 4, 4); // fixed height of 12 on Y-axis   
                } else {
                    this.g.drawOval(i * 9, this.height - 2, 4, 4);
                }
            }
        }
    }

    private void drawLines() {
        if (!this.measurements.isEmpty()) {
            this.height = this.getHeight();
            this.width = this.getWidth();
            int firstX = 0;
            int secondX = 0;
            int firstY = this.height;
            int secondY = this.height;
            for (int i = 1; i < this.measurements.size(); i++) {
                if (this.measurements.get(i) != null) {
                    firstX = i * 9 - 6;
                    secondX = i * 9 + 2;                    
                    secondY = this.height - 1 - (int) (this.height * this.measurements.get(i) / 12);
                }
                if (this.measurements.get(i - 1) != null) {
                    firstY = this.height - 1 -(int) (this.height * this.measurements.get(i - 1) / 12);
                }
                this.g.drawLine(firstX, firstY, secondX, secondY);
            }
        }
    }

    private void drawAxis() {
        for (int i = 0; i < this.width; i += 108) {
            this.g.drawLine(i, 0, i, this.height);
        }
        for (int i = 0; i < this.height; i += 60) {
            this.g.drawLine(0, i, this.width, i);
        }
    }

    public void fillMeasurements(List<Double> values) {
        this.measurements = (ArrayList<Double>) values;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
