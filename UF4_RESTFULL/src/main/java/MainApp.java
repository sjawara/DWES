import com.mycompany.uf4_restfull.domain.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
	public static void main(String[] args) {
    	// Cargar la configuración desde hibernate.cfg.xml
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");

    	// Crear la sesión de fábrica (SessionFactory)
    	SessionFactory sessionFactory = configuration.buildSessionFactory();

    	// Abrir una sesión de Hibernate
    	try (Session session = sessionFactory.openSession()) {

        	Transaction tx = session.beginTransaction();

        	// Crear un objeto Producto y guardarlo en la base de datos
        	Cliente  producto = new Cliente(1,"Seku","Jawara", "carrer rossello", "08303","Mataro");
        	session.save(producto);

        	tx.commit();

        	// Leer el producto recién guardado desde la base de datos
        	Cliente productoGuardado = session.get(Cliente.class, producto.getId());
        	System.out.println("Producto guardado: " + productoGuardado);

    	} catch (Exception e) {
        	e.printStackTrace();
    	} finally {
        	// Cerrar la sesión de fábrica al finalizar
        	sessionFactory.close();
    	}
	}
}

