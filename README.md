# Health calculator
<details>
  <summary>Tabla de Contenido</summary>
    <ol>
      <li><a href="#descripcion">Descripción</a></li>
      <li><a href="#casos_prueba">Casos de Prueba</a></li>
      <li><a href="#test">Ejecución Test</a></li>
      <li><a>Commits</a></li>
    </ol>
</details>



## :memo: Descripción
En este repositorio se va a realizar un práctica relacionada con el desarrollo de una calculadora de salud. A partir de ciertos parámetros, tales como altura, género, peso o edad, se calcularán medidas como el peso ideal o la tasa metabólica basas. Se pide implementar una interfaz proporcionada como la realización de test para los métodos. 

Además del desarrollo de la calculadora, esta práctica aborda el uso de herramientas como Maven y Git.

<a name="descripcion"></a>

## 🔍 Casos de Prueba
###### Realizaremos casos de prueba para cada uno de los métodos a implementar
#### **Test para el método idealWeight()**
<ol>
<li> El valor de <i>height</i> introducido no es válido, es menor o igual que 0. Se espera que se lance una excepción indicando este hecho.</li>
<li>Para valores de <i>height</i>  válidos, el valor de <i>gender</i> introducido es inválido, es decir es un carácter distinto de <i>'m'</i>  o  <i>'w'</i> . Se espera que se lance una excepción indicando que el género introducido no es correcto.</li>
<li>Ambas entradas son válidas, gender es  <i>'m'</i>  o  <i>'w'</i>  y <i>height</i>  tiene un valor mayor que 0. Se espera que no se lance ninguna excepción y se obtenega un resultado positivo.
<ul><li>Con la fórmula utilizada para calcular el peso ideal, puede ocurrir que con valores pequeños de altura se obtengan como resultado valores negativos de peso. Para hombres este límite inferior es $83.\overline{3}$ y para mujeres $66.\overline{6}$ . Obtener un peso negativo no tendría ningún sentido, por lo que se debería reflejar en la implentación y lanzar una excepción cuando ocurra.</li> </ul>
</li>
<li> Para entradas válidas en ambos atributos, y con el mismo valor de  _height_ para ambos géneros:
  <ul>  <li> Se espera que el resultado del peso ideal en mujeres sea igual que en  hombres, cuando la altura sea 150.</li>
        <li>En el caso de que la altura sea mayor que 150 se espera, que el peso en mujeres sea menor que en hombres.</li>
        <li>Siendo la altura menor que 150, el peso en mujeres será mayor que en hombres. </li></ul>
</li></ol>


#### **Test para el método basalMetabolicRate()**
<ol>
<li> Se realizaran para este método test similares a test 1 y test 2 para el método  <i>idealWeight()</i> , para comprobar que se lanza una excepción cuando <i>height</i> o <i>gender</i> son incorrectos. </li>
<li>Siendo el resto de entradas válidas, el valor de  <i>weight</i>  no es válido, es negativo o 0. Se espera una excepción. </li> 
<li> Siendo el resto de entradas válidas, el valor de  <i>age</i>  es inválido, es negativo. Se espera una excepción. </li>
<li> Siendo todas las entradas válidas, se espera obtener un resultado válido. No se deberá lanzar ninguna excepción. Por el parámetro que se calcula, se esperar un valor positivo. 
  <ul>
  <li> En el caso de la fórmula aplicada para mujeres, pueden existir algunas combinaciones de las entradas con valores pequeños con las que se obtenga un valor negativo como resultado, en este caso de deberá lanzar un excepción indicandolo. </li>
  </ul></li>
<li> Con entradas válidas y iguales a excepción de  <i>gender</i> , se espera que los resultados siempre sean de 166 unidades menor en mujeres que en hombres.</li>
</ol>
<a name="casos_prueba"></a>  :pushpin: En la implementación de ambos métodos, no se establece un valor máximo para <i>height</i>, <i>weight</i> y <i>age</i>.

## :white_check_mark: Ejecución de los test
He implementado 14 test, algunos de ellos parametrizados para probar con varias entradas distintas.

El resultado de la ejecución es el siguiente:

![Captura de pantalla 2024-03-06 171310](https://github.com/rgCarmen/isa2024-healthcalc/assets/81189485/82374776-31a3-4212-bac5-eb3b6dc2b2aa)

<a name="test"></a>