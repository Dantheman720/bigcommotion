package org.jboss.bigcommotion.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import org.jboss.bigcommotion.model.Asset;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * 
 */
@Stateless
@Path("/assets")
public class AssetEndpoint
{
   @PersistenceContext(unitName = "forge-default")
   private EntityManager em;

   @POST
   @Consumes(APPLICATION_JSON)
   public Response create(Asset entity)
   {
      em.persist(entity);
      return Response.created(UriBuilder.fromResource(AssetEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
   }

   @DELETE
   @Path("/{id:[0-9][0-9]*}")
   public Response deleteById(@PathParam("id") Long id)
   {
      Asset entity = em.find(Asset.class, id);
      if (entity == null)
      {
         return Response.status(Status.NOT_FOUND).build();
      }
      em.remove(entity);
      return Response.noContent().build();
   }

   @GET
   @Path("/{id:[0-9][0-9]*}")
   @Produces(APPLICATION_JSON)
   public Response findById(@PathParam("id") Long id)
   {
      TypedQuery<Asset> findByIdQuery = em.createQuery("SELECT a FROM Asset a WHERE a.id = :entityId", Asset.class);
      findByIdQuery.setParameter("entityId", id);
      Asset entity = findByIdQuery.getSingleResult();
      if (entity == null)
      {
         return Response.status(Status.NOT_FOUND).build();
      }
      return Response.ok(entity).build();
   }

   @GET
   @Produces(APPLICATION_JSON)
   public List<Asset> listAll()
   {
      final List<Asset> results = em.createQuery("SELECT a FROM Asset a", Asset.class).getResultList();
      return results;
   }

   @PUT
   @Path("/{id:[0-9][0-9]*}")
   @Consumes(APPLICATION_JSON)
   public Response update(@PathParam("id") Long id, Asset entity)
   {
      entity.setId(id);
      entity = em.merge(entity);
      return Response.noContent().build();
   }
}