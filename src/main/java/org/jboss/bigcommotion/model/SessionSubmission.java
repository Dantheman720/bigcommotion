/*
* JBoss, Home of Professional Open Source
* Copyright 2009, Red Hat, Inc. and/or its affiliates, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.jboss.bigcommotion.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

import java.lang.Override;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.jboss.bigcommotion.model.Conference;
import org.jboss.bigcommotion.model.Presenter;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@JsonIgnoreProperties("conference")
@SuppressWarnings("serial")
public class SessionSubmission implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;
   @Version
   @Column(name = "version")
   private int version = 0;

   @ManyToOne
   private Conference conference;

   public Conference getConference()
   {
      return conference;
   }

   public void setConference(Conference conference)
   {
      this.conference = conference;
   }

   @Column
   private boolean accepted;

   @Column
   @NotNull
   @Size(min = 5, max = 512, message = "A Submission's title should not be longer than 512 characters")
   private String title;

   @Column
   @Size(max = 2048)
   private String description;

   @Temporal(TemporalType.DATE)
   private Date dateSubmitted;

   @Temporal(TemporalType.DATE)
   private Date dateAccepted;

   @Temporal(TemporalType.DATE)
   private Date dateNotified;

   @Column
   @Size(max = 50, message = "A Submission's track name cannot be longer than 50 characters")
   private String track;

   @Column(length = 2056)
   @Size(max = 2056, message = "A Submission's note cannot be longer than 2056 characters")
   private String notes;

   @Column
   @Size(max = 2056, message = "A Submission's internal notes cannot be longer than 2056 characters")
   private String internalNotes;

   @ManyToOne
   private Presenter presenter;

   @ManyToOne
   private Presenter coPresenter;

   @ManyToOne
   private Presenter thirdPresenter;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   //TODO:  Clean up equality.
   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((SessionSubmission) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public boolean getAccepted()
   {
      return this.accepted;
   }

   public void setAccepted(final boolean accepted)
   {
      this.accepted = accepted;
   }

   public String getTitle()
   {
      return this.title;
   }

   public void setTitle(final String title)
   {
      this.title = title;
   }

   public String getDescription()
   {
      return this.description;
   }

   public void setDescription(final String description)
   {
      this.description = description;
   }

   public Date getDateSubmitted()
   {
      return this.dateSubmitted;
   }

   public void setDateSubmitted(final Date dateSubmitted)
   {
      this.dateSubmitted = dateSubmitted;
   }

   public Date getDateAccepted()
   {
      return this.dateAccepted;
   }

   public void setDateAccepted(final Date dateAccepted)
   {
      this.dateAccepted = dateAccepted;
   }

   public Date getDateNotified()
   {
      return this.dateNotified;
   }

   public void setDateNotified(final Date dateNotified)
   {
      this.dateNotified = dateNotified;
   }

   public String getTrack()
   {
      return this.track;
   }

   public void setTrack(final String track)
   {
      this.track = track;
   }

   public String getNotes()
   {
      return this.notes;
   }

   public void setNotes(final String notes)
   {
      this.notes = notes;
   }

   public String getInternalNotes()
   {
      return this.internalNotes;
   }

   public void setInternalNotes(final String internalNotes)
   {
      this.internalNotes = internalNotes;
   }

   public Presenter getPresenter()
   {
      return this.presenter;
   }

   public void setPresenter(final Presenter presenter)
   {
      this.presenter = presenter;
   }

   public Presenter getCoPresenter()
   {
      return this.coPresenter;
   }

   public void setCoPresenter(final Presenter coPresenter)
   {
      this.coPresenter = coPresenter;
   }

   public Presenter getThirdPresenter()
   {
      return this.thirdPresenter;
   }

   public void setThirdPresenter(final Presenter thirdPresenter)
   {
      this.thirdPresenter = thirdPresenter;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      result += "accepted: " + accepted;
      if (title != null && !title.trim().isEmpty())
         result += ", title: " + title;
      if (description != null && !description.trim().isEmpty())
         result += ", description: " + description;
      if (track != null && !track.trim().isEmpty())
         result += ", track: " + track;
      if (notes != null && !notes.trim().isEmpty())
         result += ", notes: " + notes;
      if (internalNotes != null && !internalNotes.trim().isEmpty())
         result += ", internalNotes: " + internalNotes;
      return result;
   }
}