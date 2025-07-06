package model.challenge2;

import model.challenge2.enums.Color;
import model.challenge2.enums.Geometry;
import model.challenge2.enums.LineMarkers;
import model.challenge2.enums.PointMarkers;

public class BaseMap {

    private Color color;
    private Geometry geometry;
    private LineMarkers lineMarkers = null;
    private PointMarkers pointMarkers = null;

    public BaseMap(Color color, PointMarkers marker) {
        this.pointMarkers = marker;
        this.geometry = Geometry.POINT;
        this.color = color;
    }
    public BaseMap(Color color, LineMarkers marker) {
        this.lineMarkers = marker;
        this.geometry = Geometry.LINE;
        this.color = color;
    }

    public String getMarker() {
        return String.format("%s %s", color, lineMarkers != null ? lineMarkers : pointMarkers);
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
