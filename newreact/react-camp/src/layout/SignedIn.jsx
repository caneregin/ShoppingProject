import React from 'react'
import { Dropdown, Menu, Image } from 'semantic-ui-react'

export default function SignedIn(props) {
    return (
        <div>
            <Menu.Item>
                <Image avatar spaced="right" src="https://i0.wp.com/shiftdelete.net/wp-content/uploads/2022/03/recep-ivedik-7-ilk-video.jpg?fit=1280%2C720&ssl=1" />
                <Dropdown pointing="top left" text='XD'>
                    <Dropdown.Menu>
                        <Dropdown.Item text="Bilgilerim" icon="info" />
                        <Dropdown.Item onClick={props.signOut} text="Çıkış yap" icon="sign-out" />
                    </Dropdown.Menu>
                </Dropdown>
            </Menu.Item>
        </div>
    )
}
