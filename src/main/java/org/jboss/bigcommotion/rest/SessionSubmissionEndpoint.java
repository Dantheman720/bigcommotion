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
import org.jboss.bigcommotion.model.SessionSubmission;

/**
 * 
 */
@Stateless
@Path("/sessionsubmissions")
public class SessionSubmissionEndpoint
{
   @PersistenceContext(unitName = "forge-default")
   private EntityManager em;

   @POST
   @Consumes("application/json")
   public Response create(SessionSubmission entity)
   {
      em.persist(entity);
      return Response.created(UriBuilder.fromResource(SessionSubmissionEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
   }

   @DELETE
   @Path("/{id:[0-9][0-9]*}")
   public Response deleteById(@PathParam("id") Long id)
   {
      SessionSubmission entity = em.find(SessionSubmission.class, id);
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
      TypedQuery<SessionSubmission> findByIdQuery = em.createQuery("SELECT s FROM SessionSubmission s LEFT JOIN FETCH s.conference LEFT JOIN FETCH s.presenter LEFT JOIN FETCH s.coPresenter LEFT JOIN FETCH s.thirdPresenter WHERE s.id = :entityId", SessionSubmission.class);
      findByIdQuery.setParameter("entityId", id);
      SessionSubmission entity = findByIdQuery.getSingleResult();
      if (entity == null)
      {
         return Response.status(Status.NOT_FOUND).build();
      }
      return Response.ok(entity).build();
   }

   @GET
   @Produces("application/json")
   public List<SessionSubmission> listAll()
   {
      final List<SessionSubmission> results = em.createQuery("SELECT s FROM SessionSubmission s LEFT JOIN FETCH s.conference LEFT JOIN FETCH s.presenter LEFT JOIN FETCH s.coPresenter LEFT JOIN FETCH s.thirdPresenter", SessionSubmission.class).getResultList();
      return results;
   }

   @PUT
   @Path("/{id:[0-9][0-9]*}")
   @Consumes("application/json")
   public Response update(@PathParam("id") Long id, SessionSubmission entity)
   {
      entity.setId(id);
      entity = em.merge(entity);
      return Response.noContent().build();
   }
}