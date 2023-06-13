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
        <div className="menu-item--submenu">
          <input type="checkbox" className="submenu-checkbox" id="cadastros-checkbox" />
          <label htmlFor="cadastros-checkbox" className="menu-item">
            <FontAwesomeIcon icon={faPlusSquare } className="menu-icon" />
            Cadastros
          </label>
          <div className="submenu">
            <a href="/aluguel" className="submenu-item">Aluguel</a>
            <a href="/evento" className="submenu-item">Evento</a>
            <a href="/local" className="submenu-item">Local</a>
            <a href="/paroquiano" className="submenu-item">Paroquianos</a>
            <a href="/pastoral" className="submenu-item">Pastorais</a>
            <a href="/sala" className="submenu-item">Salas</a>
            <a href="/tipoatividade" className="submenu-item">Tipo Atividade</a>
            
          </div>
        </div>
      </Menu>
    );
  }
}

export default MyMenu;