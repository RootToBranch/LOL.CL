import { useState } from "react";

import styled from "styled-components";

import PageLogo from "components/PageLogo";
import PageRegion from "components/PageRegion";

import handleSubmit from "lib/handleSubmit";



const SearchButton = styled.button`
    width: 60px;
    height: 60px;

    right: 0;

    font-size: 20px;
    margin: 0;
    padding: 0;
    background-color: red;
    border: 0;
    border-radius: 50px;

    color: rgb(208, 208, 208);
    transition: 0.25s opacity;

    &:hover {
        color: black;
        transition: 0.25s color;
    }
`;
const Input = styled.input`
    outline: none;  
    &:-webkit-autofill,
    &:-webkit-autofill:hover, 
    &:-webkit-autofill:focus {
        /* -webkit-text-fill-color: green; */
        -webkit-box-shadow: 0 0 0px 1000px transparent inset;
        transition: background-color 5000s ease-in-out 0s;

    }

`;

const SearchSection = styled.div`
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;

    /* width: 1200px; */
    flex-grow: 1;
    
    font-weight: bold;
    margin: 0 !important;
    & > label {
        margin-bottom: 5px;
    }
`

const SearchBox = () => {

    // const [player, setPlayer] = useState([]);
    return (
        <SearchSection>
            <label htmlFor="url">이름</label>
            <Input type="text" 
                    id="url" 
                    placeholder="소환사 이름 + #KR1"
            />
        </SearchSection>
    );
}

export default SearchBox;