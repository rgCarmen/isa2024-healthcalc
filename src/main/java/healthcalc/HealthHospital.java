package healthcalc;

public interface HealthHospital {

    public double bmr(char genero, int edad, float altura, int peso);
    public int pesoIdeal(char genero, float altura);
    
}