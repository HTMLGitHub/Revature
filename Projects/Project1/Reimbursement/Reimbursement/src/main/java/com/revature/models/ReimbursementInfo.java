package com.revature.models;

import java.sql.Date;
import java.util.Objects;

public class ReimbursementInfo 
{
	private int id;
	private Date submitted;
	private Date finished;
	private String reason;
	private String otherReason;
	private double amount;
	private String submittedBy;
	private String completedBy;
	private boolean pending;
	
	/**
	 * 
	 */
	public ReimbursementInfo()
	{
	}

	/**
	 * @param submitted
	 * @param reason
	 * @param amount
	 * @param submittedBy
	 * @param pending
	 */
	public ReimbursementInfo(Date submitted, String reason, double amount, String submittedBy, boolean pending)
	{
		this.submitted = submitted;
		this.reason = reason;
		this.amount = amount;
		this.submittedBy = submittedBy;
		this.pending = pending;
	}
	
	/**
	 * @param id
	 * @param submitted
	 * @param reason
	 * @param amount
	 * @param submittedBy
	 * @param pending
	 */
	public ReimbursementInfo(int id, Date submitted, String reason, double amount, String submittedBy, boolean pending)
	{
		this.id = id;
		this.submitted = submitted;
		this.reason = reason;
		this.amount = amount;
		this.submittedBy = submittedBy;
		this.pending = pending;
	}
	
	

	/**
	 * @param id
	 * @param submitted
	 * @param reason
	 * @param otherReason
	 * @param amount
	 * @param submittedBy
	 * @param pending
	 */
	public ReimbursementInfo(int id, Date submitted, String reason, String otherReason, double amount,
			String submittedBy, boolean pending)
	{
		this.id = id;
		this.submitted = submitted;
		this.reason = reason;
		this.otherReason = otherReason;
		this.amount = amount;
		this.submittedBy = submittedBy;
		this.pending = pending;
	}

	/**
	 * @param submitted
	 * @param reason
	 * @param otherReason
	 * @param amount
	 * @param submittedBy
	 * @param pending
	 */
	public ReimbursementInfo(Date submitted, String reason, String otherReason, double amount, String submittedBy,
			boolean pending)
	{
		this.submitted = submitted;
		this.reason = reason;
		this.otherReason = otherReason;
		this.amount = amount;
		this.submittedBy = submittedBy;
		this.pending = pending;
	}

	/**
	 * @param submitted
	 * @param finished
	 * @param reason
	 * @param otherReason
	 * @param amount
	 * @param submittedBy
	 * @param completedBy
	 * @param pending
	 */
	public ReimbursementInfo(Date submitted, Date finished, String reason, String otherReason,
			double amount, String submittedBy, String completedBy, boolean pending)
	{
		this.submitted = submitted;
		this.finished = finished;
		this.reason = reason;
		this.otherReason = otherReason;
		this.amount = amount;
		this.submittedBy = submittedBy;
		this.completedBy = completedBy;
		this.pending = pending;
	}
	
	

	/**
	 * @param id
	 * @param submitted
	 * @param finished
	 * @param reason
	 * @param amount
	 * @param submittedBy
	 * @param completedBy
	 * @param pending
	 */
	public ReimbursementInfo(int id, Date submitted, Date finished, String reason, double amount, String submittedBy,
			String completedBy, boolean pending)
	{
		this.id = id;
		this.submitted = submitted;
		this.finished = finished;
		this.reason = reason;
		this.amount = amount;
		this.submittedBy = submittedBy;
		this.completedBy = completedBy;
		this.pending = pending;
	}

	/**
	 * @param id
	 * @param submitted
	 * @param finished
	 * @param reason
	 * @param otherReason
	 * @param amount
	 * @param submittedBy
	 * @param completedBy
	 * @param pending
	 */
	public ReimbursementInfo(int id, Date submitted, Date finished, String reason, String otherReason,
			double amount, String submittedBy, String completedBy, boolean pending)
	{
		this.id = id;
		this.submitted = submitted;
		this.finished = finished;
		this.reason = reason;
		this.otherReason = otherReason;
		this.amount = amount;
		this.submittedBy = submittedBy;
		this.completedBy = completedBy;
		this.pending = pending;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the submitted
	 */
	public Date getSubmitted()
	{
		return submitted;
	}

	/**
	 * @param submitted the submitted to set
	 */
	public void setSubmitted(Date submitted)
	{
		this.submitted = submitted;
	}

	/**
	 * @return the finished
	 */
	public Date getFinished()
	{
		return finished;
	}

	/**
	 * @param finished the finished to set
	 */
	public void setFinished(Date finished)
	{
		this.finished = finished;
	}

	/**
	 * @return the reason
	 */
	public String getReason()
	{
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason)
	{
		this.reason = reason;
	}

	/**
	 * @return the otherReason
	 */
	public String getOtherReason()
	{
		return otherReason;
	}

	/**
	 * @param otherReason the otherReason to set
	 */
	public void setOtherReason(String otherReason)
	{
		this.otherReason = otherReason;
	}

	/**
	 * @return the amount
	 */
	public double getAmount()
	{
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the submittedBy
	 */
	public String getSubmittedBy()
	{
		return submittedBy;
	}

	/**
	 * @param submittedBy the submittedBy to set
	 */
	public void setSubmittedBy(String submittedBy)
	{
		this.submittedBy = submittedBy;
	}

	/**
	 * @return the completedBy
	 */
	public String getCompletedBy()
	{
		return completedBy;
	}

	/**
	 * @param completedBy the completedBy to set
	 */
	public void setCompletedBy(String completedBy)
	{
		this.completedBy = completedBy;
	}

	/**
	 * @return the pending
	 */
	public boolean isPending()
	{
		return pending;
	}

	/**
	 * @param pending the pending to set
	 */
	public void setPending(boolean pending)
	{
		this.pending = pending;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(amount, completedBy, finished, id, otherReason, pending, reason, submitted, submittedBy);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (!(obj instanceof ReimbursementInfo))
		{
			return false;
		}
		ReimbursementInfo other = (ReimbursementInfo) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(completedBy, other.completedBy) && Objects.equals(finished, other.finished)
				&& id == other.id && Objects.equals(otherReason, other.otherReason) && pending == other.pending
				&& Objects.equals(reason, other.reason) && Objects.equals(submitted, other.submitted)
				&& Objects.equals(submittedBy, other.submittedBy);
	}

	@Override
	public String toString()
	{
		return String.format(
				"ReimbursmentInfo [id=%s, submitted=%s, finished=%s, reason=%s, otherReason=%s, amount=%s, submittedBy=%s, completedBy=%s, pending=%s]",
				id, submitted, finished, reason, otherReason, amount, submittedBy, completedBy, pending);
	}
	
	
	
}
