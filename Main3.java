package ccs217_6.ex3;

interface WeatherData {
    String getCity();
    double getTemperature();
    String getDescription();
}

class ExternalWeatherData1 {
    private String location;
    private double temp;
    private String desc;

    public ExternalWeatherData1(String location, double temp, String desc) {
        this.location = location;
        this.temp = temp;
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public double getTemp() {
        return temp;
    }

    public String getDesc() {
        return desc;
    }
}

class ExternalWeatherData1Adapter implements WeatherData {
    private ExternalWeatherData1 externalData1;

    public ExternalWeatherData1Adapter(ExternalWeatherData1 externalData1) {
        this.externalData1 = externalData1;
    }

    @Override
    public String getCity() {
        return externalData1.getLocation();
    }

    @Override
    public double getTemperature() {
        return externalData1.getTemp();
    }

    @Override
    public String getDescription() {
        return externalData1.getDesc();
    }
}

public class Main3 {
    public static void main(String[] args) {
        ExternalWeatherData1 externalData1 = new ExternalWeatherData1("New York", 25.5, "Sunny");
        WeatherData adapter1 = new ExternalWeatherData1Adapter(externalData1);
        displayWeatherInfo(adapter1);
    }

    public static void displayWeatherInfo(WeatherData weatherData) {
        System.out.println("City: " + weatherData.getCity());
        System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println("Description: " + weatherData.getDescription());
        System.out.println();
    }
}

