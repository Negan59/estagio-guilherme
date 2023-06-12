import React from 'react';
import { slide as Menu } from 'react-burger-menu';
import '../styles/menu.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHome, faInfoCircle, faEnvelope, faPlusSquare  } from '@fortawesome/free-solid-svg-icons';

class MyMenu extends React.Component {
  showSettings(event) {
    event.preventDefault();
    // Lógica para mostrar as configurações do menu
  }

  render() {
    return (
      <Menu>
        <div className="logo-container">
          {/* ... */}
        </div>
        <a id="home" className="menu-item" href="/">
          <FontAwesomeIcon icon={faHome} className="menu-icon" />
          Home
        </a>
        <a id="about" className="menu-item" href="/about">
          <FontAwesomeIcon icon={faInfoCircle} className="menu-icon" />
          About
        </a>
        <a id="contact" className="menu-item" href="/contact">
          <FontAwesomeIcon icon={faEnvelope} className="menu-icon" />
          Contact
        </a>
        <div className="menu-item--submenu">
          <input type="checkbox" className="submenu-checkbox" id="cadastros-checkbox" />
          <label htmlFor="cadastros-checkbox" className="menu-item">
            <FontAwesomeIcon icon={faPlusSquare } className="menu-icon" />
            Cadastros
          </label>
          <div className="submenu">
            <a href="/paroquiano" className="submenu-item">Paroquianos</a>
            <a href="/pastorais" className="submenu-item">Pastorais</a>
            <a href="/sala" className="submenu-item">Salas</a>
          </div>
        </div>
      </Menu>
    );
  }
}

export default MyMenu;