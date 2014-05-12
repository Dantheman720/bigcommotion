package org.jboss.bigcommotion.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

import java.lang.Override;
import java.net.URL;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.bigcommotion.model.SessionSubmission;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.OneToMany;
import org.jboss.bigcommotion.model.PointOfContact;
import javax.persistence.ManyToMany;

/*
 * We suppress the warning about not specifying a serialVersionUID, as we are still developing this app, and want the JVM to
 * generate the serialVersionUID for us. When we put this app into production, we'll generate and embed the serialVersionUID
 */
@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Conference implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;

   @Version
   @Column(name = "version")
   private int version = 0;

   @Column(unique = true)
   @NotNull
   @Size(min = 5, max = 256, message = "A Conference's name must contain between 5 and 256 characters")
   private String name;

   @Temporal(TemporalType.DATE)
   private Date beginDate;

   @Temporal(TemporalType.DATE)
   private Date endDate;

   @Temporal(TemporalType.DATE)
   private Date cfpOpenDate;

   @Temporal(TemporalType.DATE)
   private Date cfpCloseDate;

   @Column
   private URL url;

   @Column
   @Size(max = 1000, message = "A Conference's description must be less than 1000 characters")
   private String description;

   @Column
   private int expectedAttendees;

   @Column
   private boolean sponsored;

   @Column
   private boolean booth;

   @Column
   private int numberOfRHSessions;

   @Column
   private BigDecimal estimatedCost;

   @Column
   private BigDecimal actualCost;

   @Column
   private String purchaseOrder;

   @Column
   private int requisitionID;

   @Column
   private String transferID;

   @Column
   private String receiptID;

   @Column
   @Size(max = 1024)
   private String notes;

   @Column
   private String requestedBy;

   @Column
   private String campaign;

   @Temporal(TemporalType.TIME)
   private Date setupTime;

   @Temporal(TemporalType.TIME)
   private Date dismantleTime;

   @Column
   private String eloquaID;

   @Column
   private String sfdcID;

   @OneToMany(cascade = CascadeType.ALL)
   private Set<SessionSubmission> sessionSubmissions = new HashSet<SessionSubmission>();

   @ManyToMany
   private Set<PointOfContact> vendorPointOfContact = new HashSet<PointOfContact>();

   @ManyToMany
   private Set<PointOfContact> staff = new HashSet<PointOfContact>();

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
         return id.equals(((Conference) that).id);
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

   public Date getBeginDate()
   {
      return this.beginDate;
   }

   public void setBeginDate(final Date beginDate)
   {
      this.beginDate = beginDate;
   }

   public Date getEndDate()
   {
      return this.endDate;
   }

   public void setEndDate(final Date endDate)
   {
      this.endDate = endDate;
   }

   public Date getCfpOpenDate()
   {
      return this.cfpOpenDate;
   }

   public void setCfpOpenDate(final Date cfpOpenDate)
   {
      this.cfpOpenDate = cfpOpenDate;
   }

   public Date getCfpCloseDate()
   {
      return this.cfpCloseDate;
   }

   public void setCfpCloseDate(final Date cfpCloseDate)
   {
      this.cfpCloseDate = cfpCloseDate;
   }

   public URL getUrl()
   {
      return this.url;
   }

   public void setUrl(final URL url)
   {
      this.url = url;
   }

   public String getDescription()
   {
      return this.description;
   }

   public void setDescription(final String description)
   {
      this.description = description;
   }

   public int getExpectedAttendees()
   {
      return this.expectedAttendees;
   }

   public void setExpectedAttendees(final int expectedAttendees)
   {
      this.expectedAttendees = expectedAttendees;
   }

   public boolean getSponsored()
   {
      return this.sponsored;
   }

   public void setSponsored(final boolean sponsored)
   {
      this.sponsored = sponsored;
   }

   public boolean getBooth()
   {
      return this.booth;
   }

   public void setBooth(final boolean booth)
   {
      this.booth = booth;
   }

   public int getNumberOfRHSessions()
   {
      return this.numberOfRHSessions;
   }

   public void setNumberOfRHSessions(final int numberOfRHSessions)
   {
      this.numberOfRHSessions = numberOfRHSessions;
   }

   public BigDecimal getEstimatedCost()
   {
      return this.estimatedCost;
   }

   public void setEstimatedCost(final BigDecimal estimatedCost)
   {
      this.estimatedCost = estimatedCost;
   }

   public BigDecimal getActualCost()
   {
      return this.actualCost;
   }

   public void setActualCost(final BigDecimal actualCost)
   {
      this.actualCost = actualCost;
   }

   public String getPurchaseOrder()
   {
      return this.purchaseOrder;
   }

   public void setPurchaseOrder(final String purchaseOrder)
   {
      this.purchaseOrder = purchaseOrder;
   }

   public int getRequisitionID()
   {
      return this.requisitionID;
   }

   public void setRequisitionID(final int requisitionID)
   {
      this.requisitionID = requisitionID;
   }

   public String getTransferID()
   {
      return this.transferID;
   }

   public void setTransferID(final String transferID)
   {
      this.transferID = transferID;
   }

   public String getReceiptID()
   {
      return this.receiptID;
   }

   public void setReceiptID(final String receiptID)
   {
      this.receiptID = receiptID;
   }

   public String getNotes()
   {
      return this.notes;
   }

   public void setNotes(final String notes)
   {
      this.notes = notes;
   }

   public String getRequestedBy()
   {
      return this.requestedBy;
   }

   public void setRequestedBy(final String requestedBy)
   {
      this.requestedBy = requestedBy;
   }

   public String getCampaign()
   {
      return this.campaign;
   }

   public void setCampaign(final String campaign)
   {
      this.campaign = campaign;
   }

   public Date getSetupTime()
   {
      return this.setupTime;
   }

   public void setSetupTime(final Date setupTime)
   {
      this.setupTime = setupTime;
   }

   public Date getDismantleTime()
   {
      return this.dismantleTime;
   }

   public void setDismantleTime(final Date dismantleTime)
   {
      this.dismantleTime = dismantleTime;
   }

   public String getEloquaID()
   {
      return this.eloquaID;
   }

   public void setEloquaID(final String eloquaID)
   {
      this.eloquaID = eloquaID;
   }

   public String getSfdcID()
   {
      return this.sfdcID;
   }

   public void setSfdcID(final String sfdcID)
   {
      this.sfdcID = sfdcID;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (name != null && !name.trim().isEmpty())
         result += "name: " + name;
      if (description != null && !description.trim().isEmpty())
         result += ", description: " + description;
      result += ", expectedAttendees: " + expectedAttendees;
      result += ", sponsored: " + sponsored;
      result += ", booth: " + booth;
      result += ", numberOfRHSessions: " + numberOfRHSessions;
      if (purchaseOrder != null && !purchaseOrder.trim().isEmpty())
         result += ", purchaseOrder: " + purchaseOrder;
      result += ", requisitionID: " + requisitionID;
      if (transferID != null && !transferID.trim().isEmpty())
         result += ", transferID: " + transferID;
      if (receiptID != null && !receiptID.trim().isEmpty())
         result += ", receiptID: " + receiptID;
      if (notes != null && !notes.trim().isEmpty())
         result += ", notes: " + notes;
      if (requestedBy != null && !requestedBy.trim().isEmpty())
         result += ", requestedBy: " + requestedBy;
      if (campaign != null && !campaign.trim().isEmpty())
         result += ", campaign: " + campaign;
      if (eloquaID != null && !eloquaID.trim().isEmpty())
         result += ", eloquaID: " + eloquaID;
      if (sfdcID != null && !sfdcID.trim().isEmpty())
         result += ", sfdcID: " + sfdcID;
      return result;
   }

   public Set<SessionSubmission> getSessionSubmissions()
   {
      return this.sessionSubmissions;
   }

   public void setSessionSubmissions(
         final Set<SessionSubmission> sessionSubmissions)
   {
      this.sessionSubmissions = sessionSubmissions;
   }

   public Set<PointOfContact> getVendorPointOfContact()
   {
      return this.vendorPointOfContact;
   }

   public void setVendorPointOfContact(
         final Set<PointOfContact> vendorPointOfContact)
   {
      this.vendorPointOfContact = vendorPointOfContact;
   }

   public Set<PointOfContact> getStaff()
   {
      return this.staff;
   }

   public void setStaff(final Set<PointOfContact> staff)
   {
      this.staff = staff;
   }
}