package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        float result;
        if (height <= 0) {
            throw new Exception("La altura indicada es incorrecta");
        }
        switch (gender) {
            case 'm':
                result = (height - 100) - ((height - 150) / 4f);
                break;
            case 'w':
                result = (height - 100) - ((height - 150) / 2.5f);
                break;
            default:
                throw new Exception("El género indicado es incorrecto");
        }
        if (result < 0) {
            throw new Exception("La fórmula utilizada con la altura y género indicada da un peso negativo");
        }
        return result;

    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'basalMetabolicRate'");
    }



}