import React,{useState,useEffect} from 'react'
import { Link } from 'react-router-dom'
import HeaderComponent from './HeaderComponent'
import ParkingFloorService from '../services/ParkingFloorService'
import { ToastContainer,toast } from 'react-toastify';

const UpdatedFloorDetails = () => {
    
    const[parkingfloors,setParkingFloors] = useState([])

    useEffect(() => {
        getAllFloors();
    }, [])
    
    const getAllFloors=()=>{
        ParkingFloorService.getAllFloors().then((response)=>{
            setParkingFloors(response.data)
            console.log(response.data);
        }).catch(error=>{
            console.log(error)
        })
    }

    // const deleteFloor = (p)=>{
    //     ParkingFloorService.deleteParkingFloor(parkingPremiseId).then((response)=>{
    //         getAllFloors(parkingPremiseId);
    //         deleteButton();
    //     }).catch(error=>{
    //         console.log(error);
    //     })
    // }

    const deleteButton=()=>{
        toast.success("The floor record has been deleted");
    };
  return (
    <div style={{backgroundColor:"#d4d3eb",height:"650px"}}>
        <ToastContainer/>
        <HeaderComponent/>
        <br></br>
        <br></br>
        <Link to="/createfloor" className='btn btn-primary' style={{float:"right",marginRight:"50px",textDecoration:"none"}}>  ADD FLOORS </Link>
        {/* <Link to="/bookparkingslot" className='btn btn-primary' style={{float:"right",marginRight:"50px",textDecoration:"none"}}> + BOOK SLOT </Link> */}
        <h2 className='text-center' style={{fontFamily:"auto",textDecoration:"auto"}}>Floor Details</h2>
        <table className = "table container table-bordered table-striped table-hover" style={{backgroundColor:"aliceblue",marginTop:"40px",borderRadius:"25px"}}>
            <thead style={{padding:"20px",textAlign:"center"}}>
                <th style={{padding:"20px"}}> Floor Id</th>
                <th style={{padding:"20px"}}> Parking premise </th>
                <th style={{padding:"20px"}}> floor number </th>
                <th style={{padding:"20px"}}> number of parking slots </th>
                
                {/* <th style={{padding:"20px"}}> Actions </th> */}
            </thead>
            <tbody style={{textAlign:"center",background:""}}>
                {
                    parkingfloors.map(
                        parkingfloor=>
                        <tr key = {parkingfloor.id}>
                            <td>{parkingfloor.parkingFloorId}</td>
                            
                            <td>{parkingfloor.parkingPremise.parkingPremiseName}</td>
                            <td>{parkingfloor.floorNumber}</td>
                            <td>{parkingfloor.numberOfParkingSlots}</td>
                            
                            {/* <td><button className='btn btn-danger' onClick={()=>deleteFloor(parkingfloor.parkingFloorId)}>Delete</button></td> */}

                           
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

export default UpdatedFloorDetails;