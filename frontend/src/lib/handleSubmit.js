
import axios from "axios";

const handleSubmit = (e, idx, stateChange) => {
    e.preventDefault();

    console.log(e);
    console.dir(e.target);
    let username = e.target[idx].value;
    let reg = /[`~!@$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gim;
    // eslint-disable-next-line no-unused-vars
    username = username.replace(reg, "").replace(/[#]/, "-");

    
    const options = {
       url: `api/v1/account/kr/${username}`,
       method:'GET',
       header:{
         'Accept':'application/json',
         'Content-Type':'application/json'
        }
    }

    axios(options)
        .then((data) => stateChange(data))


};

export default handleSubmit;