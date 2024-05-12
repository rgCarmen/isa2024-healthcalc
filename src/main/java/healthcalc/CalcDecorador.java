package healthcalc;

public abstract class CalcDecorador implements HealthHospital{
    protected HealthHospital calc;

    public CalcDecorador( HealthHospital calc){
        this.calc=calc;
    }

    @Override
    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
        return calc.bmr(genero, edad, altura, peso);
    }

    @Override
    public int pesoIdeal(Gender genero, float altura) throws Exception {
        return calc.pesoIdeal(genero, altura);
    }
    
}
