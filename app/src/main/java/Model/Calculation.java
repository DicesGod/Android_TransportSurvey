package Model;

import java.util.ArrayList;

public final class Calculation {

    public static float getTotalClientBusMetro() {
        return totalClientBusMetro;
    }

    public static float getTotalClientPrivateTaxi() {
        return totalClientPrivateTaxi;
    }

    public static float getTotalBusMetroKm() {
        return totalBusMetroKm;
    }

    public static float getTotalPrivateTaxiKm() {
        return totalPrivateTaxiKm;
    }

    public static float getPercentBusMetro() {
        return PercentBusMetro;
    }

    public static float getPercentPrivateTaxi() {
        return PercentPrivateTaxi;
    }

    private static float  totalClientBusMetro, totalClientPrivateTaxi,total;
    private static float totalBusMetroKm,totalPrivateTaxiKm;
    private static float PercentBusMetro,PercentPrivateTaxi;


    public static void calculation(ArrayList surveyList){
        for (int i = 0; i < surveyList.size(); i++)
        {
            Survey object = (Survey) surveyList.get(i);
            if (object.getTrans_type() == 1 || object.getTrans_type() == 2){totalClientBusMetro++;total++; totalBusMetroKm += object.getNumberofkm();}
            else if (object.getTrans_type() == 3 || object.getTrans_type() == 4){totalClientPrivateTaxi++;total++; totalPrivateTaxiKm += object.getNumberofkm();}
        }

        PercentBusMetro = totalClientBusMetro / total * 100;
        PercentPrivateTaxi = totalClientPrivateTaxi / total * 100;
    }
}
