package healthcalc;

public class CalcAmericana extends CalcDecorador{

    public CalcAmericana(HealthHospital calc) {
        super(calc);
    }

    @Override
    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
        
        return super.bmr(genero, edad, alturaMetros(altura), pesoGramos(peso));
    }

    @Override
    public int pesoIdeal(Gender genero, float altura) throws Exception {
        return super.pesoIdeal(genero, alturaMetros(altura));
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
