
package fr.istic.tp7gwtrpc.rpcmavengwt.server;
import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;



import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import fr.istic.tp7gwtrpc.rpcmavengwt.shared.ElectricDevice;

@Path("/electridevices")
public class ElectricDeviceImplService implements MyService {

	
	private EntityManager manager;

	
	 public ElectricDeviceImplService() {
		// TODO Auto-generated constructor stub
	}
	{
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		this.manager=factory.createEntityManager();
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<ElectricDevice> get_devices() {
		// TODO Auto-generated method stub
	List<ElectricDevice>devices=manager.createQuery("select p from Peripherique p").getResultList();
	return devices;
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println("osamaa");
		ElectricDeviceImplService eq=new ElectricDeviceImplService();
		eq.get_devices();
	}
	
	

}
