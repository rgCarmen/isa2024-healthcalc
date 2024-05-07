package healthcalc;

public class MainEjemplo {
    public static void main(String[] args) throws Exception {
        Adaptador calc= new Adaptador(HealthCalcImpl.getCalcImpl());
        ProxyCalc p= new ProxyCalc(calc);

        //para que se muestren ambos mensajes
        MensajeEspanol me= new MensajeEspanol(p);
        MensajeIngles mi= new MensajeIngles(me);


        CalcAmericana ca= new CalcAmericana(mi);
        //uso calculadora americana
        System.out.println("CALCULADORA AMERICANA ->");
        ca.bmr('m', 20, (float) 5.78, 108);
        System.out.println("Peso Ideal: "+ca.pesoIdeal('m', (float) 5.78));
        ca.bmr('w', 50, (float) 4.67, 81);

        CalcEuropea ce= new CalcEuropea(mi);
        //uso calculadora europea
        System.out.println();
        System.out.println("CALCULADORA EUROPEA ->");
        System.out.println(ce.bmr('m', 20, (float) 1.78, 58000));
        System.out.println("Peso Ideal"+ ce.pesoIdeal('m', (float)1.78));

        
        //estadísticas proxy (para ambas calculadoras americana y europea) se utilizan las unidades que emplea la interfaz HealthHospital
        System.out.println();
        System.out.println("ESTADÍSTICAS ->");
        System.out.println("Altura Media: "+p.alturaMedia()+" m");
        System.out.println("Edad Media: "+p.edadMedia()+" años");
        System.out.println("Peso Medio: "+p.pesoMedio()+" gramos");
        System.out.println("Bmr Medio :"+p.bmrMedio()+ "cal/dia");
        System.out.println("Número de pacientes : "+ p.numTotalPacientes());
        System.out.println("Número de hombres: "+p.numSexoH());
        System.out.println("Número de mujeres: "+p.numSexoM());
        
    }
}
