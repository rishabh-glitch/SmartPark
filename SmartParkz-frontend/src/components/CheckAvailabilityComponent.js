import React, { useState ,useEffect} from 'react'
import ParkingSlotService from '../services/ParkingSlotService';
import HeaderComponent from './HeaderComponent';
import UserHeader from './UserHeader';

const CheckAvailabilityComponent = () => {
    const[date,setDate] = useState('');

    useEffect(() => {
        checkavailability();
    }, [])
    
    const checkavailability=()=>{
        ParkingSlotService.checkavailability(date).then((response) => {
            console.log(response.data)
            if(ParkingSlotService.checkavailability(date)){
            document.getElementById('text').innerHTML = "SLOTS AVAILABLE"
        }
        }).catch(error => {
        document.getElementById('text').innerHTML = "NO SLOT AVAILABLE"
        console.log(error.response.data)
        })
    }
  return (
    <div style={{background:"aliceblue",height:"650px"}}>
        <UserHeader/>
        <div className='form-group mb-2'style={{position:"relative",left:"540px",fontFamily:"emoji"}}>
                                <label className='form-label' >ENTER DATE TO CHECK AVAILABILITY OF SLOT</label>
                                <input style={{width:"200px",marginBottom:"10px"}}
                                    type="date"
                                    placeholder='Enter Parking Date'
                                    name='parkingDate'
                                    className='form-control'
                                    value={date}
                                    onChange={(i) => setDate(i.target.value)}
                                >
                                </input>
                                <p id="text"style={{background: "chocolate",display: "inline",padding: "5px",color: "white",borderRadius: "20px"}}></p>
                            </div>
                            <td style={{display:"flex",flexDirection:"column"}}><button className='btn btn-danger'  onClick={()=>checkavailability(date)}>CHECK AVAILABILITY</button></td>
    </div>
  )
}

export default CheckAvailabilityComponent