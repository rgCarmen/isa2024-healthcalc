package healthcalc;

public interface HealthHospital {

    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception;
    public int pesoIdeal(Gender genero, float altura) throws Exception;
    
}