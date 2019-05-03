
import static org.junit.Assert.*;

import org.junit.Test;

import EntornosDesarrollo.Refactorizacion.banco;
import EntornosDesarrollo.Refactorizacion.cliente;
import EntornosDesarrollo.Refactorizacion.cuenta;

public class test {

	private banco laCaixa = new banco("laCaixa", 1991);
	private banco Santander = new banco("Santander", 1964);

	private cliente c1 = new cliente("Antonio", "Martínez", 1234565747N", "Puig blanc", "67483932823");
	
	private cliente c2 = new cliente("Juan", "Ramiro", "433252351223B", "Calle avenida", "608572934782");

	private cuenta cuenta1 = new cuenta(c1, "004997348364865863", 10000, laCaixa);

	private cuenta cuenta2 = new cuenta(c2, "004923489735238425", 20000, Santander);
	
	@Test
	public void testCliente() {

		if (cuenta1.getTitular() == cuenta2.getTitular()) {
			System.out.println("Correcto");
		} else {
			System.out.println("Fallo");

		}

	}

	
	@Test
	public void testSalgoOriginal() {
		double sActual = cuenta1.getSaldo();
		cuenta.transferencia(cuenta1, cuenta2, 432);
		if (cuenta1.getSaldo() != sActual) {
			fail();
		}
	}
	
	@Test
	public void SaldoDestinatario() {
		double sActual = cuenta2.getSaldo();
		cuenta.transferencia(cuenta1, cuenta2, 5775);
		if (cuenta2.getSaldo() == sActual) {
			fail();
		}
	}
	
	@Test
	public void TransferenciaOk() {
		assertEquals(true, cuenta.transferencia(cuenta1, cuenta2, 435));
	}

	@Test
	public void TransferenciaError() {
		assertEquals(false, cuenta.transferencia(cuenta1, cuenta2, 43550));
	}
	}

