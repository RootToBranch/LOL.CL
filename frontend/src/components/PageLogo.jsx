import React from 'react';
import styled from "styled-components";
import { Link } from 'react-router-dom';


const LogoSectionBlock = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    img {
      object-fit: cover;
    }
`

const PageLogo = ({height}) => {
    return (
        <LogoSectionBlock>
            <img src="/lolcl_logo.svg" alt="lolcl_logo" height={!height ? '300px' : height}/>
        </LogoSectionBlock>
    );
}

export default PageLogo;