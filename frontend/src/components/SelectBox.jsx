import {useEffect, useState, useNavigate, useHistory} from "react";


import styled from "styled-components";

const SelectBlock = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: left;
    /* width: 130px; */
    position: relative;
    border: 1px solid transparent;
    & > .title {
        font-weight: 600;
        margin-bottom: 5px;
    }
`;

const BtnListBlock = styled.div`
    position: absolute;
    display: flex;
    flex-direction: column;
    justify-content: left;
    border: 1px solid transparent;
    width: 100px;
    padding: 0;

`;

const VisibleBtn = styled.button`
    position: relative;
    display: flex;
    justify-content: left;
    align-items: center;
    
    border: 1px solid transparent;
    background-color: transparent;
    width: 100%;
    height: 20px;
    padding: 0;
    margin: 0;
    outline: none;
    &::after {
        content: '';
        position: absolute;
        right: 0;
        border-bottom: 7px solid;
        border-left: 5px solid rgba(0, 0, 0, 0);
        border-right: 5px solid rgba(0, 0, 0, 0);
        transform: rotate(180deg);

    }
`;
 //region_list.json을 이용할 것

const SelectBox = (props) => {
    const [clicked, setClicked] = useState(false);
    const [region, setRegion] = useState(props.defaultValue);

    const clickedEvent = (e) => {
        e.preventDefault();
        setClicked(!clicked)
    }
    // let clickedEvent = false;
    return (
        <SelectBlock style={{width: props.width}}>
            {props.children}
            <VisibleBtn 
                onClick={clickedEvent}
            >
                {(region.value)}
            </VisibleBtn>
            <input type="hidden" name="region" value={region.value}/>
            
            {
                // console.log(props) || 
                props.options.forEach((option) => (
                    <button 
                        key={option.name}
                        class={option.name}
                        defaultValue={props.defaultValue === option.value}
                        onClick={clickedEvent}
                    >
                        {option.value}
                    </button>
                ))
            }

            
        </SelectBlock>
    );
}

export default SelectBox;