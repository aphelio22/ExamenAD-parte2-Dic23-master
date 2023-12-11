package cesur.examen.domain.car;

import cesur.examen.domain.client.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Jorge Alarcón Navarro
 * Fecha: 11/12/2023
 */

/**
 * Mapeo de Car.
 */
@Data
@Entity
@Table(name = "garaje")
public class Car implements Serializable {

    /**
     * Id Car.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Matrícula de Car.
     */
    @Column(name = "matricula")
    private String plate;

    /**
     * Modelo de Car.
     */
    @Column(name = "modelo")
    private String model;

    /**
     * Manufacturador de Car.
     */
    @Column(name = "fabricante")
    private String manufacturer;

    /**
     * Clientes de Car.
     */
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Client client;

    /**
     * Override inherited toString() method to prevent stackOverFlow exceptions
     * from relationship.
     * @return
     */
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", client=" + client.getName() +
                '}';
    }
}
