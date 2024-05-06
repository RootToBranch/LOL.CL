import { useState } from "react";

import styled from "styled-components";

import PageLogo from "components/PageLogo";
import PageRegion from "components/PageRegion";

import handleSubmit from "lib/handleSubmit";
import SearchBox from "components/SearchBox";

const SearchSection = styled.form`
    user-select:none;
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 700px;
    height: 80px;
    font-family: 'Pretendard';

    border: 1px solid gray;
    border-radius: 50px;
    
    margin-top: 20px;
    & > div {
        display: inherit;
        width: 600px;
        height: inherit;
        align-items: inherit;
    }
    & > div > * {
        margin-right: 40px;
    }
    input, select {
      font-size: 16px;
      border: 0px solid transparent;
    };
    i {
        position: absolute;
        width: 60px;
        height: 60px;
        font-size: 20px;
        margin: 0;
        padding: 0;
        background-color: transparent;
        border: 0;

        text-align: center;
        line-height: 60px;
        color: rgb(208, 208, 208);
        left: 0;
    }

    #url:placeholder-shown + #search {opacity: 0}
`;

const SearchButton = styled.button`
    width: 60px;
    height: 60px;

    right: 0;

    font-size: 20px;
    margin: 0 !important;
    padding: 0;
    background-color: white;
    border: 0;
    border-radius: 50px;

    color: rgb(208, 208, 208);
    transition: 0.25s opacity;
    float: right;

    &:hover {
        color: black;
        transition: 0.25s color;
    }
`;

function SearchPage() {

    const [player, setPlayer] = useState([]);
    return (
        <>
            <PageLogo height="200" />
            <SearchSection method="GET" action="/search" onSubmit={e => handleSubmit(e, 2, setPlayer)}>
                <div>
                    <PageRegion />
                    <SearchBox />
                    <SearchButton type="submit" className="fa fa-solid fa-search" id="search" ></SearchButton>

                </div>
            </SearchSection>
        </>
    );
}

export default SearchPage;