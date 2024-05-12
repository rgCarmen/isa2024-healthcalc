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
		//hc = new HealthCalcImpl();
		hc=HealthCalcImpl.getCalcImpl();
	}

	@ParameterizedTest
	@CsvSource({ "-1060, MALE", "0, FEMALE",
			"-1, MALE", "-100, FEMALE", "0, MALE" })
	@DisplayName("Entrada height en idealWeight() es inválida, se lanza excepción")
	public void testIdealWeightInvalidHeight(int height, Gender gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.idealWeight(height, gender);
		});

	}

	/* 
	@ParameterizedTest
	@CsvSource({ "'x'", "'4'", "';'", "'t'", "'¿'", "7" })
	@DisplayName("Entrada gender en idealWeight() es distinta de MALE o FEMALE, se lanza excepción")
	public void testIdealWeightInvalidGender(Gender gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.idealWeight(160, gender);
		});
	}*/

	@ParameterizedTest
	@CsvSource({ "180, MALE", "165, FEMALE",
			"84, MALE", "67, FEMALE", "1000, MALE" }) // probamos con las valores límites de ambos géneros
	@DisplayName("Ambas entradas en idealWeight() son válidas, se espera un valor positivo")
	public void testIdealWeightValidInputs(int height, Gender gender) throws Exception {
		assertDoesNotThrow(() -> {
			float result = hc.idealWeight(height, gender);
			assertTrue(result > 0);
		});

	}

	@ParameterizedTest
	@CsvSource({ "83, MALE", "5, FEMALE",
			"56, MALE", "66, FEMALE" })
	@DisplayName("Con valores de altura menores que 84 en hombre y 67 en mujer se espera que se lanze una excepción")
	public void testIdealWeightNegative(int height, Gender gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.idealWeight(height, gender);
		});

	}

	@Test
	@DisplayName("Con una altura de 150 se debe obtener el mismo peso para hombres y mujeres.")
	public void testIdealWeightEqualHeight150() throws Exception {
		assertEquals(hc.idealWeight(150, Gender.FEMALE), hc.idealWeight(150, Gender.MALE));

	}

	@Test
	@DisplayName("Con el mismo valor de height, mayor que 150, el peso ideal debe ser menor en mujeres que en hombres.")
	public void testIdealWeightEqualHeightM150() throws Exception {
		int h = (new Random()).nextInt(151, 250);
		assertTrue(hc.idealWeight(h, Gender.FEMALE) < hc.idealWeight(h, Gender.MALE));

	}

	@Test
	@DisplayName("Con el mismo valor de height, menor que 150, el peso ideal debe ser mayor en mujeres que en hombres.")
	public void testIdealWeightEqualHeightm150() throws Exception {
		int h = (new Random()).nextInt(84, 150); // debe ser un valor que no genere valores negativos en ninguno
		assertTrue(hc.idealWeight(h, Gender.FEMALE) > hc.idealWeight(h, Gender.MALE));

	}

	@ParameterizedTest
	@CsvSource({ "-1060, MALE", "0, FEMALE",
			"-1, MALE", "-100, FEMALE", "0, MALE" })
	@DisplayName("Entrada height en basalMetabolicRate() es inválida")
	// asumimos valores de weight y age válidos
	public void testBMRInvalidHeight(int height, Gender gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(60, height, gender, 30);
		});

	}

	/*@ParameterizedTest
	@CsvSource({ "'x'", "'4'", "';'", "'t'", "'¿'", "7" })
	@DisplayName("Entrada gender en basalMetabolicRate() es distinta de MALE o FEMALE, el resto son correctas")
	public void testBMRInvalidGender(Gender gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(60, 165, gender, 30);
		});
	}*/

	@ParameterizedTest
	@CsvSource({ "-1000, MALE", "0, FEMALE",
			"-1, FEMALE" })
	@DisplayName("Entrada weight en basalMetabolicRate() no es mayor que 0, se espera Excepción")
	public void testBMRInvalidWeight(int weight, Gender gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(weight, 165, gender, 30);
		});
	}

	@ParameterizedTest
	@CsvSource({ "-235, MALE", "-1, FEMALE" })
	@DisplayName("Entrada age en basalMetabolicRate() inválida , se espera Excepción")
	public void testBMRInvalidAge(int age, Gender gender) throws Exception {
		assertThrows(Exception.class, () -> {
			hc.basalMetabolicRate(60, 165, gender, age);
		});
	}

	@ParameterizedTest
	@CsvSource({ "180, MALE, 40, 13", "165, FEMALE, 89, 78",
			"50, MALE, 4, 1", "125, FEMALE, 45, 60", "1000, MALE, 343, 23" })
	@DisplayName("Todas las entradas de basalMetabolicRate son válidas, por lo que no se espera una Excepción")
	public void testBMRValidInputs(int height, Gender gender, int weight, int age) throws Exception {
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
			hc.basalMetabolicRate(weight, height, Gender.FEMALE, age);
		});
	}

	@Test
	@DisplayName("Con los mismos valores de weight, age y height, el resultado para hombres debe ser 166 unidades mayor que en mujeres.")
	public void testBMREqualValidInput() throws Exception {
		Random r = new Random();
		int h = r.nextInt(1, 170);
		int w = r.nextInt(1, 600);
		int a = r.nextInt(0, 130);
		assertEquals(hc.basalMetabolicRate(w, h, Gender.MALE, a), hc.basalMetabolicRate(w, h, Gender.FEMALE, a) + 166);

	}

}
