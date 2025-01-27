package mascotas.example.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.CrudDAO;
import com.example.entities.Mascota;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })

public class MascotaDaoTest {

	private static final Logger log = LogManager.getLogger(MascotaDaoTest.class);

	@Autowired
	@Qualifier("mascotaDaoImp")
	private CrudDAO<Mascota> mascotaDaoImp;

	@Test
	@Ignore

	public void crearAlumnoTest() {
		// verifica que mascotaDaoImpno sea nulo
		assertNotNull(mascotaDaoImp);

		try {

			Mascota mascota = new Mascota();
			mascota.setNombre("preusab");
			mascota.setEdad(22);
			mascota.setDescripcion("perro de prueba");

			mascotaDaoImp.guardar(mascota);
			// hace referencia que la operacion guardar se realizo con exito
			assertTrue(true);
			log.info("Mascota guardada Correcamnete {}", mascota);

		} catch (Exception e) {
			log.error("error al guardar la mascota {}", e);
			// es para que si el programam actua como debe si la encuntra hace que el test
			// se tome como fallido
			// para cuando el flujo de codigo no debe de llegar a cierta parte
			fail(e.getMessage());
		}

	}

	@Test
	@Ignore
	public void buscarMascotaId() {

		assertNotNull(mascotaDaoImp);

		int idMascota = 25;

		try {

			Mascota mascota = mascotaDaoImp.encontrarPorId(idMascota);

			assertNotNull(mascota);
			assertTrue(true);

			log.info("Mascota Encontradas {}", mascota);

		} catch (Exception e) {
			log.error("Error al encontrar la mascota{}", e);
			fail(e.getMessage());
		}

	}

	@Test
	@Ignore
	public void eliminarMascota() {
		assertNotNull(mascotaDaoImp);

		Integer idMascota = 42;

		try {
			Mascota mascota = mascotaDaoImp.encontrarPorId(idMascota);

			assertNotNull(mascota);

			mascotaDaoImp.eliminar(mascota);

			assertTrue(true);
			log.info("Mascota elimnada correctamente {}", mascota);
		} catch (Exception e) {
			log.error("error al eliminar la mascota {}", e);
			fail(e.getMessage());

		}

	}

	@Test
	@Ignore
	public void mostarTodasLasMascotas() {
		assertNotNull(mascotaDaoImp);
		try {

			List<Mascota> mascotas = mascotaDaoImp.mostrarTodos();

			assertNotNull(mascotas);

			mascotas.stream().forEach(mascota -> log.info("Mascota Encontrada {}",mascota));

		} catch (Exception e) {

			log.error("Error al mostrar todos las mascotas", e);
			fail(e.getMessage());
		}

	}

	@Test
	public void actualizarMascota() {

		assertNotNull(mascotaDaoImp);
		
		Integer idMascota = 25;

		try {
			
				Mascota mascota = mascotaDaoImp.encontrarPorId(idMascota);

				assertNotNull(mascota);
				
				mascota.setNombre("mascota actualizada");

				mascotaDaoImp.actualizar(mascota);
				log.info("Mascota Actualizada correctamente {}", mascota);
			
			
			
		}catch (Exception e) {

			log.error("Error al mostrar todos las mascotas", e);
			fail(e.getMessage());
		}
		
		
		

	}

}
