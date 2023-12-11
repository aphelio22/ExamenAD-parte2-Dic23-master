package cesur.examen.domain.car;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import cesur.examen.domain.client.Client;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
public class CarDAO implements DAO<Car> {

    /**
     * Guarda un Car en la Base de Datos.
     * @param car
     * @return Car guardado.
     */
    @Override
    public Car save(Car car) {

        /* Implement method here */
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.save(car);
                transaction.commit();
            } catch (Exception e){
               if (transaction != null){
                   transaction.rollback();
               }
               e.printStackTrace();
            }
        }
        return car;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    /**
     * Coge todos los Car que tienen un mismo manufacturador.
     * @param manufacturer
     * @return Todos los Car que obtiene.
     */
    public List<Car> getAllByManufacturer(String manufacturer){
        var out = new ArrayList<Car>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Car> query = session.createQuery("from Car where manufacturer = :manufacturer", Car.class);
            query.setParameter("manufacturer", manufacturer);
            out = (ArrayList<Car>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}
