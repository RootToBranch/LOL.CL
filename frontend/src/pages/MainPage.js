
    import {useEffect, useState} from "react";
    import axios from "axios";

    import MainSearchForm from "components/MainSearchForm";

    function MainPage() {
        const [search, setSearch] = useState([]);
        const [nick, setNick] = useState([]);

    //    const navigate = useNavigate();
    //    console.log(navigate);




        const usernameLoaded = (username) => {

            let reg = /[`~!@$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gim;
            username = username.replace(reg, "").replace(/[#]/, "-");
            setNick(username);

            const options = {
               url: 'api/v1/account/',
               method:'GET',
               header:{
                 'Accept':'application/json',
                 'Content-Type':'application/json'
                }
            }

            axios(options)
                .then((data) => setSearch(data));
        };

        const nickSearch = (e) => {
            if(e.key === "Enter") usernameLoaded(e.target.value);
        }

        // const onSearchClick = (() => {
        //     fetch("/riotApiConnect?playername="+ nick)
        //         .then(res=> {})

        //         .then((response) => {
        //             return response.json();
        //         })
        //         .then((data) => {
        //             console.log(data);
        //             setSearch(data);
        //         });
        // }, []);

        return (
            <>
                <MainSearchForm />
            </>
        );
    }

    export default MainPage;