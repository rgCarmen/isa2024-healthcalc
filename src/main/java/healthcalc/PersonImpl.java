package healthcalc;

public class PersonImpl implements Person{

    private float weight;
    private float height;
    private int age;
    private Gender gender;


    //constructor para bmr
    public PersonImpl(float w, float h, int a, Gender g){
        weight=w;
        height=h;
        age=a;
        gender=g;

    }

    //constructor para pesoIdeal
    public PersonImpl(float h, Gender g){
        height=h;
        gender=g;
        //defaul para weight y age (para que salte excepción)
        weight=0;
        age=-1;
    }



    @Override
    public float weight() {
        return weight;
    }

    @Override
    public float height() {
        return height;
    }

    @Override
    public Gender gender() {
        return gender;
    }

    @Override
    public int age() {
        return age;
    }
    
}
