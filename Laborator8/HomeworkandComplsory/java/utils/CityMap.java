package utils;

import tables.Cities;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;


import java.awt.Point;
import java.util.Map;

public class CityMap extends JFrame {
    static List<Cities> cities;
    private static Map<String, Point> cityCoordinates = new HashMap<>();
    DrawMap canvas;


    public CityMap(List<Cities> cities) {
        super("My map");
        this.cities = cities;
        init();
    }
    private void init(){
        setTitle("My map");
        setLayout(new BorderLayout(10, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        configCoordinates();

        canvas = new DrawMap(this.cityCoordinates);
        getContentPane().add(canvas, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }
    public static void configCoordinates(){
        for (int i=1;i<=240;i++)
           cityCoordinates.put(cities.get(i).getName(), worldToPixel(lonToXWorld((double) cities.get(i).getLongitude()), latToYWorld((double) cities.get(i).getLatitude()), 2));

    }


    /**
     * Converts the given longitude value to the x value of the Google Maps world coordinate.
     *
     * @param lon the longitude value
     * @return the x value of the corresponding Google Maps world coordinate
     */
    public static Double lonToXWorld(Double lon) {
        Double tiles = Math.pow(2, 0);
        Double circumference = 256 * tiles;
        Double radius = circumference / (2 * Math.PI);
        Double falseEasting = -1.0 * circumference / 2.0;
        return (radius * Math.toRadians(lon)) - falseEasting;
    }

    /**
     * Converts the given latitude value to the y value of the Google Maps world coordinate.
     *
     * @param lat the latitude value
     * @return the y value of the corresponding Google Maps world coordinate
     */
    public static Double latToYWorld(Double lat) {
        Double tiles = Math.pow(2, 0);
        Double circumference = 256 * tiles;
        Double radius = circumference / (2 * Math.PI);
        Double falseNorthing = circumference / 2.0;
        return ((radius / 2.0 * Math.log((1.0 + Math.sin(Math.toRadians(lat)))
                / (1.0 - Math.sin(Math.toRadians(lat))))) - falseNorthing)
                * -1;
    }

    /**
     * Converts the given world coordinates to the pixel coordinates corresponding to the given zoom level.
     *
     * @param xWorld the x value of the world coordinate
     * @param yWorld the y value of the world coordinate
     * @param zoomLevel the zoom level
     * @return the pixel coordinates as a Point
     */
    public static Point worldToPixel(Double xWorld, Double yWorld, int zoomLevel) {
        int zoom = (int) Math.pow(2, zoomLevel);
        int x = (int) Math.round(xWorld * zoom);
        int y = (int) Math.round(yWorld * zoom);
        return new Point(x, y);
    }
}