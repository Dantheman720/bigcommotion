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
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement

public class PointOfContact implements Serializable
{

@Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;
   @Version
   @Column(name = "version")
   private int version = 0;

   @Column
   @NotNull
   @Min(2)
   @Max(256)
   private String firstName;

   @Column
   @NotNull
   @Min(2)
   @Max(50)
   private String lastName;

   @Column
   @NotNull
   private String emailAddress;

   @Column
   private String mobileNumber;

   @Column
   private String officeNumber;

   @Column
   private String twitterHandle;

   @Column
   private String skypeUsername;

   @Column
   private String organizationName;

   @Column
   private boolean isPerson;

   public Long getId()
   {
      return this.id;
   }

   public String getFullName()
   {
      return lastName + " " + firstName;
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
         return id.equals(((PointOfContact) that).id);
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

   public String getEmailAddress()
   {
      return this.emailAddress;
   }

   public void setEmailAddress(final String emailAddress)
   {
      this.emailAddress = emailAddress;
   }

   public String getMobileNumber()
   {
      return this.mobileNumber;
   }

   public void setMobileNumber(final String mobileNumber)
   {
      this.mobileNumber = mobileNumber;
   }

   public String getOfficeNumber()
   {
      return this.officeNumber;
   }

   public void setOfficeNumber(final String officeNumber)
   {
      this.officeNumber = officeNumber;
   }

   public String getTwitterHandle()
   {
      return this.twitterHandle;
   }

   public void setTwitterHandle(final String twitterHandle)
   {
      this.twitterHandle = twitterHandle;
   }

   public String getSkypeUsername()
   {
      return this.skypeUsername;
   }

   public void setSkypeUsername(final String skypeUsername)
   {
      this.skypeUsername = skypeUsername;
   }

   public String getOrganizationName()
   {
      return this.organizationName;
   }

   public void setOrganizationName(final String organizationName)
   {
      this.organizationName = organizationName;
   }

   public boolean getIsPerson()
   {
      return this.isPerson;
   }

   public void setIsPerson(final boolean isPerson)
   {
      this.isPerson = isPerson;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (firstName != null && !firstName.trim().isEmpty())
         result += "firstName: " + firstName;
      if (lastName != null && !lastName.trim().isEmpty())
         result += ", lastName: " + lastName;
      if (emailAddress != null && !emailAddress.trim().isEmpty())
         result += ", emailAddress: " + emailAddress;
      if (mobileNumber != null && !mobileNumber.trim().isEmpty())
         result += ", mobileNumber: " + mobileNumber;
      if (officeNumber != null && !officeNumber.trim().isEmpty())
         result += ", officeNumber: " + officeNumber;
      if (twitterHandle != null && !twitterHandle.trim().isEmpty())
         result += ", twitterHandle: " + twitterHandle;
      if (skypeUsername != null && !skypeUsername.trim().isEmpty())
         result += ", skypeUsername: " + skypeUsername;
      if (organizationName != null && !organizationName.trim().isEmpty())
         result += ", organizationName: " + organizationName;
      result += ", isPerson: " + isPerson;
      return result;
   }
}