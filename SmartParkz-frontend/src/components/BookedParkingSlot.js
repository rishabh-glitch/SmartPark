import React,{useState,useEffect} from 'react'
import { Link } from 'react-router-dom'
import HeaderComponent from './HeaderComponent'
import ParkingSlotService from '../services/ParkingSlotService'
import { ToastContainer,toast } from 'react-toastify';

const BookedParkingSlot = () => {
    
    const[parkingslots,setParkingSlots] = useState([])

    useEffect(() => {
        getAllParkingSlots();
    }, [])
    
    const getAllParkingSlots=()=>{
        ParkingSlotService.getAllParkingSlots().then((response)=>{
            setParkingSlots(response.data)
            console.log(response.data);
        }).catch(error=>{
            console.log(error)
        })
    }

    const deleteSlot = (parkingSlotId)=>{
        ParkingSlotService.deleteParkingSlot(parkingSlotId).then((response)=>{
            getAllParkingSlots();
            deleteButton();
        }).catch(error=>{
            console.log(error);
        })
    }

    const deleteButton=()=>{
        toast.success("The record has been deleted");
    };
  return (
    <div style={{backgroundColor:"#d4d3eb",height:"650px"}}>
        <ToastContainer/>
        <HeaderComponent/>
        <br></br>
        <br></br>
        {/* <Link to="/bookparkingslot" className='btn btn-primary' style={{float:"right",marginRight:"50px",textDecoration:"none"}}> + BOOK SLOT </Link> */}
        <h2 className='text-center' style={{fontFamily:"auto",textDecoration:"auto"}}>Booked Slots</h2>
        <table className = "table container table-bordered table-striped table-hover" style={{backgroundColor:"aliceblue",marginTop:"40px",borderRadius:"25px"}}>
            <thead style={{padding:"20px",textAlign:"center"}}>
                <th style={{padding:"20px"}}> Slot ID</th>
                <th style={{padding:"20px"}}> Booking Date </th>
                <th style={{padding:"20px"}}> Floor Number </th>
                <th style={{padding:"20px"}}> Slot Number </th>
                <th style={{padding:"20px"}}> Parking Premise Name </th>
                <th style={{padding:"20px"}}> Parking Date </th>
                <th style={{padding:"20px"}}> Parking Time </th>
                <th style={{padding:"20px"}}> Vehicle Number </th>
                <th style={{padding:"20px"}}> Actions </th>
            </thead>
            <tbody style={{textAlign:"center",background:""}}>
                {
                    parkingslots.map(
                        parkingslot=>
                        <tr key = {parkingslot.id}>
                            <td>{parkingslot.parkingSlotId}</td>
                            <td>{parkingslot.bookingDate}</td>
                            <td>{parkingslot.parkingFloor.floorNumber}</td>
                            <td>{parkingslot.slot_no}</td>
                            <td>{parkingslot.parkingFloor.parkingPremise.parkingPremiseName}</td>
                            <td>{parkingslot.parkingDate}</td>
                            <td>{parkingslot.parkingTime}</td>
                            <td>{parkingslot.vehicle.vehicleNumber}</td>
                            <td><button className='btn btn-danger' onClick={()=>deleteSlot(parkingslot.parkingSlotId)}>Delete</button></td>
                            {/* <td><Link className='btn btn-info' to={`/edit-insurance/${insurance.id}`}>Update</Link></td> */}
                        </tr>
                    )
                }
            </tbody>
        </table>
        <div>

        
        </div>
        
    </div>
  )
}

export default BookedParkingSlot