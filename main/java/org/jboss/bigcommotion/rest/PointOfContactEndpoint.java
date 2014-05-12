package org.jboss.bigcommotion.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import org.jboss.bigcommotion.model.PointOfContact;

/**
 * 
 */
@Stateless
@Path("/pointofcontacts")
public class PointOfContactEndpoint
{
   @PersistenceContext(unitName = "forge-default")
   private EntityManager em;

   @POST
   @Consumes("application/json")
   public Response create(PointOfContact entity)
   {
      em.persist(entity);
      return Response.created(UriBuilder.fromResource(PointOfContactEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
   }

   @DELETE
   @Path("/{id:[0-9][0-9]*}")
   public Response deleteById(@PathParam("id") Long id)
   {
      PointOfContact entity = em.find(PointOfContact.class, id);
      if (entity == null)
      {
         return Response.status(Status.NOT_FOUND).build();
      }
      em.remove(entity);
      return Response.noContent().build();
   }

   @GET
   @Path("/{id:[0-9][0-9]*}")
   @Produces("application/json")
   public Response findById(@PathParam("id") Long id)
   {
      TypedQuery<PointOfContact> findByIdQuery = em.createQuery("SELECT p FROM PointOfContact p WHERE p.id = :entityId", PointOfContact.class);
      findByIdQuery.setParameter("entityId", id);
      PointOfContact entity = findByIdQuery.getSingleResult();
      if (entity == null)
      {
         return Response.status(Status.NOT_FOUND).build();
      }
      return Response.ok(entity).build();
   }

   @GET
   @Produces("application/json")
   public List<PointOfContact> listAll()
   {
      final List<PointOfContact> results = em.createQuery("SELECT p FROM PointOfContact p", PointOfContact.class).getResultList();
      return results;
   }

   @PUT
   @Path("/{id:[0-9][0-9]*}")
   @Consumes("application/json")
   public Response update(@PathParam("id") Long id, PointOfContact entity)
   {
      entity.setId(id);
      entity = em.merge(entity);
      return Response.noContent().build();
   }
}