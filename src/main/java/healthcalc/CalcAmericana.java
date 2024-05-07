package healthcalc;

public class CalcAmericana extends CalcDecorador{

    public CalcAmericana(HealthHospital calc) {
        super(calc);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        return calc.bmr(genero, edad, alturaMetros(altura), pesoGramos(peso));
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        return calc.pesoIdeal(genero, alturaMetros(altura));
    }

    private float alturaMetros(float altura){
        //inches a metros
        return (float) (altura*0.3048);
    }

    private int pesoGramos(int peso){
        //libras a gramos
        return (int) (peso*453.592);
    }

    
    
    
}
