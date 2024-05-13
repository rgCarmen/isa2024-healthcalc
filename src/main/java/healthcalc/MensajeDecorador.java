package healthcalc;

public abstract class MensajeDecorador implements HealthHospital {

    protected HealthHospital calc;

    public MensajeDecorador(HealthHospital calc){
        this.calc= calc;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        double result= calc.bmr(genero, edad, altura, peso);
        mensaje(altura, peso, result);
        return result;
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        return calc.pesoIdeal(genero, altura);
    }

    protected abstract void mensaje(float altura, int peso, double result);
    
}
