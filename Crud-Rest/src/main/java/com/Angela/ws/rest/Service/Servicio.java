package com.Angela.ws.rest.Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.Angela.ws.rest.Dao.MascotaDao;
import com.Angela.ws.rest.Model.Mascota;

@Path("/AngelaPrueba")
public class Servicio {

	

	@GET
	@Path("/listaMascota")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Mascota> listadoLibros() {
		
		MascotaDao mismascotas= new MascotaDao();
		return mismascotas.ObtenerMascota();
	}
	
	
	@POST
	@Path("/RegistrarMascota")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String RegistrarAuto(Mascota miAuto) {
		MascotaDao misAutos= new  MascotaDao();
	 	misAutos.GuardarMascota(miAuto);
	 	return miAuto.getMensaje();
	}
	
	
	
	@PUT
	@Path("/EditarMascota")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String EditarAuto(Mascota miMascota) {
		MascotaDao mismascotas= new MascotaDao();
		mismascotas.EditarMascota(miMascota);
		return miMascota.getMensaje();
	}
	
	

	@DELETE
	@Path("/ElimiarMascota/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String EliminarAuto(@PathParam("id") int id) {
		Mascota miMascota=new Mascota();	
		MascotaDao misMascotas= new MascotaDao();
		misMascotas.Eliminar(id);
		return miMascota.getMensaje();
	}
	
	@GET
	@Path("/BuscarMascota/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mascota BuscarMascota(@PathParam("id") int id) {
		
		MascotaDao mismascotas= new MascotaDao();
		return mismascotas.buscar(id);
	}
	
}
