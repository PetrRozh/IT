import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {

    private final int size;
    private JImageDisplay view;
    private FractalGenerator generator;
    private final Rectangle2D.Double range;
    private JComboBox<FractalGenerator> ComboBox;

    public FractalExplorer(int size){
        this.size = size;
        this.generator = new Mandelbrot();
        this.range = new Rectangle2D.Double();
        generator.getInitialRange(range);
    }

    public void createAndShowGUI(){

        JFrame frame = new JFrame("rendered");

        view = new JImageDisplay(size,size);

        JButton Button = new JButton("Reset");
        Button.addActionListener(new ResetActionListener());

        JButton buttonSave = new JButton("Save fractal");
        buttonSave.addActionListener(new SaveActionListener());

        view.addMouseListener(new MouseClicker());

        JLabel label = new JLabel("Fractal:");
        ComboBox = new JComboBox<>();
        ComboBox.addItem(new Mandelbrot());
        ComboBox.addItem(new Tricorn());
        ComboBox.addItem(new BurningShip());
        ComboBox.addActionListener(new ComboBoxSelections());

        JPanel jPanelSelector = new JPanel();
        JPanel jPanelButtons = new JPanel();
        jPanelSelector.add(label, BorderLayout.CENTER);
        jPanelSelector.add(ComboBox, BorderLayout.CENTER);
        jPanelButtons.add(Button, BorderLayout.CENTER);
        jPanelButtons.add(buttonSave, BorderLayout.CENTER);

        frame.add(view, BorderLayout.CENTER);
        frame.add(jPanelSelector, BorderLayout.NORTH);
        frame.add(jPanelButtons, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack ();
        frame.setVisible (true);
        frame.setResizable (false);
    }

    private void drawFractal(){

        for (int x=0; x<size; x++){
            for (int y=0; y<size; y++){
                int numIters = generator.numIterations(
                        FractalGenerator.getCoord(range.x, range.x + range.width, size, x),
                        FractalGenerator.getCoord (range.y, range.y + range.width, size, y)
                );

                int rgbColor = 0;
                if (numIters != -1){
                    float hue = 0.7f + (float) numIters / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }

                view.drawPixel(x,y,rgbColor);
            }
        }
        view.repaint();
    }

    private class ResetActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearImage();
            generator.getInitialRange(range);
            drawFractal();
        }
    }

    private class MouseClicker extends MouseAdapter implements MouseListener{
        public void mouseClicked(MouseEvent e){
            double x = FractalGenerator.getCoord(range.x, range.x + range.width, size, e.getX());
            double y = FractalGenerator.getCoord(range.y, range.y + range.width, size, e.getY());

            generator.recenterAndZoomRange(range, x, y, 0.5);
            drawFractal();
        }
    }

    private class ComboBoxSelections implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            generator = (FractalGenerator) ComboBox.getSelectedItem();
            generator.getInitialRange(range);
            drawFractal();
        }
    }

    private class SaveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("PNG Images", "png");
            fileChooser.setFileFilter(fileFilter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int t = fileChooser.showSaveDialog(view);

            if (t == JFileChooser.APPROVE_OPTION) {

                try {
                    ImageIO.write(view.image, "png", fileChooser.getSelectedFile());
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(
                            view,
                            ee.getMessage(),
                            "Error saving fractal",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
    }

    public static void main(String[] args){
        FractalExplorer app = new FractalExplorer(600);

        app.createAndShowGUI();
        app.drawFractal();
    }
}

