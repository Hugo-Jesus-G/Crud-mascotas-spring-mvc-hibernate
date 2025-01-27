package mascotas.example.service;

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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.CrudDAO;
import com.example.entities.Mascota;
import com.example.service.MascotaService;

import mascotas.example.dao.MascotaDaoTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class MascotaServiceTest {
	private static final Logger log = LogManager.getLogger(MascotaServiceTest.class);

	@Autowired
	private MascotaService mascotaService;

	@Test
	

	public void crearAlumnoTest() {
		// verifica que mascotaDaoImpno sea nulo
		assertNotNull(mascotaService);

		try {

			Mascota mascota = new Mascota();
			mascota.setNombre("mascota service");
			mascota.setEdad(10);
			mascota.setDescripcion("perro de servicio");

			mascotaService.guardar(mascota);
			log.info("Mascota guardada Correcamnete {}", mascota);

		} catch (Exception e) {
			log.error("error al guardar la mascota {}", e);
			
			fail(e.getMessage());
		}

	}

	@Test
	@Ignore
	public void buscarMascotaId() {

		assertNotNull(mascotaService);

		int idMascota = 25;

		try {

			Mascota mascota = mascotaService.encontrarPorId(idMascota);

			assertNotNull(mascota);
			log.info("Mascota Encontradas {}", mascota);

		} catch (Exception e) {
			log.error("Error al encontrar la mascota{}", e);
			fail(e.getMessage());
		}

	}

	@Test
	@Ignore
	public void eliminarMascota() {
		assertNotNull(mascotaService);

		Integer idMascota = 42;
		try {
			Mascota mascota = mascotaService.encontrarPorId(idMascota);

			assertNotNull(mascota);

			mascotaService.eliminar(mascota);

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
		assertNotNull(mascotaService);
		try {

			List<Mascota> mascotas = mascotaService.mostrarTodos();

			assertNotNull(mascotas);

			mascotas.stream().forEach(mascota -> log.info("Mascota Encontrada {}", mascota));

		} catch (Exception e) {

			log.error("Error al mostrar todos las mascotas", e);
			fail(e.getMessage());
		}

	}

	@Test
	@Ignore
	public void actualizarMascota() {

		assertNotNull(mascotaService);

		Integer idMascota = 25;

		try {

			Mascota mascota = mascotaService.encontrarPorId(idMascota);

			assertNotNull(mascota);

			mascota.setNombre("mascota actualizada");

			mascotaService.actualizar(mascota);
			log.info("Mascota Actualizada correctamente {}", mascota);

		} catch (Exception e) {

			log.error("Error al mostrar todos las mascotas", e);
			fail(e.getMessage());
		}

	}

}
