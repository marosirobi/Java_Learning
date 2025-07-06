package model.challenge2;

import model.challenge2.enums.*;

public class test {
    public static void main(String[] args) {
        Mappable base = new Building(Color.BLACK, PointMarkers.CIRCLE, "Aladár", UsageType.BUSINESS);
        Mappable.mapIt(base);
        Mappable asd = new UtilityLine(Color.BLACK, LineMarkers.DASHED, "Aladár", UtilityType.FIBER_OPTIC);
        Mappable.mapIt(asd);

    }
}
