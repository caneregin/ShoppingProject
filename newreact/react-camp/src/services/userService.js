import axios from "axios"

export default class UserService{
    getByUserName(userName){
        return axios.get("http://localhost:8080/auth/"+userName);
    }
}