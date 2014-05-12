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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import java.lang.Override;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.Size;

@Entity
@XmlRootElement
@SuppressWarnings("serial")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "firstName", "lastName" }))
public class Presenter implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;
   @Version
   @Column(name = "version")
   private int version = 0;

   @Column(length = 50)
   @NotNull
   @Size(min = 2, max = 50, message = "A Speaker's first name must be at least 2 characters and no more than 50.")
   private String firstName;

   @Column
   @NotNull
   @Size(min = 2, max = 50, message = "A Speaker's last name must be at least 2 characters and no more than 50.")
   private String lastName;

   @Column
   @Size(max = 1024, message = "A Speaker's bio should not be longer than 1024 characters.")
   private String biography;

   @Column(length = 50)
   @Size(max = 50, message = "A Speaker's twitter handle cannot be longer than 50 characters.")
   private String twitterHandle;

   @Column(length = 512)
   @Size(max = 512, message = "A Speaker's image URL should not be longer than 512 characters")
   private String imageUrl;

   @Column(length = 2056)
   @Size(max = 2056, message = "Notes on a Speaker cannot exceed 2056 characters.")
   private String notes;

   @Column(length = 512)
   @Size(max = 512, message = "Come On! Who is this guy?  Title really has to be less than 512 characters.")
   private String title;

   @Column(length = 512)
   private String googlePlus;

   @Column(length = 512)
   private String linkedIn;

   @Column(length = 512)
   private String githubId;

   @Column(length = 512)
   private String facebookUrl;

   @Column
   private String jbossId;

   @Column
   private String redhatId;

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
         return id.equals(((Presenter) that).id);
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

   public String getFirstName()
   {
      return this.firstName;
   }

   public void setFirstName(final String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return this.lastName;
   }

   public void setLastName(final String lastName)
   {
      this.lastName = lastName;
   }

   public String getBiography()
   {
      return this.biography;
   }

   public void setBiography(final String biography)
   {
      this.biography = biography;
   }

   public String getTwitterHandle()
   {
      return this.twitterHandle;
   }

   public void setTwitterHandle(final String twitterHandle)
   {
      this.twitterHandle = twitterHandle;
   }

   public String getImageUrl()
   {
      return this.imageUrl;
   }

   public void setImageUrl(final String imageUrl)
   {
      this.imageUrl = imageUrl;
   }

   public String getNotes()
   {
      return this.notes;
   }

   public void setNotes(final String notes)
   {
      this.notes = notes;
   }

   public String getFullName()
   {
      return lastName + "," + firstName;
   }

   public String getTitle()
   {
      return this.title;
   }

   public void setTitle(final String title)
   {
      this.title = title;
   }

   public String getGooglePlus()
   {
      return this.googlePlus;
   }

   public void setGooglePlus(final String googlePlus)
   {
      this.googlePlus = googlePlus;
   }

   public String getLinkedIn()
   {
      return this.linkedIn;
   }

   public void setLinkedIn(final String linkedIn)
   {
      this.linkedIn = linkedIn;
   }

   public String getGithubId()
   {
      return this.githubId;
   }

   public void setGithubId(final String githubId)
   {
      this.githubId = githubId;
   }

   public String getFacebookUrl()
   {
      return this.facebookUrl;
   }

   public void setFacebookUrl(final String facebookUrl)
   {
      this.facebookUrl = facebookUrl;
   }

   public String getJbossId()
   {
      return this.jbossId;
   }

   public void setJbossId(final String jbossId)
   {
      this.jbossId = jbossId;
   }

   public String getRedhatId()
   {
      return this.redhatId;
   }

   public void setRedhatId(final String redhatId)
   {
      this.redhatId = redhatId;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (firstName != null && !firstName.trim().isEmpty())
         result += "firstName: " + firstName;
      if (lastName != null && !lastName.trim().isEmpty())
         result += ", lastName: " + lastName;
      if (biography != null && !biography.trim().isEmpty())
         result += ", biography: " + biography;
      if (twitterHandle != null && !twitterHandle.trim().isEmpty())
         result += ", twitterHandle: " + twitterHandle;
      if (imageUrl != null && !imageUrl.trim().isEmpty())
         result += ", imageUrl: " + imageUrl;
      if (notes != null && !notes.trim().isEmpty())
         result += ", notes: " + notes;
      if (title != null && !title.trim().isEmpty())
         result += ", title: " + title;
      if (googlePlus != null && !googlePlus.trim().isEmpty())
         result += ", googlePlus: " + googlePlus;
      if (linkedIn != null && !linkedIn.trim().isEmpty())
         result += ", linkedIn: " + linkedIn;
      if (githubId != null && !githubId.trim().isEmpty())
         result += ", githubId: " + githubId;
      if (facebookUrl != null && !facebookUrl.trim().isEmpty())
         result += ", facebookUrl: " + facebookUrl;
      if (jbossId != null && !jbossId.trim().isEmpty())
         result += ", jbossId: " + jbossId;
      if (redhatId != null && !redhatId.trim().isEmpty())
         result += ", redhatId: " + redhatId;
      return result;
   }
}