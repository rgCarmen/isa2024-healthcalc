package healthcalc;

public class MensajeEspanol extends MensajeDecorador{

    public MensajeEspanol(HealthHospital calc) {
        super(calc);
    }


    @Override
    protected void mensaje(float altura, int peso, double result) {
        System.out.println("La persona con altura "+altura+" metros y "+ peso/1000+" kg tiene un BMR de "+ result);
    }
}

