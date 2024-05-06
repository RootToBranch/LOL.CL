import logo from 'logo.svg';
import 'App.css';
import {useEffect, useState, useRef} from "react";
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';
import MainPage from "pages/MainPage";
import SearchPage from "pages/SearchPage";



function App() {

    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<MainPage/>}/>
                <Route path="/search" element={<SearchPage/>}/>
            </Routes>
        </BrowserRouter>
    );
}


//    const [search, setSearch] = useState([]);
//    const [nick, setNick] = useState();
//    const nickSearch = (e) => {
//        if(e.key === "Enter")
//            fetch("/riotApiConnect?playername="+ e.target.value)
//                .then((response) => response.json())
//                .then((data) => setSearch(data));
//        console.log(search);
//    };
//
//
//
//    // const onSearchClick = (() => {
//    //     fetch("/riotApiConnect?playername="+ nick)
//    //         .then(res=> {})
//
//    //         .then((response) => {
//    //             return response.json();
//    //         })
//    //         .then((data) => {
//    //             console.log(data);
//    //             setSearch(data);
//    //         });
//    // }, []);
//
//    return (
//        <div className="App">
//            <header className="App-header">
//                <input
//                    id="playername"
//                    name="playername"
//                    placeholder="닉네임을 입력해주세요"
//                    onKeyPress={nickSearch}
//                />
//
//                    Learn React
//
//                <ul>
//                    {search.id}
//                </ul>
//            </header>
//        </div>
//    );
//}

export default App;