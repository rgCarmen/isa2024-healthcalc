# isa2024-healtcalc
Health calculator

#### Casos de Prueba
**Test para el método idealWeight()**
1. El valor de _height_ introducido no es válido, es menor o igual que 0. Se espera que se lance una excepción indicando este hecho.
2. Para valores de _height_ válidos, el valor de _gender_ introducido es inválido, es decir es un carácter distinto de _'m'_  o  _'w'_ . Se espera que se lance una excepción indicando que el género introducido no es correcto.
3. Ambas entradas son válidas, gender es  _'m'_  o  _'w'_  y  _height_  tiene un valor mayor que 0. Se espera que no se lance ninguna excepción y se obtenega un resultado positivo.
    3.1. Con la fórmula utilizada para calcular el peso ideal, puede ocurrir que con valores pequeños de altura se obtengan como resultado valores negativos de peso. Para hombres este límite inferior es $83.\overline{3}$ y para mujeres $66.\overline{6}$. Obtener un peso negativo no tendría ningún sentido por lo que en estos casos se debería lanzar una excepción indicandolo.

4. Para entradas válidas en ambos atributos, y con el mismo valor de  _height_ para ambos géneros. Se espera que el resultado del peso ideal en mujeres sea igual que en  hombres, cuando la altura sea 150. En el caso de que la altura sea mayor que 150 se espera, que el peso en mujeres sea menor que en hombres. Siendo la altura menor que 150, el peso en mujeres será mayor que en hombres. 


**Test para el método basalMetabolicRate()**
1. Se realizaran para este método test similares a test 1 y test 2 para el método  _idealWeight()_ . 
2. Siendo el resto de entradas válidas, el valor de  _weight_  no es válido, es negativo o 0. Se espera una excepción.
3. Siendo el resto de entradas válidas, el valor de  _age_  es inválido, es negativo. Se espera una excepción. 
4. Siendo todas las entradas válidas, se espera obtener un resultado válido. No se deberá lanzar ninguna excepción. 
    4.1. Se debería esperar un valor positivo. En caso de la fórmula aplicada para hombre siempre se obtendrían valores positivos. Pero en el caso de la fórmula aplicada para mujeres, pueden existir algunas combinaciones de las entradas con valores pequeños con las que se obtenga un valor negativo como resultado, en este caso de deberá lanzar un excepción indicandolo.
5. Con entradas válidas y iguales a excepción de  _gender_ , se espera que los resultados siempre sean de 166 unidades menor en mujeres que en hombres.