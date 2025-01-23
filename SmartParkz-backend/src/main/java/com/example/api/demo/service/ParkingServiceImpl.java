
package com.example.api.demo.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.demo.entity.ParkingSlots;
import com.example.api.demo.exception.NoSuchParkingSlotException;
import com.example.api.demo.exception.ParkingSlotNotAvailableException;
import com.example.api.demo.repository.ParkingFloorRepository;
import com.example.api.demo.repository.ParkingRepository;
import com.example.api.demo.repository.ParkingSlotRepository;

@Service
public class ParkingServiceImpl implements ParkingService{

	@Autowired
	private ParkingRepository parkingrepository;
	@Autowired
	private ParkingFloorRepository floorrepo;
	@Autowired
	private ParkingSlotRepository slotrepo;


	
	@Override
	public boolean checkAvailability(Date date) throws ParkingSlotNotAvailableException{
		List<ParkingSlots> result = slotrepo.findAllByParkingDate(date);
		if(result.size()>0)
		{
			throw new ParkingSlotNotAvailableException();
		}
		else
		{
			return true;
		}
	}
	
	@Override
	public boolean bookParkingSlot(ParkingSlots parkingslot) throws ParkingSlotNotAvailableException {
		// TODO Auto-generated method stub
		if(floorrepo.existsById(parkingslot.getParkingFloor().getParkingFloorId()))
		{
			
				List<ParkingSlots> l = slotrepo.findSlotOnFloorId(parkingslot.getParkingFloor().getParkingFloorId(),parkingslot.getSlot_no());
				if(l.size()>0)
				{
						throw new ParkingSlotNotAvailableException();
				}
				else
				{
					slotrepo.saveAndFlush(parkingslot);
					return true;
					
				}
		}
		else
		{
			throw new ParkingSlotNotAvailableException();
		}

	}
	
//	@Override
//	public boolean bookParkingSlot(ParkingSlots parkingslot) throws ParkingSlotNotAvailableException {
//		// TODO Auto-generated method stub
//		if(floorrepo.existsById(parkingslot.getParkingFloor().getParkingFloorId()))
//		{
//			if(slotrepo.existsById(parkingslot.getParkingSlotId()))
//			{
//				throw new ParkingSlotNotAvailableException();
//			}
//			else
//			{
//				slotrepo.save(parkingslot);
//				return true;
//			}
//		} 
//		else
//		{
//			throw new ParkingSlotNotAvailableException();
//		}
//	}
//	
	@Override
	public boolean cancelParkingSlotBooking(int id) throws NoSuchParkingSlotException
	{
			if(slotrepo.existsById(id))
			{
				slotrepo.deleteById(id);
				return true;
			}
			else
			{
				throw new NoSuchParkingSlotException();
			}
	}
	
	@Override
	public List<ParkingSlots> getAllParkingSlotsByPremise(int parkingpremiseid) {
		// TODO Auto-generated method stub
		return slotrepo.findAllParkingSlotByPremise(parkingpremiseid);
	}
	
	@Override
	public List<ParkingSlots> getAllParkingSlotsByFloor(int parkingFloorId)
	{
		return slotrepo.findAllParkingSlot(parkingFloorId);
		
	}

	@Override
	public ParkingSlots getParkingSlotsById(Integer parkingSlotId) throws NoSuchParkingSlotException
	{
		if(!slotrepo.existsById(parkingSlotId))
		{
			throw new NoSuchParkingSlotException();
		}
		
		List<ParkingSlots> pay = slotrepo.findAll();
		ParkingSlots p = null;
		for(ParkingSlots a : pay)
		{
			if(a.getParkingSlotId() ==parkingSlotId)
			{
				p = a;
			}
		}
		return p;
	}

	@Override
	public List<ParkingSlots> getAllParkingSlots() {
		// TODO Auto-generated method stub
		return slotrepo.findAll();
	}


}
