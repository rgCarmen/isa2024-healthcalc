package healthcalc;


public class ProxyCalc implements HealthStats, HealthHospital{

    private HealthHospital calc;
    private float altura =0;
    private int peso=0;
    private int edad=0;
    private int numM=0;
    private int numW=0;
    private double bmrtotal=0;
    private int numpatientBMR=0;
    private int numpatientIW=0;


    public ProxyCalc( HealthHospital h){
        calc= h;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        double result= calc.bmr(genero, edad, altura, peso);
        this.edad += edad;
        this.altura += altura;
        this.peso += peso;
        this.bmrtotal+= result;
        if (genero == 'm'){
            numM+=1;
        }else{
            numW+=1;
        }
        numpatientBMR+=1;
        return result;
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        int result = calc.pesoIdeal(genero, altura);
        this.altura+=altura;
        if (genero == 'M'){
            numM+=1;
        }else{
            numW+=1;
        }
        this.numpatientIW +=1;
        return result;
    }

    @Override
    public float alturaMedia() {
        return (float) (altura/ numTotalPacientes());
    }

    @Override
    public float pesoMedio() {
        //incluir tambien el peso ideal que obtenemos
        return (float) (peso/numpatientBMR);
    }

    @Override
    public float edadMedia() {
        return (float) (edad/numpatientBMR);
    }

    @Override
    public float bmrMedio() {
        return (float) (bmrtotal/numpatientBMR);
    }

    @Override
    public int numSexoH() {
       return numM;
    }

    @Override
    public int numSexoM() {
        return numW;
    }

    @Override
    public int numTotalPacientes() {
        return numpatientBMR + numpatientIW;
    }

    
    
}
