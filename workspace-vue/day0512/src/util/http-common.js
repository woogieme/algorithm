import axios from "axios";

export default axios.create({
    baseURL: "http://192.168.214.40:7777/bookcafe",
    headers: {
        "Content-Type":"application/json" //Front->Back으로 보내는 데이터 형식
    }
    
})