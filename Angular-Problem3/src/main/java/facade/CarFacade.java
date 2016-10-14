/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Service.EmfService;
import entity.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author philliphbrink
 */
public class CarFacade {
    
    public List<Car> getCars(){
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Car> persons = em.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> listOfCars = persons.getResultList();
            return listOfCars;
        } finally {
            em.close();
        }
    }
}
