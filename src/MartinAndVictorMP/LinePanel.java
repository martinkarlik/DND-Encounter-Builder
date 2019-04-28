package src.MartinAndVictorMP;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LinePanel extends JPanel{

    private BufferedImage image;

    public LinePanel() {
        try {
            image = ImageIO.read(new File("src/Images/line.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
        setSize(new Dimension(300, 10));
    }

}
