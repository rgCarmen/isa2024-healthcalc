# Health calculator
<details>
  <summary>Tabla de Contenido</summary>
  <ol>
    <li><a href="#practica1">Práctica1</a>
      <ol> <li><a href="#descripcion">Descripción</a></li>
        <li><a href="#casos_prueba">Casos de Prueba</a></li>
        <li><a href="#test">Ejecución Test</a></li>
        <li><a href="#commits">Estado Registro de Commits</a></li></ol> </li>
    <li><a href="#practica2">Práctica2</a></li>
      <ol> <li><a href="#descripcion2">Descripción</a>
        <li><a href="#diagrama">Diagrama Casos de Uso</a></li>
        <li><a href="#especificacion">Especificación Casos de Uso</a></li>
  </ol>
</details>

---

# Práctica 1 
<a name="practica1"></a>

## :memo: Descripción
<a name="descripcion"></a>
En este repositorio se va a realizar un práctica relacionada con el desarrollo de una calculadora de salud. A partir de ciertos parámetros, tales como altura, género, peso o edad, se calcularán medidas como el peso ideal o la tasa metabólica basal. Se pide implementar una interfaz proporcionada como la realización de test para los métodos. 

Además del desarrollo de la calculadora, esta práctica aborda el uso de herramientas como Maven y Git.


## 🔍 Casos de Prueba
<a name="casos_prueba"></a> 
###### Realizaremos casos de prueba para cada uno de los métodos a implementar
#### **Test para el método <code>idealWeight()</code>**
<ol>
<li> El valor de <code>height</code> introducido no es válido, es menor o igual que 0. Se espera que se lance una excepción indicando este hecho.</li>
<li>Para valores de <code>height</code>  válidos, el valor de <code>gender</code> introducido es inválido, es decir es un carácter distinto de <code>'m'</code>  o  <code>'w'</code> . Se espera que se lance una excepción indicando que el género introducido no es correcto.</li>
<li>Ambas entradas son válidas, <code>gender</code> es  <code>'m'</code>  o  <code>'w'</code>  y <code>height</code>  tiene un valor mayor que 0. Se espera que no se lance ninguna excepción y se obtenega un resultado positivo.
<ul><li>Con la fórmula utilizada para calcular el peso ideal, puede ocurrir que con valores pequeños de altura se obtengan como resultado valores negativos de peso. Para hombres este límite inferior es $83.\overline{3}$ y para mujeres $66.\overline{6}$ . Obtener un peso negativo no tendría ningún sentido, por lo que se debería reflejar en la implentación y lanzar una excepción cuando ocurra.</li> </ul>
</li>
<li> Para entradas válidas en ambos atributos, y con el mismo valor de  <code>height</code> para ambos géneros:
  <ul>  <li> Se espera que el resultado del peso ideal en mujeres sea igual que en  hombres, cuando la altura sea 150.</li>
        <li>En el caso de que la altura sea mayor que 150 se espera, que el peso en mujeres sea menor que en hombres.</li>
        <li>Siendo la altura menor que 150, el peso en mujeres será mayor que en hombres. </li></ul>
</li></ol>

:pushpin: En la implementación de ambos métodos, no se establece un valor máximo para <code>height</code>, <code>weight</code> y <code>age</code>.
#### **Test para el método <code>basalMetabolicRate()</code>**
<ol>
<li> Se realizaran para este método test similares a test 1 y test 2 para el método  <code>idealWeight()</code> , para comprobar que se lanza una excepción cuando <code>height</code> o <code>gender</code> son incorrectos. </li>
<li>Siendo el resto de entradas válidas, el valor de  <code>weight</code>  no es válido, es negativo o 0. Se espera una excepción. </li> 
<li> Siendo el resto de entradas válidas, el valor de  <code>age</code>  es inválido, es negativo. Se espera una excepción. </li>
<li> Siendo todas las entradas válidas, se espera obtener un resultado válido. No se deberá lanzar ninguna excepción. Por el parámetro que se calcula, se esperar un valor positivo. 
  <ul>
  <li> En el caso de la fórmula aplicada para mujeres, pueden existir algunas combinaciones de las entradas con valores pequeños con las que se obtenga un valor negativo como resultado, en este caso de deberá lanzar un excepción indicandolo. </li>
  </ul></li>
<li> Con entradas válidas y iguales a excepción de  <code>gender</code> , se espera que los resultados siempre sean de 166 unidades menor en mujeres que en hombres.</li>
</ol>


## :white_check_mark: Ejecución de los test
<a name="test"></a>
Se han implementado 14 test, algunos de ellos parametrizados para probar distintas, entradas.

El resultado de la ejecución es el siguiente:
![Captura de pantalla 2024-03-11 085039](https://github.com/rgCarmen/isa2024-healthcalc/assets/81189485/8eb1e0c7-c24b-4824-b27a-fc4793e041bd)

![Captura de pantalla 2024-03-06 171310](https://github.com/rgCarmen/isa2024-healthcalc/assets/81189485/82374776-31a3-4212-bac5-eb3b6dc2b2aa)

## :calendar: Registro de Commits
<a name="commits"> </a>
![Captura de pantalla 2024-03-11 141856](https://github.com/rgCarmen/isa2024-healthcalc/assets/81189485/452f7e99-266c-48c7-8a53-bb5c8b0adc77)

---
# Práctica 2
<a name="practica2"></a>
## :memo: Descripción
<a name="descripcion2"></a>
En este práctica se abordarán el desarrollo del diagrama de casos de usos de este proyecto junto con la especificación de uno de esos casos de uso.
## :bust_in_silhouette: Diagrama Casos de Uso
<a name="diagrama"></a>

![Use Case Diagram](https://github.com/rgCarmen/isa2024-healthcalc/assets/81189485/c352783f-d8b7-470a-a812-790f380dcc48)

## 📄Especificación Caso de Uso
<a name="especificacion"></a>
**Caso de Uso**
```
Nombre: Calcular IdealWeight
Stakeholder e intereses:
	Usario : obtener el peso ideal.
Actor principal: Usuario
Alcance: Calculadora de Salud
Nivel de abstracción: user-goal
Precondiciones:Los parámetros introducidos son válido.
Garantía mínima: Se recibe algún tipo de resultado o mensaje.
Garantía de Éxilo: Se obtiene un resultado correcto.
Triger: El usuario indica que quiere calcular un peso ideal.
Escenario Principal:
1. El sistema válida que los valor de los parámetros introducidos son correctos, height y gender.
2. El sistema calcula el peso mediante la fórmula y según los parámetros indicados.
3. El sistema comprueba que el resultado es positivo.
4. El sistema devuelve el resultado al usuario.
Extensiones:
1b. El sistema detecta que alguno de los párametros no es válido.
	1b1. El sistema indica que los parámetros no son válidos y pide volver a introducirlos. Vuelve al paso 1.
3b. El sistema detecta que el resultado es negativo, no es válido.
	3b1. El sistema indica que los parámetros introducidos generan un peso negativo.
	3b.2 El sistema pide al usuario introducir los parámetros de nuevo y vuelve al paso 1.
```
