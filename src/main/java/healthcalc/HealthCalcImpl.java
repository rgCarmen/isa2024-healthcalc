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
        if (height <= 0) {
            throw new Exception("La altura indicada es incorrecta");
        }
        if (weight <= 0) {
            throw new Exception("El peso indicado no es válido");
        }

        if (age < 0) {
            throw new Exception("La edad indicada no es válida");
        }

        switch (gender) {
            case 'm':
                return 10 * weight + 6.25f * height - 5 * age + 5;
            case 'w':
                float result = 10 * weight + 6.25f * height - 5 * age - 161;
                if (result < 0) {
                    throw new Exception(
                            "La combinación de valores indicados para mujer, generan un valor negativo de tasa metabólica");
                } else {
                    return result;
                }
            default:
                throw new Exception("El género indicado es incorrecto");
        }

    }

}