package sotiris.zogos.dataanalysis;

public class Sensors {

    String name;
    int resolution_min, resolution_max;
    double datarate_min, datarate_max;
    double adc_min, adc_max;

    Sensors(String name, int resolution_min, int resolution_max, double datarate_min, double datarate_max, double adc_min, double adc_max) {
        this.name = name;
        this.resolution_min = resolution_min;
        this.resolution_max = resolution_max;
        this.datarate_min = datarate_min;
        this.datarate_max = datarate_max;
        this.adc_min = adc_min;
        this.adc_max = adc_max;
    }
    Sensors(){};

    public String getName ( ) {
        return name;
    }

    public int getResolution_min ( ) {
        return resolution_min;
    }

    public int getResolution_max ( ) {
        return resolution_max;
    }

    public double getDatarate_min ( ) {
        return datarate_min;
    }

    public double getDatarate_max ( ) {
        return datarate_max;
    }

    public double getAdc_min ( ) {
        return adc_min;
    }

    public double getAdc_max ( ) {
        return adc_max;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setResolution_min (int resolution_min) {
        this.resolution_min = resolution_min;
    }

    public void setResolution_max (int resolution_max) {
        this.resolution_max = resolution_max;
    }

    public void setDatarate_min (double datarate_min) {
        this.datarate_min = datarate_min;
    }

    public void setDatarate_max (double datarate_max) {
        this.datarate_max = datarate_max;
    }

    public void setAdc_min (double adc_min) {
        this.adc_min = adc_min;
    }

    public void setAdc_max (double adc_max) {
        this.adc_max = adc_max;
    }
}
