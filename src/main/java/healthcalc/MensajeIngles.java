package healthcalc;

public class MensajeIngles extends MensajeDecorador {

    public MensajeIngles(HealthHospital calc) {
        super(calc);
    }

    @Override
    protected void mensaje(float altura, int peso, double result) {
        System.out.println("The person with height "+altura+" meters and "+ peso/1000+" kg has a BMR of "+result);
    }
    
}
