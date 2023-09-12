import React from 'react';
import { slide as Menu } from 'react-burger-menu';
import '../styles/menu.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHome, faPlusSquare, faCalendar, faMapMarkerAlt, faUserFriends, faUsers, faDoorOpen, faListAlt } from '@fortawesome/free-solid-svg-icons';

class MyMenu extends React.Component {
  showSettings(event) {
    event.preventDefault();
    // Lógica para mostrar as configurações do menu
  }

  render() {
    return (
      <Menu>
        <div className="container logo-container mb-4">
          {/* ... */}
        </div>
        <a id="home" className="menu-item" href="/">
          <FontAwesomeIcon icon={faHome} className="menu-icon mr-2" />
          Home
        </a>
        <div className="menu-item--submenu">
          <input type="checkbox" className="submenu-checkbox" id="cadastros-checkbox" />
          <label htmlFor="cadastros-checkbox" className="menu-item">
            <FontAwesomeIcon icon={faPlusSquare} className="menu-icon mr-2" />
            Cadastros
          </label>
          <div className="submenu">
            <a href="/aluguel" className="submenu-item">
              <FontAwesomeIcon icon={faCalendar} className="submenu-icon mr-2" />
              Aluguel
            </a>
            <a href="/evento" className="submenu-item">
              <FontAwesomeIcon icon={faCalendar} className="submenu-icon mr-2" />
              Evento
            </a>
            <a href="/funcionario" className="submenu-item">
              <FontAwesomeIcon icon={faUsers} className="submenu-icon mr-2" />
              Funcionário
            </a>
            <a href="/itemsalao" className="submenu-item">
              <FontAwesomeIcon icon={faListAlt} className="submenu-icon mr-2" />
              Item do Salão Paroquial
            </a>
            <a href="/local" className="submenu-item">
              <FontAwesomeIcon icon={faMapMarkerAlt} className="submenu-icon mr-2" />
              Local
            </a>
            <a href="/padre" className="submenu-item">
              <FontAwesomeIcon icon={faUserFriends} className="submenu-icon mr-2" />
              Padres
            </a>
            <a href="/paroquiano" className="submenu-item">
              <FontAwesomeIcon icon={faUserFriends} className="submenu-icon mr-2" />
              Paroquianos
            </a>
            <a href="/pastoral" className="submenu-item">
              <FontAwesomeIcon icon={faUsers} className="submenu-icon mr-2" />
              Pastorais
            </a>
            <a href="/sala" className="submenu-item">
              <FontAwesomeIcon icon={faDoorOpen} className="submenu-icon mr-2" />
              Salas
            </a>
            <a href="/tipoatividade" className="submenu-item">
              <FontAwesomeIcon icon={faListAlt} className="submenu-icon mr-2" />
              Tipo Atividade
            </a>
          </div>
        </div>
      </Menu>
    );
  }
}

export default MyMenu;
