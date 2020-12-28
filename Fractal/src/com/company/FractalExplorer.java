package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class FractalExplorer extends JFrame {
    public static void main(String[] args){
        FractalExplorer fractalExplorer = new FractalExplorer(DSIZE);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }
    public FractalExplorer(int dsize) {
        this.sidesize = dsize;
        generator = new Mandelbrot();
        Imdisplay = new JImageDisplay(sidesize,sidesize);
        diap = new Rectangle2D.Double();
        generator.getInitialRange(diap);

    }
    public void drawFractal(){
        for (int x = 0; x<sidesize; ++x ) {
            FractalWorker str = new FractalWorker(x);
            str.execute();
        }
        rowsRemained = sidesize;
        enableUI(false);
    }
    public void enableUI(boolean val){
        list.setEnabled(val);
        restart.setEnabled(val);
        save.setEnabled(val);
    }
    public void createAndShowGUI(){
        JFrame frame = new JFrame();
        frame.setTitle("Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel buttons = new JPanel();
        buttons.add(restart);
        buttons.add(save);
        restart.addActionListener(new ResetButtonListener());
        save.addActionListener(new SaveButtonListener());
        Imdisplay.addMouseListener(new DisplayListener());
        frame.add(Imdisplay);
        frame.add(buttons);
        frame.getContentPane().add(Imdisplay, BorderLayout.CENTER);
        frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        list.addItem(new Mandelbrot());
        list.addItem(new Tricorn());
        list.addItem(new BurningShip());
        JLabel label = new JLabel("Fractal - ");
        JPanel pn1 = new JPanel();
        pn1.add(label);
        pn1.add(list);
        frame.getContentPane().add(pn1, BorderLayout.NORTH);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == list){
                    FractalExplorer.this.setFractalGenerator((FractalGenerator) list.getSelectedItem());
                    generator.getInitialRange(diap);
                    drawFractal();
                }
            }
        });
        frame.pack ();
        frame.setVisible (true);
        frame.setResizable (false);
    }
    public void setFractalGenerator(FractalGenerator gen){
        this.generator = gen;
    }
    private class SaveButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG images", "PNG");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int st = fileChooser.showSaveDialog(Imdisplay);
            if (st == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedImage pic = Imdisplay.getPicture();
                    ImageIO.write(pic, "PNG", file);

                } catch (IOException err){
                    JOptionPane.showMessageDialog(Imdisplay, err.getMessage(), "Can`t save picture", JOptionPane.ERROR_MESSAGE);
                }
            } else return;
        }
    }
    private class ResetButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            generator.getInitialRange(diap);
            drawFractal();
        }
    }
    private class DisplayListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (rowsRemained == 0){
                return;
            }
            int x = e.getX();
            int y = e.getY();
            double XCoord = FractalGenerator.getCoord(diap.x,diap.x+diap.width,sidesize,x);
            double YCoord = FractalGenerator.getCoord(diap.y,diap.y+diap.height,sidesize,y);
            generator.recenterAndZoomRange(diap,XCoord,YCoord,0.5); //выводим и масштабируем до 0.5
            drawFractal();
        }
    }
    public class FractalWorker extends SwingWorker<Object,Object>{
        int y;
        private FractalWorker(int fir){
            y = fir;
        }
        ArrayList<Integer> picArr = new ArrayList();
        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 0; i<sidesize; ++i) {
                double XCoord = FractalGenerator.getCoord(diap.x, diap.x + diap.width, sidesize, i);
                double YCoord = FractalGenerator.getCoord(diap.y, diap.y + diap.height, sidesize, y);
                int rgbColor = Color.BLACK.getRGB();
                int numIters = generator.numIterations(XCoord, YCoord);
                if (numIters != -1) {
                    float hue = 0.7f + (float) numIters / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }
                picArr.add(rgbColor);
            }
            return null;
        }

        @Override
        protected void done() {
            for (int x = 0; x<sidesize; x++){
                Imdisplay.drawPixel(x,y, picArr.get(x));
            }
            Imdisplay.repaint(0,0,y,sidesize,1);
            rowsRemained--;
            if (rowsRemained == 0){
                enableUI(true);
            }
            super.done();
        }
    }
    JComboBox list = new JComboBox();
    JButton save = new JButton("Save Image");
    JButton restart = new JButton("Reset Display");
    private static final int DSIZE = 800;
    private final JImageDisplay Imdisplay;
    private final int sidesize;
    private FractalGenerator generator;
    private final Rectangle2D.Double diap;
    private int rowsRemained;
}
