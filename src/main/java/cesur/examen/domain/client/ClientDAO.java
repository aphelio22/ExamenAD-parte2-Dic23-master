package cesur.examen.domain.client;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Jorge Alarcón Navarro
 * Fecha: 11/12/2023
 */

/**
 * Implementa métodos que realizan operaciones con Bases de Datos con Hibernate.
 */
@Log
public class ClientDAO implements DAO<Client> {
    @Override
    public Client save(Client client) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public boolean remove(Client client) {
        return false;
    }

    @Override
    public Client get(Long id) {
        return null;
    }

    /**
     * Obtiene todos los Client.
     * @return Lista de Client.
     */
    @Override
    public List<Client> getAll() {
        var out = new ArrayList<Client>();
        /* Implement method here */
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Client> query = session.createQuery("from Client", Client.class);
            out = (ArrayList<Client>) query.getResultList();
        }
        return out;
    }

}
