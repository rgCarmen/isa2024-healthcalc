package healthcalc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {
	private HealthCalc hc;

	@BeforeEach
	public void init() {
		hc = new HealthCalcImpl();
	}

	@ParameterizedTest
	@CsvSource({ "-1060, 'm'", "0, 'w'",
			"-1, 'm'", "-100, 'w'", "0, 'm'" })
	@DisplayName("Entrada height en idealWeight() es inválida, se lanza excepción")
	public void testIdealWeightInvalidHeight(int height, char gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.idealWeight(height, gender);
		});

	}

	@ParameterizedTest
	@CsvSource({ "'x'", "'4'", "';'", "'t'", "'¿'", "7" })
	@DisplayName("Entrada gender en idealWeight() es distinta de 'm' o 'w', se lanza excepción")
	public void testIdealWeightInvalidGender(char gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.idealWeight(160, gender);
		});
	}

	@ParameterizedTest
	@CsvSource({ "180, 'm'", "165, 'w'",
			"84, 'm'", "67, 'w'", "1000, 'm'" }) // probamos con las valores límites de ambos géneros
	@DisplayName("Ambas entradas en idealWeight() son válidas, se espera un valor positivo")
	public void testIdealWeightValidInputs(int height, char gender) throws Exception {
		assertDoesNotThrow(() -> {
			float result = hc.idealWeight(height, gender);
			assertTrue(result > 0);
		});

	}

	@ParameterizedTest
	@CsvSource({ "83, 'm'", "5, 'w'",
			"56, 'm'", "66, 'w'" })
	@DisplayName("Con valores de altura menores que 84 en hombre y 67 en mujer se espera que se lanze una excepción")
	public void testIdealWeightNegative(int height, char gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.idealWeight(height, gender);
		});

	}

	@Test
	@DisplayName("Con una altura de 150 se debe obtener el mismo peso para hombres y mujeres.")
	public void testIdealWeightEqualHeight150() throws Exception {
		assertEquals(hc.idealWeight(150, 'w'), hc.idealWeight(150, 'm'));

	}

	@Test
	@DisplayName("Con el mismo valor de height, mayor que 150, el peso ideal debe ser menor en mujeres que en hombres.")
	public void testIdealWeightEqualHeightM150() throws Exception {
		int h = (new Random()).nextInt(151, 250);
		assertTrue(hc.idealWeight(h, 'w') < hc.idealWeight(h, 'm'));

	}

	@Test
	@DisplayName("Con el mismo valor de height, menor que 150, el peso ideal debe ser mayor en mujeres que en hombres.")
	public void testIdealWeightEqualHeightm150() throws Exception {
		int h = (new Random()).nextInt(84, 150); // debe ser un valor que no genere valores negativos en ninguno
		assertTrue(hc.idealWeight(h, 'w') > hc.idealWeight(h, 'm'));

	}

	@ParameterizedTest
	@CsvSource({ "-1060, 'm'", "0, 'w'",
			"-1, 'm'", "-100, 'w'", "0, 'm'" })
	@DisplayName("Entrada height en basalMetabolicRate() es inválida")
	// asumimos valores de weight y age válidos
	public void testBMRInvalidHeight(int height, char gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(60, height, gender, 30);
		});

	}

	@ParameterizedTest
	@CsvSource({ "'x'", "'4'", "';'", "'t'", "'¿'", "7" })
	@DisplayName("Entrada gender en basalMetabolicRate() es distinta de 'm' o 'w', el resto son correctas")
	public void testBMRInvalidGender(char gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(60, 165, gender, 30);
		});
	}

	@ParameterizedTest
	@CsvSource({ "-1000, 'm'", "0, 'w'",
			"-1, 'w'" })
	@DisplayName("Entrada weight en basalMetabolicRate() no es mayor que 0, se espera Excepción")
	public void testBMRInvalidWeight(int weight, char gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(weight, 165, gender, 30);
		});
	}

	@ParameterizedTest
	@CsvSource({ "-235, 'm'", "-1, 'w'" })
	@DisplayName("Entrada age en basalMetabolicRate() inválida , se espera Excepción")
	public void testBMRInvalidAge(int age, char gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(60, 165, gender, age);
		});
	}

	@ParameterizedTest
	@CsvSource({ "180, 'm', 40, 13", "165, 'w', 89, 78",
			"50, 'm', 4, 1", "125, 'w', 45, 60", "1000, 'm', 343, 23" })
	@DisplayName("Todas las entradas de basalMetabolicRate son válidas, por lo que no se espera una Excepción")
	public void testBMRValidInputs(int height, char gender, int weight, int age) throws Exception {
		assertDoesNotThrow(() -> {
			float result = hc.basalMetabolicRate(weight, height, gender, age);
			assertTrue(result > 0);
		});
	}

	@ParameterizedTest
	@CsvSource({ "10, 10, 5", "1, 6, 0" })
	@DisplayName("Si el resultado para mujeres en basalMetabolicRate es negativo, se espera una Excepción")
	public void testBMRWomenNegative(int height, int weight, int age) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(weight, height, 'w', age);
		});
	}

	@Test
	@DisplayName("Con los mismos valores de weight, age y height, el resultado para hombres debe ser 166 unidades mayor que en mujeres.")
	public void testBMREqualValidInput() throws Exception {
		Random r = new Random();
		int h = r.nextInt(1, 170);
		int w = r.nextInt(1, 600);
		int a = r.nextInt(0, 130);
		assertEquals(hc.basalMetabolicRate(w, h, 'm', a), hc.basalMetabolicRate(w, h, 'w', a) + 166);

	}

}
