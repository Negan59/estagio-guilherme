import React, { useState } from 'react';
import TabelaTipoAtividade from './TabelaTipoAtividade';
import ModalTipoAtividade from './ModalTipoAtividade';
import '../../styles/formulario.css';

const TipoAtividade = () => {
  const [showModal, setShowModal] = useState(false);
  const [reloadKey, setReloadKey] = useState(0);

  const handleModalToggle = () => {
    setShowModal(!showModal);
    recarregarComponente();
  };

  const recarregarComponente = () => {
    // Atualize o estado da chave para forçar o componente a recarregar
    setReloadKey(reloadKey + 1);
  };

  return (
    <div className="container">
      <button className="botao" onClick={handleModalToggle}>
        Adicionar Tipo de Atividade
      </button>
      {showModal && <ModalTipoAtividade onClose={handleModalToggle} />}
      <div className="tabela-container">
        <h2>Tipos de Atividade cadastrados</h2>
        <TabelaTipoAtividade key={reloadKey} />
      </div>
    </div>
  );
};

export default TipoAtividade;