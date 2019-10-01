package com.Angela.ws.rest.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.Angela.ws.rest.Model.Mascota;
import com.Angela.ws.rest.Model.JPAUtil;

public class MascotaDao {
	
EntityManager miEntity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void GuardarMascota(Mascota miMascota) {
		
		miEntity.getTransaction().begin();
		miEntity.persist(miMascota);
		miEntity.getTransaction().commit();
		miMascota.setMensaje("....Mascota Registrada Exitosamente....  ");
		
	}
	

	
	public Mascota buscar(int id) {
		Mascota misMascotas = new Mascota();
		misMascotas=miEntity.find(Mascota.class, misMascotas);
		return misMascotas;
	}
	
	
	public List<Mascota> ObtenerMascota(){
		
		List<Mascota>listaMascota=new ArrayList<>();
		Query miQuery=miEntity.createQuery("SELECT misMascotas FROM Mascota misMascotas ");
		listaMascota=miQuery.getResultList();
		return listaMascota;
	}
	
	public Mascota Eliminar (int id){
		Mascota misMascotas = new Mascota();
		misMascotas=miEntity.find(Mascota.class, misMascotas);
		miEntity.getTransaction().begin();
		miEntity.remove(misMascotas);
		miEntity.getTransaction().commit();
		misMascotas.setMensaje(" .....Se Elimino Correctamente..... ");
		return misMascotas;
	}
	
	
	public void EditarMascota(Mascota miMascota) {
		
		miEntity.getTransaction().begin();
		miEntity.persist(miMascota);
		miEntity.getTransaction().commit();
		miMascota.setMensaje("....Mascota Registrada Exitosamente... ");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
