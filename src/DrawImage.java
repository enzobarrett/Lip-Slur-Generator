import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.Color.BLACK;

public class DrawImage {
    BufferedImage bi;
    Graphics2D ig2;

    public DrawImage() throws IOException {
        int height = 683;
        int width = 1211;

        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        ig2 = bi.createGraphics();

        File pathToFile = new File("blank_staff3.png");
        Image image = ImageIO.read(pathToFile);
        ig2.drawImage(image, 0, 0, null);
    }

    public void drawNotes(ArrayList<Note> list) {
        int x = 400;

        for (Note n : list) {
            String value = n.getValue();

            switch (n.getOctave()) {
                case 1 -> {
                    switch (value) {
                        case "C" -> {
                            drawNote(606, x, false);
                            drawBottomLedgerLine(x);
                        }
                        case "G" -> drawNote(466, x, false);
                    }
                    x += 160;
                }
                case 2 -> {
                    switch (value) {
                        case "C" -> drawNote(361, x);
                        case "E" -> drawNote(291, x);
                        case "G" -> drawNote(221, x);
                        case "Bb" -> {
                            drawNote(151, x);
                            drawTopLedgerLine(x, 1);
                            Bb(x);
                        }
                    }
                    x += 160;
                }
                case 3 -> {
                    if ("C".equals(value)) {
                        drawNote(116, x);
                        drawTopLedgerLine(x, 2);
                    }
                    x += 160;
                }
            }

        }

        //System.out.println(x);
        //ig2.draw(new Arc2D.Double(305, 50, 900, 900, 73, 73, Arc2D.OPEN));


    }

    private void drawNote(int y, int x) {
        drawNote(y, x, true);
    }

    private void drawNote(int y, int x, boolean stemDown) {
        ig2.setPaint(BLACK);
        ig2.fill(new Ellipse2D.Double(x - 35, y - 35, 70, 70));
        ig2.setStroke(new BasicStroke(5));
        if (stemDown) {
            ig2.draw(new Line2D.Double(x - 33, y, x - 33, y + 210));
        } else {
            ig2.draw(new Line2D.Double(x + 33, y, x + 33, y - 210));
        }
    }

    private void drawTopLedgerLine(int x, int num) {
        ig2.setStroke(new BasicStroke(5));
        ig2.draw(new Line2D.Double(x - 60,
                186,
                x + 60,
                186));

        if (num > 1) {
            ig2.draw(new Line2D.Double(x - 60,
                    116,
                    x + 60,
                    116));
        }
    }

    public void drawBottomLedgerLine(int x) {
        ig2.setStroke(new BasicStroke(5));
        ig2.draw(new Line2D.Double(x - 60,
                606,
                x + 60,
                606));
    }

    public void Bb(int x) {
        Font font = new Font("TimesRoman", Font.BOLD, 150);
        ig2.setFont(font);
        ig2.drawString("♭", x - 100, 180);
    }

    public void writePNG() throws IOException {
        ImageIO.write(bi, "PNG", new File("./test.PNG"));
    }
}
