package pantallas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pantallaPrincipalTest {
	
	pantallaPrincipal pP=new pantallaPrincipal();
	
	@Test
	void test() {
		assertEquals("Paco",pP.getNameJug1("Paco"));
	}

}
