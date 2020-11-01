/* $Id$ */

package com.zoho.books.test;

import java.util.ArrayList;
import java.util.List;

import com.zoho.books.api.VendorCreditsApi;
import com.zoho.books.exception.BooksException;
import com.zoho.books.model.Bill;
import com.zoho.books.model.Comment;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.VendorCredit;
import com.zoho.books.model.VendorCreditList;
import com.zoho.books.model.VendorCreditRefund;
import com.zoho.books.model.VendorCreditRefundList;

public class VendorCreditsTest 
{
	
	public static void main(String[] args)throws Exception
	{
		
		VendorCreditsApi vendorCreditsApi = new VendorCreditsApi("{access_token}", "{organization_id}");	//No I18N
		
		try
		{
			
			VendorCreditList getVendorCredits = vendorCreditsApi.getVendorCredits(null);
			
			String vendorCreditId = getVendorCredits.get(0).getVendorCreditId();
			
			VendorCredit get = vendorCreditsApi.get(vendorCreditId);
			
			get.setVendorCreditNumber("");
			
			get.setReferenceNumber("");
			
			VendorCredit create = vendorCreditsApi.create(null, get);
			
			VendorCredit update = vendorCreditsApi.update(get);
			
			String convertToOpen = vendorCreditsApi.convertToOpen(vendorCreditId);
			
			String convertToVoid = vendorCreditsApi.convertToVoid(vendorCreditId);
			
			
			
			String billsCredited = vendorCreditsApi.getBillsCredited(vendorCreditId);
			
			List<Bill> bills = new ArrayList<Bill>();
			
			Bill bill = new Bill();
			bill.setBillId("36991000000124057");
			bill.setAmountApplied(100.00);
			
			bills.add(bill);
			
			String applyCreditsToBill = vendorCreditsApi.applyCreditsToBill(vendorCreditId, bills);
			
			String vendorCreditBillId = "";
			
			String deleteBillsCredited = vendorCreditsApi.deleteBillsCredited(vendorCreditId, vendorCreditBillId);
			
			
			VendorCreditRefundList vendoCreditRefunds = vendorCreditsApi.getVendorCreditRefunds(null);
			
			VendorCreditRefundList refundsOfVendorCredit = vendorCreditsApi.getRefundsOfVendorCredit(vendorCreditId);
			
			String vendorCreditRefundId = refundsOfVendorCredit.get(0).getVendorCreditRefundId();
			
			VendorCreditRefund getVendorCreditRefund = vendorCreditsApi.getVendorCreditRefund(vendorCreditId, vendorCreditRefundId);
			
			getVendorCreditRefund.setAmount(50.00);
			
			VendorCreditRefund refundAVendorCredit = vendorCreditsApi.refundAVendorCredit(vendorCreditId, getVendorCreditRefund);
			
			VendorCreditRefund updateVendorCreditRefund = vendorCreditsApi.updateVendorCreditRefund(vendorCreditId, getVendorCreditRefund);
			
			String deleteVendorCreditRefund = vendorCreditsApi.deleteVendorCreditRefund(vendorCreditId, vendorCreditRefundId);
			
			
			
			CommentList getComments = vendorCreditsApi.getComments(vendorCreditId);
			
			String commentId = getComments.get(0).getCommentId();
			
			String description = "Test Comment";	//No I18N
			
			Comment addComment = vendorCreditsApi.addComment(vendorCreditId, description);
			
			String deleteComment = vendorCreditsApi.delete(vendorCreditId);
			
			//System.out.println(create);
			
		}
		catch (BooksException be)
		{
			//System.out.println("Error Code: "+ be.getCode()+" Message: "+be.getMessage());
			
			throw be;
		}
		
	}

}
