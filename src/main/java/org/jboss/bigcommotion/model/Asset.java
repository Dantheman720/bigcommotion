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

import org.jboss.bigcommotion.model.FrequencyOfUpdates;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@SuppressWarnings("serial")
@XmlRootElement
public class Asset implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;
   @Version
   @Column(name = "version")
   private int version = 0;

   @Column(length = 256)
   @NotNull
   @Size(min = 2, max = 256, message = "The Asset's name must be between 2 and 256 characters.")
   private String name;

   @Column
   @NotNull(message = "You are required to state if the Asset aleady exists.")
   private boolean existsToday;

   @Column
   @Size(min = 8, max = 512, message = "The Asset's URL must be between 8 and 512 characters.")
   private String url;

   @Column(length = 20)
   @Size(min = 5, max = 50, message = "The Asset's owner must be between 3 and 20 characters in length.")
   private String owner;

   @Column
   private FrequencyOfUpdates frequencyOfUpdates;

   @Column(length = 1024)
   @Size(max = 1024, message = "The Asset's description must not be longer than 1024 characters.")
   private String description;

   @Column(length = 256)
   @Size(max = 256, message = "The Asset's call to action must not be longer than 256 characters.")
   private String callToAction;

   @Column(length = 256)
   @Size(max = 256, message = "The Asset's 2nd call to action must not be longer than 256 characters.")
   private String callToAction2;

   @Column(length = 256)
   @Size(max = 256, message = "The Asset's 3rd call to action must not be longer than 256 characters.")
   private String callToAction3;

   @Column(length = 1024)
   @Size(min = 8, max = 1024, message = "The Asset's note must not be longer than 1024 characters.")
   private String note;

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
         return id.equals(((Asset) that).id);
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

   public String getName()
   {
      return this.name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public boolean getExistsToday()
   {
      return this.existsToday;
   }

   public void setExistsToday(final boolean existsToday)
   {
      this.existsToday = existsToday;
   }

   public String getUrl()
   {
      return this.url;
   }

   public void setUrl(final String url)
   {
      this.url = url;
   }

   public String getOwner()
   {
      return this.owner;
   }

   public void setOwner(final String owner)
   {
      this.owner = owner;
   }

   public FrequencyOfUpdates getFrequencyOfUpdates()
   {
      return this.frequencyOfUpdates;
   }

   public void setFrequencyOfUpdates(final FrequencyOfUpdates frequencyOfUpdates)
   {
      this.frequencyOfUpdates = frequencyOfUpdates;
   }

   public String getDescription()
   {
      return this.description;
   }

   public void setDescription(final String description)
   {
      this.description = description;
   }

   public String getCallToAction()
   {
      return this.callToAction;
   }

   public void setCallToAction(final String callToAction)
   {
      this.callToAction = callToAction;
   }

   public String getCallToAction2()
   {
      return this.callToAction2;
   }

   public void setCallToAction2(final String callToAction2)
   {
      this.callToAction2 = callToAction2;
   }

   public String getCallToAction3()
   {
      return this.callToAction3;
   }

   public void setCallToAction3(final String callToAction3)
   {
      this.callToAction3 = callToAction3;
   }

   public String getNote()
   {
      return this.note;
   }

   public void setNote(final String note)
   {
      this.note = note;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (name != null && !name.trim().isEmpty())
         result += "name: " + name;
      result += ", existsToday: " + existsToday;
      if (url != null && !url.trim().isEmpty())
         result += ", url: " + url;
      if (owner != null && !owner.trim().isEmpty())
         result += ", owner: " + owner;
      if (description != null && !description.trim().isEmpty())
         result += ", description: " + description;
      if (callToAction != null && !callToAction.trim().isEmpty())
         result += ", callToAction: " + callToAction;
      if (callToAction2 != null && !callToAction2.trim().isEmpty())
         result += ", callToAction2: " + callToAction2;
      if (callToAction3 != null && !callToAction3.trim().isEmpty())
         result += ", callToAction3: " + callToAction3;
      if (note != null && !note.trim().isEmpty())
         result += ", note: " + note;
      return result;
   }
}