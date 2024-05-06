import {useEffect, useState, useNavigate, useHistory} from "react";


import styled from "styled-components";
import SelectBox from "./SelectBox";


 //region_list.json을 이용할 것

const PageRegion = (props) => {
    const region_list = [
        {
            "name": "BR1",
            "value": "Brazil",
            "l10n": "REGION_BR",
            "urlName": "br"
        },
        {
            "name": "EUN1",
            "value": "EU Nordic & East",
            "l10n": "REGION_EUNE",
            "urlName": "eune"
        },
        {
            "name": "EUW1",
            "value": "EU West",
            "l10n": "REGION_EUW",
            "urlName": "euw"
        },
        {
            "name": "JP1",
            "value": "Japan",
            "l10n": "REGION_JP",
            "urlName": "jp"
        },
        {
            "name": "KR",
            "value": "Korea",
            "l10n": "REGION_KR",
            "urlName": "kr"
        },
        {
            "name": "LA1",
            "value": "Latin America North",
            "l10n": "REGION_LAN",
            "urlName": "lan"
        },
        {
            "name": "LA2",
            "value": "Latin America South",
            "l10n": "REGION_LAS",
            "urlName": "las"
        },
        {
            "name": "NA1",
            "value": "North America",
            "l10n": "REGION_NA",
            "urlName": "na"
        },
        {
            "name": "OC1",
            "value": "Oceania",
            "l10n": "REGION_OCE",
            "urlName": "oce"
        },
        {
            "name": "PBE1",
            "value": "Public Beta",
            "l10n": "REGION_PBE",
            "urlName": "pbe"
        },
        {
            "name": "RU",
            "value": "Russia",
            "l10n": "REGION_RU",
            "urlName": "ru"
        },
        {
            "name": "TR1",
            "value": "Turkey",
            "l10n": "REGION_TR",
            "urlName": "tr"
        },
        {
            "name": "TW2",
            "value": "Taiwan",
            "l10n": "REGION_TW2",
            "urlName": "tw"
        },
        {
            "name": "PH2",
            "value": "Phillipines",
            "l10n": "REGION_PH2",
            "urlName": "ph"
        },
        {
            "name": "SG2",
            "value": "Singapore",
            "l10n": "REGION_SG2",
            "urlName": "sg"
        },
        {
            "name": "VN2",
            "value": "Vietnam",
            "l10n": "REGION_VN2",
            "urlName": "vn"
        },
        {
            "name": "TH2",
            "value": "Thailand",
            "l10n": "REGION_TH2",
            "urlName": "th"
        }
    ];

    return(
        <SelectBox options={region_list}
            defaultValue={region_list[4]}
            width="150px">
                <div className="title">
                    지역
                </div>
            </SelectBox>
        );
}

export default PageRegion;