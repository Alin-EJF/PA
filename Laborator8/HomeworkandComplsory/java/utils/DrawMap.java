package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class DrawMap extends JPanel {
    private Map<String, Point> cityCoordinates = new HashMap<>();
    int canvasWidth = 1200;
    int canvasHeight = 800;
    BufferedImage image;
    Graphics2D offscreen;

    public DrawMap(Map<String, Point> cityCoordinates) {
        this.cityCoordinates = cityCoordinates;
        createOffscreenImage();
        init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
        repaint();
    }
    final void init() {
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createEtchedBorder());
        paintMap();
    }
    private void paintMap() {
        Font font = new Font( "Comic Sans MS", Font.PLAIN, 14 );
        offscreen.setFont(font);

        for (Map.Entry city : cityCoordinates.entrySet()) {
            String name = (String)city.getKey();
            Point point = (Point) city.getValue();

            offscreen.setColor(Color.GREEN);
            offscreen.drawOval(point.x, point.y, 5, 5);
            offscreen.fillOval(point.x, point.y, 5, 5);

            offscreen.setColor(Color.BLACK);
            offscreen.drawString(name, point.x - 10, point.y - 5);
        }
    }
    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

}