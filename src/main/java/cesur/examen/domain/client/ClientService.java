package cesur.examen.domain.client;

import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Jorge Alarcón Navarro
 * Fecha: 11/12/2023
 */

/**
 * Métodos de servicio de Client.
 */
public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){
        var out = new ArrayList<Client>(0);

        CarDAO carDAO = new CarDAO();
        List<Car> cars = carDAO.getAllByManufacturer(manufacturer);
        Set<Client> uniqueClients = new HashSet<>();
        for (Car car : cars) {
            Client client = car.getClient();
            uniqueClients.add(client);
        }
        out.addAll(uniqueClients);
        return out;
    }
}
