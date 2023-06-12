import logo from '../images/paroquia.jpeg'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser } from '@fortawesome/free-solid-svg-icons';
const Header = ()=>{
    return(
        <div>
            <div className="login-icon">
                <FontAwesomeIcon icon={faUser} />
                    Login
            </div>
            <div className="menu-bar">
                <img src={logo} alt="paroquia" className="logo" />
                <h1 className="parish-name">Paróquia Nossa Senhora Mãe da Igreja</h1>
            </div>
        </div>
        
    )
}

export default Header