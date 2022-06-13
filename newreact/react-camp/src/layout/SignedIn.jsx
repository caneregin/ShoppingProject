import React from 'react'
import { Dropdown, Menu, Image } from 'semantic-ui-react'
import { useHistory } from "react-router-dom"
import IconButton from '@material-ui/core/IconButton';

export default function SignedIn(props) {
    let history = useHistory();

    const logOut = () => {
      localStorage.removeItem("tokenKey")
      localStorage.removeItem("currentUser")
      localStorage.removeItem("userName")
      history.go("/")
    }
    return (
        <div>
            <Menu.Item>


             
             <Image avatar spaced="right" src="https://i0.wp.com/shiftdelete.net/wp-content/uploads/2022/03/recep-ivedik-7-ilk-video.jpg?fit=1280%2C720&ssl=1" />
                <Dropdown pointing="top left" text='XD'>
                    <Dropdown.Menu>
                        <Dropdown.Item text="Bilgilerim" icon="info" />
                        <Dropdown.Item onClick={logOut} text="Çıkış yap" icon="sign-out" />
                    </Dropdown.Menu>
                </Dropdown>
             
            </Menu.Item>
        </div>
    )
}
