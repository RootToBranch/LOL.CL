import React from 'react';
import styled from "styled-components";
import { Link } from 'react-router-dom';
import PageLogo from "./PageLogo";


const Header = styled.div` 
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    width: 1280px;
    height: 100px;
`;

 PageHead() {
    return (
        <Header>
            <PageLogo />
            <div class="searchSection">
                <i class="fa fa-solid fa-user" id="user"></i>
                <i class="fa fa-solid fa-users" id="user2"></i>
                <input type="text" id="url" placeholder="소환사명, 소환사명, ... / [챔피언 이름]" />
                <button class="fa fa-solid fa-search" id="search"></button>
            </div>
        </Header>
    );
}

export default PageHead;