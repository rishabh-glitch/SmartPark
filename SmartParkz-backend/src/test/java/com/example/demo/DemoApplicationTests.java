//package com.example.demo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.demo.entity.Address;
//import com.example.demo.entity.Owner;
//import com.example.demo.entity.ParkingFloor;
//import com.example.demo.entity.ParkingPremise;
//import com.example.demo.entity.ParkingSlots;
//import com.example.demo.entity.Payment;
//import com.example.demo.entity.Vehicle;
//import com.example.demo.exception.NoSuchParkingSlotException;
//import com.example.demo.exception.NoSuchPaymentFoundException;
//import com.example.demo.exception.ParkingSlotNotAvailableException;
//import com.example.demo.repository.ParkingSlotRepository;
//import com.example.demo.repository.PaymentRepository;
//import com.example.demo.service.ParkingServiceImpl;
//import com.example.demo.service.PaymentServiceImpl;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DemoApplicationTests {
//	@Autowired
//	private PaymentServiceImpl payment;
//	
//	@MockBean
//	private PaymentRepository payrepo;
//	
//	
////-----------------------Payment Test Cases -----------------------------------------
//
//
//	 
//	@Test
//	public void findPaymentByDate() throws ParseException, NoSuchPaymentFoundException
//	{
//		String date = "2022-09-18";
//		Date payDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//		when(payrepo.findAllByPaymentDateTime(payDate)).
//		thenReturn(Stream.of(new Payment(1, "online",payDate,12.0,"completed")).
//				collect(Collectors.toList()));
//		assertEquals(1,payment.findPaymentByDate(payDate).size());
//	}
//
////--------------------------Parking Services Test Cases -------------------------------
//	
//	@Autowired ParkingServiceImpl parking;
//	
//	
//	@MockBean ParkingSlotRepository parkrepo;
//	
//	
//	Address address = new Address(1,"Delhi","Delhi","201030");
//	
//	ParkingPremise premise = new ParkingPremise(1,"Teja Parking",address,10);
//	
//	Owner owner = new Owner(1,"Rishabh","singh","rishabh123@gmail.com","9012333333",false);
//	
//	Vehicle vehicle = new Vehicle(1,"TwoWheeler","UP 30 AB 2020","Ford","X4",owner);
//	
//	ParkingFloor floor = new ParkingFloor(1,premise,"10",5);
//	
//	Date date1 = new Date(System.currentTimeMillis());
//	
//	Payment pay1 = new Payment(1, "online",date1,12.0,"completed");
//	
//	ParkingSlots slot = new ParkingSlots(1,floor,vehicle,date1,"12:00pm",date1,5,5,pay1);
//	
//
//	@Test
//	public void getAllParkingSlotsByPremiseTest() {
//		List<ParkingSlots> slots = new ArrayList<ParkingSlots>();
//		slots.add(slot);
//		int id = 1;
//		when(parkrepo.findAllParkingSlotByPremise(1)).thenReturn(slots);
//		assertEquals(1,parking.getAllParkingSlotsByPremise(id).size());
//	}
//	
//	@Test
//	public void getAllParkingSlotsByFloorTest()
//	{
//		List<ParkingSlots> slots = new ArrayList<ParkingSlots>();
//		slots.add(slot);
//		int id = 1;
//		when(parkrepo.findAllParkingSlot(id)).thenReturn(slots);
//		assertEquals(1,parking.getAllParkingSlotsByFloor(id).size());
//		
//	}
//	
//	@Test
//	public void saveSlotTest() throws ParkingSlotNotAvailableException
//	{
//		when(parkrepo.saveAndFlush(slot)).thenReturn(slot);
//		assertEquals(true,parking.bookParkingSlot(slot));
//	}
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////@Test
////public void findAllVehiclesByUserIdTest() throws ParseException, NoSuchPaymentFoundException {
////	String date = "2022-09-18";
////	Date payDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
////	int Id = 1;
////	when(payrepo.findById((int) Id)).thenReturn(Optional
////			.of(new Payment(1, "online", payDate, 12.00, "comp")));
////	assertEquals(Optional.of(new Payment(1, "online", payDate, 12.00, "comp")), payment.findPaymentById(Id));
////}
//
//
//
//
//
////@Test
////public void getPaymentByIdTest() throws NoSuchPaymentFoundException {
////	Date date = new Date(System.currentTimeMillis());
////	List<Payment> paymentList = new ArrayList<Payment>();
////	paymentList.add(new Payment(1, "online",date,12.0,"completed"));
////	paymentList.add(new Payment(2, "offline",date,15.0,"pending"));
////	Optional<Payment> p = Optional.of( new Payment(1, "online",date,12.0,"completed"));
////	int id = 1;
////	when(payrepo.findAll()).thenReturn(paymentList);
////	assertEquals(p,payment.findPaymentById(id).get());
////}
////
//
//
////@Test
////public void cancelSlotTest() throws NoSuchParkingSlotException
////{
////	parking.cancelParkingSlotBooking(1);
////	verify(parkrepo,times(1).deleteById(1));
////}
//
////@Test
////public void getSlotsById() throws NoSuchParkingSlotException {
////
////
////List<ParkingSlots> slotList = new ArrayList<ParkingSlots>();
////
////slotList.add(slot);
////
////int id = 1;
////
////when(parkrepo.findAll()).thenReturn(slotList);
////assertEquals(id,parking.getParkingSlotsById(id).getParkingSlotId());
//////when(parkrepo.findById(1)).thenReturn(Optional.of(slot));
////}