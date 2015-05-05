 package fr.istic.tp7gwtrpc.rpcmavengwt.server;
import java.util.List;

import fr.istic.tp7gwtrpc.rpcmavengwt.shared.*;

import javax.persistence.Entity;

public interface MyService 
{

	List<ElectricDevice> get_devices();

}
