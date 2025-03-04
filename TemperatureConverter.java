abstract class Temperature {
    double temp;
    
    void setTempData(double temp) {
        this.temp = temp;
    }
    
    abstract void changeTemp();
}

class Fahrenheit extends Temperature {
    double ctemp;
    
    @Override
    void changeTemp() {
        ctemp = (5.0 / 9.0) * (temp - 32);
        System.out.println("Temperature in Celsius: " + ctemp);
    }
}

public class TemperatureConverter {
    public static void main(String[] args) {
        Fahrenheit fahrenheit = new Fahrenheit();
        fahrenheit.setTempData(98.6);
        fahrenheit.changeTemp();
    }
}
