package healthcalc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {
	private HealthCalc hc;

	/*
	 * @BeforeEach
	 * public void init() {
	 * hc = new HealthCalcImpl();
	 * }
	 */
	@ParameterizedTest
	@CsvSource({ "-1060, 'm'", "0, 'w'",
			"-1, 'm'", "-100, 'w'", "0, 'm'" })
	@DisplayName("Entrada height en idealWeight() es inválida")
	public void testIdealWeightInvalidHeight(int height, char gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.idealWeight(height, gender);
		});

	}

	@ParameterizedTest
	@CsvSource({ "'x'", "'4'", "';'", "'t'", "'¿'", "7" })
	@DisplayName("Entrada gender en idealWeight() es distinta de 'm' o 'w'")
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
		int h = (new Random()).nextInt(84, 150); //debe ser un valor que no genere valores negativos en ninguno
		assertTrue(hc.idealWeight(h, 'w') > hc.idealWeight(h, 'm'));

	}

}
