package healthcalc;

public class Adaptador implements HealthHospital{

    private HealthCalcImpl calc;
    public Adaptador(HealthCalcImpl h){
        calc=h;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        //peso esta en gramos y debemos pasarlo a kiligramos
        //altura esta en metros y debemos pasarla a centimetros
        
        return calc.basalMetabolicRate(new PersonImpl(peso/1000f, (altura*100), edad, getGender(genero)));
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception{
        double result =  calc.getIdealBodyWeight(new PersonImpl((altura*100), getGender(genero)));
        //el resultado esta en kilogramos y lo tenemos que pasar a gramos
        return  (int) result*1000;
    }

    private Gender getGender(char genero){

        switch (genero) {
            case 'm':
                return Gender.MALE;
            case 'w':
                return Gender.FEMALE;
            default:
                throw new IllegalArgumentException("Género no válido: " + genero);
        }
    }
    
}
