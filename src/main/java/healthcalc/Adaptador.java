package healthcalc;

public class Adaptador implements HealthHospital{

    private HealthCalcImpl calc;
    public Adaptador(HealthCalcImpl h){
        calc=h;
    }

    @Override
    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
        //peso esta en gramos y debemos pasarlo a kiligramos
        //altura esta en metros y debemos pasarla a centimetros
        return (double) calc.basalMetabolicRate(new PersonImpl(peso/1000f, (altura*100), edad, genero));
    }

    @Override
    public int pesoIdeal(Gender genero, float altura) throws Exception{
        float result =  calc.idealWeight(new PersonImpl((altura*100), genero));
        //el resultado esta en kilogramos y lo tenemos que pasar a gramos
        return  (int) result*1000;
    }
    
}
