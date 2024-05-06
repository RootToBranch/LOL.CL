
import styled from "styled-components";

const SearchBtn = styled.button`
    display: flex;
    justify-content: center;
    align-items: center;

    width: ${(props) => props.size || "30px"};
    height: ${(props) => props.size || "30px"};
    font-size: ${(props) => (props.size - props.size / 3) || "20px"};

    margin: 0 !important;
    padding: 0;
    background-color: white;
    border: 0;

    color: rgb(208, 208, 208);
    transition: 0.25s opacity;

    &:hover {
        color: black;
        transition: 0.25s color;
    }
`;

const SearchButton = ({ size }) => {
    return (
        <SearchBtn type="submit" size={size} className="fa fa-solid fa-search" id="search"></SearchBtn>
    )
}

export default SearchButton;