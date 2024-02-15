package railway.com.example.RailwayAndMeal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.exceptions.TicketAlreadyExistsException;
import railway.com.example.RailwayAndMeal.exceptions.TicketNotFoundException;

@Service
public class RailwayService {

	public List<Ticket> list = new ArrayList<>();
	public Map<Long,Ticket> ticketMap = new HashMap<>();
	
	/** This function adds a ticket to a list and associates it with a PNR in a ticket map 
	    for efficient retrieval. **/
	public void addTicket(Ticket ticket) {
		if(ticketMap.containsKey(ticket.getPnr())) {
			throw new TicketAlreadyExistsException("Ticket already exists for PNR: "+ticket.getPnr());
		}
		else {
			list.add(ticket);
			ticketMap.put(ticket.getPnr(), ticket);
		}
	}
	
	/** This function returns a list of all tickets stored in the class. **/
	public List<Ticket> getAllTickets() {		
		return list;
	}
	
	/** This method retrieves a ticket based on its unique PNR from ticketmap. **/ 
	public Ticket getTicketByPnr(long pnr) {
		if(ObjectUtils.isEmpty(ticketMap.get(pnr))) {
			throw new TicketNotFoundException("Ticket not found for PNR: "+pnr);
		}
		return ticketMap.get(pnr);
	}
	
	public void deleteTicketByPnr(long pnr){
		if(ObjectUtils.isEmpty(ticketMap.get(pnr))) {
			throw new TicketNotFoundException("Ticket not found for PNR: "+pnr);
		}
		else {
			Ticket ticket = getTicketByPnr(pnr);
			list.remove(ticket);
			
			ticketMap.remove(pnr);
		}
	}

	public void updateTicket(Ticket newTicket) {
		// TODO Auto-generated method stub
		if(ObjectUtils.isEmpty(ticketMap.get(newTicket.getPnr()))) {
			throw new TicketNotFoundException("Ticket not found for PNR: "+newTicket.getPnr());
		}
		else {
			Ticket ticket = getTicketByPnr(newTicket.getPnr());
			list.remove(ticket);
			list.add(newTicket);
			
			
			ticketMap.put(newTicket.getPnr(), newTicket);
		}
		
	}
		
}