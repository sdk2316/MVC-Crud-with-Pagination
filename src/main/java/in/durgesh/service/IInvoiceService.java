package in.durgesh.service;

import java.util.List;

import in.durgesh.model.Invoice;

public interface IInvoiceService {
	public Invoice saveInvice(Invoice invoice);
    public List<Invoice> getAllInvoices();
    public Invoice getInvoiceById(Long id);
    public void deleteInvoiceById(Long id);
    public void updateInvoice(Invoice invoice);

}
